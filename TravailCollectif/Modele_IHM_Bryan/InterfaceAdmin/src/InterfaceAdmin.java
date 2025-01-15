import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.net.URL;

public class InterfaceAdmin extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(modifierPofil());
        primaryStage.setTitle("Administrateur");
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public Scene modifierPofil(){
        BorderPane root = new BorderPane();
        VBox centre = new VBox();
        HBox haut = new HBox();
        HBox bas = new HBox();

        HBox hbxImg = new HBox();
        URL imageURL = getClass().getResource("profile.png");
        Image image = new Image(imageURL.toExternalForm());
        ImageView imageView = new ImageView(image);

        haut.setPadding(new Insets(50, 100, 100, 100));

        Button ConsStat = new Button("Consulter statistiques");
        Button GerUtil = new Button("Gérer utilisateur");
        haut.getChildren().add(imageView);
        centre.getChildren().addAll(ConsStat, GerUtil);
        root.setCenter(centre);
        root.setBottom(bas);
        root.setTop(haut);


        centre.setAlignment(Pos.TOP_CENTER);
        bas.setAlignment(Pos.BOTTOM_CENTER);
        haut.setAlignment(Pos.TOP_CENTER);
        centre.setSpacing(75);
        ConsStat.setStyle("-fx-font-family: Courier; -fx-font-size: 20px; -fx-background-color:#00f2ad ;-fx-border-color:black");
        GerUtil.setStyle("-fx-font-family: Courier; -fx-font-size: 20px; -fx-background-color: #62ffff ;-fx-border-color:black");
        DropShadow dsh = new DropShadow();
        dsh.setRadius(5.0);
        dsh.setOffsetX(3.0);
        dsh.setOffsetY(3.0);
        dsh.setColor(Color.color(0.4,0.5,0.5));
        ConsStat.setEffect(dsh);
        GerUtil.setEffect(dsh);
        ConsStat.setId("Constat");
        GerUtil.setId("GerUtil");
        ConsStat.setMaxWidth(ConsStat.getPrefWidth()+275);
        GerUtil.setMaxWidth(GerUtil.getPrefWidth()+275);
        ConsStat.setMaxHeight(ConsStat.getPrefHeight()+100);
        GerUtil.setMaxHeight(GerUtil.getPrefHeight()+100);



        ActionBouton ab = new ActionBouton(this);
        ConsStat.setOnAction(ab);
        GerUtil.setOnAction(ab);




        return new Scene(root, 700, 700);
    }
}
