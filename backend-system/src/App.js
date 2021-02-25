import './App.css';
import Listbooks from './components/Listbooks';
import Header from'./components/Header';
import Footer from './components/Footer';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import Createbook from './components/Createbook';

function App() {
  return (
    <div>
      <Router>
      <div className="container">
        <Header/>
        <div className="container">
            <Switch>
              <Route path = '/' exact component = {Listbooks}></Route>
              <Route path = '/createbook' component = {Createbook}></Route>
            </Switch>      
        </div>
        <Footer/>
      </div>
      </Router>
    </div>
  );
}

export default App;
