# Kotlin DDD Sample

**Kotlin DDD Sample** is a open-source project meant to be used as a start point, or an inspiration, for those who want to build Domain Driven Design applications in Kotlin. The domain model was inspired by [this](https://github.com/mcapanema/ddd-rails-example) repo where we built a sample project using Rails.

**NOTE:** This is NOT intended to be a definitive solution or a production ready project

# Technologies/frameworks/tools involved

- Kotlin
- Spring
- Axon Framework
  - CommandGateway (Command Handlers)
  - EventBus (Event Handlers)
- Gradle

# Architecture overview

## Layers
- **Web**: Spring controllers and actions
- **Application**: Orchestrates the jobs in the domain needed to be done to accomplish a certain "use case"
- **Domain**: Where the business rules resides
- **Infrastructure**: Technologies concerns resides here (database access, sending emails, calling external APIs)

## CQRS

CQRS splits your application (and even the database in some cases) into two different paths: **Commands** and **Queries**.
 
### Command side

Every operation that can trigger an side effect on the server must pass through the CQRS "command side". I like to put the `Handlers` (commands handlers and events handlers) inside the application layer because their goals are almost the same: orchestrate domain operations (also usually using infrastructure services). 
 
![command side](docs/images/command_side_with_events.jpg)

### Query side

Pretty straight forward, the controller receives the request, calls the related query repo and returns a DTO (defined on infrastructure layer itself). 

![query side](docs/images/query_side.jpg)

# The domain (problem space)

This project is based on a didactic domain that basically consists in maintaining an Order (adding and removing items in it). The operations supported by the application are:

* Create an order 
* Add products ta a given order
* Change product quantity
* Remove product
* Pay the order
* Shipping: ships product and notify user

# Setup

**Linux/MacOS:** 

```
./gradlew build
```

**Windows:**

```
gradlew.bat build
```

# Tests

```
./gradlew test
```

# Backlog
- [x] Implement Unit Tests examples (Domain layer)
- [x] Implement Integrated Tests examples (Web layer)
- [ ] Include docker container with JDK and gradle configured
- [ ] Configure Swagger and Swagger UI
- [ ] Include a Event Sourced bounded context or Aggregate
- [ ] Domain Notifications instead of raising exceptions
- [x] Implement concrete repositories with JPA (the current implementations just returns fake instances)

