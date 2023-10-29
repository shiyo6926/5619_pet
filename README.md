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
    -`petback/`
        -`src/`
            - `main/`
                - `java/com/example/petback/`
                    -`config/`
                    -`controller/`
                    -`entity/`
                    -`mapper/`
                    -`service/`
                    -`PetbackApplication.java`
                - `resources/application.yml`
            - `test/java/com/example/petback/`
                - `service/`
                - `PetbackApplicationTests.java`
        -`target/`
        -`pom.xml`
        -`HELP.md`
        -`mvnw`
        -`mvnw.cmd`
    -`5619pet.sql`
    -`PetConnect`
        -`src/`
            -`components/`
            -`pages/`
                -`Home/`
                -`Signin/`
                -`Signup/`
            -`router`
            -`utils`
        -`build/`
        -`public/`
        -`package.json`
        -`package-lock.json`
        -`yarn.lock`
  - `doc/`
  
## 快速入门

```TODO,请输入前端路径，前端端口```
Backend:

To get started, open your IDE and navigate to the [`.src/petback`](./src/petback) folder. Then, run the [`.src/main/java/com/example/petback/PetbackApplication.java`](./src/main/java/com/example/petback/PetbackApplication.java) file. The default backend IP is `localhost`, and the port is `9090`. You can perform testing on this port.

Frontend:

在.src/PetConnect文件夹开命令行输入:
yarn\
npm start\
Runs the app in the development mode.Open [http://localhost:3000](http://localhost:3000) to view it in your browser.
即可看到注册页面，注册用户，之后进行登录，即可看到个人主界面，主界面中包含```TODO```。
The page will reload when you make changes.You may also see any lint errors in the console.

## 贡献

项目并未完善前端的部分功能，包括专家咨询、通知和宠物产品部分。您可以对此继续完善。\
此外，

## 测试

如果适用，提供有关如何运行项目测试的信息。

## 演示或截图

如果适用，提供演示或项目的截图，以便用户可以更好地了解项目的外观和功能。

## Author information and contact information

Front end:Qinyan Zhong
Back end: Junqi Su, Jie Yang, Yaqi Zhou
If you have any questions, please contact Yaqi Zhou with: <yzho0829@uni.sydney.edu.au>
