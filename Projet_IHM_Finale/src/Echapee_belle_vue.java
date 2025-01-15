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
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;

public class Echapee_belle_vue extends Application {
    private Label l2;
    private Label l3;
    private GestionStatsAdminJDBC gestionStatsAdminJDBC;
    private ModeleEchapee echapee;
    private VueEchapee vueEchap;
    private Stage primaryStage;
    private TextField tId;
    private PasswordField tMdp;
    private CarteJDBC cartejdbc;
    private UtilisateurJDBC utilisateurJDBC;
    private InformationJDBC informationJDBC;
    private ConnexionMySQL connexionMySQL;
    private CreationPartieJDBC creationPartieJDBC;
    private Scenario scenario;
    private TextField tf1;
    private PasswordField tf2;
    private PasswordField tf3;
    private TextField tf4;
    private FileChooser fc;
    private Button tf5;
    private ImageView cadreimg;
    private String chemin;
    private ImageView imageViewAJ;
    private ImageView imageViewPJ;
    private Button creer;
    private Button consulterDernierScena;
    private Button consulterStat;
    private Label resPartieJoue;
    private Label resMeilleurTps;
    private Label resScenaMoins10;
    private Label resPartieWin;
    private TextField tfCrea;
    private Label vbNom;
    private Label vbDuree;
    private Label vbDate;
    public Scenario getScenario() {
        return scenario;
    }

    public Label getVbNom() {
        return vbNom;
    }

    public Label getVbDuree() {
        return vbDuree;
    }

    public Label getVbDate() {
        return vbDate;
    }

    public Button getTf5() {
        return tf5;
    }

    public TextField getTfCrea() {
        return tfCrea;
    }

    public ImageView getImageViewAJ() {
        return imageViewAJ;
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
        this.informationJDBC = new InformationJDBC(connexionMySQL);
        this.cartejdbc = new CarteJDBC(connexionMySQL);
        this.creationPartieJDBC = new CreationPartieJDBC(connexionMySQL);
        this.gestionStatsAdminJDBC = new GestionStatsAdminJDBC(connexionMySQL);
        primaryStage.setScene(new Scene(Bienvenue(),700,700));
        primaryStage.show();
    }

