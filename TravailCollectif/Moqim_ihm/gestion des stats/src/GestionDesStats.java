import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class GestionDesStats extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(modifierPofil());
        primaryStage.setTitle("Gestion des statistiques");
        primaryStage.show();
    }

    public Scene modifierPofil(){

        FileInputStream input = null;
        FileInputStream input2 = null;
        try {
            input = new FileInputStream("src/retour.png");
            input2 = new FileInputStream("src/profile.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image i = new Image(input);
        ImageView image1 = new ImageView(i);
        image1.setPreserveRatio(true);

        Image i2 = new Image(input2);
        ImageView image2 = new ImageView(i2);
        image2.setPreserveRatio(true);

        image1.setFitHeight(30);
        image1.setFitWidth(30);
        image2.setFitHeight(30);
        image2.setFitWidth(30);








        BorderPane root = new BorderPane();
        VBox centre = new VBox();
        HBox haut = new HBox();
        HBox bas = new HBox();
        Button nbSenCree = new Button("Nombre de scénarios créés");
        Button nbPartieCours = new Button("Nombre de parties en cours");
        Button nbPersonnesInscr = new Button("Nombre de personnes inscrites");
        Button boutonHaut = new Button("", image2);
        Button boutonBas = new Button("", image1);
        Label lHaut = new Label("Gestion des statistiques");
        centre.getChildren().addAll(lHaut, nbSenCree, nbPartieCours, nbPersonnesInscr);
        root.setCenter(centre);
        root.setBottom(bas);
        root.setTop(haut);
        bas.getChildren().add(boutonBas);
        haut.getChildren().add(boutonHaut);
        centre.setAlignment(Pos.CENTER);
        bas.setAlignment(Pos.BOTTOM_LEFT);
        haut.setAlignment(Pos.TOP_RIGHT);
        centre.setSpacing(100);
        nbPartieCours.setStyle("-fx-font-family: Courier; -fx-font-size: 20px; -fx-background-color: #00f2ad;-fx-border-color:black");
        nbPersonnesInscr.setStyle("-fx-font-family: Courier; -fx-font-size: 20px; -fx-background-color: #00f2ad; -fx-border-color:black");
        nbSenCree.setStyle("-fx-font-family: Courier; -fx-font-size: 20px; -fx-background-color: #00f2ad ;-fx-border-color:black");
        lHaut.setStyle("-fx-font-family: Courier; -fx-font-size: 30px; -fx-font-weight: bold");
        DropShadow dsh = new DropShadow();
        dsh.setRadius(5.0);
        dsh.setOffsetX(3.0);
        dsh.setOffsetY(3.0);
        dsh.setColor(Color.color(0.4,0.5,0.5));
        lHaut.setEffect(dsh);
        nbPartieCours.setEffect(dsh);
        nbPersonnesInscr.setEffect(dsh);
        nbSenCree.setEffect(dsh);
        nbPartieCours.setId("nbPartie");
        nbPersonnesInscr.setId("nbPersonne");
        nbSenCree.setId("nbScenario");
        boutonBas.setId("boutonBas");
        boutonHaut.setId("boutonHaut");
        nbPartieCours.setMaxWidth(nbPartieCours.getPrefWidth()+400);
        nbPersonnesInscr.setMaxWidth(nbPersonnesInscr.getPrefWidth()+400);
        nbSenCree.setMaxWidth(nbSenCree.getPrefWidth()+400);
        nbPartieCours.setMaxHeight(nbPartieCours.getPrefHeight()+400);
        nbPersonnesInscr.setMaxHeight(nbPersonnesInscr.getPrefHeight()+400);
        nbSenCree.setMaxHeight(nbSenCree.getPrefHeight()+400);









        ActionBouton ab = new ActionBouton(this);
        nbPartieCours.setOnAction(ab);
        nbSenCree.setOnAction(ab);
        nbPersonnesInscr.setOnAction(ab);
        boutonBas.setOnAction(ab);
        boutonHaut.setOnAction(ab);
        root.setStyle("-fx-background-color:#a19c9c");




        return new Scene(root, 700, 700);
    }

    public Scene nbParties() {
        VBox v1 = new VBox();
        Label lHaut = new Label("Gestion des statistiques");
        Label l1 = new Label("Nombre de parties en cours  :  ");
        Label l2 = new Label("nb");
        v1.getChildren().addAll(lHaut, l1, l2);
        v1.setAlignment(Pos.CENTER);
        v1.setSpacing(50);

        DropShadow dsh = new DropShadow();
        dsh.setRadius(5.0);
        dsh.setOffsetX(3.0);
        dsh.setOffsetY(3.0);
        dsh.setColor(Color.color(0.4,0.5,0.5));
        l1.setEffect(dsh);
        l2.setEffect(dsh);
        lHaut.setEffect(dsh);
        lHaut.setStyle("-fx-font-family: Courier; -fx-font-size: 20px; -fx-font-weight: bold");
        l1.setStyle("-fx-font-family: Courier; -fx-font-size: 20px; -fx-font-weight: bold");
        l2.setStyle("-fx-font-family: Courier; -fx-font-size: 45px; -fx-font-weight: bold");
        return new Scene(v1, 400, 400);
        
        }
        
        
    public Scene nbPersonnes() {
        VBox v1 = new VBox();
        Label lHaut = new Label("Gestion des statistiques");
        Label l1 = new Label("Nombre de personnes inscrites  :  ");
        Label l2 = new Label("nb");
        v1.getChildren().addAll(lHaut, l1, l2);
        v1.setAlignment(Pos.CENTER);
        v1.setSpacing(50);

        DropShadow dsh = new DropShadow();
        dsh.setRadius(5.0);
        dsh.setOffsetX(3.0);
        dsh.setOffsetY(3.0);
        dsh.setColor(Color.color(0.4,0.5,0.5));
        l1.setEffect(dsh);
        l2.setEffect(dsh);
        lHaut.setEffect(dsh);
        lHaut.setStyle("-fx-font-family: Courier; -fx-font-size: 20px; -fx-font-weight: bold");
        l1.setStyle("-fx-font-family: Courier; -fx-font-size: 20px; -fx-font-weight: bold");
        l2.setStyle("-fx-font-family: Courier; -fx-font-size: 45px; -fx-font-weight: bold");

        return new Scene(v1, 400, 400);
        }
        
        

    public Scene nbScenario() {
        VBox v1 = new VBox();
        Label lHaut = new Label("Gestion des statistiques");
        Label l1 = new Label("Nombre de scénario céés  :  ");
        Label l2 = new Label("nb");
        v1.getChildren().addAll(lHaut, l1, l2);
        v1.setAlignment(Pos.CENTER);
        v1.setSpacing(50);

        DropShadow dsh = new DropShadow();
        dsh.setRadius(5.0);
        dsh.setOffsetX(3.0);
        dsh.setOffsetY(3.0);
        dsh.setColor(Color.color(0.4,0.5,0.5));
        l1.setEffect(dsh);
        l2.setEffect(dsh);
        lHaut.setEffect(dsh);
        lHaut.setStyle("-fx-font-family: Courier; -fx-font-size: 20px; -fx-font-weight: bold");
        l1.setStyle("-fx-font-family: Courier; -fx-font-size: 20px; -fx-font-weight: bold");
        l2.setStyle("-fx-font-family: Courier; -fx-font-size: 45px; -fx-font-weight: bold");

        return new Scene(v1, 400, 400);}



}
