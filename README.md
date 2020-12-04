# SNAKEIFFEL

Coding II & Software Engineering - Project

Members: Enzo Job, Michiel Kindt, Théo Rey

## Table of contents
1. [Prelude](#prelude)
    + [Goal](#goal)
    + [Conditions](#conditions)
1. [Build instructions](#build-instructions)
1. [Operating manual](#operating-manual)
1. [Userstories](#userstories)
1. [Releaseplan](#releaseplan)
1. [Documentation - Sprint 1](#documentation-sprint-1)
    + [Tasklist - Sprint 1](#tasklist)
    + [Important code snippets - Sprint 1](#important-code-snippets)
1. [Documentation - Sprint 2](#dokumentation-sprint-2)
    + [Tasklist - Sprint 2](#tasklist)
    + [Important code snippets - Sprint 2](#important-code-snippets)

## Prelude
Welcome to our project "SNAKEIFFEL" ! The project consists of our own interpretation of the well known and often copied game "SNAKE".
The player controls the snake on by changing directions on the playfield.
The goal of the game lies in collecting points by eating Apples, without letting the snake eat his own Tail.
The game doesn't need an internet connection and can be played alone.
It is a great idea to spend some fun time and to sharpen your reflexes.

### Goal
The aim is to combine the skills and competencies learned in programming and software engineering within a single project.
For development we're using the SCRUM framework.
We are planning on two sprints for this project.

### Conditions
* The game should be programmed with JAVA
* The project should be published on GitHub.
* The build automation should be done with MAVEN.
* This program should be playable on MAC, Windows and Linux Computers.
* The classes of the program should have the appropriate Unit-Tests.
* The program should be able to be executed using a specially created JAR file and the command java-jar xxxxx.jar.

## Build instructions

## Operating manual

## Userstories
| **Userstory Nr.** |   **Userstories**  | **Storypoints**  |  **Priority**  |  **Acceptance criteria** |
|:-:|-----|:-:|:-:|-----|
| 1 | As a player I want to eat apples to win points, grow and speed up with every meal | 3 | 1 | Points are added when the snake eats an Apple, the snake grows and becomes faster |
| 2 | As a user I would like to be able to enter difficulty parameters | 2 | 3 | The player can choose between several levels of difficulty |
| 3 | As a user I would like to be able to start over or leave at the end of the game | 3 | 2 | A menu asks the player after the end of a game if he wants to restart or to quit the game |
| 4 | As a user I want to see an animation and my final score at the end of the game | 3 | 3 | The end score is displayed at the end of a game with a small animation |
| 5 | As a user I want to have a good looking interface | 3 | 3 | The interface should look good |
| 6 | As user I would like to see my current score | 2 | 1 | The current score is displayed and updated in real time during the game |
| 7 | As a programmer I want to be able to reproduce the program easily in order to rebuild it, maintain it and add new features. | 2 | 2 |  Comments in the code. Logical structure (classes, methods, variables) |
| 8 | As a user I would like to be able to move with the arrow keys | 5 | 1 | The player uses the arrow keys to change the directions of the snake |
| 9 | As a user I would like to have game options | 2 | 3 | Game options are implemented to let the player choose between different grafical sprites |

## Releaseplan
|  **Sprint 1** | **Sprint 2**  |
|-----|-----|
|  **Userstory 1:**  Eat apples | **Userstory 2:**  Difficulty parameters  |
|  **Userstory 3:**  Start over | **Userstory 4:**  Final score  |
|  **Userstory 6:**  Current score | **Userstory 5:**  Good looking interface  |
|  **Userstory 7:**  Logical structure | **Userstory 9:**  Game options  |
|  **Userstory 8:**  Arrow keys |   |
	
## Documentation - Sprint 1
### Tasklist
| Tasknummer | Tasks | Userstory | Geschätzter Aufwand |
|:-:|-----|:-:|:-:|
| 1 | Create and display apples randomly | 1 | x Stunden |
| 2 | Increment the score with each apple eaten | 1 | x Stunden |
| 3 | Extend the snake with every apple | 1 | x Stunden |
| 4 | Implement options for start/end | 3 | x Stunden |
| 5 | Implement menu  | 3 | x Stunden |
| 6 | Score somewhere Display | 6 | x Stunden |
| 7 | Reset score at death | 6 | x Stunden |
| 8 | Classes should be well divided | 7 | x Stunden |
| 9 | Add a comment | 7 | x Stunden |
| 10 | Respect conventions | 7 | x Stunden |
| 11 | Create interface | 8 | x Stunden |
| 12 | Implementing movement | 8 | x Stunden |
| 13 | Prevent forbidden movement | 8 | x Stunden |

### Important code snippets

## Documentation - Sprint 2
### Tasklist
| Tasknummer | Tasks | Userstory | Geschätzter Aufwand |
|:-:|-----|:-:|:-:|
| 1 | Adjust speed | 2 | x Stunden |
| 2 | Walls allow | 2 | x Stunden |
| 3 | Random Snack | 2 | x Stunden |
| 4 | Show Endscore | 4 | x Stunden |
| 5 | Create animation(s) | 4 | x Stunden |
| 6 | Implement animation | 4 | x Stunden |
| 7 | Menu presentation | 5 | x Stunden |
| 8 | More realistic sprites | 5 | x Stunden |
| 9 | Select background with keyboard or mouse | 9 | x Stunden |
| 10 | Snake colour can be selected | 9 | x Stunden |

### Important code snippets