    public Pane JeuEchappe() throws SQLException{


        echapee=new ModeleEchapee(10,10,this.cartejdbc.rechercherPlan(1), 5, 4);



        Image img=new Image("file:src/Images/IMAGESbd/tilesMaison.png");


        //Le truc pour pas qu'on reduise la fenêtre
        //st.setResizable(false);

//        boolean actif=true; // mettre actif à false pour tester la méthode activer()
//        setSceneTuile( img.getWidth()/3,img.getHeight()/3,1,1,0,actif, img);
        vueEchap =new VueEchapee(echapee,img,400, 5, 4);//LA YA EU DU CHANGEMENT
        ControlleurJoueur controlJ = new ControlleurJoueur(echapee, vueEchap);
        primaryStage.getScene().setOnKeyPressed(controlJ);

        return vueEchap;

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
        this.creer = new Button("CREER UNE PARTIE");
        this.consulterDernierScena = new Button("CONSULTER DERNIERS SCENARIOS");
        this.consulterStat = new Button("CONSULTER STATISTIQUES");

        this.creer.setOnAction( new ActionBoutonJoueur(this,"creer"));
        this.consulterDernierScena.setOnAction(new ActionBoutonJoueur(this,"consulterDer"));
        this.consulterStat.setOnAction(new ActionBoutonJoueur(this,"consulterStat"));


        this.creer.setPrefWidth(400);
        this.creer.setPrefHeight(65);
        this.consulterDernierScena.setPrefWidth(400);
        this.consulterDernierScena.setPrefHeight(65);
        this.consulterStat.setPrefWidth(400);
        this.consulterStat.setPrefHeight(65);
        this.creer.setStyle("-fx-font-family: \"Liberation Serif\"; -fx-font-size: 18px; -fx-background-color: #ff7979;");
        this.consulterDernierScena.setStyle("-fx-font-family: \"Liberation Serif\"; -fx-font-size: 18px; -fx-background-color: #5ffff0;");
        this.consulterStat.setStyle("-fx-font-family: \"Liberation Serif\"; -fx-font-size: 18px; -fx-background-color: #5fff6d;");



        Image img = null;
        Blob blob = this.utilisateurJDBC.getUti().getAvatarUtilisateur();
        InputStream is = null;
        try {
            img = new Image(new FileInputStream("src/Images/IMAGESbd/1.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ;
        try {
            if(blob!=null){
                is = blob.getBinaryStream();
                img = new Image(is);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        this.imageViewAJ = new ImageView(img);
        imageViewAJ.setFitHeight(70);
        imageViewAJ.setFitWidth(55);
        imageViewAJ.setOnMouseClicked(new ActionAccueilJoueur(this));

        // Ajout des boutons dans la Vbox
        vb.getChildren().addAll(imageViewAJ,this.creer,this.consulterDernierScena,this.consulterStat);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(100);

        //bp3.setOnAction(new ActionAccueilJoueur(this, "Consulter statistiques"));


        panel.setCenter(vb);

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
        this.tf5.setPrefSize(100,100);
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
            input = new FileInputStream("src/Images/retour.png");
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
            input2 = new FileInputStream("src/Images/validation.png");
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
    public Pane editJoueur() {
        //Création des containers
        BorderPane bp = new BorderPane();

        VBox vb = new VBox();
        GridPane gp = new GridPane();
        HBox hbBas = new HBox();

        Image img = null;
        Blob blob = this.utilisateurJDBC.getUti().getAvatarUtilisateur();
        InputStream is = null;
        try {
            img = new Image(new FileInputStream("src/Images/IMAGESbd/1.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ;
        try {
            if(blob!=null){
                is = blob.getBinaryStream();
                img = new Image(is);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        this.imageViewPJ = new ImageView(img);
        imageViewAJ.setFitHeight(70);
        imageViewAJ.setFitWidth(55);


        vb.getChildren().add(imageViewPJ);
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(50, 0, 0, 0));

        //Création des labels et fields
        Label pseudo = new Label("Pseudo :");
        Label mail = new Label("Adresse mail :");
        Label mdp = new Label("Mot de passe :");

        Label pseudoField =  new Label(this.utilisateurJDBC.getUti().getPseudoUtilisateur());
        Label mailField = new Label(this.utilisateurJDBC.getUti().getMailUtilisateur());
        PasswordField mdpField = new PasswordField();

        //Ajout des labels et fiels dans le gridpane
        gp.add(pseudo, 1, 1);
        gp.add(mail, 1, 2);
        gp.add(mdp, 1, 3);

        gp.add(pseudoField, 2, 1);
        gp.add(mailField, 2, 2);
        gp.add(mdpField, 2, 3);

        gp.setAlignment(Pos.CENTER);
        gp.setVgap(30);
        gp.setHgap(30);
        gp.setPadding(new Insets(0, 0, 50, 0));

        //Ajout des boutons dans le Hbox
        FileInputStream input2 = null;
        try {
            input2 = new FileInputStream("src/Images/retour.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image i2 = new Image(input2);
        ImageView imgRetour = new ImageView(i2);
        imgRetour.setFitHeight(50);
        imgRetour.setFitWidth(50);
        imgRetour.setPreserveRatio(true);
        Button retour = new Button( "", imgRetour);
        retour.setPrefHeight(50);
        retour.setOnAction(new ActionEditJoueur(this, "retour"));

        Button deco = new Button("Déconnexion");
        deco.setStyle("-fx-font-family: \"Liberation Serif\"; -fx-font-size: 18px; -fx-background-color: #ff7979;");
        deco.setOnAction(new ActionEditJoueur(this, "Déconnexion"));
        deco.setPrefHeight(50);

        hbBas.getChildren().addAll(retour, deco);
        hbBas.setSpacing(514);
        hbBas.setAlignment(Pos.BOTTOM_CENTER);
        // Ajout des containers dans le borderpane
        bp.setTop(vb);
        bp.setCenter(gp);
        bp.setBottom(hbBas);
        return bp;
    }

    public Pane statistiques() {
        BorderPane bp = new BorderPane();
        HBox hbHaut = new HBox();
        VBox vb = new VBox();


        // Boutons
        Button creerPartie = new Button("Créer une partie");
        Button consultScenar = new Button("Consulter derniers\n scénarios");
        Button consultStats = new Button("Consulter statistiques");

        creerPartie.setOnAction( new ActionBoutonJoueur(this,"creer"));
        consultScenar.setOnAction( new ActionBoutonJoueur(this,"consulterDer"));
        consultStats.setOnAction( new ActionBoutonJoueur(this,"consulterStat"));

        creerPartie.setPrefWidth(210);
        consultScenar.setPrefWidth(210);
        consultStats.setPrefWidth(210);

        creerPartie.setPrefHeight(57);
        consultScenar.setPrefHeight(57);
        consultStats.setPrefHeight(57);

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

        Image img = null;
        Blob blob = this.utilisateurJDBC.getUti().getAvatarUtilisateur();
        InputStream is = null;
        try {
            img = new Image(new FileInputStream("src/Images/IMAGESbd/1.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ;
        try {
            if(blob!=null){
                is = blob.getBinaryStream();
                img = new Image(is);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        this.imageViewAJ = new ImageView(img);
        imageViewAJ.setFitHeight(57);
        imageViewAJ.setFitWidth(57);
        imageViewAJ.setOnMouseClicked(new ActionAccueilJoueur(this));
        ///
        hbHaut.getChildren().addAll(creerPartie, consultScenar, consultStats, imageViewAJ);


        // Labels
        Label nbPartieJoue = new Label("Nombre de parties jouées : ");
        this.resPartieJoue = new Label("0");
        try {
            this.resPartieJoue.setText(""+this.informationJDBC.partieJoue(this.utilisateurJDBC.getUti().getPseudoUtilisateur()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Label nbPartieWin = new Label("Nombre de parties gagnées : ");

        this.resPartieWin = new Label("0");

        try {
            this.resPartieWin.setText(""+this.informationJDBC.partieGagne(this.utilisateurJDBC.getUti().getPseudoUtilisateur()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Label meilleurTps = new Label("Meilleur temps réalisé : ");
        this.resMeilleurTps = new Label("0");
        try {
            this.resMeilleurTps.setText(""+this.informationJDBC.bestTps(this.utilisateurJDBC.getUti().getPseudoUtilisateur()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Label scenarMoins10 = new Label("Nombre de scénatios réalisés en moins de 10 minutes : ");
        this.resScenaMoins10 = new Label("0");
        try {
            this.resScenaMoins10.setText(""+this.informationJDBC.nbTpsInfDix(this.utilisateurJDBC.getUti().getPseudoUtilisateur()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        vb.getChildren().addAll(nbPartieJoue, this.resPartieJoue,nbPartieWin,this.resPartieWin, meilleurTps,this.resMeilleurTps, scenarMoins10,this.resScenaMoins10);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(50);
        vb.setStyle("-fx-font-weight: bold;");


        bp.setTop(hbHaut);
        bp.setCenter(vb);
        return bp;
    }
    public Pane AcceuilAdmin(){
        BorderPane root = new BorderPane();
        VBox centre = new VBox();
        HBox haut = new HBox();
        HBox bas = new HBox();

        Image img = null;
        Blob blob = this.utilisateurJDBC.getUti().getAvatarUtilisateur();
        InputStream is = null;
        try {
            img = new Image(new FileInputStream("src/Images/profile.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ;
        try {
            if(blob!=null){
                is = blob.getBinaryStream();
                img = new Image(is);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        this.imageViewAJ = new ImageView(img);
        imageViewAJ.setFitHeight(70);
        imageViewAJ.setFitWidth(55);
        imageViewAJ.setOnMouseClicked(new ActionAcceuilAdmin(this));


        haut.setPadding(new Insets(50, 100, 100, 100));

        Button ConsStat = new Button("Consulter statistiques");
        Button GerUtil = new Button("Gérer utilisateur");
        ConsStat.setOnAction(new ActionGestionAdmin(this, "consStat"));
        GerUtil.setOnAction(new ActionEditAdmin(this,"gerUtil"));
        haut.getChildren().add(imageViewAJ);
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

        return root;
    }
    public Pane editAdmin() {
        //Création des containers
        BorderPane bp = new BorderPane();

        VBox vb = new VBox();
        GridPane gp = new GridPane();
        HBox hbBas = new HBox();

        Image img = null;
        Blob blob = this.utilisateurJDBC.getUti().getAvatarUtilisateur();
        InputStream is = null;
        try {
            img = new Image(new FileInputStream("src/Images/profile.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ;
        try {
            if(blob!=null){
                is = blob.getBinaryStream();
                img = new Image(is);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        this.imageViewPJ = new ImageView(img);
        imageViewAJ.setFitHeight(70);
        imageViewAJ.setFitWidth(55);


        vb.getChildren().add(imageViewPJ);
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(50, 0, 0, 0));

        //Création des labels et fields
        Label pseudo = new Label("Pseudo :");
        Label mail = new Label("Adresse mail :");
        Label mdp = new Label("Mot de passe :");

        Label pseudoField =  new Label(this.utilisateurJDBC.getUti().getPseudoUtilisateur());
        Label mailField = new Label(this.utilisateurJDBC.getUti().getMailUtilisateur());
        PasswordField mdpField = new PasswordField();

        //Ajout des labels et fiels dans le gridpane
        gp.add(pseudo, 1, 1);
        gp.add(mail, 1, 2);
        gp.add(mdp, 1, 3);

        gp.add(pseudoField, 2, 1);
        gp.add(mailField, 2, 2);
        gp.add(mdpField, 2, 3);

        gp.setAlignment(Pos.CENTER);
        gp.setVgap(30);
        gp.setHgap(30);
        gp.setPadding(new Insets(0, 0, 50, 0));

        //Ajout des boutons dans le Hbox
        FileInputStream input2 = null;
        try {
            input2 = new FileInputStream("src/Images/retour.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image i2 = new Image(input2);
        ImageView imgRetour = new ImageView(i2);
        imgRetour.setFitHeight(50);
        imgRetour.setFitWidth(50);
        imgRetour.setPreserveRatio(true);
        Button retour = new Button( "", imgRetour);
        retour.setPrefHeight(50);
        retour.setOnAction(new ActionEditAdmin(this, "retour"));

        Button deco = new Button("Déconnexion");
        deco.setStyle("-fx-font-family: \"Liberation Serif\"; -fx-font-size: 18px; -fx-background-color: #ff7979;");
        deco.setOnAction(new ActionEditAdmin(this, "Déconnexion"));
        deco.setPrefHeight(50);

        hbBas.getChildren().addAll(retour, deco);
        hbBas.setSpacing(514);
        hbBas.setAlignment(Pos.BOTTOM_CENTER);
        // Ajout des containers dans le borderpane
        bp.setTop(vb);
        bp.setCenter(gp);
        bp.setBottom(hbBas);
        return bp;
    }
    public Pane creerPartie(){
        BorderPane bp = new BorderPane();
        HBox haut = new HBox();
        //Bas
        HBox hbBas = new HBox();
        Button lancerPartie = new Button("Lancer la partie");
        hbBas.getChildren().add(lancerPartie);
        hbBas.setAlignment(Pos.CENTER);
        lancerPartie.setOnAction(new ActionLancerPartie(this, this.creationPartieJDBC));

        // Images
        FileInputStream input = null;
        try {
            input = new FileInputStream("src/Images/loupe.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image i = new Image(input);
        ImageView imgLoupe = new ImageView(i);
        imgLoupe.setFitHeight(25);
        imgLoupe.setFitWidth(25);
        imgLoupe.setPreserveRatio(true);
        System.out.println(creationPartieJDBC);
        imgLoupe.setOnMouseClicked(new ActionLoupe(this, this.creationPartieJDBC));
        Image img = null;
        Blob blob = this.utilisateurJDBC.getUti().getAvatarUtilisateur();

        InputStream is = null;
        try {
            img = new Image(new FileInputStream("src/Images/IMAGESbd/1.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ;
        try {
            if(blob!=null){
                is = blob.getBinaryStream();
                img = new Image(is);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        this.imageViewAJ = new ImageView(img);
        imageViewAJ.setFitHeight(57);
        imageViewAJ.setFitWidth(57);
        imageViewAJ.setOnMouseClicked(new ActionAccueilJoueur(this));

        // Gérer la table
        Label titre = new Label("Choisir un scénario");
        titre.setFont(new Font("Arial", 20));

        Label nomS = new Label("Nom");
        Label dureeMax = new Label("Durée");
        Label date = new Label("Date mise en ligne");
        this.tfCrea= new TextField();


        HBox hbHaut = new HBox();
        hbHaut.getChildren().addAll(nomS, dureeMax, date);
        hbHaut.setAlignment(Pos.CENTER);
        hbHaut.setSpacing(50);
        nomS.setFont(new Font("Arial", 15));
        dureeMax.setFont(new Font("Arial", 15));
        date.setFont(new Font("Arial", 15));

        this.vbNom = new Label("Aucune information");
        this.vbDuree = new Label("Aucune information");
        this.vbDate = new Label("Aucune information");

        HBox hbMid = new HBox();
        hbMid.getChildren().addAll(vbNom, vbDuree, vbDate);
        hbMid.setSpacing(10);
        hbMid.setAlignment(Pos.CENTER);

        HBox hb = new HBox();
        hb.getChildren().addAll(imgLoupe, this.tfCrea);
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(10);

        VBox vb = new VBox();
        vb.setSpacing(50);
        vb.setPadding(new Insets(10));
        vb.getChildren().addAll(titre, hbHaut, hbMid, hb);
        vb.setAlignment(Pos.CENTER);



        // BorderPane
        bp.setCenter(vb);
        bp.setTop(haut);
        bp.setBottom(hbBas);

        // Haut
        Button bPartie = new Button("Créer partie");
        Button bDernierSc = new Button("Consulter derniers\n scénarios");
        Button bConsultStats = new Button("Consulter\n statistiques");

        bPartie.setOnAction( new ActionBoutonJoueur(this,"creer"));
        bDernierSc.setOnAction( new ActionBoutonJoueur(this,"consulterDer"));
        bConsultStats.setOnAction( new ActionBoutonJoueur(this,"consulterStat"));
        haut.getChildren().addAll(bPartie, bDernierSc, bConsultStats, imageViewAJ);

        bPartie.setPrefWidth(210);
        bDernierSc.setPrefWidth(210);
        bConsultStats.setPrefWidth(210);

        bPartie.setPrefHeight(57);
        bDernierSc.setPrefHeight(57);
        bConsultStats.setPrefHeight(57);

        bPartie.setStyle("-fx-font-family: \"Liberation Serif\"; -fx-font-size: 18px; -fx-background-color: #ff7979;");
        bDernierSc.setStyle("-fx-font-family: \"Liberation Serif\"; -fx-font-size: 18px; -fx-background-color: #5ffff0;");
        bConsultStats.setStyle("-fx-font-family: \"Liberation Serif\"; -fx-font-size: 18px; -fx-background-color: #5fff6d;");

        DropShadow ds = new DropShadow();
        ds.setRadius(5.0);
        ds.setOffsetX(3.0);
        ds.setOffsetY(3.0);
        ds.setColor(Color.color(0.4, 0.5, 0.5));

        bPartie.setEffect(ds);
        bDernierSc.setEffect(ds);
        bConsultStats.setEffect(ds);



        return bp;
    }

    public Pane GestionStats(){

        FileInputStream input = null;
        FileInputStream input2 = null;
        try {
            input = new FileInputStream("src/Images/retour.png");
            input2 = new FileInputStream("src/Images/profile.png");
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
        nbSenCree.setOnAction(new ActionBoutonGestionStatsAdmin(this, "nbSc"));

        Button nbPartieCours = new Button("Nombre de parties en cours");
        nbPartieCours.setOnAction(new ActionBoutonGestionStatsAdmin(this, "nbPart"));
        Button nbPersonnesInscr = new Button("Nombre de personnes inscrites");
        nbPersonnesInscr.setOnAction(new ActionBoutonGestionStatsAdmin(this, "nbPers"));
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
        root.setStyle("-fx-background-color:#a19c9c");




        return root;
    }

    public Pane nbParties() {
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
        return v1;

    }


    public Pane nbPersonnes() {
        VBox v1 = new VBox();
        Label lHaut = new Label("Gestion des statistiques");
        Label l1 = new Label("Nombre de personnes inscrites  :  ");
        this.l2 = new Label("nb");
        try {
            l2.setText(""+this.gestionStatsAdminJDBC.nbPersonnesInscrites());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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

        return v1;
    }



    public Pane nbScenario() {
        VBox v1 = new VBox();
        Label lHaut = new Label("Gestion des statistiques");
        Label l1 = new Label("Nombre de scénario céés  :  ");
        this.l3 = new Label("nb");
        try {
            this.l3.setText(""+this.gestionStatsAdminJDBC.nbScenarioCreer());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        v1.getChildren().addAll(lHaut, l1, l3);
        v1.setAlignment(Pos.CENTER);
        v1.setSpacing(50);

        DropShadow dsh = new DropShadow();
        dsh.setRadius(5.0);
        dsh.setOffsetX(3.0);
        dsh.setOffsetY(3.0);
        dsh.setColor(Color.color(0.4,0.5,0.5));
        l1.setEffect(dsh);
        l3.setEffect(dsh);
        lHaut.setEffect(dsh);
        lHaut.setStyle("-fx-font-family: Courier; -fx-font-size: 20px; -fx-font-weight: bold");
        l1.setStyle("-fx-font-family: Courier; -fx-font-size: 20px; -fx-font-weight: bold");
        l3.setStyle("-fx-font-family: Courier; -fx-font-size: 45px; -fx-font-weight: bold");

        return v1;}
    ///////////////
    public void changeVue(Pane panel){
        primaryStage.getScene().setRoot(panel);
    }
    public void updateScena(){
        this.vbNom.setText(this.scenario.getTitreScenario());
        this.vbDate.setText(this.scenario.getDateMiseEnLigne().toString());
        this.vbDuree.setText(this.scenario.getTempsMaxScenario().toString());
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }
}
