# Regulatory Management
Project for managing regulations for employees who work in activities that require mandatory courses by the Ministry of Labor

## Projects technologies
- [x] Spring Boot 3.1.5
- [x] Spring Web
- [x] Spring Security
- [x] Spring Boot JPA
- [x] Spring Validations
- [x] H2 Database and Postgresql
- [x] Java JWT 4.4.0

## Conceptual model
![newModel](https://github.com/AlissonWenceslau/regulatory-management/assets/74499967/02f49347-6501-45fe-bbdb-bac0500d7fc1)
## Objects Instances
![instances](https://github.com/AlissonWenceslau/regulatory-management/assets/74499967/ae287896-0062-4535-896f-9949c43c0e8f)
### Get dynamic token on Postman
```javascript
if(responseCode.code >= 200 && responseCode.code < 300){
    var json = JSON.parse(responseBody);
    postman.setEnvironmentVariable('token', json.token);
}
```
 
