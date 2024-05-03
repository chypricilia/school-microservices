# School Microservices 

This is an example project showcasing school microservices architecture using Spring Boot for each service. The project consists of the following services:

- Service Registry
- School Service
- Student Service
- Config Server
- API Gateway

## Prerequisites

Before running the microservices, ensure you have MySQL installed and configured. The project assumes the use of MySQL. Here's how to set up the databases:

1. Create the `school_db` database.
2. Create the `student_db` database.

Once you've created the databases, you can run the project. The tables will be automatically created based on the entity definitions. You can then insert sample data using the provided SQL queries or add data through the APIs.

## SQL Queries

You can find the SQL queries to set up the databases and tables in the `sql` folder.

## Postman Examples

You can find example Postman requests in the `postman` folder.

## Running the Services

The microservices should be run sequentially in the following order:

1. Service Registry (Eureka Server) - running at http://localhost:8761
2. School Service
3. Student Service
4. Config Server
5. API Gateway - end point on Postman would hit to `http://localhost:8090`

## APIs

### School Service

1. **GET /school**: Retrieve all schools.
2. **GET /school/{id}**: Retrieve a school by ID.
3. **GET /school/with-student**: Retrieve all schools with associated students.
4. **POST /school**: Add a new school. Request body should include code and name.
5. **DELETE /school/{id}**: Delete a school by ID.
6. **PATCH /school/{id}**: Update a school. Request body should include id, code, and name.

### Student Service

1. **GET /student**: Retrieve all students.
2. **GET /student/{id}**: Retrieve a student by ID.
3. **POST /student**: Add a new student. Request body should include name, schoolId, grade, and gender.
4. **DELETE /student/{id}**: Delete a student by ID.
5. **PATCH /student/{id}**: Update a student. Request body should include id, name, schoolId, grade, and gender.
