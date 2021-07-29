# Blue Energy  

### A content management system for gas service company.

This project is only for demonstration purposes and holds no other value.

The goal is to demonstrate the ability to solve various common challenges
that backend developers and developers in general face.

### Project has multi-module maven structure. For now there are 2 main modules: 
- **repository module** that contains **api module** for interacting with various repository implementations 
and currently the only implementation which is **rdbms**.
- **admin module** has two parts: **backend module** that will have REST endpoints for accessing the service functionality,
  authentication and authorization configuration and exception handling. **client module** is our frontend.
  
## Build and run


### Requirements
- jdk >= 11
- PostgreSQL >= 13

#### 1. Clone repository
```
git clone https://github.com/ShaddiCS/blue-energy.git
```
#### 2. Set up database
```sql
createdb -U <username> -E UTF-8 blue-energy-db
```
#### 3. Run
```
cd blue-energy

mvnw -Dspring.profiles.active=RDBMS spring-boot:run
```

or

```
cd blue-energy

mvnw clean package

java -jar -Dspring.profiles.active=RDBMS admin/admin/backend/target/blue-energy-bundle.jar
```
The application will start running at http://localhost:4333.

## Technologies used

### Backend
- Spring Boot
- Spring Data JPA
- Spring Security
- Lombok
- PostgreSQL


### Frontend
- Vue.js
- Typescript
- Element plus
- Vite
- Tailwind
