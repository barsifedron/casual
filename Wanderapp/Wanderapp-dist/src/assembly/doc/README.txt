                           A Notification Service for the whole family
\ \      / /_ _ _ __   __| | ___ _ __ __ _ _ __  _ __  
 \ \ /\ / / _` | '_ \ / _` |/ _ \ '__/ _` | '_ \| '_ \ 
  \ V  V / (_| | | | | (_| |  __/ | | (_| | |_) | |_) |
   \_/\_/ \__,_|_| |_|\__,_|\___|_|  \__,_| .__/| .__/ 
                                          |_|   |_|   



--------------------------------------------------------------------------------
----------------------------------- INTRODUCTION -------------------------------
--------------------------------------------------------------------------------

The Wanderapp notification center comes with two modules.

- The Wanderapp-service provides REST api's and basic views of the notifications
  made with mustache. It was built using dropwizard.

- The Wanderapp-webapp provides a nice web application, running on a jetty server,
   built using angularjs and twitter bootstrap.


--------------------------- ZIP ARBORESCENCE

Here is a description of this Zip arborescence :

notification-wanderapp-project-and-dist.zip
|-- README.txt
|-- ${wanderapp.dist.name}-dist.zip  
`-- wanderapp-maven-project.zip


- The zip fle wanderapp-maven-project.zip contains the maven project.

- The zip file ${wanderapp.dist.name}-dist.zip contains the ready to deploy build


--------------------------------------------------------------------------------
------------------------------  GETTING STARTED --------------------------------
--------------------------------------------------------------------------------



------------------------- PREREQUESITES 

- The variable $JAVA_HOME must be set to a jre of version 7
- We will use the http ports 8080 and 9000 !!!!!!


-------------------------- INSTALLATION 


Start by unziping Wanderapp-dist.zip found here :


notification-wanderapp-project-and-dist.zip :
|-- Wanderapp-dist.zip    


After unzip, you should have this arborescence :

`-${wanderapp.dist.name}/
|-- Wanderapp-service
`-- Wanderapp-webapp




--------------------- LAUNCHING THE WANDERAPP-SERVICE 

In your shell, navigate to 

`-${wanderapp.dist.name}/
  |-- Wanderapp-service

and type :    "sh start.sh"
This will launch the Wanderapp-service with the preconfigured database.






--------------------- LAUNCHING THE WANDERAPP-WEBAPP


In your shell, navigate to 
`-${wanderapp.dist.name}/
  `-- Wanderapp-webapp
and type :    "sh start.sh"

This will launch the wanderapp-webapp





----------------------- SEEING THAT IT WORKS


Open your web-browser and go to the adress :  http://localhost:8080/
You should see a list of users. Click on one of them to see all his/her notifications!


--------------------------------------------------------------------------------
---------------------------POINTS OF INTEREST-----------------------------------
--------------------------------------------------------------------------------



---------------------  ABOUT THE REST SERVICES

The wanderapp-service listens on the http port 9000.


For the REST Services, the following paths are proposed

   DELETE  /notifications/delete/{notificationUuid} 
    GET     /notifications 
    GET     /notifications/view 
    GET     /notifications/{notificationUuid} 
    GET     /notifications/{notificationUuid}/view 
    POST    /notifications 
    PUT     /notifications/read/{notificationUuid} 
    GET     /notifications/user/{userUuid} 
    GET     /notifications/user/{userUuid}/view 
    GET     /users/ 



The paths ending with "view", provide acces to the really simple mustache interfaces.
 For example, you can acces a basic view of all notifications at the adress :
 http://localhost:9000/view



--------------------  FUNCTIONNALITIES 

By calling  
    GET     /notifications/user/{userUuid}
We can retrieve a list of all notifications belonging to a user.

!!!!!!!!!!!!! The database request providing the the notifications order them
 by date and type of notification, starting with the most recent ones.


By calling
    DELETE  /notifications/delete/{notificationUuid}
We can delete a notification



By calling

    PUT    /notifications/read/{notificationUuid} 
We can update a notification to mark it read.


By calling
    GET     /notifications/{notificationUuid} 
We can get a specific notification. The acces to this service automatically marks
the notification as read.




----------------------------- ABOUT THE WEBAPP ------------------------------------

The webapp was built using angularjs and twitter bootstrap.
It's hosted by a Jetty intance, with a proxy forwarding the REST request to the 
Wonderapp-service on port 9000.





------------------------------ABOUT THE DATABSE --------------------------------

We use an h2 database, already filled with some data.


---- START WITH AN EMPTY DATA BASE

It is of course possible to empty it and start from scratch. To do so :
- Stop the Wonderapp-service.
- Delete the file : notificationsDB.h2.db, located here

`-${wanderapp.dist.name}/
  |-- Wanderapp-service
  |   |-- database
  |   |   |-- notificationsDB.h2.db



Navigate to 

`-${wanderapp.dist.name}/
  |-- Wanderapp-service


Type :
    "sh inti.sh" (init database schema)
 and : 
    "sh start.sh" (starts the service again)

Now your service is runing with an empty database.



---- POPULATE THE DATABASE WITH TEST VALUES

You can populate your database again with curl by launching the script:

  sh database/notifsCurl.sh     located here:

`--${wanderapp.dist.name}/
    |-- Wanderapp-service
    |   |-- database
        |   |   `-- notifsCurl.sh





--------------------------- THE MAVEN PROJECT ----------------------


The porject has 3 modules

        <module>Wanderapp-service</module>
        <module>Wanderapp-webapp</module>
        <module>Wanderapp-dist</module>


The module <module>Wanderapp-dist</module> produces the distribution zip, 
ready to install and to play with.







