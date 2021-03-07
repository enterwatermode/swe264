package com.example.kingdle;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReadFragment extends Fragment {
/*
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ReadFragment.
     */
    /*
    // TODO: Rename and change types and number of parameters
    public static ReadFragment newInstance(String param1, String param2) {
        ReadFragment fragment = new ReadFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
*/



    /**************************************
    Author: Yukan Zhang
    Timer connection
    *****************************************/
    TimerService FragTimer;
    boolean bound;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            TimerService.TimerBinder TimerBinder = (TimerService.TimerBinder) iBinder;
            FragTimer = TimerBinder.getTime();
            FragTimer.runTimer1();
            FragTimer.running = true;
            bound = true;
            Log.v("Main","GetBinder");
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            FragTimer.running =false;
            bound = false;
            // Log.v("Main","unBinder");
        }
    };
    /***********************************
    Timer connection end
    ***********************************/
    /***********************************
     Author: Yukan Zhang
     Timer connection, Database access
     ***********************************/
    ServiceDB db;
    ServiceDao sdao;
    ServiceTable stable;
    /***********************************
     Timer connection, database access end
     ***********************************/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //    if (getArguments() != null) {
    //        mParam1 = getArguments().getString(ARG_PARAM1);
    //        mParam2 = getArguments().getString(ARG_PARAM2);
    //    }
        /***********************************
         Author: Yukan Zhang
         Timer connection, Database access
         ***********************************/
        db = ServiceDB.getDatabase(this.getContext());
        sdao = db.serviceDao();
        stable = new ServiceTable();
        /***********************************
         Timer connection, database access end
         ***********************************/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_read, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        /***********************************
        Author: Yukan Zhang
        Timer connection
        ***********************************/
        if(!bound) {
            Intent intent = new Intent(getContext(), TimerService.class);
            getActivity().bindService(intent, connection, Context.BIND_AUTO_CREATE);
        }
        /***********************************
        Timer connection end
        ***********************************/
    }

    @Override
    public void onStop() {
        super.onStop();
        /***********************************
        Author: Yukan Zhang
        Timer connection, Database access
        ***********************************/
        if(bound) {
            //TimerControl.last_read = FragTimer.seconds1;
            class SaveTask extends AsyncTask<Void, Void, Void> {
                @Override
                protected Void doInBackground(Void... voids) {

                    stable.date =  java.text.DateFormat.getDateTimeInstance().format(new Date());
                    stable.last_read = FragTimer.seconds1;
                    Log.v("last_read to db", String.valueOf(stable.last_read));
                    //adding to database
                    sdao.insert(stable);
                    return null;
                }
                @Override
                protected void onPostExecute(Void aVoid) {
                    super.onPostExecute(aVoid);
                }
            }
            SaveTask st = new SaveTask();
            st.execute();

            getActivity().unbindService(connection);
            FragTimer.running = false;
            bound = false;
        }
        /***********************************
        Timer connection, database access end
        ***********************************/
    }

}