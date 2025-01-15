public class Tileset{
    private String nomTuile;
    private byte[] imageTuileSet;
    public Tileset(String nomTuile,byte[] imageTuileSet){
        this.nomTuile = nomTuile;
        this.imageTuileSet=imageTuileSet;
        
    }
    public byte[] getImageTuileSet(){
        return this.imageTuileSet;
    }

    public void setImageTuileSet(byte[] imageTuileSet){
        this.imageTuileSet = imageTuileSet;
    }
    public String getNomTuile(){
        return this.nomTuile;
    }

    public void setNomTuile(String nomTuile){
        this.nomTuile= nomTuile;

    }



}