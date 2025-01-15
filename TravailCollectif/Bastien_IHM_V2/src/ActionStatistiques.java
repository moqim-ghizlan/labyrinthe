import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ActionStatistiques implements EventHandler<ActionEvent>{

    private Echapee_belle_vue echa;
    private String action;

    public ActionStatistiques(Echapee_belle_vue echa, String action){
        this.echa = echa;
        this.action = action;
    }

    @Override
    public void handle(ActionEvent e) {
        Button b = (Button) e.getTarget();
        if (action.equals("Avatar")){
            this.echa.changeVue(this.echa.editJoueur());
        }
        else{

        }
    }
}
