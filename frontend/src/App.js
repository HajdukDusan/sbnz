import React, { Component } from "react";
import Button from 'react-bootstrap/Button';

import { Link, Outlet } from "react-router-dom";
import "./App.css";

function App() {
  return (
    <div>
      <h1>Music recommend app</h1>
      <nav
        style={{
          borderBottom: "solid 1px",
          paddingBottom: "1rem",
        }}
      >
          <Link to="/users">
            <Button>Users </Button>    
          </Link>
          <span>          </span>
          <Link to="/songs">
            <Button>Songs</Button>
          </Link>
      </nav>
      <Outlet />
    </div>
  );
}

export default App;
