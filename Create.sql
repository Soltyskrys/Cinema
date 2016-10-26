CREATE TABLE Movie
(
id INTEGER NOT NULL PRIMARY KEY,
name CHARACTER,
durationInMinutes FLOAT,
description CHARACTER
);


CREATE TABLE Show
(
id INTEGER NOT NULL PRIMARY KEY,
movie_id integer NOT NULL  references Movie(id)
);


CREATE TABLE Seat
(
id INTEGER NOT NULL PRIMARY KEY,
row INTEGER NOT NULL,
number INTEGER NOT NULL
);

CREATE TABLE Client
(
id INTEGER NOT NULL PRIMARY KEY

);

CREATE TABLE Reservation
(
id INTEGER NOT NULL PRIMARY KEY,

id_client INTEGER NOT NULL references Client(id),
id_show INTEGER NOT NULL references Show(id),
is_seat INTEGER NOT NULL references Seat(id)

);



CREATE TABLE Discount
(
name CHARACTER NOT NULL PRIMARY KEY
);

