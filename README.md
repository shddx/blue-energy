# Blue Energy  
___
### A content management system for gas service company.

This project is only for demonstration purposes and holds no other value.

The goal is to demonstrate the ability to solve various common challenges
that backend developers and developers in general face.

### This is project with multi-module maven structure. For now there are 2 main modules: 
- **repository module** that contains **api module** for interacting with various repository implementations 
and currently the only implementation which is **rdbms**.
- **admin module** has two parts: **backend module** that will have REST endpoints for accessing the service functionality,
  authentication and authorization configuration and exception handling. **client module** is our frontend.
  
## Build and run
___

### Requirements
- jdk >= 11
```
git clone https://github.com/ShaddiCS/blue-energy.git

cd blue-energy

mvnw -Dspring.profiles.active=RDBMS spring-boot:run
```

or

```
git clone https://github.com/ShaddiCS/blue-energy.git

cd blue-energy

mvnw clean package

cd admin/admin/backend/target

java -jar -Dspring.profiles.active=RDBMS blue-energy-bundle.jar
```
## Technologies used
___
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
