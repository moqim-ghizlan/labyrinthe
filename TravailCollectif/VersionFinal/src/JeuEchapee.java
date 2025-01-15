
import javafx.application.Application;
//import javafx.event.EventHandler;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.image.Image;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.layout.*;
//import javafx.stage.Stage;
//
//import java.sql.SQLException;
//import java.util.Arrays;
//import java.util.List;
//
//
//
//public class JeuEchapee extends Application {
//    CarteJDBC cartejdbc;
//    ConnexionMySQL connexionMySQL;
//
//    Stage st;
//    VueEchapee vueEchap;
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//
//
//
//    public CarteJDBC getCartejdbc() {
//        return cartejdbc;
//    }
//
//
//    @Override
//    public void start(Stage stage) throws Exception{
//
//        this.connexionMySQL = new ConnexionMySQL();
//        this.connexionMySQL.connecter("servinfo-mariadb","DBbmeunier","bmeunier","bmeunier");
//        this.cartejdbc = new CarteJDBC(connexionMySQL);
//
//
//
//        echapee=new ModeleEchapee(10,10,this.getCartejdbc().rechercherPlan(2), 5, 4);
//
//
//        st=stage;
//        Image img=new Image("file:src/Images/IMAGESbd/Tileset.png");
//
//
//        stage.setTitle("Jeu du taquin");
//        stage.setWidth(700);
//        stage.setHeight(700);
//        //Le truc pour pas qu'on reduise la fenêtre
//        //st.setResizable(false);
//
//        boolean actif=true; // mettre actif à false pour tester la méthode activer()
////        setSceneTuile( img.getWidth()/3,img.getHeight()/3,1,1,0,actif, img);
//        vueEchap =new VueEchapee(echapee,img,400, 5, 4);//LA YA EU DU CHANGEMENT
//        st.setScene(new Scene(vueEchap));
//        ControlleurJoueur controlJ = new ControlleurJoueur(echapee, vueEchap);
//        st.getScene().setOnKeyPressed(controlJ);
//
//
//        stage.show();
//
//    }
//}