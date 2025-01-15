import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.naming.NamingEnumeration;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class GestionDesUtils extends Application {
    private Label labelStatus;
    private Label labelPseudo;
    private Label labelMail;
    private Label labelGate;
    private TextField rechercherEntee;
    public TextField getRechercherEntee(){return this.rechercherEntee;}
    public Label getLabelStatus(){return this.labelStatus;}
    public Label getLabelPseudo(){return this.labelPseudo;}
    public Label getLabelMail(){return this.labelMail;}
    public Label getLabelGate(){return this.labelGate;}

    public static void main(String[] args) {
        launch(args);
    }
    public Scene modifierPofil(){


        FileInputStream input = null;
        FileInputStream input2 = null;
        FileInputStream input3 = null;
        try {
            input = new FileInputStream("src/retour.png");
            input2 = new FileInputStream("src/profile.png");
            input3 = new FileInputStream("src/rechercher.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image i = new Image(input);
        ImageView image1 = new ImageView(i);
        image1.setPreserveRatio(true);

        Image i2 = new Image(input2);
        ImageView image2 = new ImageView(i2);
        image2.setPreserveRatio(true);

        Image i3 = new Image(input3);
        ImageView image3 = new ImageView(i3);
        image2.setPreserveRatio(true);


        image1.setFitHeight(30);
        image1.setFitWidth(30);
        image2.setFitHeight(30);
        image2.setFitWidth(30);
        image3.setFitHeight(20);
        image3.setFitWidth(20);
        BorderPane root = new BorderPane();
        Button buttonHaut = new Button("", image2);
        Button buttonBas = new Button("", image1);
        Button buttonRechercher = new Button("",image3);
        Label labelGlobal = new Label("Gestion des utilisateurs");
        this.rechercherEntee = new TextField();


        Label labelStatusStatic = new Label("Status");
        Label labelPseudoStatic = new Label("Pseudo");
        Label labelMailStatic = new Label("Adresse mail");
        Label labelGateStatic = new Label("Gate\ncréaction\ncompte");
        this.labelStatus = new Label("À imlementer");
        this.labelPseudo = new Label("À imlementer");
        this.labelMail = new Label("À imlementer");
        this.labelGate = new Label("À imlementer");
        GridPane centre = new GridPane();

        HBox top = new HBox();
        HBox buttom = new HBox();
        HBox label = new HBox();
        label.getChildren().add(labelGlobal);
        centre.setHgap(25);
        centre.setPadding(new Insets(0, 0, 0, 120));


        VBox v1 = new VBox();
        HBox h1 = new HBox();
        HBox recherBar = new HBox();
        v1.getChildren().addAll(label, recherBar, centre);
        
        recherBar.getChildren().addAll(buttonRechercher, rechercherEntee);
        recherBar.setAlignment(Pos.CENTER);

        label.setAlignment(Pos.CENTER);

        centre.add(labelStatusStatic, 0, 3);
        centre.add(labelPseudoStatic, 1, 3);
        centre.add(labelMailStatic, 2, 3);
        centre.add(labelGateStatic, 3, 3);

        centre.add(labelStatus, 0, 4);
        centre.add(labelPseudo, 1, 4);
        centre.add(labelMail, 2, 4);
        centre.add(labelGate, 3, 4);

        root.setCenter(v1);
        root.setTop(top);
        v1.setAlignment(Pos.CENTER);
        v1.setSpacing(0);
        root.setBottom(buttom);
        label.setPadding(new Insets(0, 0, 50, 0));

        top.getChildren().add(buttonHaut);
        buttom.getChildren().add(buttonBas);
        top.setAlignment(Pos.TOP_RIGHT);
        buttom.setAlignment(Pos.BOTTOM_LEFT);
        centre.setVgap(50);
        DropShadow dsh = new DropShadow();
        dsh.setRadius(5.0);
        dsh.setOffsetX(3.0);
        dsh.setOffsetY(3.0);
        dsh.setColor(Color.color(0.4,0.5,0.5));
        labelGlobal.setEffect(dsh);
        labelGlobal.setStyle("-fx-font-family: Courier; -fx-font-size: 33px; -fx-font-weight: bold");

        ActionBouton c = new ActionBouton(this);
        buttonHaut.setOnAction(c);
        buttonBas.setOnAction(c);
        buttonRechercher.setOnAction(c);
        buttonHaut.setId("modifierProdile");
        buttonBas.setId("arrier");
        buttonRechercher.setId("recherche");

        return new Scene(root, 700, 700); }


    
    
    
    
    
    Scene nbParties(){
        VBox v1 = new VBox();
        Label L1 = new Label("Nombre de parties créés  :  ");
        Label l2 = new Label("ici le nombre de partie\n>>bd");
        v1.getChildren().addAll(l1, l2);
        v1.setAlignment(Pos.CENTER);
        v1.setSpacing(50);
        
        
        
        
        return new Scene(root, 400, 400); 
        
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(modifierPofil());
        primaryStage.setTitle("Gestion des utilisateurs");
        primaryStage.show();
    }
}