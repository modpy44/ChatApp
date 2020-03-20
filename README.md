# Chat Application 

A java web application , could be tested on a tomcat server by following the steps below : 
1. Clone the repo in your enviroment .
``
git clone https://github.com/modpy44/ChatApp.git
``
2. cd browse to the project directory
3. Use the following command to generate .war file 
``
jar -cvf ChatApp.war *
``
4. Install the application in tomcat server by adding the war file to `<tomcat_home>\webapps`
5. Check port configuration, by default tomcat server should be running on port 8080 , start the server 
6. Open browser , type in adress bar `localhost:8080/ChatApp`
7. Invite your friends to connect to your pc on a LAN network : `<your_ip_adress>:8080/ChatApp`
8. Pick a user name and log into the conversation .
 