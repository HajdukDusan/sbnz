import React, { useEffect, useState } from "react";
import {  useParams } from "react-router-dom";
import axios from 'axios';
import ListGroup from "react-bootstrap/ListGroup"
import Button from "react-bootstrap/Button"


export default function User() {
  const [user, setUser] = useState();
  const [error, setError] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  const [simularUsers,setSimularUsers] = useState();

  const fetchData = () => {
    const userUrl = "http://localhost:8080/korisnik/get/" + params.userId;
    const simularUrl= "http://localhost:8080/korisnik/simular/" + params.userId;
    const getUser = axios.get(userUrl)
    const getSimular = axios.get(simularUrl)
    axios.all([getUser,getSimular]).then(
      axios.spread((... allData) => {
        const userData = allData[0].data
        const simularUsers = allData[1].data
        setUser(userData)
        setSimularUsers(simularUsers)
        setIsLoaded(true);
      }
    ))
  }

  let params = useParams();
  useEffect(() => {
    fetchData()
  }, [params]);


  useEffect(() => {
    fetch("http://localhost:8080/korisnik/simular/" + params.userId)
    .then((res) => res.json())
      .then(
        (result) => {
          setSimularUsers(result);
          
        },
        (error) => {
        }
      );
    }, [params]);

  if (error) {
    return <div>Error: {error.message}</div>;
  } else if (!isLoaded) {
    return <div>Loading...</div>;
  } else {
    return (
      <div>
        <h2>User</h2>
        <ListGroup>
        {user.omiljenePesme.map((pesma) => (<ListGroup.Item key={pesma.id}>{pesma.naziv}</ListGroup.Item>))}
        </ListGroup>
        <h2>Simular users</h2>
        <ListGroup>
        {simularUsers.map((pesma) => (<ListGroup.Item key={pesma.username}>{pesma.username}</ListGroup.Item>))}
        </ListGroup>
        
      </div>
    );
  }
}
