import MyLayout from "./MyLayout.jsx";
import React from "react";
import ReactDOM from "react-dom/client";
import {BrowserRouter, Routes, Route} from "react-router";
// import './index.css'
// import App from './App.jsx'
import Page1 from "./pages/Page1.jsx";
import Page2 from "./pages/Page2.jsx";
import Home from "./pages/Home.jsx";

const root = document.getElementById("root");
ReactDOM.createRoot(root).render(
    <BrowserRouter>
        <Routes>
            <Route element={<MyLayout/>}>
                <Route index element={<Home/>}/>
                <Route path={"/page1"} element={<Page1/>} />
                <Route path={"/page2"} element={<Page2/>} />
            </Route>
        </Routes>
    </BrowserRouter>
)