import java.sql.*;

public class UtilisateurJDBC {
    private ConnexionMySQL connexionMySQL;
    private Utilisateur uti;

    public Utilisateur getUti() {
        return uti;
    }

    public UtilisateurJDBC(ConnexionMySQL connexionMySQL) throws SQLException {
        this.connexionMySQL=connexionMySQL;
        this.uti=uti;
    }
    public boolean testerConnexion(String identifiant, String mdp) throws SQLException {
        boolean res = false;
        Statement s = this.connexionMySQL.createStatement();
        ResultSet rs = s.executeQuery("Select * from UTILISATEUR where mdput = password('"+mdp+"') and pseudout = '"+identifiant+"'");
        if(rs.next()){
            this.uti = new Utilisateur(rs.getInt("idut"), rs.getString("pseudout"),rs.getString("emailut"),rs.getString("mdput"),rs.getString("activeut").charAt(0),rs.getInt("idro"),rs.getBlob("avatarut"));
            return true;
        }
        return res;
    }
    public void creationCompte(String pseudo, String mdp,String adresse, Blob img) throws SQLException{
        Statement s = this.connexionMySQL.createStatement();
        ResultSet rs = s.executeQuery("Select max(idut) maxId from UTILISATEUR");
        PreparedStatement pst = this.connexionMySQL.prepareStatement("insert into UTILISATEUR values(?,?,?,password(?),?,?,?);");
        rs.next();
        int newId = rs.getInt("maxId");
        pst.setInt(1, newId+1);
        pst.setString(2, pseudo);
        pst.setString(3, adresse);
        pst.setString(4, mdp);
        pst.setString(5,"O");
        pst.setBlob(6, img);
        pst.setInt(7,2);
        System.out.println(pst.toString());
        pst.executeUpdate();
    }
    public int verification(String pseudo, String email) throws Exception{
        Statement s = this.connexionMySQL.createStatement();
        ResultSet rs = s.executeQuery("Select * from UTILISATEUR");
        while (rs.next()){
            if(rs.getString("pseudout").equals(pseudo)) {
                return 1;
            }
            else if(rs.getString("emailut").equals(email)){
                return 2;
            }
        }
        return 0;
    }

}
