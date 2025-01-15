/**import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TestJDBC extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private LoginBD loginBD;
    private FicheJoueur ficheJoueur;
    private JoueurBD joueurBD;
    private ConnexionMySQL connexionMySQL;
    private Scene scene;
    private MenuApplication menuApplication;
    private Label message;
    private FicheResultat ficheResultat;

    public void init(){
        try {
            this.connexionMySQL = new ConnexionMySQL();
        }catch (ClassNotFoundException ex){
            System.out.println("Driver MySQL non trouvé!!!");
            System.exit(1);
        }
        this.loginBD = new LoginBD(this);
        this.ficheJoueur = new FicheJoueur(this);
        this.ficheResultat = new FicheResultat(this);
        this.joueurBD = new JoueurBD(this.connexionMySQL);
        this.message = new Label("Vous n'êtes pas connecté");
        this.message.setFont(Font.font(24));
        this.message.setAlignment(Pos.CENTER);
    }
    @Override
    public void start(Stage primaryStage) {
        VBox fp = new VBox(5);
        fp.setAlignment(Pos.TOP_CENTER);
        this.menuApplication = new MenuApplication(this);
        fp.getChildren().addAll(this.menuApplication,message);
        this.scene = new Scene(fp,500,500);
        primaryStage.setScene(this.scene);
        primaryStage.setTitle("L'échappée Belle");
        primaryStage.show();
    }

    public LoginBD getLoginBD() {
        return this.loginBD;
    }

    public void connexionReussie(){
        this.message.setText("Vous êtes connecté");
        VBox fp=((VBox)scene.getRoot());
        fp.getChildren().remove(1);
        fp.getChildren().addAll(this.message);
        this.menuApplication.connecter();
    }

    public void deconnexionReussie(){
        this.message.setText("Vous êtes déconnecté");
        VBox fp=((VBox)scene.getRoot());
        fp.getChildren().remove(1);
        fp.getChildren().addAll(this.message);
        this.menuApplication.deconnecter();
    }
    public void showFenetreConnexion(){
        VBox fp=((VBox)scene.getRoot());
        fp.getChildren().remove(1);
        fp.getChildren().addAll(this.loginBD);
    }
    public void showFicheJoueur(){
        VBox fp=((VBox)scene.getRoot());
        fp.getChildren().remove(1);
        fp.getChildren().addAll(this.ficheJoueur);
    }
    public void showFicheResultat(String resultat){
        this.ficheResultat.setTexte(resultat);
        VBox fp=((VBox)scene.getRoot());
        fp.getChildren().remove(1);
        fp.getChildren().addAll(this.ficheResultat);
    }
    public void setMessage(String message){
        this.message.setText(message);
         VBox fp=((VBox)scene.getRoot());
        fp.getChildren().remove(1);
        fp.getChildren().addAll(this.message);
    }

    public ConnexionMySQL getConnexionMySQL() {
        return this.connexionMySQL;
    }

    public JoueurBD getJoueurBD() {
        return this.joueurBD;
    }

    public FicheJoueur getFicheJoueur() {
        return this.ficheJoueur;
    }
}
**/