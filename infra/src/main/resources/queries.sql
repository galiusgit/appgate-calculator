--
-- File generated with SQLiteStudio v3.3.3 on mié. oct. 6 03:45:38 2021
--
-- Text encoding used: UTF-8
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: calc_session
CREATE TABLE calc_session (id varchar not null, creation_date timestamp not null, description varchar, result numeric, status varchar not null, update_date timestamp not null, primary key (id));

-- Table: operation
CREATE TABLE operation (id varchar NOT NULL, calc_session_id varchar NOT NULL, creation_date timestamp NOT NULL, description varchar, other_session_id varchar, operator integer, type varchar NOT NULL, value numeric NOT NULL, PRIMARY KEY (id), FOREIGN KEY (calc_session_id) REFERENCES calc_session (id) ON DELETE CASCADE ON UPDATE CASCADE);

-- Index: index_operation_calc_session_id
CREATE INDEX index_operation_calc_session_id ON operation (calc_session_id);

-- Index: index_operation_creation_date
CREATE INDEX index_operation_creation_date ON operation (creation_date);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;


-----------------------------


select * from operation where calc_session_id = '';

select * from operation where calc_session_id = '' and type = 'RESULT'
order by creation_date desc limit 1;