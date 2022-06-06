INSERT INTO KORISNIK(email,username,password) VALUES ('pera','pera','pera'),('pera1','pera1','pera1');

INSERT INTO ZANR (naziv) VALUES ('pera');

INSERT INTO PESMA(naziv,duzina,points,average_ocena,broj_slusanja) VALUES ('p1',130,0,0,500),('p2',300,0,0,500000),('p3',500,0,0,50000000);
--
-- INSERT INTO OCENA(ocena,pesma_id) VALUES (1,1);
-- INSERT INTO OCENA(ocena,pesma_id) VALUES (2,1);
-- INSERT INTO OCENA(ocena,pesma_id) VALUES (3,1);
INSERT INTO OCENA(ocena,pesma_id,korisnik_id) VALUES (4,1,1);

INSERT INTO OCENA(ocena,pesma_id,korisnik_id) VALUES (5,2,1);
-- INSERT INTO OCENA(ocena,pesma_id) VALUES (3,2);
-- INSERT INTO OCENA(ocena,pesma_id) VALUES (4,2);
-- INSERT INTO OCENA(ocena,pesma_id) VALUES (4,2);