import React, { useEffect, useState } from "react";
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';


export default function Songs() {
    const [songs, setSongs] = useState([]);
    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    const rateSong = (korisnikId, pesmaId, grade) => {
        fetch(`http://localhost:8080/korisnik/rate/${korisnikId}/${pesmaId}/${grade}`, { method: 'GET' })
            .then(response => response.json())
            .then(data => setSongs(data));
        setShow(false);
    }

    useEffect(() => {

        fetch('http://localhost:8080/report/allSongs', { method: 'GET' })
            .then(response => response.json())
            .then(data => setSongs(data));
    }, []);

    return (
        <div>
            <Row xs={1} md={4} className="g-4">
                {songs.map((song, indx) => {
                    return (
                        <Col key={indx}>
                            <Card style={{ width: '18rem' }}>
                                <Card.Body>
                                    <Card.Title>{song.naziv}</Card.Title>
                                    <Card.Text>
                                        ID: {song.id} <br />
                                        Length: {song.duzina} <br />
                                        Number of Views: {song.brojSlusanja} <br />
                                    </Card.Text>
                                    <Button variant="primary" onClick={handleShow}>
                                        Rate
                                    </Button>
                                </Card.Body>
                            </Card>
                        </Col>
                    )
                })}
            </Row>


            <label htmlFor="user">User ID</label>
            <input className="form-control" id="userId" />

            <label htmlFor="grade">Grade</label>
            <input
                className="form-control"
                id="grade"
                placeholder="3"
                type="number"
                min="1"
                max="5"
            />
            
        </div>
    );
}
