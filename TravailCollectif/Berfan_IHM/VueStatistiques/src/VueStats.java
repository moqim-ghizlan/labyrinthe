import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VueStats extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(statistiques());
        primaryStage.show();
    }

    public Scene statistiques(){
        BorderPane bp = new BorderPane();
        HBox hbHaut = new HBox();
        VBox vb = new VBox();


        // Boutons
        Button creerPartie = new Button("Créer une partie");
        Button consultScenar = new Button("Consulter derniers\n scénarios");
        Button consultStats = new Button("Consulter statistiques");

        creerPartie.setPrefWidth(200);
        consultScenar.setPrefWidth(200);
        consultStats.setPrefWidth(200);

        creerPartie.setPrefHeight(50);
        consultScenar.setPrefHeight(50);
        consultStats.setPrefHeight(50);

        creerPartie.setStyle("-fx-font-family: \"Liberation Serif\"; -fx-font-size: 18px; -fx-background-color: #ff7979;");
        consultScenar.setStyle("-fx-font-family: \"Liberation Serif\"; -fx-font-size: 18px; -fx-background-color: #5ffff0;");
        consultStats.setStyle("-fx-font-family: \"Liberation Serif\"; -fx-font-size: 18px; -fx-background-color: #5fff6d;");

        DropShadow ds = new DropShadow();
        ds.setRadius(5.0);
        ds.setOffsetX(3.0);
        ds.setOffsetY(3.0);
        ds.setColor(Color.color(0.4, 0.5, 0.5));

        creerPartie.setEffect(ds);
        consultScenar.setEffect(ds);
        consultStats.setEffect(ds);






        hbHaut.getChildren().addAll(creerPartie, consultScenar, consultStats);


        // Labels
        Label nbPartieJoue = new Label("Nombre de parties jouées : ");
        Label nbPartieWin = new Label("Nombre de parties gagnées : ");
        Label meilleurTps = new Label("Meilleur temps réalisé : ");
        Label scenarMoins10 = new Label("Nombre de scénatios réalisés en moins de 10 minutes : ");


        vb.getChildren().addAll(nbPartieJoue, nbPartieWin, meilleurTps, scenarMoins10);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(50);
        vb.setStyle("-fx-font-weight: bold;");


        bp.setTop(hbHaut);
        bp.setCenter(vb);
        return new Scene(bp, 700, 700);
    }
}
