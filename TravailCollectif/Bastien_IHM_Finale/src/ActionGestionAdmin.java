import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ActionGestionAdmin implements EventHandler<ActionEvent>{
    private Echapee_belle_vue echa;
    private String action;
    public ActionGestionAdmin(Echapee_belle_vue echa, String action) {
        this.echa=echa;
        this.action=action;
    }

    @Override
    public void handle(ActionEvent e) {
        Button b = (Button) e.getTarget();
        if(action.equals("consStat")){
            this.echa.changeVue(this.echa.GestionStats());
        }
        else{

        }
    }
}
