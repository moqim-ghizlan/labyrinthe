import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ActionBoutonJoueur implements EventHandler<ActionEvent>{
    private Echapee_belle_vue echa;
    private String action;
    public ActionBoutonJoueur(Echapee_belle_vue echa, String action) {
        this.echa=echa;
        this.action=action;
    }

    @Override
    public void handle(ActionEvent e) {
        Button b = (Button) e.getTarget();
        if(action.equals("creer")){
            this.echa.changeVue(this.echa.creerPartie());
        }
        else if (action.equals("consulterDer")){

        }
        else{
            this.echa.changeVue(this.echa.statistiques());
        }
    }
}
