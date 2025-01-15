import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.Files;
import java.sql.Blob;
import java.sql.SQLException;

public class ActionInscription implements EventHandler<ActionEvent> {
    private Echapee_belle_vue echa;
    private String action;
    public ActionInscription(Echapee_belle_vue echa, String action) {
        this.echa = echa;
        this.action = action;
    }
    @Override
    public void handle(ActionEvent e) {
        Button b = (Button) e.getTarget();
        System.out.print(action);
        if (action.equals("retour")){
            this.echa.changeVue(this.echa.Bienvenue());
        }
        else{
            String pseudo = this.echa.getTf1().getText();
            String mdp = this.echa.getTf2().getText();
            String mdpVerif = this.echa.getTf3().getText();
            String adresse = this.echa.getTf4().getText();
            try {
                File f = new File(this.echa.getChemin());
                byte[] img = Files.readAllBytes(f.toPath());
                Blob blob = this.echa.getConnexionMySQL().createBlob();
                blob.setBytes(1, img);
                int verif= this.echa.getUtilisateurJDBC().verification(pseudo,adresse);
                System.out.println(verif);
                if(mdp != mdpVerif){
                    Alert al =new Alert(Alert.AlertType.ERROR);
                    al.setTitle("Problème d'inscription'");
                    al.setHeaderText("Pas de correspondance mot de passe");
                    al.setContentText("Changer les mots de passe");
                    al.showAndWait();
                }
                else if(verif == 0){
                    this.echa.getUtilisateurJDBC().creationCompte(pseudo,mdp,adresse,blob);
                    this.echa.changeVue(this.echa.Bienvenue());
                }
                else if(verif == 1){
                    Alert al =new Alert(Alert.AlertType.ERROR);
                    al.setTitle("Problème d'inscription'");
                    al.setHeaderText("Pseudo existe déjà");
                    al.setContentText("Changer le pseudo pour vous inscrire");
                    al.showAndWait();
                }
                else{
                    Alert al =new Alert(Alert.AlertType.ERROR);
                    al.setTitle("Problème d'inscription'");
                    al.setHeaderText("Adresse email existe déjà");
                    al.setContentText("Changer l'adresse email pour vous inscrire");
                    al.showAndWait();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
