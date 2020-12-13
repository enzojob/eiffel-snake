package address.presentation;

import address.SnakeApp;
import address.model.Snake;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.InputStream;

public class Main_UI extends Application {

    long then = System.nanoTime(); // global time variable for frames
    boolean changed = false;
    int nextUpdate;
    boolean hasNext = false;
    static int speedFactor = 8;
    static int speedCounter = 0;

    Scene startScene, scene, lostScene, gifScene;
    Field field;
    Button buttonStart, buttonExit, buttonReturnMenu, buttonExitInGame, buttonRestartWhenLost, buttonBackToMenuWhenLost,
            buttonExitWhenLost, buttonSpeed, buttonGif;

    public void start(Stage ps) {

        VBox start = new VBox(15);
        start.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null))); // set the background color

        // init of buttonStart
        buttonStart = new Button("START"); // initializes buttonStart as a new button
        buttonStart.setPrefSize(250, 100); // set width and height of the buttonStart
        buttonStart.setTextFill(Color.WHITE); // set the text color in the button
        buttonStart.setStyle("-fx-font: 22 arial; -fx-font-weight: bold; -fx-base: #32CD32 ;"); // CSS
        DropShadow shadow = new DropShadow();
        buttonStart.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
            buttonStart.setEffect(shadow); // shadow effect at mouse hover
        });

        /*
         * Initialization of the other buttons:
         * - init button with text
         * - text color
         * - CSS styling
         * */

        // init buttonSpeed
        buttonSpeed = new Button("SPEED");
        buttonSpeed.setTextFill(Color.WHITE);
        buttonSpeed.setStyle("-fx-font: 18 arial; -fx-font-weight: bold; -fx-base: #FF8C00 ;");

        // init buttonExit
        buttonExit = new Button("EXIT");
        buttonExit.setTextFill(Color.WHITE);
        buttonExit.setStyle("-fx-font: 18 arial; -fx-font-weight: bold; -fx-base: #FF4500  ;");

        // init buttonReturnMenu
        buttonReturnMenu = new Button("BACK TO MENU");
        buttonReturnMenu.setTextFill(Color.WHITE);
        buttonReturnMenu.setStyle("-fx-font: 18 arial; -fx-font-weight: bold;-fx-base:  #FF8C00 ");

        // init buttonExitInGame
        buttonExitInGame = new Button("EXIT");
        buttonExitInGame.setTextFill(Color.WHITE);
        buttonExitInGame.setStyle("-fx-font: 18 arial; -fx-font-weight: bold; -fx-base: #FF4500 ;");

        // init buttonRestartWhenLost
        buttonRestartWhenLost = new Button("RESTART");
        buttonRestartWhenLost.setTextFill(Color.WHITE);
        buttonRestartWhenLost.setStyle("-fx-font: 18 arial; -fx-font-weight: bold; -fx-base: #32CD32 ;");

        // init buttonBackToMenuWhenLost
        buttonBackToMenuWhenLost = new Button("BACK TO MENU");
        buttonBackToMenuWhenLost.setTextFill(Color.WHITE);
        buttonBackToMenuWhenLost.setStyle("-fx-font: 18 arial; -fx-font-weight: bold; -fx-base: #FF8C00 ;");

        // init buttonExitWhenLost
        buttonExitWhenLost = new Button("EXIT");
        buttonExitWhenLost.setTextFill(Color.WHITE);
        buttonExitWhenLost.setStyle("-fx-font: 18 arial; -fx-font-weight: bold; -fx-base: #FF4500 ;");

        // init buttonGif
        buttonGif = new Button("CONTINUE");
        buttonGif.setTextFill(Color.WHITE);
        buttonGif.setStyle("-fx-font: 18 arial; -fx-font-weight: bold; -fx-base: #32CD32 ;");

        // init score Label
        Label score = new Label(" Score : 0 ");
        score.setTextFill(Color.WHITE);
        score.setFont(Font.font("Arial Black", 20));

        field = new Field(SnakeApp.getWidth(), SnakeApp.getHeight());
        field.addSnake(new Snake(Snake.getInitialSnakeLength(), field));

        HBox buttonBox = new HBox(15);
        buttonBox.setPadding(new Insets(15, 15, 15, 15));
        buttonBox.setAlignment(Pos.BASELINE_CENTER);
        buttonBox.getChildren().addAll(score, buttonReturnMenu, buttonExitInGame);
        VBox root = new VBox(10, field, buttonBox);
        root.setPadding(new Insets(10));
        root.setBackground(new Background(new BackgroundFill(Color.LIMEGREEN, null, null))); // set the background color
        scene = new Scene(root);

        AnimationTimer timer = new AnimationTimer() { // infinite loop - handler is refreshed with every frame
            public void handle(long now) {

                if (now - then > 1000000000 / speedFactor) { // refresh speed
                    field.update();
                    then = now;
                    score.setText("Score: " + field.score);
                    changed = false;

                    if (hasNext) {
                        setDirection(field.snake, nextUpdate);
                        hasNext = false;
                    }

                    if (field.isDead()) {
                        try {
                            // creating an image with resourceStream for JAR compatibility
                            InputStream inputStream = getClass().getResourceAsStream("/gameover.gif");
                            Image image = new Image(inputStream);

                            // setting the image view
                            ImageView imageView = new ImageView(image);

                            // setting the fit height and width of the image view
                            imageView.setFitWidth(500);

                            // setting the preserve ratio of the image view
                            imageView.setPreserveRatio(true);

                            VBox gifBox = new VBox();
                            gifBox.setAlignment(Pos.BASELINE_CENTER);

                            buttonGif.setOnAction(event -> {
                                VBox lost = new VBox(10);
                                lost.setPadding(new Insets(10, 10, 10, 10));
                                Label finalScore = new Label("Your final Score is : " + field.score);
                                finalScore.setFont(Font.font("Arial Black", 22));
                                lost.getChildren().addAll(finalScore, buttonRestartWhenLost, buttonBackToMenuWhenLost,
                                        buttonExitWhenLost);
                                lost.setAlignment(Pos.CENTER);
                                lostScene = new Scene(lost, 500, 300);
                                ps.setScene(lostScene);
                                ps.setResizable(false);
                                ps.show();

                                buttonRestartWhenLost.setOnAction(event1 -> {
                                    root.getChildren().clear();
                                    field = new Field(SnakeApp.getWidth(), SnakeApp.getHeight());
                                    field.addSnake(new Snake(Snake.getInitialSnakeLength(), field));
                                    score.setText("Score : 0");
                                    root.getChildren().addAll(field, buttonBox);
                                    ps.setResizable(false);
                                    ps.setScene(scene);
                                    ps.show();
                                });

                                buttonBackToMenuWhenLost.setOnAction(event13 -> {
                                    ps.setScene(startScene);
                                    ps.show();
                                });
                                buttonExitWhenLost.setOnAction(event12 -> System.exit(0));
                            });

                            gifBox.getChildren().addAll(imageView, buttonGif);
                            gifBox.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
                            gifScene = new Scene(gifBox, 500, 350);
                            ps.setScene(gifScene);
                            ps.show();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        };

        // start animationTimer
        timer.start();

        // listen to keyboard input for mvt:
        scene.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.UP) && field.snake.getDirection() != Block.DOWN) {
                setDirection(field.snake, Block.UP);
            }
            if (e.getCode().equals(KeyCode.DOWN) && field.snake.getDirection() != Block.UP) {
                setDirection(field.snake, Block.DOWN);
            }
            if (e.getCode().equals(KeyCode.RIGHT) && field.snake.getDirection() != Block.LEFT) {
                setDirection(field.snake, Block.RIGHT);
            }
            if (e.getCode().equals(KeyCode.LEFT) && field.snake.getDirection() != Block.RIGHT) {
                setDirection(field.snake, Block.LEFT);
            }
        });

        // Button event handlers:

        buttonStart.setOnAction(event -> {
            root.getChildren().clear();
            field = new Field(SnakeApp.getWidth(), SnakeApp.getHeight());
            field.addSnake(new Snake(Snake.getInitialSnakeLength(), field));
            score.setText("Score : 0");
            root.getChildren().addAll(field, buttonBox);

            ps.setResizable(false);
            ps.setScene(scene);
            ps.setTitle("Snake Game");
            ps.show();
        });

        buttonExit.setOnAction(event -> System.exit(0));

        buttonReturnMenu.setOnAction(event -> {
            ps.setScene(startScene);
            ps.show();
        });

        buttonExitInGame.setOnAction(event -> System.exit(0));

        buttonSpeed.setOnAction(event -> buttonSpeed.setText(setSpeed()));

        // Initial window:
        start.getChildren().addAll(buttonStart, buttonSpeed, buttonExit);
        start.setAlignment(Pos.CENTER);
        startScene = new Scene(start, 500, 300);
        ps.initStyle(StageStyle.DECORATED);
        ps.setTitle("Snake Game");
        ps.setScene(startScene);
        ps.show();
    }

    public void setDirection(Snake snake, int direction) {
        if (!changed) {
            snake.setDirection(direction);
            changed = true;
        } else {
            hasNext = true;
            nextUpdate = direction;
        }
    }

    // method to set the speed on startup:
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

    public static void main(String[] args) {
        launch(args);
    }
}