--STATUS
INSERT INTO status VALUES (NEXTVAL('status_seq'), 'Budzet','B');
INSERT INTO status VALUES (NEXTVAL('status_seq'), 'Samofinansiranje','S');

INSERT INTO status VALUES (-100, 'TestStatus','TS');

--FAKULTET

INSERT INTO fakultet VALUES (NEXTVAL('fakultet_seq'), 'Fakultet tehnickih nauka', 'Novi Sad');
INSERT INTO fakultet VALUES (NEXTVAL('fakultet_seq'), 'Ekonomski fakultet', 'Subotica');
INSERT INTO fakultet VALUES (NEXTVAL('fakultet_seq'), 'Arhitektonski fakultet', 'Beograd');
INSERT INTO fakultet VALUES (NEXTVAL('fakultet_seq'), 'Poljoprivredni fakultet', 'Novi Sad');

INSERT INTO fakultet VALUES (-100, 'TestFaks', 'TestSediste');

--DEPARTMAN
INSERT INTO departman VALUES (NEXTVAL('departman_seq'), 'Departman za industrijsko inzenjerstvo i menadzment', 'DIIM', 1);
INSERT INTO departman VALUES (NEXTVAL('departman_seq'), 'Departman za energetiku, elektroniku i telekomunikacije', 'DEET', 1);

INSERT INTO departman VALUES (NEXTVAL('departman_seq'), 'Departman za finansije i racunovodstvo', 'DFR', 2);
INSERT INTO departman VALUES (NEXTVAL('departman_seq'), 'Departman za poslovnu informatiku i kvantitativne metode', 'DPIKM', 2);

INSERT INTO departman VALUES (NEXTVAL('departman_seq'), 'Departman za arhitekturu', 'DA', 3);
INSERT INTO departman VALUES (NEXTVAL('departman_seq'), 'Departman za urbanizam', 'DU', 3);

INSERT INTO departman VALUES (NEXTVAL('departman_seq'), 'Departman za poljoprivrednu tehniku', 'DPT', 4);
INSERT INTO departman VALUES (NEXTVAL('departman_seq'), 'Departman za veterinarsku medicinu', 'DVM', 4);

INSERT INTO departman VALUES (-100, 'TestDepartman', 'DT', 1);

--STUDENT
INSERT INTO student(id, ime, prezime, broj_indeksa, status, departman) VALUES (NEXTVAL('student_seq'), 'Ana', 'Kovacevic', 'I15/2019', 1, 1);
INSERT INTO student(id, ime, prezime, broj_indeksa, status, departman) VALUES (NEXTVAL('student_seq'), 'Luka', 'Pavlovic', 'M45/2020', 2, 1);

INSERT INTO student(id, ime, prezime, broj_indeksa, status, departman) VALUES (NEXTVAL('student_seq'), 'Filip', 'Filipovic', 'E54/2018', 2, 2);
INSERT INTO student(id, ime, prezime, broj_indeksa, status, departman) VALUES (NEXTVAL('student_seq'), 'Ema', 'Vasic', 'T7/2020', 1, 2);

INSERT INTO student(id, ime, prezime, broj_indeksa, status, departman) VALUES (NEXTVAL('student_seq'), 'Sara', 'Jovanovic', 'F20/2017', 2, 3);
INSERT INTO student(id, ime, prezime, broj_indeksa, status, departman) VALUES (NEXTVAL('student_seq'), 'Nikola', 'Ivanic', 'R2/2019', 1, 3);

INSERT INTO student(id, ime, prezime, broj_indeksa, status, departman) VALUES (NEXTVAL('student_seq'), 'Pera', 'Peric', 'I42/2020', 2, 4);
INSERT INTO student(id, ime, prezime, broj_indeksa, status, departman) VALUES (NEXTVAL('student_seq'), 'Iva', 'Lazic', 'K12/2018', 1, 4);

INSERT INTO student(id, ime, prezime, broj_indeksa, status, departman) VALUES (NEXTVAL('student_seq'), 'Jelena', 'Vidovic', 'A14/2019', 1, 5);
INSERT INTO student(id, ime, prezime, broj_indeksa, status, departman) VALUES (NEXTVAL('student_seq'), 'Milos', 'Matic', 'A22/2020', 1, 5);

INSERT INTO student(id, ime, prezime, broj_indeksa, status, departman) VALUES (NEXTVAL('student_seq'), 'Stefan', 'Kovac', 'U61/2018', 1, 6);
INSERT INTO student(id, ime, prezime, broj_indeksa, status, departman) VALUES (NEXTVAL('student_seq'), 'Marija', 'Bilic', 'U17/2017', 2, 6);

INSERT INTO student(id, ime, prezime, broj_indeksa, status, departman) VALUES (NEXTVAL('student_seq'), 'Milica', 'Katic', 'T21/2018', 1, 7);
INSERT INTO student(id, ime, prezime, broj_indeksa, status, departman) VALUES (NEXTVAL('student_seq'), 'Dejan', 'Horvat', 'T4/2019', 1, 7);

INSERT INTO student(id, ime, prezime, broj_indeksa, status, departman) VALUES (NEXTVAL('student_seq'), 'Goran', 'Pavic', 'V30/2020', 1, 8);
INSERT INTO student(id, ime, prezime, broj_indeksa, status, departman) VALUES (NEXTVAL('student_seq'), 'Vera', 'Juric', 'V14/2018', 2, 8);

INSERT INTO student(id, ime, prezime, broj_indeksa, status, departman) VALUES (-100, 'Test', 'Student', 'TS1/1', 1, 1);