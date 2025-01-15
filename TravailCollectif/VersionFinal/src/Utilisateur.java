

import java.sql.Blob;

public class Utilisateur {
    private int id;
    private String pseudoUtilisateur;
    private String mailUtilisateur;
    private String mdpUtilisateur;
    private char activUtilisateur;
    private int roleUtilisateur;
    private Blob avatarUtilisateur;


    public Utilisateur(int id, String pseudoUtilisateur, String mailUtilisateur, String mdpUtilisateur, char activUtilisateur, int roleUtilisateur, Blob avatarUtilisateur) {
        this.id=id;
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

    public int getRoleUtilisateur() {
        return this.roleUtilisateur;
    }
    public void setRoleUtilisateur(int roleUtilisateur) {
        this.roleUtilisateur = roleUtilisateur;
    }

    public Blob getAvatarUtilisateur() {
        return this.avatarUtilisateur;
    }
    public void setAvatarUtilisateur(Blob avatarUtilisateur) {
        this.avatarUtilisateur = avatarUtilisateur;
    }

    public char getActivUtilisateur(){
        return this.activUtilisateur;
    }

    public void setActivUtilisateur(char activUtilisateur){
        this.activUtilisateur = activUtilisateur;
    }
}
