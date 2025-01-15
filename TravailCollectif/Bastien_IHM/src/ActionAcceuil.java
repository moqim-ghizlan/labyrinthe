import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ActionAcceuil implements EventHandler<ActionEvent> {
    private Echapee_belle_vue echa;
    private String action;
    public ActionAcceuil(Echapee_belle_vue echa, String action) {
        this.echa = echa;
        this.action = action;
    }
    @Override
    public void handle(ActionEvent e) {
        Button b = (Button) e.getTarget();
        if (action.equals("Connecter")) {
            this.echa.changeVue(this.echa.creerConnexion());
        }
        else{
            this.echa.changeVue(this.echa.inscription());
        }
    }
}