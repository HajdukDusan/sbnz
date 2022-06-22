import React, { useEffect, useState } from "react";
import { Link, Outlet } from "react-router-dom";
export default function Users() {
  const [error, setError] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  const [users, setItems] = useState([]);

  // Note: the empty deps array [] means
  // this useEffect will run once
  // similar to componentDidMount()
  useEffect(() => {
    fetch("http://localhost:8080/korisnik/get/all")
      .then((res) => res.json())
      .then(
        (result) => {
          setIsLoaded(true);
          setItems(result);
        },
        // Note: it's important to handle errors here
        // instead of a catch() block so that we don't swallow
        // exceptions from actual bugs in components.
        (error) => {
          setIsLoaded(true);
          setError(error);
        }
      );
  }, []);

  if (error) {
    return <div>Error: {error.message}</div>;
  } else if (!isLoaded) {
    return <div>Loading...</div>;
  } else {
    return (
      <div>
        <ul>
          {users.map((user) => (
            // <li key={item.id}>
            //   {item.username} {item.id} <button>Slusanje</button>
            // </li>

            <Link
              style={{ display: "block", margin: "1rem 0" }}
              to={`/users/${user.id}`}
              key={user.id}
            >
              {user.username}
            </Link>
          ))}
        </ul>
        <Outlet />
      </div>
    );
  }
}
