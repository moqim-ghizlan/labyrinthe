import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.sql.SQLException;

public class ActionLancerPartie implements EventHandler<ActionEvent> {
    private Echapee_belle_vue echa;
    private String action;

    public ActionLancerPartie(Echapee_belle_vue echa, String action) {
        this.echa = echa;
        this.action = action;
    }

    public void handle(ActionEvent e) {
        Button b = (Button) e.getTarget();
        System.out.print(action);
        if (action.equals("Lancer partie")) {
            try {
                this.echa.changeVue(this.echa.JeuEchappe());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}