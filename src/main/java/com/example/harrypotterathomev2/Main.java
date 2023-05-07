package com.example.harrypotterathomev2;

import AlertType.INFORMATION;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private static final Alert.AlertType INFORMATION = null;


    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        // Ajouter l'image au centre
        Image image;
        image = new Image("file:src/assets/Hogwarts-Logo-500x281.png");
        ImageView imageView = new ImageView(image);
        root.setCenter(imageView);

        // Créer le bouton "Start Game"
        Button startButton = new Button("Start Game");

        // Ajouter une action lorsqu'on clique sur le bouton "Start Game"
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Appeler la fonction permettant de lancer le jeu
                GameLogic.startGame();
            }
        });

        // Créer le bouton "Infos"
        Button infoButton = new Button("Infos");

        // Ajouter l'action du bouton "Infos"
        infoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Ouvrir une page d'information
                showInformation(primaryStage, root);
            }
        });

        // Créer le bouton "Exit"
        Button exitButton = new Button("Exit");

        // Ajouter une action lorsqu'on clique sur le bouton "Exit"
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Quitter le programme
                Platform.exit();
            }
        });

        // Créer la boîte pour les boutons
        HBox buttonBox = new HBox(10, startButton, infoButton, exitButton);
        buttonBox.setAlignment(Pos.CENTER);
        root.setBottom(buttonBox);

        // Créer la scène
        Scene scene = new Scene(root, 800, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showInformation(Stage primaryStage, BorderPane root) {
        Alert alert = new Alert(INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);

        alert.setContentText("Welcome to Harry Potter at Home, the wizarding RPG. Do you have what it takes to be the greatest " +
                "wizard? Can you meet all the challenges? Let's get started! \n\nYour goal is to complete your education at Hogwarts. " +
                "Each year will be full of challenges. \n\nAt the beginning of a game, you create your wizard. You then have to equip him with a" +
                " wand and let the Sorting Hat assign him his own enemies. The mechanics for defeating them will change depending on the enemy. " +
                "\n\nTo fight your enemies, you will be able to use spells that you will learn as the years go by. You also have potions which c" +
                "an help you to regain life. The spells you cast have a percentage chance of success, so you can fail your spells. \n\nEach hous" +
                "e has its own specificity: \n- Potions are more effective for Hufflepuff members. \n- Spells do more damage for Slytherin membe" +
                "rs. \n- Gryffindor wizards are more resistant to damage. \n- Ravenclaw wizards are more accurate. \n\nTo complete the game, you" +
                " must survive all 7 levels. If you do, you will graduate from the most prestigious wizarding school on the planet!");

        // Ajouter un bouton "Ok"
        alert.getButtonTypes().setAll(ButtonType.OK);

        // Changer la couleur de fond en marron et l'écriture en gras
        alert.getDialogPane().setStyle("-fx-background-color: #784e2b; -fx-font-weight: bold; -fx-font-color: #000000;");

        alert.showAndWait();
    }
}