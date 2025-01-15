import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class ActionBouton implements EventHandler<ActionEvent> {
    private GestionDesStats appi;

    public ActionBouton(GestionDesStats appi){this.appi = appi;}

    @Override
    public void handle(ActionEvent e) {
        Button b = (Button) e.getTarget();
        if(b.getId().equals("nbPartie")){
            System.out.println("Nombre de parties en cours");
            Stage s = new Stage();
            s.setTitle("Nombre de parties créés");
            s.setScene(appi.nbParties());
            s.show();

        }
        if(b.getId().equals("nbPersonne")){
            System.out.println("Nombre de personnes inscrites");

            Stage s = new Stage();
            s.setTitle("Nombre de personnes inscrites");
            s.setScene(appi.nbPersonnes());
            s.show();



        }
        if(b.getId().equals("nbScenario")){
            System.out.println("Nombre de scénario créés");

            Stage s = new Stage();
            s.setTitle("Nombre de scénario créés");
            s.setScene(appi.nbScenario());
            s.show();


        }
        if(b.getId().equals("boutonHaut")){
            System.out.println("modifier profil");
        }
        if(b.getId().equals("boutonBas")){
            System.out.println("revenir en arrire");
        }
        //System.out.println("Pseudo : "+appi.getAdresse().toString()+", adresse mail : "+appi.getAdresse().toString()+" et mot de passe :"+appi.getMdp().toString());

    }
}
