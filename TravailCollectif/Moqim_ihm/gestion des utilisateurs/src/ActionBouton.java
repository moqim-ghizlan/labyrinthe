import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class ActionBouton implements EventHandler<ActionEvent> {
    private GestionDesUtils appi;

    public ActionBouton(GestionDesUtils appi){this.appi = appi;}

    @Override
    public void handle(ActionEvent e) {
        Button b = (Button) e.getTarget();
        Label labelStatus = (Label) appi.getLabelStatus();
        Label labelPseudo = (Label) appi.getLabelPseudo();
        Label labelMail = (Label) appi.getLabelMail();
        Label labelGate = (Label) appi.getLabelGate();



        if(b.getId().equals("modifierProdile")){
            System.out.println("modifer son profile");

        }
        if(b.getId().equals("arrier")){
            System.out.println("aller en arrier");


        }
        if(b.getId().equals("recherche")){
            System.out.println("recherche : "+this.appi.getRechercherEntee().getText());
            this.appi.getLabelStatus().setText(this.appi.getRechercherEntee().getText());
            this.appi.getLabelPseudo().setText(this.appi.getRechercherEntee().getText());
            this.appi.getLabelMail().setText(this.appi.getRechercherEntee().getText());
            this.appi.getLabelGate().setText(this.appi.getRechercherEntee().getText());
        }
    }
}
