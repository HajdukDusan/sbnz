INSERT INTO KORISNIK(email,username,password) VALUES ('pera','pera','pera'),
                                                     ('pera1','pera1','pera1'),
                                                     ('pera2','pera2','pera2'),
                                                    ('pera3','pera3','pera3');

INSERT INTO ZANR (naziv) VALUES ('pera');

INSERT INTO IZVODJAC(naziv) values ('radiohead');

INSERT INTO PESMA(naziv,duzina,points,average_ocena,broj_slusanja) VALUES
                                                                       ('radiohead',130,0,0,500),('p2',300,0,0,500000),('p3',500,0,0,50000000),('p4',130,0,0,500),('p5',130,0,0,500);

INSERT INTO PESMA(naziv,duzina,points,average_ocena,broj_slusanja,izvodjac_id) VALUES ('no surprises',130,0,0,500,1);
INSERT INTO PESMA(naziv,duzina,points,average_ocena,broj_slusanja,izvodjac_id) VALUES ('rockstar made',130,0,0,500,1);
INSERT INTO PESMA(naziv,duzina,points,average_ocena,broj_slusanja,izvodjac_id) VALUES ('pesma1',130,0,0,500,1);
INSERT INTO PESMA(naziv,duzina,points,average_ocena,broj_slusanja,izvodjac_id) VALUES ('pesma2',130,0,0,500,1);
INSERT INTO PESMA(naziv,duzina,points,average_ocena,broj_slusanja,izvodjac_id) VALUES ('pesma3',130,0,0,500,1);
INSERT INTO PESMA(naziv,duzina,points,average_ocena,broj_slusanja,izvodjac_id) VALUES ('pesma4',130,0,0,500,1);
INSERT INTO PESMA(naziv,duzina,points,average_ocena,broj_slusanja,izvodjac_id) VALUES ('pesma5',130,0,0,500,1);
INSERT INTO PESMA(naziv,duzina,points,average_ocena,broj_slusanja,izvodjac_id) VALUES ('pesma6',130,0,0,500,1);
INSERT INTO PESMA(naziv,duzina,points,average_ocena,broj_slusanja,izvodjac_id) VALUES ('pesma7',130,0,0,500,1);
INSERT INTO PESMA(naziv,duzina,points,average_ocena,broj_slusanja,izvodjac_id) VALUES ('pesma8',130,0,0,500,1);
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