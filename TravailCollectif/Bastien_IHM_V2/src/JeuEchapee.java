
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;


public class JeuEchapee extends Application {
    ModeleEchapee echapee;
    Stage st;
    VueEchapee vueEchap;

    public static void main(String[] args) {
        launch(args);
    }

    void setSceneTuile(double largeur,double hauteur,double ratio, int lig, int col, boolean actif, Image image){
        Tuile tuile=new Tuile(largeur,hauteur,ratio,lig,col,image);
        tuile.activer(actif);
        FlowPane fp=new FlowPane(tuile);
        fp.setAlignment(Pos.CENTER);
        st.setScene(new Scene(fp));
    }
    void setSceneTaquin(Image img){
        VueEchapee vue=new VueEchapee(echapee,img,400, 5, 4);//LA YA EU DU CHANGEMENT
        st.setScene(new Scene(vue));

    }

    @Override
    public void init() {
        List<List<Integer>> liste = Arrays.asList(Arrays.asList(7, 3, 3, 3, 3, 3, 3, 3, 3, 8),Arrays.asList(19, 26, 40, 41, 24, 13, 13, 23, 24, 19),
                Arrays.asList(19, 36, 50, 51, 34, 2, 2, 2, 34, 19), Arrays.asList(19, 2, 2, 2, 2, 2, 2, 2, 25, 19), Arrays.asList(19, 57, 58, 44, 45, 46, 2, 2, 35, 19),
                Arrays.asList(27, 3, 6, 54, 55, 56, 5, 3, 3, 38), Arrays.asList(19, 60, 13, 16, 47, 48, 15, 13, 61, 19),
                Arrays.asList(19, 70, 1, 33, 1, 1, 1, 1, 71, 19), Arrays.asList(19, 1, 1, 1, 1, 1, 1, 1, 49, 19), Arrays.asList(17, 9, 9, 9, 9, 9, 9, 9, 9, 18));
        echapee=new ModeleEchapee(10,10,liste);
    }
    @Override
    public void start(Stage stage) {
        ControlleurJoueur controlJ = new ControlleurJoueur(echapee, vueEchap);
        st=stage;
        Image img=new Image("file:src/Images/IMAGESbd/tilesMaison.png");
//        BackgroundImage bgImage = new BackgroundImage(img, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
//                BackgroundSize.DEFAULT);

        stage.setTitle("Jeu du taquin");
        stage.setWidth(700);
        stage.setHeight(700);
        //Le truc pour pas qu'on reduise la fenêtre
        //st.setResizable(false);

        boolean actif=true; // mettre actif à false pour tester la méthode activer()
//        setSceneTuile( img.getWidth()/3,img.getHeight()/3,1,1,0,actif, img);
        setSceneTaquin(img);
        st.getScene().setOnKeyPressed(controlJ);


        stage.show();

    }
}