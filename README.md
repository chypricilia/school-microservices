# Spring Boot Microservices 

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

1. **Service Registry (Eureka Server)** - running at http://localhost:8761
2. **School Service**
3. **Student Service**
4. **Config Server**
5. **API Gateway** - The endpoint on Postman would hit to `http://localhost:8090`

## APIs

### School Service

| Method | Endpoint                      | Description                              |
|--------|-------------------------------|------------------------------------------|
| GET    | /school                       | Retrieve all schools.                    |
| GET    | /school/{id}                  | Retrieve a school by ID.                 |
| GET    | /school/with-student          | Retrieve all schools with associated students. |
| POST   | /school                       | Add a new school. Request body should include code and name. |
| DELETE | /school/{id}                  | Delete a school by ID.                   |
| PATCH  | /school/{id}                  | Update a school. Request body should include id, code, and name. |

### Student Service

| Method | Endpoint                      | Description                              |
|--------|-------------------------------|------------------------------------------|
| GET    | /student                      | Retrieve all students.                   |
| GET    | /student/{id}                 | Retrieve a student by ID.                |
| POST   | /student                      | Add a new student. Request body should include name, schoolId, grade, and gender. |
| DELETE | /student/{id}                 | Delete a student by ID.                  |
| PATCH  | /student/{id}                 | Update a student. Request body should include id, name, schoolId, grade, and gender. |

## Additional Information

### Port Configuration

- **Service Registry (Eureka Server):** Running at http://localhost:8761
- **API Gateway:** The endpoint on Postman would hit to `http://localhost:8090`. If the default port is in use, you can change it by modifying the configuration files.

### Configuration Server

- The Config Server is responsible for serving configuration properties to all services. Ensure it is running before starting other services.

### Troubleshooting

- **Port Conflicts:** If the default port for any service is in use, you can change it by modifying the configuration files. For example, to change the port for the API Gateway, modify the configuration file and restart the service.
- If you encounter any issues, ensure that MySQL is installed and properly configured.
- Check the console logs for any error messages when starting the services.
