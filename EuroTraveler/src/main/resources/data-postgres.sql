INSERT INTO KORISNIK(email,username,password) VALUES ('pera','pera','pera'),
                                                     ('marko','marko','marko'),
                                                     ('ana','ana','ana'),
                                                    ('igor','igor','igor');

INSERT INTO ZANR (naziv) VALUES ('pera');

INSERT INTO IZVODJAC(naziv) values ('radiohead');

INSERT INTO PESMA(naziv,duzina,points,average_ocena,broj_slusanja) VALUES
('radiohead',130,0,0,500),
('Polozenie',300,0,0,500000),
('Rock You',500,0,0,50000000),
('Lost Road',130,0,0,500),
('ASAP ROCKY',130,0,0,500);

INSERT INTO PESMA(naziv,duzina,points,average_ocena,broj_slusanja,izvodjac_id) VALUES ('no surprises',130,0,0,500,1);
INSERT INTO PESMA(naziv,duzina,points,average_ocena,broj_slusanja,izvodjac_id) VALUES ('rockstar made',130,0,0,500,1);
INSERT INTO PESMA(naziv,duzina,points,average_ocena,broj_slusanja,izvodjac_id) VALUES ('Sigma Grindset',130,0,0,500,1);
INSERT INTO PESMA(naziv,duzina,points,average_ocena,broj_slusanja,izvodjac_id) VALUES ('Honest Person',130,0,0,500,1);
INSERT INTO PESMA(naziv,duzina,points,average_ocena,broj_slusanja,izvodjac_id) VALUES ('Ride Till We Die',130,0,0,500,1);
INSERT INTO PESMA(naziv,duzina,points,average_ocena,broj_slusanja,izvodjac_id) VALUES ('Paradice City',130,0,0,500,1);
INSERT INTO PESMA(naziv,duzina,points,average_ocena,broj_slusanja,izvodjac_id) VALUES ('Gangstas Paradice',130,0,0,500,1);
INSERT INTO PESMA(naziv,duzina,points,average_ocena,broj_slusanja,izvodjac_id) VALUES ('Fillings',130,0,0,500,1);
INSERT INTO PESMA(naziv,duzina,points,average_ocena,broj_slusanja,izvodjac_id) VALUES ('Happy or Sad',130,0,0,500,1);
INSERT INTO PESMA(naziv,duzina,points,average_ocena,broj_slusanja,izvodjac_id) VALUES ('Blur',130,0,0,500,1);
-- INSERT INTO OCENA(ocena,pesma_id) VALUES (1,1);
-- INSERT INTO OCENA(ocena,pesma_id) VALUES (2,1);
-- INSERT INTO OCENA(ocena,pesma_id) VALUES (3,1);


INSERT INTO OCENA(ocena,pesma_id,korisnik_id) VALUES (4,5,1);

INSERT INTO OCENA(ocena,pesma_id,korisnik_id) VALUES (5,2,1);
INSERT INTO OCENA(ocena,pesma_id,korisnik_id) VALUES (5,5,1);


INSERT INTO OCENA(ocena,pesma_id,korisnik_id) VALUES (5,5,2);

INSERT INTO OCENA(ocena,pesma_id,korisnik_id) VALUES (4,5,3);
INSERT INTO OCENA(ocena,pesma_id,korisnik_id) VALUES (4,5,3);
INSERT INTO OCENA(ocena,pesma_id,korisnik_id) VALUES (4,5,4);

INSERT INTO OCENA(ocena,pesma_id,korisnik_id) VALUES (4,5,4);
INSERT INTO OCENA(ocena,pesma_id,korisnik_id) VALUES (4,8,4);



INSERT INTO SLUSANJE(datum_slusanja,pesma_id,korisnik_id) VALUES ('2022-06-08 12:12:12',2,1);
INSERT INTO SLUSANJE(datum_slusanja,pesma_id,korisnik_id) VALUES ('2022-02-02 12:12:12',2,1);
INSERT INTO SLUSANJE(datum_slusanja, pesma_id,korisnik_id) VALUES ('2022-02-02 12:12:12',2,1);

