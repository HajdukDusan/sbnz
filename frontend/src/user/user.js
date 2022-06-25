import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from 'axios';
import ListGroup from "react-bootstrap/ListGroup"
import Button from "react-bootstrap/Button"
import Col from "react-bootstrap/Col"
import Row from "react-bootstrap/Row"
import Card from "react-bootstrap/Card"


export default function User() {
  const [user, setUser] = useState();
  const [error, setError] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  const [simularUsers, setSimularUsers] = useState();

  const [recommendedSongs, setRecommendedSongs] = useState([]);

  const findSongRecommendation = (songId) => {
    const requestOptions = {
      method: 'GET',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        name: document.getElementById("searchInput"),
      })
    };
    fetch('http://localhost:8080/korisnik/songs/' + songId, requestOptions)
      .then(response => response.json())
      .then(data => setRecommendedSongs(data));
  }

  const fetchData = () => {
    const userUrl = "http://localhost:8080/korisnik/get/" + params.userId;
    const simularUrl = "http://localhost:8080/korisnik/simular/" + params.userId;
    const getUser = axios.get(userUrl)
    const getSimular = axios.get(simularUrl)
    axios.all([getUser, getSimular]).then(
      axios.spread((...allData) => {
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

  if (error) {
    return <div>Error: {error.message}</div>;
  } else if (!isLoaded) {
    return <div>Loading...</div>;
  } else {
    return (
      <div>
        <h2>User: {user.username}</h2>
        <h4>Favorite Songs:</h4>

        <ListGroup>
          <Row xs={1} md={4} className="g-4">

            {user.omiljenePesme.map((pesma, indx) => (
              <Col key={indx}>
                <ListGroup.Item key={pesma.id}>
                  <Card style={{ width: '18rem' }}>
                    <Card.Body>
                      <Card.Title>{pesma.naziv}</Card.Title>
                      <Card.Text>
                        ID: {pesma.id} <br />
                        Length: {pesma.duzina} <br />
                        Number of Views: {pesma.brojSlusanja} <br />
                      </Card.Text>
                    </Card.Body>
                  </Card>
                </ListGroup.Item>
              </Col>
            ))}



          </Row>
        </ListGroup>

        <h2>Simular users</h2>
        <ListGroup>
          {simularUsers.map((korisnik) => (<ListGroup.Item key={korisnik.username}>{korisnik.username}</ListGroup.Item>))}
        </ListGroup>

      </div>
    );
  }
}
