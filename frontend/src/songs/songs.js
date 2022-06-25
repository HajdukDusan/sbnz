import React, { useEffect, useState } from "react";
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';


export default function Songs() {
    const [songs, setSongs] = useState([]);
    const [show, setShow] = useState(false);


    let pesmaId = 0;
    const handleClose = () => setShow(false);
    const handleShow = (songId) => {
        pesmaId = songId;
        setShow(true);
    }

    const rateSong = () => {
        fetch(`http://localhost:8080/korisnik/rate/${
            document.getElementById("userId").value
        }/${pesmaId}/${
            document.getElementById("grade").value.toString()
        }`, { method: 'GET' })
            .then(response => response.json())
            .then(data => setSongs(data));
        setShow(false);
        window.location.reload();
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
                                    <Button variant="primary" onClick={() => handleShow(song.id)}>
                                        Rate
                                    </Button>
                                </Card.Body>
                            </Card>
                        </Col>
                    )
                })}
            </Row>

            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Rate Song</Modal.Title>
                </Modal.Header>
                <Modal.Body>
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
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Cancel
                    </Button>
                    <Button variant="primary" onClick={rateSong}>
                        Rate
                    </Button>
                </Modal.Footer>
            </Modal>
        </div>
    );
}
