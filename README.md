# practical-test-quipux
Simple solution for a practical test using Java Spring Boot.

# Author
- Jesus Caraballo

# Requirements
- Java 17
- [Maven](https://maven.apache.org/install.html)
- Git
- Postman

# Simple Development Guide
## Before to start
```sh
  # Clone
  git clone https://github.com/jesucluna/practical-test-quipux.git
```
```sh
  cd practical-test-quipux
```
## Steps
1. Build the project
```sh
  mvn clean install
```   
2. Run
```sh
  mvn spring-boot:run
```
3. The webservices are accessible via localhost:8080. You can see endpoints code in [Controller](src/main/java/com/quipux/practical_test/controller)
4. Import [collection](https://api.postman.com/collections/8508934-993e5a8f-0980-407f-8ba6-55bdd8213d98?access_key=) in Postman and read documentation
5. Test each endpoint the way is shown in collection documentation
