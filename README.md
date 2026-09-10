# iCET Student Management System

A console-based Student Management System built in **Java** for the iCET institute. It manages student records, batches, module grades, and generates reports — all through a simple menu-driven terminal interface.

## Features

### 1. Student Management
- **Add Student** — register a new student to an open batch and auto-generate a unique registration number (Physical `PR` or Online `OR`)
- **Update Student** — change a student's name and/or NIC
- **View Student Profile** — look up a student's details, PRF / DBMS marks, and GPA
- **Delete Student Profile** — remove a student from the system

### 2. Batch Management
- **Add Batch** — create a new batch with enrollment status and student count
- **Update Batch** — toggle a batch between ENROLLMENT OPEN / CLOSED
- **View Batch** — display a summary table of all batches

### 3. Grade Management
- **PRF Marks Update** — update Programming Fundamentals marks (with validation)
- **DBMS Marks Update** — update Database Management Systems marks (with validation)

### 4. Report Generator
- **Student Registration Report** — full, alphabetically sorted list of all students with marks and GPA
- **BatchWise Student Report** — filter students per batch (105–110)
- **Industry Training Eligibility Report** — students eligible for industry training (`PRF > 50`, `DBMS > 50`, `GPA > 3.25`)

## GPA & Grading

The GPA is computed as the average of the PRF and DBMS grade points, converted from marks using an iCET grade scale:

| Marks   | Grade Point |
| ------- | ----------- |
| 90+     | 4.25        |
| 80–89   | 4.00        |
| 75–79   | 3.70        |
| 70–74   | 3.30        |
| 65–69   | 3.00        |
| 60–64   | 2.70        |
| 55–59   | 2.30        |
| 50–54   | 2.00        |
| 45–49   | 1.70        |
| 40–44   | 1.30        |
| 30–39   | 1.00        |
| 20–29   | 0.70        |

Special mark values:
- `-1` → **Absent**
- `-2` → **Not Conducted**

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or later

### Running the Application

```bash
javac StudentManagementSystem.java
java StudentManagementSystem
```

## Usage

1. On startup you will see the main menu with five options.
2. Enter the number of the menu item you want to open.
3. Follow the on-screen prompts to add, update, view, or delete records.
4. Use `Y` / `N` prompts to continue or go back to the homepage / exit.

```
-----------------------------------------------------------------
|				iCET Student Management System			|
-----------------------------------------------------------------

[1] Student Management

[2] Batch Management

[3] Grade Management

[4] Report Generator

[5] Exit
```

## Project Structure

| File                          | Description                           |
| ----------------------------- | ------------------------------------- |
| `StudentManagementSystem.java` | Entire system (data, menus, logic)   |
| `README.md`                   | This file                            |

## Data Storage

All data is held in-memory using Java arrays. Any changes made while the program is running (adding / updating / deleting) do **not** persist after the program exits.

## License

This is a course project and is provided for educational purposes.