# Android-TO-DO-project

My Android CRUD project was to create an application in Androdi Studio that is helpfull in following your everyday tasks (to-do items).
The applications main purpose is to be able to crate, edit and delete a to-do item and view them in a list. 

##I used different sources to help me create this application:
   https://www.androidhive.info/2013/09/android-sqlite-database-with-multiple-tables/
   https://www.youtube.com/watch?v=hDSVInZ2JCs
   https://www.youtube.com/watch?v=aO2qYYNwWpA

#Classes, activities
##Classes
For this app I had to create 2 different classes:
 -DataBaseHelper: this class helps to manage database creation and version management. Contains the structure of the database and all of the necessary functions and    processes. In my case the database has one table and the items have a title, a description and a due date. The CRUD processes are the following: 
 *addTodoItem, deleteTodoItem, updateTodoItem, getTodoItem, getAllitem*.
 -todoModel: this class is for the object. It inherites from Serializable class to be able to get sent from one activity to another. This class contains the attributes of the to-do items, getters, setters and constructors.
