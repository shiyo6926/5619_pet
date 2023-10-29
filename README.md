# 5619 PET

## Project profile

This is a website related to pets, and it includes features such as Login Function, Account Creation, Logout Function, AI Pet Assistant, Real-time Weather Display, Pet Diaries, Community Communication, Event Calendar, Notification Functionality, Adoption Information, Animal Rescue, Rescue Suggestion Reading, Article Search.

This project aims to:

- **Provide a comprehensive pet information platform** to enhance the quality of life for pets.

- **Promote pet rescue and adoption**, encouraging individuals to support pet rescue efforts.

- **Connect pet lovers with experts**, foster an active community, and promote pet love and responsibility.

The target audience for this project includes pet owners.

## Project structure

The front end of this project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

This backend is built on the [Spring Boot 3.0](https://spring.io/projects/spring-boot) framework with [JDK 17](https://openjdk.java.net/projects/jdk/17/).

The necessary Maven dependencies for the backend can be found in the [./src/petback/pom.xml](./src/petback/pom.xml) file.

Project structure:

- `5619_pet/`
  - `README.md`
  - `src/`
    - `petback/`
      - `src/`
        - `main/`
          - `java/com/example/petback/`
            - `config/`
            - `controller/`
            - `entity/`
            - `mapper/`
            - `service/`
            - `PetbackApplication.java`
          - `resources/application.yml`
          - `test/java/com/example/petback/`
            - `service/`
            - `PetbackApplicationTests.java`
      - `target/`
      - `pom.xml`
      - `HELP.md`
      - `mvnw`
      - `mvnw.cmd`
    - `5619pet.sql`
    - `PetConnect`
      - `src/`
        - `components/`
        - `pages/`
          - `Home/`
          - `Signin/`
          - `Signup/`
        - `router`
        - `utils`
        - `App.js`
      - `build/`
      - `public/`
      - `package.json`
      - `package-lock.json`
      - `yarn.lock`
  - `doc/`

You can view the database format and data by importing the [`.src/5619pet.sql`](.src/5619pet.sql) file.

## Quick start

Backend:

To get started, open your IDE and navigate to the [`.src/petback`](./src/petback) folder. Then, run the [`.src/main/java/com/example/petback/PetbackApplication.java`](./src/main/java/com/example/petback/PetbackApplication.java) file. The default backend IP is `localhost`, and the port is `9090`. You can perform testing on this port.

Frontend:

Open the command line in the [`.src/PetConnect`](.src/PetConnect) folder by entering:\
yarn\
npm start\
Runs the app in the development mode.Open [http://localhost:3000](http://localhost:3000) to view it in your browser.\
You can see the registration page, register as a user, and then log in to access the personal main interface. The main interface includes Logout Function, AI Pet Assistant, Real-time Weather Display, Pet Diaries, Community Communication, Event Calendar, Notification Functionality, Adoption Information, Animal Rescue, Rescue Suggestion Reading, Article Search.\
The page will reload when you make changes.You may also see any lint errors in the console.

## Test

Backend:

To run tests, open your IDE and navigate to the [`.src/petback`](./src/petback) folder.Then, run the files under [`.src/test/java/com/example/petback/`](./src/test/java/com/example/petback/)for testing.

Frontend:

Open the command line in the [`.src/PetConnect`](.src/PetConnect) folder by entering:\
npm test\
Launches the test runner in the interactive watch mode.\
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

## demo

```TODO```

## Project Enhancement

The project's frontend is not yet complete in certain areas, including expert consultation, notifications, and the pet products section. You have the opportunity to further enhance these features.

Additionally, you can enrich the website's content by adding other functionalities, such as real-time communication with experts, expanding pet information (e.g., adding pet gender and names), and making the notification functionality interact with more events.

## Author information and contact information

Front end:Qinyan Zhong\
Back end: Junqi Su, Jie Yang, Yaqi Zhou\
If you have any questions, please contact Yaqi Zhou with: <yzho0829@uni.sydney.edu.au>
