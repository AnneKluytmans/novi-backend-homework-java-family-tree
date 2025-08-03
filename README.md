# Family Tree Application – NOVI Backend Java Assignment

## About the Project

This repository contains my implementation of the **Family Tree** assignment for the Backend module at [Novi University](https://www.novi.nl).  
The goal of this project is to practice working with **Java classes**, **object relationships** (inheritance, aggregation), and **unit testing** using JUnit.  
The application allows you to build a family tree by adding people, pets, and family relationships such as parents, children, siblings, and grandchildren.

---

![Family!](./assets/Family.JPG)

## Table of Contents

- [Tech Stack](#tech-stack)
- [Key Features](#key-features)
- [How to Run](#how-to-run)
- [Credits](#credits)
- [License](#license)

---

## Tech Stack

- **IntelliJ IDEA** (recommended IDE)
- **Java 17+**
- **JUnit 5**
- **Maven**

---

## Key Features

- `Person` class with attributes such as name, age, gender, parents, siblings, pets, partner and children
- `Pet` class with name, species, age, and owner
- Methods for:
    - `addParents(Person mother, Person father)`
    - `addChild(Person child)`
    - `addSibling(Person sibling)`
    - `addPet(Pet pet)`
    - `getGrandChildren()`
    - `getGrandChildrenPets()` – returns all pets of a person's grandchildren 
    - `getNieces()` – returns all female children of a person's siblings 
    - `getInvitationList()`– generates a full list of relatives to invite to a family event
- Composition: pets are associated with persons
- Aggregation: relationships like parent, child, sibling are modeled as lists of `Person` objects
- Unit tests are included for all functional methods (excluding basic getters/setters)

---

## How to Run

1. Open the project in your IDE (IntelliJ IDEA)
2. Navigate to the `Main` class
3. Locate the `main` method and click the green play button to **Run 'Main'** or use the terminal:
```bash
./mvnw clean compile exec:java
```

### How to Run Tests

1. Right-click on the `test` folder or any individual test class.
2. Choose **Run 'All Tests'** or **Run 'PersonTest'**, etc.
   or
   Open a terminal in the root of the project and run:
```bash
./mvnw test
```

## Credits
> "This assignment was developed as part of the Backend Java module in the NOVI Software Development program. All instructions, logic, and structure are part of the official coursework."

## License
> "This repository is intended for educational purposes only. You are welcome to use the code for learning, but not for commercial use."