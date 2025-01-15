import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import javax.swing.plaf.ActionMapUIResource;
import javax.swing.text.LabelView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class VueEchapee extends BorderPane {
    private Image image; // image servant de support au taquin
    private ModeleEchapee echapee; // modèle du jeu de taquin
    private double largeurTuile; // largeur en nombre de pixels d'une tuile du taquin
    private double hauteurTuile; // hauteur en nombre de pixels d'une tuile du taquin
    private double tailleMax; // taille maximum autorisée pour l'affichage du taquin
    private Vector<Tuile> lesTuiles; // vecteur contenant les tuile du taquin
    private Label lNbMouvements; // label permettant d'indiquer le nombre de mouvements effectués
    private GridPane gp;
    private TextField reponse;

    /**
     * Constructeur de la vue du taquin.
     * @param taquin modèle du taquin
     * @param img image servant de support au taquin
     * @param tailleMax la taille maximum autorisée pour une dimension (hauteur ou largeur) de l'image du taquin
     */
    public VueEchapee(ModeleEchapee echapee, Image img, double tailleMax, int posx, int posy) {
        super();
        this.echapee = echapee;
        this.image = img;
        this.tailleMax = tailleMax;
        this.hauteurTuile = this.image.getHeight()/this.echapee.getHauteur();
        this.largeurTuile = this.image.getWidth()/this.echapee.getLargeur();
//        this.hauteurTuile = 32;
//        this.largeurTuile = 32;


        this.lesTuiles = new Vector<Tuile>(this.echapee.getHauteur()*this.echapee.getLargeur());
//        this.lesTuiles = new Vector<Tuile>((echapee.getHauteur()/32)*(echapee.getLargeur()/32));
        gp = new GridPane();
//        Tuile tuileJ = new Tuile(this.largeurTuile, this.hauteurTuile, 1,
//                echapee.getLigneCible(0, 0), echapee.getColonneCible(0, 0), image);
//        tuileJ.avatar.toFront();
//        gp.add(tuileJ, 0, 0);

        Random randomizer = new Random();
        List<Integer> lEnigme = new ArrayList<>();
        int k = 0;
        while (k<3){
            int y = randomizer.nextInt(this.echapee.getHauteur()-2)+1;
            int x = randomizer.nextInt(this.echapee.getLargeur()-2)+1;
            int indice = y*this.echapee.getHauteur()+x;
            if(!lEnigme.contains(indice)){
                lEnigme.add(indice);
                k += 1;
            }
        }


        for(int i = 0; i<this.echapee.getHauteur(); i++){
            for(int j=0; j<this.echapee.getLargeur(); j++){
                int index = echapee.getEchapee().get(i * echapee.getHauteur() + j);
                int posix = index / echapee.getHauteur();
                int posiy = index % echapee.getHauteur();
                boolean isEnigme = false;
                if(lEnigme.contains(i*this.echapee.getHauteur()+j)){
                    isEnigme = true;
                }
                Tuile tuile = new Tuile(this.largeurTuile, this.hauteurTuile, 1,
                        posix, posiy, image, isEnigme);
//                tuile.setOnKeyPressed(new ControlleurJoueur(this.echapee, this, i , j));
                if(i == posx && j == posy){
                    tuile.placerJoueur();
//                    tuile.avatar.toFront();
                }
                lesTuiles.add(tuile);
                gp.add(tuile, j, i);
            }
        }

//        this.getChildren().addAll(gp);
        this.setCenter(gp);
        this.lNbMouvements = new Label();
    }

    public void Enigme(){
        BorderPane bp = new BorderPane();


        HBox hb = new HBox();
        Button valider = new Button("Valider");
        valider.setOnAction(new ActionRépondreEnigme(this.echapee, this));

        Button retour = new Button("Retour");
        retour.setOnAction(new ActionRépondreEnigme(this.echapee, this));

        hb.getChildren().add(retour);
        hb.getChildren().add(valider);
        hb.setAlignment(Pos.CENTER);


        VBox vb = new VBox();
        Image enigme = new Image("file:src/Images/IMAGESbd/Enigme_excalibur.jpg");
        ImageView excalibur = new ImageView(enigme);

        Label question = new Label("Question: Pour sortir de cette forêt maléfique il faut nommer le propriétaire de cette épée!\\nLes lettres de se prénom se trouve dans un département de l''IUT''O!");


        Label lReponse = new Label("Entrez votre réponse ici:");
        reponse = new TextField();

        vb.getChildren().add(question);
        vb.getChildren().add(excalibur);

        vb.getChildren().add(lReponse);
        vb.getChildren().add(reponse);
        vb.setSpacing(15);
        vb.setAlignment(Pos.CENTER);

        vb.getChildren().addAll(hb);


        this.setCenter(vb);




    }

    public void setMap(){
        this.setCenter(gp);
    }

    public void deplacerDroite(int posx, int posy){

    }

    public TextField getReponse() {
        return reponse;
    }

    /**
     * active ou désactive les tuiles du taquin
     * @param actif booléen indiquant l'état d'activité à mettre au taquin
     */
    void activer(boolean actif){
        for(Tuile t: this.lesTuiles){
            t.activer(actif);
        }
    }

    /**
     * met à jour la vue du taquin en fonction du modèle
     */
    void update(){
        lesTuiles.get(this.echapee.getPosx()*this.echapee.getHauteur()+ this.echapee.getPosy()).placerJoueur();

//        for(int i =0; i<this.echapee.getHauteur(); i++){
//            for(int j = 0;  j<this.echapee.getHauteur(); i++){
//
//            }
//        }
    }

    void enleverJoueur(){
        lesTuiles.get(this.echapee.getPosx()*this.echapee.getHauteur()+ this.echapee.getPosy()).retirerJoueur();
    }

    public Image getImage(){
        return this.image;
    }

    public double getTMax(){
        return this.tailleMax;
    }

    public boolean aEnigme(){
        return this.lesTuiles.get(this.echapee.getPosx()*this.echapee.getHauteur()+ this.echapee.getPosy()).isPossedeEnigme();
    }

    public void retirerEnigme(){
        this.lesTuiles.get(this.echapee.getPosx()*this.echapee.getHauteur()+ this.echapee.getPosy()).setEtatEnigme(false);
    }


}
