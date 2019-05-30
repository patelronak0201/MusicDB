--Artists----------------------------------------------------------------------
insert into artist(id, name) values (1, 'Muse');
insert into artist(id, name) values (2, 'Duran Duran');
insert into artist(id, name) values (3, 'Van Halen');

--Albums----------------------------------------------------------------------
insert into album(id, name, year_released) values (1, 'Drones', 2015);
insert into album(id, name, year_released) values (2, 'Origin of Symmetry', 2001);
insert into album(id, name, year_released) values (3, 'Rio', 1982);
insert into album(id, name, year_released) values (4, '1984', 1984);

insert into artist_albums(artist_id, albums_id) values(1, 1);
insert into artist_albums(artist_id, albums_id) values(1, 2);
insert into artist_albums(artist_id, albums_id) values(2, 3);
insert into artist_albums(artist_id, albums_id) values(3, 4);

--Songs----------------------------------------------------------------------
--Muse-Drones
