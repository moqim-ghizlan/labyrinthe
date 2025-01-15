import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.awt.*;

public class ActionBouton implements EventHandler<ActionEvent> {
    private VueConnexion connexion;

    public ActionBouton(VueConnexion connexion){this.connexion = connexion;}

    @Override
    public void handle(ActionEvent ae) {
        String nomOk = "";
        String mdpOk = "";
        Button b = new Button();
        try{
            nomOk = connexion.getTId().getText();
        } catch (Exception e){
            if (nomOk == null || mdpOk == null)
                System.out.println("Erreur, le nom ou le mdp ne contient rien");
        }
    }
}
