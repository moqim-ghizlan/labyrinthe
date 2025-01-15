import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

GestionDesStats

public class VueConnexion extends Application {

    private TextField tId;
    private PasswordField tMdp;
    private  TextField getAdresse;

    public TextField getTId(){return this.tId;}
    public TextField getAdresse(){return this.tId;}
    public PasswordField getMdp(){return this.tMdp;}

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(modifierPofil());
        primaryStage.setTitle("modifiez votre pofil");
        primaryStage.show();
    }

    public Scene modifierPofil(){

        HBox haut = new HBox();
        GridPane centre = new GridPane();
        HBox bas = new HBox();
        BorderPane root = new BorderPane();

        // Labels

        Label lId = new Label("Pseudo : ");
        Label lAdress = new Label("Adresse mail : ");
        Label lMdp = new Label("Mot de passe : ");
        //titre.setStyle("-fx-font-family: Roboto; -fx-font-size: 30px; -fx-font-weight: bold;");
        lId.setStyle("-fx-font-family: Courier; -fx-font-size: 20px;");
        lMdp.setStyle("-fx-font-family: Courier; -fx-font-size: 20px;");
        lAdress.setStyle("-fx-font-family: Courier; -fx-font-size: 20px;");



        // Boutons
        Button bRetour = new Button("R ");//faut mettre image pour revenir en arrire
        Button bDesconn = new Button("Déconnexion");
        Button mPs = new Button("-_-");
        Button mAm = new Button("-_-");
        bRetour.setStyle("-fx-font-family: \"Liberation Serif\"; -fx-font-size: 20px; -fx-background-color: #E66A6A;");
        bDesconn.setStyle("-fx-font-family: \"Liberation Serif\"; -fx-font-size: 20px; -fx-background-color: #8aff80;");

        ActionBouton ab = new ActionBouton(this);
        bDesconn.setOnAction(ab);
        bRetour.setOnAction(ab);
        mAm.setOnAction(ab);
        mPs.setOnAction(ab);
        mPs.setId("changer pseudo");
        mAm.setId("changer adresse mail");
        bRetour.setId("revenir en arrire");
        bDesconn.setId("desconnexion");

        // TextField
        this.tId = new TextField();
        this.getAdresse = new TextField();
        this.tMdp = new PasswordField();

        // Haut

        haut.setAlignment(Pos.CENTER);
        haut.setPadding(new Insets(15));


        // Centre
        centre.add(lId, 0, 0);
        centre.add(lAdress, 0, 1);
        centre.add(lMdp, 0, 2);
        centre.add(mAm, 3, 0);
        centre.add(mPs, 3, 1);
        centre.add(tId, 1, 0);
        centre.add(getAdresse, 1, 1);
        centre.add(tMdp, 1, 2);
        centre.setAlignment(Pos.CENTER);
        centre.setVgap(30);

        // Bas
        bas.getChildren().addAll(bRetour, bDesconn);
        bas.setAlignment(Pos.CENTER);
        bas.setSpacing(300);
        bas.setPadding(new Insets(15));


        javafx.scene.text.Font.getFamilies();

        root.setCenter(centre);
        root.setBottom(bas);
        root.setTop(haut);
        return new Scene(root, 700, 700);
    }
}
