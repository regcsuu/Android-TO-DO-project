# Android-TO-DO-project

My Android CRUD project was to create an application in Androdi Studio that is helpfull in following your everyday tasks (to-do items).
The applications main purpose is to be able to crate, edit and delete a to-do item and view them in a list. 

## I used different sources to help me create this application:
  - https://www.androidhive.info/2013/09/android-sqlite-database-with-multiple-tables/
  - https://www.youtube.com/watch?v=hDSVInZ2JCs
  - https://www.youtube.com/watch?v=aO2qYYNwWpA

# Source files

## Activities
I created 3 different activities:
- activity_main: this is the main page of the application. It contains an add button and a list view for displaying the created to-do item. By clicking on the Add button, the activity_create_todoitem page will be opened.
- activity_create_todoitem: this page is called by clicking on the Add button on the main page. Here the user can create a brand new to-do item by filling out the required informations about the to-do task. It has 2 buttons: a save and a cancel button.
- activity_edit_todoitem: this page is called when the user selects an item from the list view. The user can edit the item or delete it. 

## Classes
For this app I had to create 2 different classes:
 - DataBaseHelper: this class helps to manage database creation and version management. Contains the structure of the database and all of the necessary functions and    processes. In my case the database has one table and the items have a title, a description and a due date. The CRUD processes are the following: 
 *addTodoItem, deleteTodoItem, updateTodoItem, getTodoItem, getAllitem*.
 - todoModel: this class is for the object. It inherites from Serializable class to be able to get sent from one activity to another. This class contains the attributes of the to-do items, getters, setters and constructors.
 - MainActivity: this is the java class behind *activity_main*. It contains the button listener for the add button and the listener for clicking on a list item in the listview. It also contains 2 process which opens the required pages (*openEdittodo, openCreateTodoItem*).
 - CreateTodoItem: this is the java class behind *activity_create_todoitem*. It contains the button listener for the save button and the listener for the cancel button. It also contains a *openMainActivityPage* process which send us back to the main page.
 - EditTodoItem: this is the java class behind *activity_edit_todoitem*. It contains 3 button listeners: save, delete and cancel. It also contains a *openMainActivityPage* process which send us back to the main page, in case of canceling or editing the item.

## Other
In strings.xml I saved all the strings that I used on the 3 pages.


