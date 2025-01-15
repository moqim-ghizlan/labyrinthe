import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.sql.SQLException;

public class ActionConnexion implements EventHandler<ActionEvent> {
    private Echapee_belle_vue echa;
    private String action;
    public ActionConnexion(Echapee_belle_vue echa, String action) {
        this.echa = echa;
        this.action = action;
    }
    @Override
    public void handle(ActionEvent e) {
        Button b = (Button) e.getTarget();
        String valeur1 = this.echa.getTId().getText();
        String valeur2 = this.echa.getMdp().getText();
        if (action.equals("retourAccueille")) {
            this.echa.changeVue(this.echa.Bienvenue());
        }
        else{
            try {
                if(this.echa.getUtilisateurJDBC().testerConnexion(valeur1,valeur2)){
                    if(this.echa.getUtilisateurJDBC().getUti().getRoleUtilisateur() == 2){
                        this.echa.changeVue(this.echa.AccueilJoueur());
                    }
                    else if(this.echa.getUtilisateurJDBC().getUti().getRoleUtilisateur() == 1){
                        //this.echa.changeVue();
                    }
                }
                else{
                    Alert al =new Alert(Alert.AlertType.ERROR);
                    al.setTitle("Problème de connexion");
                    al.setHeaderText("Identifiant ou mot de passe incorrect");
                    al.setContentText("Changer l'adresse mail ou le mot de passe");
                    al.showAndWait();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
