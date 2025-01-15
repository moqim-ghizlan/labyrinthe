import java.util.Date;
import java.time.LocalTime;

public class Partie{
    private Date datepartie;
    private LocalTime heurepartie;
    private LocalTime dureepartie;
    private int nbPartiejoue;
    private int nbpartiesgagnees;
    private double reussite;

    public Partie(Date datepartie, LocalTime heurepartie, LocalTime dureepartie){
        this.datepartie = datepartie;
        this.heurepartie = heurepartie;
        this.dureepartie = dureepartie;

    }

    public LocalTime getHeurePartie(){
        return this.heurepartie;
    }

    public void setHeurePartie(LocalTime heurepartie){
        this.heurepartie = heurepartie;

    }

    public Date getDatePartie(){
        return this.datepartie;
    }

    public void setDatePartie(Date datepartie){
        this.datepartie = datepartie;
    }

    public LocalTime getDureePartie(){
        return this.dureepartie;
    }
    
    public void setDureePartie(LocalTime dureepartie){
        this.dureepartie = dureepartie;
    }

    public int getNbPartieJouee(){
        return this.nbPartiejoue;
    }

    public int getNbPartieGagnee(){
        return this.nbpartiesgagnees;
    }


    public int getnbPartieJouees(){
        return this.nbPartiejoue+=nbPartiejoue;
    }

    public double getPourcentageDeReussite(){
        this.reussite = this.nbPartiejoue/this.nbpartiesgagnees;
        return this.reussite;
    }

}