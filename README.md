# Student Grades Management System

JavaFX application for managing student grades using a custom generic
ArrayBag<T> implemented with plain arrays.

## Author
- Name: (Esam najjar)
- ID: (1320253048)

## Build (logic only, Termux)
javac -d out ArrayBag.java Student.java StudentManager.java TestManager.java
java -cp out TestManager

## Run GUI (requires desktop with JavaFX)
mvn javafx:run
