import React, { useEffect } from 'react';
import logo from '../images/logo.svg';
import './Home.css';

export default function Home() {
    document.title = "Home"

    return (
        <div className="Home">
            <img src={logo} className="App-logo" alt="logo" />
            Home
        </div>
    )
}
