import React, { useEffect, useState } from "react";
import {
  Route,
  Link,
  NavLink,
  Outlet,
  useSearchParams,
} from "react-router-dom";
import Button from 'react-bootstrap/Button';


function favoriteSongsFromSlusanje(){
  fetch("http://localhost:8080/korisnik/slusanja/all")
}
function favoriteSongsFromOcene(){
  fetch("http://localhost:8080/korisnik/all")
}
export default function Users() {
  const [error, setError] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  const [users, setUsers] = useState([]);
  const [searchParams, setSearchParams] = useSearchParams();

  useEffect(() => {
    fetch("http://localhost:8080/korisnik/get/all")
      .then((res) => res.json())
      .then(
        (result) => {
          setIsLoaded(true);
          setUsers(result);
        },
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
        <Button variant="primary" onClick={() => favoriteSongsFromOcene()}>Calculate favorite songs from ocene</Button>{' '}
        <Button variant="primary" onClick={() => favoriteSongsFromSlusanje()}>Calculate favorite songs from slusanje</Button>
        <ul>
          <input
            value={searchParams.get("filter") || ""}
            onChange={(event) => {
              let filter = event.target.value;
              if (filter) {
                setSearchParams({ filter });
              } else {
                setSearchParams({});
              }
            }}
          />
          {users
            .filter((user) => {
              let filter = searchParams.get("filter");
              if (!filter) return true;
              let name = user.username.toLowerCase();
              return name.startsWith(filter.toLowerCase());
            })
            .map((user) => (
              <NavLink
                style={({ isActive }) => {
                  return {
                    display: "block",
                    margin: "1rem 0",
                    color: isActive ? "red" : "",
                  };
                }}
                to={{
                  pathname: `/users/${user.id}`,
                }}
                key={user.id}
              >
                {user.username}
              </NavLink>
            ))}
        </ul>
        <Outlet />
      </div>
    );
  }
}
