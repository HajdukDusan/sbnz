import React, { useEffect, useState } from "react";
import { useLocation, useParams } from "react-router-dom";
export default function User() {
  const [user, setUser] = useState();
  const [error, setError] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  let params = useParams();
  const location = useLocation;
  useEffect((location) => {
    console.log("location" + params.userId);
  });
  useEffect((location) => {
    fetch("http://localhost:8080/korisnik/get/" + params.userId)
      .then((res) => res.json())
      .then(
        (result) => {
          setIsLoaded(true);
          setUser(result);
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
        <h2>User</h2>
        <p>{user.username}</p>
      </div>
    );
  }
}
