import React, { Component } from 'react';
import Bookservice from '../service/Bookservice';
import "../styles/Createbook.css";

class Createbook extends Component {
    
    constructor(props) {
        super(props);
        this.state = {
            bookname: "",
            bookcontent: ""
        };
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeContentHandler = this.changeContentHandler.bind(this);
        this.saveBook = this.saveBook.bind(this);
    }

    changeNameHandler = (event) => {
        this.setState({bookname: event.target.value});
    }

    
    changeContentHandler = (event) => {
        this.setState({bookcontent: event.target.value});
    }
    
    saveBook = (event) => {
        event.preventDefault();
        let book = {bookname: this.state.bookname, content: this.state.bookcontent};
        
        Bookservice.createBooks(book).then(res => {
            this.props.history.push('/');
        })
    }

    back = () => {
        this.props.history.push('/');
    }

    render() {
        return (
            <div>
                <div className="container">
                    <div className = "row">
                        <div className = "card col-md-6 offset-md-3 offset-md-3 addBookContent">
                            <h3 className="text-center addBookHeadline">Add book</h3>
                            <hr/>
                            <div className = "card-body">
                                <form>
                                    <div className="form-group">
                                        <label>Book name</label>
                                        <input placeholder="Book name" name="bookname" className="form-control"  
                                        value={this.state.bookname} onChange={this.changeNameHandler}/>
                                    </div>
                                    <div className="form-group">
                                        <label>Book content</label>
                                        <textarea placeholder="Book content" name="bookcontent" className="form-control"  
                                        value={this.state.bookcontent} onChange={this.changeContentHandler}/>
                                    </div>
                                    <button className="btn btn-success" onClick={this.saveBook}>Save</button>
                                    <button className="btn btn-success addBookBackButton" onClick={this.back}>Back</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Createbook;