import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ActionBouton implements EventHandler<ActionEvent> {
    private Echapee_belle_vue echa;

    public ActionBouton(Echapee_belle_vue echa){this.echa = echa;}

    @Override
    public void handle(ActionEvent e) {
        Button b = (Button) e.getTarget();
        if(b.getId().equals("Constat")){
            System.out.println("Consulter statistiques");

        }
        if(b.getId().equals("GerUtil")){
            System.out.println("Gerer utilisateur");

        }


    }
}
