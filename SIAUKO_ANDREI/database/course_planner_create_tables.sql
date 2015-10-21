CREATE SCHEMA IF NOT EXISTS course_planner_schema;

CREATE TABLE IF NOT EXISTS course_planner_schema.Lecturer
(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (id)
);

CREATE TABLE IF NOT EXISTS course_planner_schema.Course
(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL,
	section VARCHAR(100) NOT NULL,
	start_date DATE NOT NULL,
	end_date DATE NOT NULL,
	id_lecturer INT,
	PRIMARY KEY (id),
	FOREIGN KEY (id_lecturer) REFERENCES Lecturer(id),
	UNIQUE (id)
);

CREATE TABLE IF NOT EXISTS course_planner_schema.Student
(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	id_course INT,
	PRIMARY KEY (id),
	FOREIGN KEY (id_course) REFERENCES Course(id),
	UNIQUE (id)
);

CREATE TABLE IF NOT EXISTS course_planner_schema.Lecture
(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL,
	date DATE,
	id_course INT,
	PRIMARY KEY (id),
	FOREIGN KEY (id_course) REFERENCES Course(id),
	UNIQUE (id)
);

INSERT INTO course_planner_schema.Lecturer (name)
	VALUE
		('KOWALSKI'),
		('NOWAK'),
		('OSTROWSKI');

INSERT INTO course_planner_schema.Course (name, section, start_date, end_date, id_lecturer)
	VALUE
		('discrete mathematics', 'mathematics', '2015-10-13', '2015-11-30', 2),
		('probability theory', 'mathematics', '2015-11-19', '2015-12-20', 2),
		('mathematical analysis', 'mathematics', '2015-09-01', '2015-12-31', 1),
		('economic theory', 'economy', '2015-01-02', '2015-05-03', 3);

INSERT INTO course_planner_schema.Student (name, id_course)
	VALUE
		('Daniel', 1),
		('Marcin', 3),
		('Robert', 2),
		('Katarzyna', 4),
		('Michal', 1);

INSERT INTO course_planner_schema.Lecture (name, date, id_course)
	VALUE
		('limit', '2012-11-10', 1),
		('derivative', '2013-11-03', 3),
		('stochastic processes', '2013-11-03', 2),
		('theory of the firm', '2014-02-04', 4);
