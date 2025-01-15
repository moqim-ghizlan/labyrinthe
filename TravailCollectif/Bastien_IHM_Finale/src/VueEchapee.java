import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.util.Vector;

public class VueEchapee extends VBox {
    private Image image; // image servant de support au taquin
    private ModeleEchapee echapee; // modèle du jeu de taquin
    private double largeurTuile; // largeur en nombre de pixels d'une tuile du taquin
    private double hauteurTuile; // hauteur en nombre de pixels d'une tuile du taquin
    private double tailleMax; // taille maximum autorisée pour l'affichage du taquin
    private Vector<Tuile> lesTuiles; // vecteur contenant les tuile du taquin
    private Label lNbMouvements; // label permettant d'indiquer le nombre de mouvements effectués

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
        GridPane gp = new GridPane();
//        Tuile tuileJ = new Tuile(this.largeurTuile, this.hauteurTuile, 1,
//                echapee.getLigneCible(0, 0), echapee.getColonneCible(0, 0), image);
//        tuileJ.avatar.toFront();
//        gp.add(tuileJ, 0, 0);
        for(int i = 0; i<this.echapee.getHauteur(); i++){
            for(int j=0; j<this.echapee.getLargeur(); j++){
                int index = echapee.getEchapee().get(i * echapee.getHauteur() + j);
                int posix = index / echapee.getHauteur();
                int posiy = index % echapee.getHauteur();
                Tuile tuile = new Tuile(this.largeurTuile, this.hauteurTuile, 1,
                        posix, posiy, image);
//                tuile.setOnKeyPressed(new ControlleurJoueur(this.echapee, this, i , j));
                if(i == posx && j == posy){
                    tuile.placerJoueur();
//                    tuile.avatar.toFront();
                }
                lesTuiles.add(tuile);
                gp.add(tuile, j, i);
            }
        }

        this.getChildren().addAll(gp);
        this.lNbMouvements = new Label();
    }

    public void deplacerDroite(int posx, int posy){

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

}
