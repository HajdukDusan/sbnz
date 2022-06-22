import React, { Component } from "react";

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
        <Link to="/users">Users</Link> | <Link to="/songs">Songs</Link>
      </nav>
      <Outlet />
    </div>
  );
}

export default App;
