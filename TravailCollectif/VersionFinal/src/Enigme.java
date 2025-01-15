public class Enigme{
    private int iden;
    private String nomEnigme;
    private String texteEnigme;
    private String reponseEnigme;
    private byte[] aideEnigme; 
    private boolean BrouillonEnigme;
    private byte[] imageEnigme;

    public Enigme(int iden, String nomEnigme,String texteEnigme, String reponseEnigme, byte[] aideEnigme, boolean BrouillonEnigme, byte[] imageEnigme){
        this.iden = iden;
        this.nomEnigme=nomEnigme;
        this.texteEnigme = texteEnigme;
        this.reponseEnigme=reponseEnigme;
        this.aideEnigme=aideEnigme;
        this.BrouillonEnigme=BrouillonEnigme;
        this.imageEnigme = imageEnigme;
    }
    public byte[] getaideEnigme(){
        return this.aideEnigme;
    }

    public void setAideEnigme(byte[] aideEnigme){
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


    public boolean getBrouillonEnigme(){
        return this.BrouillonEnigme;
    }

    public void setBrouillonEnigme(boolean BrouillonEnigme){
        this.BrouillonEnigme = BrouillonEnigme;
    }
      
    public byte[] getImageEnigme() {
        return this.imageEnigme;        
    }

    public void setImageEnigme(byte[] imageEnigme){
        this.imageEnigme = imageEnigme;
    }
    

}