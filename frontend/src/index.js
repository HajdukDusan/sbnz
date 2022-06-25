import React from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import App from "./App";
import Users from "./user/users";
import User from "./user/user";
import 'bootstrap/dist/css/bootstrap.css';
import Songs from "./songs/songs";
const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <div>
  <BrowserRouter>
    <App />
    <Routes>
      <Route path="users" element={<Users />}>
        <Route path=":userId" element={<User />} />
      </Route>
      <Route path="songs" element={<Songs />} />
      <Route
        path="*"
        element={
          <main style={{ padding: "1rem" }}>
            <p>There's nothing here!</p>
          </main>
        }
      />
    </Routes>
  </BrowserRouter>
  </div>
);
