CREATE TABLE users
(
    id SERIAL PRIMARY KEY,
    fullname VARCHAR(100),
    email VARCHAR(100),
    password text,
    country VARCHAR(100),
    birthday date,
    gender VARCHAR(50),
    address VARCHAR(200),
    phonenumber VARCHAR(50),
    preferredlanguage VARCHAR(100),
    educationlevel VARCHAR(100)
);

CREATE TABLE courses
(
    id SERIAL PRIMARY KEY,
    title VARCHAR(200),
    description text,
    rating float,
    nreviews integer,
    duration time without time zone
);

CREATE TABLE users_courses(
    id SERIAL PRIMARY KEY,
    userid INTEGER REFERENCES users(id),
    courseid INTEGER REFERENCES courses(id)
);

ALTER TABLE users
    ADD CONSTRAINT email_unique UNIQUE (email);

INSERT INTO courses(title,description,rating,nreviews,duration)
VALUES('Java Advanced','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque id dui ac lectus aliquam volutpat eu ut tortor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer mattis tortor mauris.',4.8,100,'3:00:00');

INSERT INTO courses(title,description,rating,nreviews,duration)
VALUES('Javascript Basic','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque id dui ac lectus aliquam volutpat eu ut tortor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer mattis tortor mauris.',4.8,100,'3:00:00');

INSERT INTO courses(title,description,rating,nreviews,duration)
VALUES('Python','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque id dui ac lectus aliquam volutpat eu ut tortor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer mattis tortor mauris.',4.8,100,'3:00:00');

INSERT INTO courses(title,description,rating,nreviews,duration)
VALUES('UI/UX Design','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque id dui ac lectus aliquam volutpat eu ut tortor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer mattis tortor mauris.',4.8,100,'3:00:00');

INSERT INTO courses(title,description,rating,nreviews,duration)
VALUES('Spring Boot','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque id dui ac lectus aliquam volutpat eu ut tortor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer mattis tortor mauris.',4.8,100,'3:00:00');

INSERT INTO courses(title,description,rating,nreviews,duration)
VALUES('Vue.js Advanced','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque id dui ac lectus aliquam volutpat eu ut tortor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer mattis tortor mauris.',4.8,100,'3:00:00');