import java.sql.Blob;

public class Enigme{
    private int iden;
    private String nomEnigme;
    private String texteEnigme;
    private String reponseEnigme;
    private String aideEnigme;
    private char BrouillonEnigme;
    private Blob imageEnigme;

    public Enigme(int iden, String nomEnigme,String texteEnigme, String reponseEnigme, String aideEnigme, char BrouillonEnigme, Blob imageEnigme){
        this.iden = iden;
        this.nomEnigme=nomEnigme;
        this.texteEnigme = texteEnigme;
        this.reponseEnigme=reponseEnigme;
        this.aideEnigme=aideEnigme;
        this.BrouillonEnigme=BrouillonEnigme;
        this.imageEnigme = imageEnigme;
    }
    public String getaideEnigme(){
        return this.aideEnigme;
    }

    public void setAideEnigme(String aideEnigme){
        this.aideEnigme = aideEnigme;
    }

    public String getReponseEnigme(){
        return reponseEnigme;
    }

    public void setReponseEnigme(String reponseEnigme){
        this.reponseEnigme=reponseEnigme;
    }

    public String getNomEnigme() {
        return this.nomEnigme;
    }

    public void setNomEnigme(String nomEnigme){
        this.nomEnigme = nomEnigme;
    }


    public String getTexteEnigme() {
        return this.texteEnigme;
    }

    public void setTexteEnigme(String texteEnigme){
        this.texteEnigme = texteEnigme;
    }


    public char getBrouillonEnigme(){
        return this.BrouillonEnigme;
    }

    public void setBrouillonEnigme(char BrouillonEnigme){
        this.BrouillonEnigme = BrouillonEnigme;
    }
      
    public Blob getImageEnigme() {
        return this.imageEnigme;        
    }

    public void setImageEnigme(Blob imageEnigme){
        this.imageEnigme = imageEnigme;
    }
    

}