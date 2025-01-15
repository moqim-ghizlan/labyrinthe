import java.sql.Time;
import java.util.Date;

public class Scenario{
    private String messageTxt;
    private byte[] imgTxt;
    private String titreScenario;
    private String resumeScenario;
    private byte[] icone;
    private Time tempsMaxScenario;
    private Date dateMiseEnLigne;
    private boolean BrouillonScenario;
    public Scenario(String titreScenario, String resumeScenario, byte[] icone, Time tempsMaxScenario, Date dateMiseEnLigne, boolean BrouillonScenario, String messageTxt, byte[] imgTxt){
        this.titreScenario = titreScenario;
        this.resumeScenario = resumeScenario;
        this.icone = icone;
        this.tempsMaxScenario = tempsMaxScenario ;
        this.dateMiseEnLigne = dateMiseEnLigne;
        this.BrouillonScenario = BrouillonScenario;
        this.messageTxt = messageTxt;
        this.imgTxt=imgTxt;
    }
    public Scenario(String titreScenario, Date dateMiseEnLigne, Time tempsMaxScenario){
        this.titreScenario=titreScenario;
        this.dateMiseEnLigne=dateMiseEnLigne;
        this.tempsMaxScenario=tempsMaxScenario;
    }
    public String getTitreScenario(){
        return this.titreScenario;

    }

    public void setTitreScenario(String titreScenario){
        this.titreScenario = titreScenario;

    }
    public String getResumeScenario(){
        return this.resumeScenario;

    }

    public void setResumeScenario(String resumeScenario){
        this.resumeScenario = resumeScenario;
    }

    public Time getTempsMaxScenario(){
        return this.tempsMaxScenario;

    }

    public void setTempsMaxScenario(Time tempsMaxScenario){
        this.tempsMaxScenario = tempsMaxScenario;
    }

    public byte[] getIcone(){
        return this.icone;

    }

    public void setIcone(byte[] icone){
        this.icone = icone;
    }

    public Date getDateMiseEnLigne(){
        return this.dateMiseEnLigne;

    }

    public void setDateMiseEnLigne(Date dateMiseEnLigne){
        this.dateMiseEnLigne = dateMiseEnLigne;
    }

    public boolean getBrouillonScenario(){
        return this.BrouillonScenario;

    }

    public void setBrouillonScenario(boolean BrouillonScenario){
        this.BrouillonScenario = BrouillonScenario;
    }

    public String getMessageText(){
        return this.messageTxt;
    }

    public void setMessageText(String messageTxt){
        this.messageTxt = messageTxt;
    }

    public byte[] getImgTxt(byte[] imgTxt){
        return this.imgTxt;
    }

    public void setImgTxt(byte[] imgTxt){
        this.imgTxt=imgTxt;
    }
}
