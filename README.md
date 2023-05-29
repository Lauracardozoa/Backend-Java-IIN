# Evaluation Java Backend Developer

1. For run the backend application you have to install Postgre SQL from https://www.postgresql.org/download/

2. After that you have to create a database on PostgreSQL with the name `backend`

3. Then you have to run the file `config.sql` located on the base path of this repo, this file helps you to create the
database tables and also populate the courses table.

4. To Finalize the configuration you have to configure your DB username and password on the file `application.properties`
which is located in the `src/main/resources` you have to change 
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/backend
spring.datasource.username=$USER
spring.datasource.password=$PASSWORD
```
You have to put your PostgreSQL database user on `$USER` and your PostgreSQL database passord on `$PASSWORD`,
you can also change the port of your local DB replacing `5432` with the port or the name of your DB replacing `backend` on `spring.datasource.url` property.
