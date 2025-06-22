-- Create Database
CREATE DATABASE coursesdb;

-- Switch to DB
\c coursesdb;

-- Create table: course
CREATE TABLE courses (
  id SERIAL PRIMARY KEY,
  course_id VARCHAR(10) UNIQUE NOT NULL,
  title VARCHAR(255) NOT NULL,
  description TEXT
);

-- Create table: prerequisites
CREATE TABLE prerequisites (
  course_id VARCHAR(10) NOT NULL,
  prerequisite_id VARCHAR(10) NOT NULL,
  PRIMARY KEY (course_id, prerequisite_id),
  FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE,
  FOREIGN KEY (prerequisite_id) REFERENCES courses(course_id)
);

-- Create table: instances
CREATE TABLE course_instances (
  id SERIAL PRIMARY KEY,
  course_id VARCHAR(10) NOT NULL,
  year INTEGER NOT NULL,
  semester INTEGER NOT NULL,
  FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);
