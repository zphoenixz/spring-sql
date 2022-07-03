# Spring SQL

This is a simple REST API that allows Users to Suscribe and Unsuscribe to Subjects which is kind of a good way to learn how to work on relations using SQL.

#### Entity Relationship Diagram
<p align="center">
<img src="https://github.com/zphoenixz/mobile-fun/blob/master/captures/ERD.png" width="500" height="200">
</p>

#### Design Features
* *Register* as User.
* *Update* my User profile.
* *Register* new Subjects.
* *Register* to multiple Subjects.
* *Unregister* from Registered Subjects.
* *List* all Subjects assigned to a User.
* *List* all Users assigned to a Subject.

#### Technical Features
* *MVC pattern*.
* Java 11.
* Gradle 7.1.
* SpringBoot 2.7.1
* MySQL 8
* Tested on Local Env only

## Running
0. Prerequisites
```
Be aware on having above versions
```
1. Get the repo
```
git clone git@github.com:zphoenixz/spring-sql.git
```
2. Go to the repo folder
```
cd spring-sql
```
3. Start Spring Application
```
Run src/main/java/com/edtech/edtech/EdtechApplication Main Application
```
4. Start
```
Run src/main/java/com/edtech/edtech/EdtechApplication Main Application
```
5Import Postman Collection
```
Use sdk debug run
```

## My comments
The pattern is well (not perfect) developed, you can see all the BL correctly ordered on models, services, controllers, using a pseudo Builder pattern just for decoupling purposes.
Nevertheless, there are lots of points where this can be improved, I will mention some of them on the following list:
* Use proper abstract schemas to validate straight from the concrete models.
* Write a proper way to Build Models for DB transactions.
* Implement an Authentication BL, although users are able to register with password, atm we are not using any Login BL.
* Enrich model fields, as of now our models have the least possible amount of fields.
* Increase ERD by adding more tables in order to support perhaps Professors, timetables, etc.
* Add audit tracks like CreatedAt, UpdatedAt, UpdatedBy in order to be able to track our transactions.
* more....