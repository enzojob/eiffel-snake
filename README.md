# SNAKEIFFEL
### Coding II & Software Engineering - Project
Members: Enzo Job, Michiel Kindt, Théo Rey

![snakeGame](https://user-images.githubusercontent.com/73689853/102015714-80f93280-3d5d-11eb-9317-1f27883470c3.PNG)



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
1. [Diagramm](#diagramm) 
    + [Package diagramm](#package-diagramm)
    + [Class diagramm](#class-diagramm)
    + [Sequence diagramm](#sequence-diagramm)
1. [Test cases](#test-cases)

## Prelude
Welcome to our project "SNAKEIFFEL" ! The project consists of our own interpretation of the well known and often copied game "SNAKE".
The player controls the snake on by changing directions on the playfield.
The goal of the game lies in collecting points by eating Apples, without letting the snake eat his own Tail.
The game doesn't need an internet connection and can be played alone.
It is a great idea to spend some fun time and to sharpen your reflexes.

### Goal
+ Make sure that you have installed a Java Runtime Environment on your computer.
+ Download the file from our repository in Github.
+ Unzip the downloaded file to the desired destination folder.
+ Copy the path of the desired version file (.jar) to the clipboard.
+ Open the console of your computer.
+ Enter java -jar followed by the copied path (.jar).

		Example: java -jar C:\Users\ejob\Downloads\eiifel-snake-2.0-SNAPSHOT.jar		
+ Confirm your entry with Enter, the game should start.
+ Have Fun!

### Conditions
* The game should be programmed with JAVA
* The project should be published on GitHub.
* The build automation should be done with MAVEN.
* This program should be playable on MAC, Windows and Linux Computers.
* The classes of the program should have the appropriate Unit-Tests.
* The program should be able to be executed using a specially created JAR file and the command java-jar xxxxx.jar.

## Build instructions
* Laden Sie die Datei .jar auf ihren Computer runter.
* Vergewissern Sie sich, dass Sie eine Java Runtime Environment auf Ihrem Computer installiert haben.
* Klicken Sie (Doppelklick) auf ebenjene, um die Datei auszuführen.

## Operating manual
Here is a short introduction to our game: 
* After starting the game, a start interface will appear with different buttons: START, EXIT....
* The goal is to eat as many apples as possible to make the snake grow  
* Each apple eaten gives 20 points 
* When you bump into yourself you will die 
* You can return to the menu or exit the game at any time 

## Userstories
| **Userstory Nr.** |   **Userstories**  | **Storypoints**  |  **Priority**  |  **Acceptance criteria** |
|:-:|-----|:-:|:-:|-----|
| 1 | As a player I want to eat apples to win points and grow | 3 | 1 | Points are added when the snake eats an Apple, the snake growswith each apple |
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
| Tasknumber | Tasks | Userstory | Estimated effort |
|:-:|-----|:-:|:-:|
| 1 | Create and display apples randomly | 1 | 2 Stunden |
| 2 | Increment the score with each apple eaten | 1 | 1 Stunde |
| 3 | Extend the snake with every apple | 1 | 2 Stunden |
| 4 | Implement options for start/end | 3 | 30 min |
| 5 | Implement menu  | 3 | 30 min |
| 6 | Display score somewhere| 6 | 20 min |
| 7 | Reset score at death | 6 | 1 Stunde |
| 8 | Classes should be well divided | 7 | 30 min |
| 9 | Add comments | 7 | 20 min    |
| 10 | Respect conventions | 7 | 20 min |
| 11 | Create interface | 8 | 1 Stunde |
| 12 | Implementing movements | 8 | 4 Stunden |
| 13 | Prevent forbidden movements | 8 | 2 Stunden |

### Important code snippets
In this section we want to discuss in depth the code that permits to create an apple at a random location in the field.
To do this we will first look into the Constructor "Food" and explain how it works. 
The constructor is then called with addFood() each time we need to place another Apple.
#### Food() in Food.java
The constructor takes the x and y values and mutiplies them by the BlockSize to calculate the position of the object Food.
In same time it changes the color of the Apple randomly every time the constructor is called and the border is set to black.
Via setArcHeight and setArcWidth we change the aspect of the object to a circle, more representativ of an actual Apple.

	public Food(int x, int y) {

		super(SnakeApp.getBlockSize(), SnakeApp.getBlockSize());

		this.posX = x;
		this.posY = y;

		setTranslateX(posX * SnakeApp.getBlockSize());
		setTranslateY(posY * SnakeApp.getBlockSize());

		setFill(Color.color(Math.random(), Math.random(), Math.random()));
		setStroke(Color.BLACK);
		setArcHeight(SnakeApp.getBlockSize());
		setArcWidth(SnakeApp.getBlockSize());
	}    
	
#### addFood() in Field.java
In this Method we generate two random numbers inside the field to represent the location of the new Apple.
We create another object food of type Food and give it the x and y position that we generated before.
After this we add it to the field and remove the old one.

    public void addFood() {
        int randomX = (int) (Math.random() * width);
        int randomY = (int) (Math.random() * height);

        Food food = new Food(randomX, randomY);

        getChildren().add(food);
        getChildren().remove(this.food);
        this.food = food;
    }
    
## Documentation - Sprint 2
### Tasklist
| Tasknumber | Tasks | Userstory | Estimated effort |
|:-:|-----|:-:|:-:|
| 1 | Adjust speed of the snake| 2 | 1 Stunden |
| 2 | Show Endscore | 4 | 1 Stunden |
| 3 | Create animation(s) | 4 | 10 min |
| 4 | Implement animation | 4 | 10 min |
| 5 | Menu presentation | 5 | 2 Stunden |

### Important code snippets
In this section we want to show you how me managed to set different difficulty levels by increasing the speed of the snake. 
In reality we do not increase it's speed but we rather decrease the duration between each update with AnimationTimer.
In the Menu we can choose between EASY, MEDIUM and HARD, this results in a change of the "speedFactor".

    public String setSpeed() {
        String[] speedArray = {"EASY", "MEDIUM", "HARD",};
        int[] factorArray = {8, 12, 16};

        if (speedCounter < 2) {
            speedCounter++;
        } else
            speedCounter = 0;
        speedFactor = factorArray[speedCounter];
        return speedArray[speedCounter];
    }

The choosen speedFactor is than used inside of the timer "AnimationTimer" to update the game faster or slower. 
This results in the impression that the snake moves at different speeds.

     AnimationTimer timer = new AnimationTimer() {
         public void handle(long now) {

             if (now - then > 1000000000 / speedFactor) { // vitesse a laquelle l'affichage est mis a jours
                 field.update();
                 then = now;
                 score.setText("Score: " + field.score);
                 changed = false;
	
We also wanted to talk about another important code snippet regarding the display of the "Game Over" gif.
We used InputStrem to call the gameover.gif file belonging to ressources. We than created an object image of type Image and displayed it on the screen.
		    
	InputStream inputStream = getClass().getResourceAsStream("/gameover.gif");
        Image image = new Image(inputStream);
        ImageView imageView = new ImageView(image);
	
![Gif](https://user-images.githubusercontent.com/73689853/102015309-1e9f3280-3d5b-11eb-9609-02f6ddd5d69f.PNG)	
	
## Diagramm
### Package diagramm 
![packageDiagramm](https://user-images.githubusercontent.com/73689853/102015263-bcdec880-3d5a-11eb-963d-0a9c28907eac.PNG)

### Class diagramm 
![classDiagramm](https://user-images.githubusercontent.com/73689853/102015294-f1eb1b00-3d5a-11eb-8f48-47fab0e2a428.PNG)

### Sequence diagramm
![mainAppSeqDiagramm](https://user-images.githubusercontent.com/73689853/102015399-b3a22b80-3d5b-11eb-8efc-366877c61db1.png)

## Test cases
| Test Case # | Description | Test Data | Expected Result | Actual Result | Pass/Fail |
|:-:|-----|:-:|-----|:-:|:-:|
| 1 | Are Apples appearing randomly inside the playfield? | / | Apples are distributed randomly on the field | As expected | Pass |
| 2 | Is the score incremented with each eaten Apple? | Eat Apple | Increment the score with each apple eaten | As expected | Pass |
| 3 | Does the snkae grow in size with each appel eaten? | Eat Apple | The size of the snake grows with apples eaten | As expected | Pass |
| 4 | Are the start and exit buttons working properly? | Click on start/exit | The start button starts a new game and the exit button closes the software | As expected | Pass |
| 5 | Is the score displayed during the game? | / | The current score is displayed and constantly updated during the game | As expected | Pass |
| 6 | Is the score resetted at death? | Die | At the death, the current score is resetted to zero | As expected | Pass |
| 7 | Can you change the direction of the snake by using the arrow keys? | Arrow Keys | Arrow keys change the direction of the snake | As expected | Pass |
| 8 | Are forbidden movements prevented? | Arrow Keys | Cannot change the direction to the opposite (left->right or up->down) | As expected | Pass |
| 9 | Can you adjust the difficulty of the game? | Clicking on the different difficulty buttons | The speed of the snake can be changed in the Menu to set the difficulty of the game| As expected | Pass |
| 10 | Is the endscore shown on the screen? | Game Over | The Endscore is shown on the screen at Game Over| As expected | Pass |




