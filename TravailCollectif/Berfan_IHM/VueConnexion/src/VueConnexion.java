import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class VueConnexion extends Application {

    private TextField tId;
    private PasswordField tMdp;

    public TextField getTId(){return this.tId;}
    public PasswordField getMdp(){return this.tMdp;}

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(creerConnexion());
        primaryStage.show();
    }

    public Scene creerConnexion(){
        BorderPane bp = new BorderPane();
        HBox haut = new HBox();
        GridPane centre = new GridPane();
        HBox bas = new HBox();

        // Labels
        Label titre = new Label("Connexion");
        Label lId = new Label("Identifiant : ");
        Label lMdp = new Label("Mot de passe : ");
        titre.setStyle("-fx-font-family: Roboto; -fx-font-size: 30px; -fx-font-weight: bold;");
        lId.setStyle("-fx-font-family: Courier; -fx-font-size: 20px;");
        lMdp.setStyle("-fx-font-family: Courier; -fx-font-size: 20px;");




        // Boutons
        Button bRetour = new Button("Retour");
        Button bValider = new Button("Valider");
        bRetour.setStyle("-fx-font-family: \"Liberation Serif\"; -fx-font-size: 20px; -fx-background-color: #E66A6A;");
        bValider.setStyle("-fx-font-family: \"Liberation Serif\"; -fx-font-size: 20px; -fx-background-color: #8aff80;");

        // TextField
        this.tId = new TextField();
        this.tMdp = new PasswordField();

        // Haut
        haut.getChildren().add(titre);
        haut.setAlignment(Pos.CENTER);
        haut.setPadding(new Insets(15));

        // Centre
        centre.add(lId, 0, 0);
        centre.add(lMdp, 0, 1);
        centre.add(tId, 1, 0);
        centre.add(tMdp, 1, 1);
        centre.setAlignment(Pos.CENTER);
        centre.setVgap(50);

        // Bas

        bas.getChildren().addAll(bRetour, bValider);
        bas.setAlignment(Pos.CENTER);
        bas.setSpacing(300);
        bas.setPadding(new Insets(15));


        bp.setTop(haut);
        bp.setCenter(centre);
        bp.setBottom(bas);

        javafx.scene.text.Font.getFamilies();


        return new Scene(bp, 500, 500);
    }
}
