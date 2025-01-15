import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;

public class Echapee_belle_vue extends Application {
    private Stage primaryStage;
    private TextField tId;
    private PasswordField tMdp;
    private UtilisateurJDBC utilisateurJDBC;
    private ConnexionMySQL connexionMySQL;
    private TextField tf1;
    private PasswordField tf2;
    private PasswordField tf3;
    private TextField tf4;
    private FileChooser fc;
    private Button tf5;
    private ImageView cadreimg;
    private String chemin;

    public Button getTf5() {
        return tf5;
    }

    public TextField getTf1() {

        return tf1;
    }

    public PasswordField getTf2() {
        return tf2;
    }

    public PasswordField getTf3() {
        return tf3;
    }

    public TextField getTf4() {
        return tf4;
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    public ConnexionMySQL getConnexionMySQL() {
        return connexionMySQL;
    }

    public UtilisateurJDBC getUtilisateurJDBC() {
        return utilisateurJDBC;
    }

    public FileChooser getFc() {
        return fc;
    }

    public TextField getTId(){return this.tId;}
    public PasswordField getMdp(){return this.tMdp;}

    public void setCadreimg(Image img) {
        this.cadreimg.setImage(img);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.connexionMySQL = new ConnexionMySQL();
        this.connexionMySQL.connecter("servinfo-mariadb","DBbmeunier","bmeunier","bmeunier");
        this.utilisateurJDBC = new UtilisateurJDBC(connexionMySQL);
        primaryStage.setScene(new Scene(Bienvenue(),700,700));
        primaryStage.show();
    }
    public Pane Bienvenue(){
        BorderPane panel = new BorderPane();
        panel.setStyle("-fx-background-image: url(\"Bienvenue_img.png\");-fx-background-repeat: stretch;-fx-background-position: center center; -fx-background-size: 700 700; -fx-font-size: 20px;-fx-focus-color: transparent;");
        Label titre = new Label("Bienvenue");
        HBox hb = new HBox();
        hb.getChildren().add(titre);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(125,10,10,10));
        titre.setStyle("-fx-font-family: \"Liberation Serif\"; -fx-font-size: 30 px; -fx-text-fill: white");
        VBox vb = new VBox();
        panel.setTop(hb);
        titre.setAlignment(Pos.CENTER);
        Button bp_connecter = new Button("Se connecter");
        bp_connecter.setOnAction(new ActionAcceuil(this, "Connecter"));
        Button bp_inscrire = new Button("S'inscrire");
        bp_inscrire.setOnAction(new ActionAcceuil(this, "Inscrire"));
        // regler position et taille des boutons
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(100);
        bp_connecter.setPrefWidth(200);
        bp_connecter.setPrefHeight(65);
        bp_inscrire.setPrefWidth(200);
        bp_inscrire.setPrefHeight(65);
        vb.getChildren().addAll(bp_connecter,bp_inscrire);
        panel.setCenter(vb);
        return panel;
    }
    public Pane AccueilJoueur(){
        BorderPane panel = new BorderPane();
        HBox hb = new HBox();
        VBox vb = new VBox();
        Button bp1 = new Button("CREER UNE PARTIE");
        Button bp2 = new Button("CONSULTER DERNIERS SCENARIOS");
        Button bp3 = new Button("CONSULTER STATISTIQUES");
        vb.getChildren().addAll(bp1,bp2,bp3);
        bp1.setPrefWidth(400);
        bp1.setPrefHeight(65);
        bp2.setPrefWidth(400);
        bp2.setPrefHeight(65);
        bp3.setPrefWidth(400);
        bp3.setPrefHeight(65);
        bp1.setStyle("-fx-font-family: \"Liberation Serif\"; -fx-font-size: 18px; -fx-background-color: #ff7979;");
        bp2.setStyle("-fx-font-family: \"Liberation Serif\"; -fx-font-size: 18px; -fx-background-color: #5ffff0;");
        bp3.setStyle("-fx-font-family: \"Liberation Serif\"; -fx-font-size: 18px; -fx-background-color: #5fff6d;");
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(100);
        FileInputStream input = null;
        try {
            input = new FileInputStream("/home/bmeunier/Bureau/Projet_Echappee/gr11a/Bastien_IHM/src/retour.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image i = new Image(input);
        ImageView imgRetour = new ImageView(i);
        imgRetour.setFitHeight(50);
        imgRetour.setFitWidth(50);
        imgRetour.setPreserveRatio(true);
        Button bp_retour = new Button("", imgRetour);
        panel.setCenter(vb);
        panel.setBottom(bp_retour);
        return panel;
    }
    public Pane inscription(){

        Label labInscript = new Label("Inscription");
        HBox hb = new HBox();
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().add(labInscript);
        labInscript.setStyle("-fx-font-family: Roboto; -fx-font-size: 30px; -fx-font-weight: bold");
        hb.setPadding(new Insets(80, 0, 0,0));

        Label info1 = new Label("Saisir un identifiant:");
        this.tf1 = new TextField();

        Label info2 = new Label("Choisir un mot de passe:");
        this.tf2 = new PasswordField();

        Label info3 = new Label("Confirmer votre mot de passe:");
        this.tf3 = new PasswordField();

        Label info4 = new Label("Adresse mail:");
        this.tf4 = new TextField();

        Label info5 = new Label("Selectionner votre avatar:");
        this.tf5 = new Button();
        this.tf5.setMaxWidth(100);
        this.tf5.setPrefHeight(100);
        this.fc = new FileChooser();
        fc.setTitle("Choix de l'avatar");
        FileChooser.ExtensionFilter et = new FileChooser.ExtensionFilter("image","*.png");
        fc.getExtensionFilters().add(et);
        tf5.setOnAction(new BoutonAvatar(this));

        this.cadreimg = new ImageView();
        GridPane gp = new GridPane();
        gp.add(info1, 1,1);
        gp.add(tf1, 2, 1);

        gp.add(info2, 1,2);
        gp.add(tf2, 2, 2);

        gp.add(info3, 1,3);
        gp.add(tf3, 2, 3);

        gp.add(info4, 1,4);
        gp.add(tf4, 2, 4);

        gp.add(info5, 1,5);
        gp.add(tf5, 2, 5);

        gp.setAlignment(Pos.CENTER);
        gp.setVgap(30);
        gp.setHgap(10);

        HBox hbBas = new HBox();


        FileInputStream input = null;
        try {
            input = new FileInputStream("/home/bmeunier/Bureau/Projet_Echappee/gr11a/Bastien_IHM/src/retour.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image i = new Image(input);
        ImageView imgRetour = new ImageView(i);
        imgRetour.setFitHeight(50);
        imgRetour.setFitWidth(50);
        imgRetour.setPreserveRatio(true);
        Button retour = new Button( "", imgRetour);
        retour.setOnAction(new ActionInscription(this, "retour"));
        FileInputStream input2 = null;
        try {
            input2 = new FileInputStream("/home/bmeunier/Bureau/Projet_Echappee/gr11a/Bastien_IHM/src/validation.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image i2 = new Image(input2);
        ImageView imgValider = new ImageView(i2);
        imgValider.setFitHeight(50);
        imgValider.setFitWidth(50);
        imgRetour.setPreserveRatio(true);
        Button valider = new Button("", imgValider);
        valider.setOnAction(new ActionInscription(this, "valider"));


        hbBas.getChildren().add(retour);
        hbBas.getChildren().add(valider);
        hbBas.setSpacing(565);

        BorderPane bp = new BorderPane();
        bp.setCenter(gp);
        bp.setTop(hb);
        bp.setBottom(hbBas);

        return bp;
    }
    public Pane creerConnexion(){
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
        bRetour.setOnAction(new ActionConnexion(this,"retourAccueille"));
        Button bValider = new Button("Valider");
        bValider.setOnAction(new ActionConnexion(this,"validerAcces"));
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


        return bp;
    }
    public Pane statistiques(){
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
        return bp;
    }
    public void changeVue(Pane panel){
        primaryStage.getScene().setRoot(panel);
    }
}
