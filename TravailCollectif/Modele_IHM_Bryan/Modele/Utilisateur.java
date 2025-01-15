

public class Utilisateur {
    private String pseudoUtilisateur;
    private String mailUtilisateur;
    private String mdpUtilisateur;
    private boolean activUtilisateur;
    private String roleUtilisateur;
    private byte[] avatarUtilisateur;


    public Utilisateur(String pseudoUtilisateur, String mailUtilisateur, String mdpUtilisateur, boolean activUtilisateur, String roleUtilisateur, byte[] avatarUtilisateur) {
        this.pseudoUtilisateur = pseudoUtilisateur;
        this.mailUtilisateur = mailUtilisateur;
        this.mdpUtilisateur = mdpUtilisateur;
        this.mailUtilisateur = mailUtilisateur;
        this.roleUtilisateur = roleUtilisateur;
        this.avatarUtilisateur = avatarUtilisateur;
        this.activUtilisateur = activUtilisateur;

    }


    public String getPseudoUtilisateur() {
        return pseudoUtilisateur;
    }
    public void setPseudoUtilisateur(String pseudoUtilisateur) {
        this.pseudoUtilisateur = pseudoUtilisateur;
    }
    public String getMailUtilisateur() {
        return this.mailUtilisateur;
    }

    public void setMailUtilisateur(String mailUtilisateur){
        this.mailUtilisateur = mailUtilisateur;
    }

    public String getMdpUtilisateur() {
        return this.mdpUtilisateur;
    }

    public void setMdpUtilisateur(String mdpUtilisateur){
        this.mdpUtilisateur = mdpUtilisateur;
    }

    public String getRoleUtilisateur() {
        return this.roleUtilisateur;
    }
    public void setRoleUtilisateur(String roleUtilisateur) {
        this.roleUtilisateur = roleUtilisateur;
    }

    public byte[] getAvatarUtilisateur() {
        return this.avatarUtilisateur;
    }
    public void setAvatarUtilisateur(byte[] avatarUtilisateur) {
        this.avatarUtilisateur = avatarUtilisateur;
    }

    public boolean getActivUtilisateur(){
        return this.activUtilisateur;
    }

    public void setActivUtilisateur(boolean activUtilisateur){
        this.activUtilisateur = activUtilisateur;
    }

    public void ActiverJoueur(){
        if(getActivUtilisateur()==false)
            setActivUtilisateur(true);

    }

    public void DesactiverJoueur(){
        if(getActivUtilisateur()==true)
            setActivUtilisateur(false);

    }
}
