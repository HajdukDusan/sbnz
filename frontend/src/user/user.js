import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
export default function User() {
  const [user, setUser] = useState();
  const [error, setError] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  let params = useParams();
  useEffect(() => {
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
  return (
    <div>
      <h2>User</h2>
      <p>{JSON.stringify(user)}</p>
    </div>
  );
}
