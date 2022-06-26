import React, { useEffect, useState } from "react";
import { useParams,useSearchParams } from "react-router-dom";
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

  const [searchParams, setSearchParams] = useState("");
  const [recommendedSongs, setRecommendedSongs] = useState([]);

  // const findSongRecommendation = (searchValue) => {
  //   setSearchParams(searchValue);
  //   const requestOptions = {
  //     method: 'POST',
  //     headers: { 'Content-Type': 'application/json' },
  //     body: JSON.stringify({
  //       name: searchParams,
  //     })
  //   };
  //   fetch('http://localhost:8080/korisnik/songs/' + params.userId, requestOptions)
  //     .then(response => response.json()).then(data => setRecommendedSongs(data));
      
  // }

  useEffect(() => {
    const requestOptions = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        name: searchParams,
      })
    };
    fetch('http://localhost:8080/korisnik/songs/' + params.userId, requestOptions)
      .then(response => response.json()).then(data => setRecommendedSongs(data));
  },[searchParams]);

  const fetchData = () => {
    const userUrl = "http://localhost:8080/korisnik/get/" + params.userId;
    const simularUrl = "http://localhost:8080/korisnik/simular/" + params.userId;
    const songsRecUrl = "http://localhost:8080/korisnik/songs/" + params.userId;
    const getUser = axios.get(userUrl)
    const getSimular = axios.get(simularUrl)
    const getSongs = axios.get(songsRecUrl)
    axios.all([getUser, getSimular,getSongs]).then(
      axios.spread((...allData) => {
        const userData = allData[0].data
        const simularUsers = allData[1].data
        const recommendedSong = allData[2].data
        setUser(userData)
        setSimularUsers(simularUsers)
        setRecommendedSongs(recommendedSong)
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
        <hr/>
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

        <h4>Simular users</h4>
        <ListGroup>
          {simularUsers.map((korisnik) => (<ListGroup.Item key={korisnik.username}>{korisnik.username} Simularity: {korisnik.simularity}</ListGroup.Item>))}
        </ListGroup>
        <h4>Song recommendations</h4>
        <input
            id="searchInput"
            value={searchParams}
            
            onChange={(event) => {
              setSearchParams(event.target.value)
              // findSongRecommendation(event.target.value)
            }}
          />
        <ListGroup>
          {recommendedSongs.map((pesma) => (<ListGroup.Item key={pesma.id}>{pesma.naziv}</ListGroup.Item>))}
        </ListGroup>
      </div>
    );
  }
}
