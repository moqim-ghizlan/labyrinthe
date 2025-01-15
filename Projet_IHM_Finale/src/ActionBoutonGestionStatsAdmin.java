import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ActionBoutonGestionStatsAdmin implements EventHandler<ActionEvent>{
    private Echapee_belle_vue echa;
    private String action;
    public ActionBoutonGestionStatsAdmin(Echapee_belle_vue echa, String action) {
        this.echa=echa;
        this.action=action;
    }

    @Override
    public void handle(ActionEvent e) {
        Button b = (Button) e.getTarget();
        if(action.equals("nbSc")){
            this.echa.changeVue(this.echa.nbScenario());
        }
        else if (action.equals("nbPart")){
            this.echa.changeVue(this.echa.nbParties());
        }
        else{
            this.echa.changeVue(this.echa.nbPersonnes());
        }
    }
}
