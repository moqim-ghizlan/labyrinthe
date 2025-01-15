import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.sql.SQLException;

public class ActionLancerPartie implements EventHandler<ActionEvent> {
    private Echapee_belle_vue echa;
    private CreationPartieJDBC creationPartieJDBC;
    public ActionLancerPartie(Echapee_belle_vue echa,CreationPartieJDBC creationPartieJDBC) {
        this.echa = echa;
        this.creationPartieJDBC = creationPartieJDBC;
    }

    public void handle(ActionEvent e) {
        Button b = (Button) e.getTarget();
        try {
            if(this.creationPartieJDBC.etat(this.echa.getTfCrea().getText())){
                this.echa.changeVue(this.echa.JeuEchappe());
            }
            else{
                Alert al =new Alert(Alert.AlertType.ERROR);
                al.setTitle("Problème lancement de la partie");
                al.setHeaderText("Le scénario n'existe pas");
                al.setContentText("Vous devez choisir un autre scénario pour lancer la partie");
                al.showAndWait();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
