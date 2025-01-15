import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


public class ActionBouton implements EventHandler<ActionEvent> {
    private VueConnexion appi;

    public ActionBouton(VueConnexion appi){this.appi = appi;}

    @Override
    public void handle(ActionEvent e) {
        Button b = (Button) e.getTarget();
        if(b.getId().equals("changer pseudo")){
            System.out.println("Veut changer son pseudo");

        }
        if(b.getId().equals("changer adresse mail")){
            System.out.println("Veut changer son adresse mail");
            

        }
        if(b.getId().equals("revenir en arrire")){
            System.out.println("Veut revenir en arrire");

        }
        if(b.getId().equals("desconnexion")){
            System.out.println("Veut désconneter");
        }
        //System.out.println("Pseudo : "+appi.getAdresse().toString()+", adresse mail : "+appi.getAdresse().toString()+" et mot de passe :"+appi.getMdp().toString());

    }
}
