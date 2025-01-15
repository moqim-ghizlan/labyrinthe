import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ActionEditAdmin implements EventHandler<ActionEvent>{

    private Echapee_belle_vue echa;
    private String action;

    public ActionEditAdmin(Echapee_belle_vue echa, String action){
        this.echa = echa;
        this.action = action;
    }

    @Override
    public void handle(ActionEvent e) {
        Button b = (Button) e.getTarget();
        System.out.print(action);
        if (action.equals("retour")){
            this.echa.changeVue(this.echa.AcceuilAdmin());
        }
        else{
            this.echa.changeVue(this.echa.Bienvenue());
        }
    }
}
