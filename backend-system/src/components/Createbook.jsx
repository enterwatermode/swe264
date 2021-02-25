import React, { Component } from 'react';

class Createbook extends Component {
    
    constructor() {
        super();
        this.setState({
            bookname: "",
            bookcontent: ""
        });
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
    }

    render() {
        return (
            <div>
                <div className="container">
                    <div className = "row">
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">Add book</h3>
                            <div className = "card-body">
                                <form>
                                    <div className="form-group">
                                        <label>Book name</label>
                                        <input placeholder="Book name" classHolder="form-control"  onChange={this.changeNameHandler}/>
                                    </div>
                                    <div className="form-group">
                                        <label>Book content</label>
                                        <input placeholder="Book content"  classHolder="form-control"  onChange={this.changeContentHandler}/>
                                    </div>
                                    <button className="btn btn-success" onClick={this.saveBook}>Save</button>
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