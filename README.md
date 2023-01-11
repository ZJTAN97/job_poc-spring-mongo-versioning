# Mongo Versioning of Sub Documents

# Objectives

- Explore possibility to allow versioning at embedded document level
- Find out if changing sub-documents causes the root level version to change

<br>

# Set up for Repository

- For easier understanding and usage, you can opt not to "test" by running the server.
- Can just look into the test cases to understand how the Research Results came about.

<br>

# Research Results

### Id Related

- `@Id` does not support Embedded documents.

<br>

### Version Related

| Root Document update | Embedded Document update | Root Version Change? | Embedded Document Version Change? |
|:--------------------:|:------------------------:|:--------------------:|:---------------------------------:|
|         Yes          |            No            |         Yes          |               Null                |
|          No          |           Yes            |         Yes          |               Null                |

From the table above, the conclusions are as followed:

- As long an update is performed (in context of Spring Data Mongo) as long as the `save` method is called, versioning
  will increment.
- `@Version` does not support Embedded documents.

<br>

# References

- [More on Optimistic Locking](https://www.baeldung.com/jpa-optimistic-locking)
- [Embbeded Id issue](https://stackoverflow.com/questions/56913429/how-to-create-an-id-within-the-embedded-document-using-mongodb-and-spring-data)
- [Embedded Id issue 2](https://www.baeldung.com/spring-boot-mongodb-auto-generated-field)