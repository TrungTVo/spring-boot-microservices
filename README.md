# Spring Microservices

Demo on Spring Microservices:

- 3 microservices:

  - **Movie catalog Service**
    - GET `/catalog/{userID}`: return user's list of movie details, including movie rating
    - Sample response:
    - ```
      [
        {
            title: "Lord of the Rings",
            desc: "Some thing about this movie...",
            rating: 7.6
        },
        {
            title: "Good Doctor",
            desc: "Some thing about this movie...",
            rating: 8.6
        },
        ...
      ]
      ```
  - **Movie info Service**
    - GET `/movies/{movieID}`: returns movie info details, given a movie ID
    - Sample response:
    - ```
      {
        id: 123,
        title: "Lord of the Rings",
        overview: "Some description of this movie...",
        producer: "Trung Vo",
        ...
      }
      ```
  - **Rating Service**
    - GET `/ratingsData/{movieID}`: returns movie rating, given movie ID
      - Sample response:
      - ```
        {
          movieID: 123,
          rating: 4.6
        }
        ```
    - GET `/ratingsData/users/{userID}`: returns user's list of movie ratings
      - Sample response:
      - ```
        {
          userRating: [
              { movieID: 123, rating: 4.6 },
              { movieID: 456, rating: 7.6 },
              { movieID: 789, rating: 5.6 }
          ]
        }
        ```

- 1 Service Discovery Server

  - **Discovery Server**: discover and identify above 3 services, given their name specified by `spring.application.name`. This helps discover different microservice instances without constantly changing configuration like port number.

- Circuit Breaker
  - Use Spring Cloud Hystrix from Spring Cloud Netflix (can use different mechanism like `Resilience4j` as well)
