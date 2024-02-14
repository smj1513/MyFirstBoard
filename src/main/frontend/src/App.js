import './App.css';
import Board from "./component/boardPost/board";
import AppBar from "@mui/material/AppBar";
import NavBar from "./component/Head/head";
import Aside from "./component/aside/side";
import {useState} from "react";


function App() {
    const open = useState(false);
    return (
        <div className="App">
            <NavBar sideOpen={open}></NavBar>
            <Aside open={open}></Aside>
            <Board></Board>
        </div>
    );
}

export default App;
