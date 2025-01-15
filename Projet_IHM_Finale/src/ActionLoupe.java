import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

public class ActionLoupe implements EventHandler<MouseEvent> {
    private Echapee_belle_vue echa;
    private CreationPartieJDBC creationPartieJDBC;

    public ActionLoupe(Echapee_belle_vue echa, CreationPartieJDBC creationPartieJDBC){
        this.echa = echa;
        this.creationPartieJDBC = creationPartieJDBC;
    }

    @Override
    public void handle(MouseEvent e) {
        System.out.println("ok");
        try {
            if(this.creationPartieJDBC.etat(this.echa.getTfCrea().getText())){
                this.echa.setScenario(creationPartieJDBC.donne_scenario(this.echa.getTfCrea().getText()));
                System.out.println(this.echa.getTfCrea().getText());
                this.echa.updateScena();
            }
            else{
                Alert al =new Alert(Alert.AlertType.ERROR);
                al.setTitle("Problème avec le nom du Scénario");
                al.setHeaderText("Le scénario n'existe pas");
                al.setContentText("Veuillez choisir un autre scénario");
                al.showAndWait();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
