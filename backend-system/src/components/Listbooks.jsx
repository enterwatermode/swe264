import React, { Component } from 'react';
import Bookservice from '../service/Bookservice';

class Listbooks extends Component {
    constructor(props) {
        super(props);
        this.state = {
            books: []
        }
        this.addBooks = this.addBooks.bind(this);
    }

    addBooks() {
        this.props.history.push('/createbook');
    }

    componentDidMount() {
        Bookservice.getBooks().then((res) => {
            this.setState({books : res.data});
        });
    }
    render() {
        return (
            <div>
                <div className = "row">
                    <button className="btn btn-primary" onClick={this.addBooks}>Add books</button>
                </div>
                <div className = "row">
                    <table className = "table table-striped table-bordered">
                        <thead>
                            <th>Book Name</th>
                            <th>Book content</th>
                            <th>Action</th>
                        </thead>
                        <tbody>
                            {
                                this.state.books.map(book => 
                                <tr key = {book.id}>
                                    <td>{book.bookname}</td>
                                    <td>{book.ccontent}</td>
                                </tr>)
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

export default Listbooks;