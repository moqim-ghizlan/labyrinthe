import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Tuile extends VBox {
    private double largeur, hauteur;
    private double ratio;
    private ImageView vueTuile;
    //private BackgroundImage vueTuile;
    private int lig;
    private int col;
    private Image imagePerso = new Image("file:src/Images/persoFace.png");
    public ImageView avatar = new ImageView(imagePerso);

    public StackPane stP;

    /**
     * Constructeur
     * @param largeur largeur en pixels de la tuile
     * @param hauteur hauteur en pixels de la tuile
     * @param ratio ratio d'agrandissement ou de rapetissement de la tuile
     * @param lig numéro de la ligne où se trouve la tuile dans l'image
     * @param col numéro de la colonne où se trouve la tuile dans l'image
     * @param image image d'où est extraite la tuile
     */
    Tuile(double largeur,double hauteur,double ratio, int lig, int col, Image image) {
        super();
        //
//        Image avatar = new Image("file:src/Images/persoFace.png");
//        ImageView avatarView = new ImageView(avatar);
//        avatarView.setFitHeight(50);
//        avatarView.setFitWidth(50);

        // initialisation des paramètres
        this.largeur=largeur;
        this.hauteur=hauteur;
        this.ratio=ratio;
        // création de l'imageview
        this.vueTuile =new ImageView(image);
        //this.vueTuile = new BackgroundImage(image,BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        // création du viewport (point de vue)
        Rectangle2D viewport = new Rectangle2D(col * largeur, lig * hauteur, largeur, hauteur);
        this.vueTuile.setViewport(viewport);
        // redimensionnement de la tuile en fonction du ratio demandé
        this.vueTuile.setFitWidth(largeur*ratio);
        this.vueTuile.setFitHeight(hauteur*ratio);
        this.vueTuile.setSmooth(true);

        //Ajout de l'image avatar
//        Image imagePerso = new Image("file:src/Images/persoFace.png");
//        ImageView avatar = new ImageView(imagePerso);
//        avatar.setFitWidth(25);
//        avatar.setFitHeight(25);

        this.stP = new StackPane();
        stP.getChildren().add(avatar);
        stP.getChildren().add(this.vueTuile);
        this.getChildren().add(stP);
        this.setAlignment(Pos.CENTER);
        avatar.toBack();

        // traitement du cas où la tuile à un numéro de ligne ou de colonne inférieur à 0
        // ce cas sera utilisé pour la tuile "en moins" du taquin"
//        if (lig<0 || col<0)
//            this.setBorder(Border.EMPTY);
//        else
//            this.setBordure(Color.GRAY);
//        this.getChildren().add(vueTuile);
//        this.getChildren().add(avatarView);
        this.setAlignment(Pos.CENTER);
    }

    /**
     * change la position de la tuile (c'est-à-dire change le point de vue de l'image)
     * @param ligne numéro de la ligne où se trouve la tuile dans l'image
     * @param colonne numéro de la colonne où se trouve la tuile dans l'image
     */
    void setPosition(int ligne, int colonne){
        Rectangle2D viewport = new Rectangle2D(colonne * this.largeur, ligne* hauteur, this.largeur, this.hauteur);
        this.vueTuile.setViewport(viewport);
//        if (ligne<0 || colonne<0)
//            this.setBorder(Border.EMPTY);
//        else
//            this.setBordure(Color.GRAY);
    }

    /**
     * change la couleur de la bordure de la vBox de la tuile
     * @param color couleur de la bordure
     */
    void setBordure(Color color){
        this.setBorder(new Border(new BorderStroke(color, BorderStrokeStyle.SOLID, new CornerRadii(largeur * 0.025), new BorderWidths(3))));
    }

    /**
     * permet d'activer ou non la tuile. Lorsque la tuile est désactivée sa bordure doit être rouge et grise sinon
     * @param actif un booléen indiquant si la tuile doit être active ou non
     */
    void activer(boolean actif){
        // A IMPLEMENTER
        if (!actif){
            this.setBordure(Color.RED);
        }
        else{
            this.setBordure(Color.GRAY);
        }

    }
}


