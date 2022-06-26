import React, { useEffect, useState } from "react";
import Table from 'react-bootstrap/Table';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';


export default function Report() {
    const [songs, setSongs] = useState([]);

    const refreshData = () => {
        fetch('http://localhost:8080/report/all')
        console.log("Refreshed data");
    }

    const fetchData = () => {
        console.log("Fetching data")
        console.log(document.getElementById("datepick").value)
        fetch(`http://localhost:8080/report/all/${document.getElementById("datepick").value}`, { method: 'GET' })
            .then(response => response.json())
            .then(data => {
                setSongs(data);
                console.log(data);
            });
    }

    useEffect(async () => {
        await refreshData();
        fetchData();
    }, []);

    return (
        <div>

            <h2> Top Songs By Score</h2>

            <div className="row">
                <div className="col-md-4">
                    <Form.Group controlId="dob">
                        <Form.Label>Select Date</Form.Label>
                        <Form.Control id="datepick" type="date" name="dob" placeholder="Date of Birth" onChange={fetchData} />
                    </Form.Group>
                </div>
            </div>

            <br />
            <Container text>
                <Table striped bordered hover>
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Name</th>
                            <th>Points</th>
                            <th>Views</th>
                            <th>Length</th>
                        </tr>
                    </thead>
                    <tbody>
                        {songs.map((song, indx) => {
                            return (
                                <tr key={indx}>
                                    <td>{indx + 1}</td>
                                    <td>{song.naziv}</td>
                                    <td>{song.points}</td>
                                    <td>{song.brojSlusanja}</td>
                                    <td>{song.duzina}</td>
                                </tr>
                            )
                        })}
                    </tbody>

                </Table>
            </Container>
        </div>
    );
}