INSERT INTO SLUSANJE(datum_slusanja,pesma_id,korisnik_id) VALUES ('2022-02-02 12:12:12',3,1);
INSERT INTO SLUSANJE(datum_slusanja,pesma_id,korisnik_id) VALUES ('2022-02-02 12:12:12',3,1);
INSERT INTO SLUSANJE(datum_slusanja, pesma_id,korisnik_id) VALUES ('2022-02-02 12:12:12',3,1);


INSERT INTO SLUSANJE(datum_slusanja,pesma_id,korisnik_id) VALUES ('2022-02-02 12:12:12',3,1);
INSERT INTO SLUSANJE(datum_slusanja, pesma_id,korisnik_id) VALUES ('2022-02-02 12:12:12',3,1);

INSERT INTO SLUSANJE(datum_slusanja,pesma_id,korisnik_id) VALUES ('2022-02-02 12:12:12',4,1);
INSERT INTO SLUSANJE(datum_slusanja, pesma_id,korisnik_id) VALUES ('2022-02-02 12:12:12',4,1);
INSERT INTO SLUSANJE(datum_slusanja, pesma_id,korisnik_id) VALUES ('2022-02-02 12:12:12',4,1);


INSERT INTO SLUSANJE(datum_slusanja,pesma_id,korisnik_id) VALUES ('2021-06-08 12:12:12',3,1);
INSERT INTO SLUSANJE(datum_slusanja,pesma_id,korisnik_id) VALUES ('2021-02-02 12:12:12',3,1);
INSERT INTO SLUSANJE(datum_slusanja, pesma_id,korisnik_id) VALUES ('2021-02-02 12:12:12',3,1);


INSERT INTO SLUSANJE(datum_slusanja, pesma_id,korisnik_id) VALUES ('2021-02-02 12:12:12',3,2);
INSERT INTO SLUSANJE(datum_slusanja, pesma_id,korisnik_id) VALUES ('2021-02-02 12:12:12',3,2);
INSERT INTO SLUSANJE(datum_slusanja, pesma_id,korisnik_id) VALUES ('2021-02-02 12:12:12',3,2);

--
-- INSERT INTO SLUSANJE(datum_slusanja, pesma_id,korisnik_id) VALUES ('2021-02-02 12:12:12',4,1);
-- INSERT INTO SLUSANJE(datum_slusanja, pesma_id,korisnik_id) VALUES ('2021-02-02 12:12:12',5,1);
-- INSERT INTO SLUSANJE(datum_slusanja, pesma_id,korisnik_id) VALUES ('2021-02-02 12:12:12',6,1);
-- INSERT INTO SLUSANJE(datum_slusanja, pesma_id,korisnik_id) VALUES ('2021-02-02 12:12:12',7,1);
-- INSERT INTO SLUSANJE(datum_slusanja, pesma_id,korisnik_id) VALUES ('2021-02-02 12:12:12',8,1);
-- INSERT INTO SLUSANJE(datum_slusanja, pesma_id,korisnik_id) VALUES ('2021-02-02 12:12:12',9,1);



INSERT INTO SLUSANJE(datum_slusanja,pesma_id,korisnik_id) VALUES ('2021-06-08 12:12:12',3,3);
INSERT INTO SLUSANJE(datum_slusanja,pesma_id,korisnik_id) VALUES ('2021-02-02 12:12:12',3,3);
INSERT INTO SLUSANJE(datum_slusanja, pesma_id,korisnik_id) VALUES ('2021-02-02 12:12:12',3,3);


INSERT INTO SLUSANJE(datum_slusanja,pesma_id,korisnik_id) VALUES ('2021-06-08 12:12:12',4,3);
INSERT INTO SLUSANJE(datum_slusanja,pesma_id,korisnik_id) VALUES ('2021-02-02 12:12:12',4,3);
INSERT INTO SLUSANJE(datum_slusanja, pesma_id,korisnik_id) VALUES ('2021-02-02 12:12:12',4,3);