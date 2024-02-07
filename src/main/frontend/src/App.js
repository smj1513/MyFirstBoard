import logo from './logo.svg';
import './App.css';
import {useEffect, useState} from "react";
import axios from "axios";


function get(setState) {
    axios.get("/test").then((message) => {
        setState(message.data)
    })
}

function post(setState) {
    axios.post("/test", null, {
        params: {
            test: "post test"
        }
    }).then((res) => {
        setState(res.data)
    })
}

function App() {
    const [state, setState] = useState('');

    useEffect(() => {
        get(setState)
    }, []);

    return (
        <div className="App">
            <header className="App-header">
                <img src={logo} className="App-logo" alt="logo"/>
                <p>
                    {state}
                </p>
                <a
                    className="App-link"
                    onClick={() => {
                        post(setState)
                    }}
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    Learn React
                </a>
            </header>
        </div>
    );
}

export default App;
