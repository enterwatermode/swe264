import React, { Component } from 'react';
import img1 from '../image/img1.jpg';
import "../styles/Header.css"

class Header extends Component {
    render() {
        return (
            <div className="head">            
                <h2><img src={img1} className = "headerImg" alt=""/>  Kingdle Books Management System</h2>
            </div>
        );
    }
}

export default Header;