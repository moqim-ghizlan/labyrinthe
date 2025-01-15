import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.awt.event.ActionListener;


public class ActionAcceuilAdmin implements EventHandler<MouseEvent>{
    private Echapee_belle_vue echa;


    public ActionAcceuilAdmin(Echapee_belle_vue echa){
        this.echa = echa;
    }

    @Override
    public void handle(MouseEvent e) {
        this.echa.changeVue(this.echa.editAdmin());
    }
}
