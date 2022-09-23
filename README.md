# Quiz-Engine
- This describes a Java GUI based Quiz Engine which incorporates a full-fledged database connectivity.

# List of contents
  - About the application
  - Modules
  - Requirements for running the application
  - How to run the application?
  - Important Points
  - Credits  
  
# About the application
- This defines a complete interface for e-educational question bank scenario. It basically allows us to provide the user with the integrated question palette via interactive means.

# Modules
- If we consider the conceptual key features then this whole interface is seggregated into two modules:

1. **Admin Module** : This allows us in configuring all the backend functions with the help of authenticated identity.  
- Interactive features:  
  - Adding the questions at once by selecting a "csv" file or by entering the questions manually one by one. This directs the questions into the database.  
  - Deleting all the questions at once or by deleting the questions manually with the help of question-id.  
  - Showing all the questions which are present in the database.

2. **Student Module** : This is the main module of the application which behaves as being the frontend. Desired user has the flexibility of starting the quiz. Upon starting, number of questions from the database are provided along with their multiple options. The user needs to select the desired option and proceed further.  
- Interactive features:  
  - Dis-allowance of leaving the screen and displaying the error message respectively upto a limit after which the quiz ends itself.  
  - Question Palette with coloured indication about the attempted and unattempted question.  
  - Previous, Save and Next buttons for scrolling along the questions. - Clear button for clearing the option selection.  
  - Timer for setting the time limit for the quiz, exceeding which the quiz ends itself.  
  - End Quiz Button for ending the quiz.  
  - Result displayed in the form of score card along with the selected as well as correct answer.

# Requirements for running the application
  - Installed JDK and MySql
# How to run the application?
  - Step 1 - In MySql create a database named "quizengine"  
    - to create database type in MySql: "create database quizengine;"  
  - Step 2 - Use the database "quizengine"  
    - to use database quizengine type in MySql: "use quizengine;"  
  - Step 3 - Then create a table named "quiz" in it  
    - to create table type in MySql: "create table quiz(qid integer primary key, question varchar(200), answer varchar(100), option1 varchar(100), option2 varchar(100), option3 varchar(100), option4 varchar(100));"  
  - Step 4 - Now, open the "quizengine.java" and edit the user and password of mysql in the 'connector' variable.  
  - Step 5 - Run the quizengine.java  
  - Step 6 - Click Admin and type password "admin" and click "ok"  
  - Step 7 - Add questions to the database by selecting the appropriate option.  
  - Step 8 - Click Back and then click Student and start the quiz.

# Important points
  - You can change the admin login password, quiz length, time limit of quiz, number of warnings accordingly.
# Credits
  - This project is completed by Rohan Kumar Sharma.
