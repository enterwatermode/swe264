import React, { Component } from 'react';
import Bookservice from '../service/Bookservice';
import "../styles/Details.css";

class Details extends Component {
    
    constructor(props) {
        super(props);

        this.state = {
            id: this.props.match.params.id,
            book: {}
        }
    }

    componentDidMount() {
        Bookservice.getBookById(this.state.id).then(res => {
            this.setState({
                book: res.data
            });
        })
    }

    back() {
        this.props.history.push('/');
    }
    
    render() {
        return (
            <div>
                <hr />
                <button onClick={() => this.back()} className = "btn btn-info">Back</button>
                <div className = "bookTitle">
                    {this.state.book.bookname} <br/>
                </div>
                <div className = "bookContent" style={{whiteSpace: 'pre-wrap'}}>
                    <p className = "article">{this.state.book.ccontent}</p>
                </div>
            </div>
        );
    }
}

export default Details;