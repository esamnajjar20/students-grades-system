# Student Grades Management System

A JavaFX desktop application for managing student grades, built using Java 21 and Maven.
It uses a custom generic `ArrayBag<T>` data structure implemented with ordinary Java arrays.

## Author
- Name: Esam Najjar
- ID: 1320253048

## How to Run the Application
This project uses Maven to handle dependencies (including JavaFX). 

1. Ensure you have Java 21 and Maven installed on your system.
2. Open a terminal in the project directory.
3. Run the following command:
   ```bash
   mvn clean javafx:run


Features

· Add, search, and remove student records.
· Input validation (duplicate IDs, grade ranges 0-100, empty fields).
· Calculate average, highest, and lowest grades.
· Display grade distribution using a BarChart.
· Custom ArrayBag implementation for frequency and existence checks.

