import React, { Component } from 'react';
import Bookservice from '../service/Bookservice';
import '../styles/Listbooks.css';

class Listbooks extends Component {
    constructor(props) {
        super(props);
        this.state = {
            books: []
        }
        this.addBooks = this.addBooks.bind(this);
        this.deleteBooks = this.deleteBooks.bind(this);
    }

    addBooks() {
        this.props.history.push('/createbook');
    }

    viewDetail(id) {
        this.props.history.push(`/details/${id}`);
    }

    deleteBooks(id) {
        Bookservice.deleteBooks(id).then( res => {
            this.setState({books: this.state.books.filter(book => book[0] !== id)});
        });
    }

    componentDidMount() {
        Bookservice.getBooksNamesWithId().then((res) => {
            this.setState({books : res.data});
        });
    }
    render() {
        return (
            <div>
                <div className = "row">
                    <button className="btn btn-primary addBooks" onClick={this.addBooks}>Add books</button>
                </div>
                <div className = "row">
                    <table className = "table table-striped table-bordered">
                        <thead>
                            <th>Book Name</th>
                            <th>Action</th>
                        </thead>
                        <tbody className = "allBooks">
                            {
                                this.state.books.map(book => 
                                <tr key = {book[0]}>
                                    <td>{book[1]}</td>
                                    <td>
                                        <button onClick={() => this.deleteBooks(book[0])} className = "btn btn-info">Delete</button>
                                        <button onClick={() => this.viewDetail(book[0])} className = "btn btn-info btnDetail">Detail</button>
                                    </td>
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