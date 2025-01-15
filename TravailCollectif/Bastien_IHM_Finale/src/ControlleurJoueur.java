import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class ControlleurJoueur implements EventHandler<KeyEvent> {
    private ModeleEchapee modelEchapee; // modèle du jeu de de l'échapée
    private VueEchapee vueEchapee; // vue du jeu de l'échapée
    private int lig,col; // ligne et colonne où se situe la tuile dans la vue

    /**
     * constructeur
     * @param modelTaquin modèle du jeu de taquin
     * @param vueTaquin vue du jeu de taquin
     * @param lig ligne où se situe la tuile dans la vue
     * @param col colonne où se situe la tuile dans la vue
     */
    public ControlleurJoueur(ModeleEchapee modelEchapee, VueEchapee vueJeu) {
        this.modelEchapee = modelEchapee;
        this.vueEchapee = vueJeu;

    }
    @Override

    public void handle(KeyEvent keyEvent) {
        vueEchapee.enleverJoueur();
        if(keyEvent.getCode() == KeyCode.RIGHT){
            this.modelEchapee.deplacerDroite();

            System.out.println("Déplacement à droite");
        }
        if(keyEvent.getCode() == KeyCode.LEFT){
            this.modelEchapee.deplacerGauche();
            System.out.println("Déplacement à gauche");
        }
        if(keyEvent.getCode() == KeyCode.UP){
            this.modelEchapee.deplacerHaut();
            System.out.println("Déplacement en haut");
        }
        if(keyEvent.getCode() == KeyCode.DOWN){
            this.modelEchapee.deplacerBas();
            System.out.println("Déplacement en bas");
        }


//        this.modelEchapee.decale(lig, col , 1);
        vueEchapee.update();
//        System.out.println(this.modelTaquin.decale(lig, col , 1));
    }


}
