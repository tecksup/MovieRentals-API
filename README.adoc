# MovieRentals-API
 A SpringBoot project for learning how things work. Will keep track of movie rentals.


A simple movie-rental API, using Postman to interact with it. The API should follow RESTful best practices and should support the following operations: GET, DELETE, and POST. With no security/authentication for now. The entities will be: Movie, Reservation.

Ideally we should be able to:

* See how many movies are available
* See how many movies have been reserved
* Create a reservation
* Delete a reservation


Technically, I'd have the whole DTO + DAO + ObjectMapper for each entity, but that'd just be annoying: I'll already have plenty of work there.
Those are all things that are (usually) in the day-to-day life of a REST API developer that uses Spring. :man_shrugging: 
Some of the tech stack was arbitrarily chosen, but they are for the most part the most popular choices so it won't be wasted effort to have learned them.

### Some extra challenges:
- [*] Extract all normal logic from the Controller: it should be the Service layer that takes care of that.
- [ ] Normal logic assumes all inputs are correct: use javax.constraints (`@Validated`) to take care of that
- [ ] Use `@ControllerAdvice` for controlling the error handling separately from this all
- [ ] Understand how to can use application.properties, along with Spring Profiles, to control the flow of the application: it should have a local and a prod profile.
- [ ] For each profile, use a different database: first, the local profile should connect to an H2 (in-memory) database, and then prod should instead connect to a PosgreSQL database that would run locally (it would actually be in the cloud or whatever, but for the purpose of this exercise we'll just make sure it can connect to 2 different DBs using profiles configuration)
- [ ] Use Hibernate along with Spring Data to set up `@Repository` classes that would manage the connection and SQL calls to the DBs.
- [ ] Those repositories should be injected in the service layers. The Controller should never see the repositories.
- [ ] Create a few test classes that use Jupiter for setting up the scenarios (`@BeforeEach`) and making some assertions (Assertions.asserTrue(...)). Those tests should use their own H2 DB. Simply make those integration tests (so go ahead and use `@SpringBootTest`, which will load the entire context).
- [ ] Create some unit tests for any specific class using Mockito.
- [ ] Add an OpenAPI documentation ("Swagger v3") to the project to help other people discover the API without having to read through the entire documentation. 


Credit https://github.com/payne911 for helping me put together the project requirements in a manner that will best help me learn the important parts of SpringBoot. 
