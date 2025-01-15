import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.Optional;


public class ActionRépondreEnigme implements EventHandler<ActionEvent> {
    private ModeleEchapee modelEchapee; // modèle du jeu de de l'échapée
    private VueEchapee vueEchapee; // vue du jeu de l'échapée
    private int lig, col; // ligne et colonne où se situe la tuile dans la vue

    /**
     * constructeur
     *
     * @param modelTaquin modèle du jeu de taquin
     * @param vueTaquin   vue du jeu de taquin
     * @param lig         ligne où se situe la tuile dans la vue
     * @param col         colonne où se situe la tuile dans la vue
     */
    public ActionRépondreEnigme(ModeleEchapee modelEchapee, VueEchapee vueJeu) {
        this.modelEchapee = modelEchapee;
        this.vueEchapee = vueJeu;


    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getTarget();
        if(button.getText().equals("Valider")){
            if(this.vueEchapee.getReponse().getText().equals("QUENTIN")){
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Bonne réponse");
                Optional<ButtonType> result = alert.showAndWait();
                this.vueEchapee.setMap();

                this.vueEchapee.retirerEnigme();
            }
        }
        else if(button.getText().equals("Retour")){
            this.vueEchapee.setMap();
        }
    }
}
