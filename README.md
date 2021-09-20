# IoT Voting System
The IoT Voting system is a system where people can vote for a certain poll whether or not with a physical device. A registered user can create a poll and every user is able to vote on a poll. A poll could be either public or private. The poll also has a certain time frame.

![System Architecture](https://github.com/h578011/Dat250Oblig1/blob/master/Docs/SystemArchitecture.png?raw=true)

## Use Cases
These use cases give an understanding of what the functionalities are in our application.
Create poll: A registered user is able to create a poll, with a certain time limit and with certain privacy settings.

Open/close poll: A registered user must be able to open or close their poll.
Reset poll: A registered user must be able to reset their poll.
Pair IoT Device: A registered user must be able to pair the poll to an IoT device.
Vote: each user can vote on a poll.
![System Architecture](https://github.com/h578011/Dat250Oblig1/blob/master/Docs/UseCases.png?raw=true)

## Domain Model
This domain model shows all the required concepts of our application including their relationships to each other. In this case we have a fairly simple domain model with only two tables RegisteredUser and Poll. These tables are also stored in a database.
![System Architecture](https://github.com/h578011/Dat250Oblig1/blob/master/Docs/DomainModel.png?raw=true)
## Application Flow Diagram
![System Architecture](https://github.com/h578011/Dat250Oblig1/blob/master/Docs/WebApplicationFlow.png?raw=true)
This application consists of 4 screens. Non-logged-in users have the ability to vote on public polls and they can also register as a user. Logged-in users can create, edit and view their polls and also vote on public and private polls. The registered users also have the ability to reset their polls and to connect an IoT device.
User Screens
The user screens you’ll see below is a prototype of the application it will give a good understanding of how the application will work.
The first screen a person would see is the homescreen, here you can enter the ID of the poll to vote on a certain public poll, you also have the ability to login or register.


In the register page a non-registered user is able to register as a user to have access to the creation of polls.

On the manage polls page a user can watch all the polls he has created and has the option to view/edit them. The user also has the chance to create a poll on this page.

When we click on the create poll button we are redirected to a new page where we can create a brand new poll, with a certain title, description, time and options.

We also have a page where we can edit the poll and also view the score of a certain poll. On this page we also have the ability to delete a poll and to start/stop it.
Architectural Diagram

In the diagram above we laid the foundation for our application. We have two different possible sources of input, namely an IoT Feedback device or a web browser. This is all being sent to the web app which is the core of our application (using a PAAS - Container). On our web app service we can connect to our database which stores the results of the polls and also the registered users. Next to the database we also have a Rest API so other applications can easily integrate information from our polls. Finally we also send activity from the polls to an external service called Dweet.io.


## DB view in intellij:

## PollUser Class and DAO:

## Poll Class and DAO:


## Sample Data:

## PollUser Table:


## Poll Table:

