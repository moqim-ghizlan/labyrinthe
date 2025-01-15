import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BoutonAvatar implements EventHandler<ActionEvent>{
    private Echapee_belle_vue echa;
    public BoutonAvatar(Echapee_belle_vue echa){
        this.echa=echa;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        File file = this.echa.getFc().showOpenDialog(null);
        FileInputStream input = null;
        try {
            this.echa.setChemin(file.getAbsolutePath());
            input = new FileInputStream(this.echa.getChemin());
            Image img = new Image(input);
            ImageView imgView = new ImageView(img);
            this.echa.setCadreimg(img);
            this.echa.getTf5().setGraphic(imgView);
        } catch (Exception e) {

        }
    }
}
