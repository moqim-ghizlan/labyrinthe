import java.sql.*;

public class InformationJDBC {
    private ConnexionMySQL connexionMySQL;

    public InformationJDBC(ConnexionMySQL connexionMySQL) throws SQLException {
        this.connexionMySQL=connexionMySQL;
    }
    public int partieJoue(String identifiant) throws SQLException {
        Statement s = this.connexionMySQL.createStatement();
        ResultSet rs = s.executeQuery("Select count(*) nb from UTILISATEUR natural join PARTIE where pseudout = '" + identifiant + "'");
        rs.next();
        return rs.getInt("nb");
    }
    public int partieGagne(String identifiant) throws SQLException{
        Statement s = this.connexionMySQL.createStatement();
        ResultSet rs = s.executeQuery("Select count(*) nb from UTILISATEUR natural join PARTIE where pseudout = '" + identifiant + "' and gagne = 'O'");
        rs.next();
        return rs.getInt("nb");
    }
    public String bestTps(String identifiant) throws SQLException{
        Statement s = this.connexionMySQL.createStatement();
        ResultSet rs = s.executeQuery("Select MIN(tpsresolution) minimum from UTILISATEUR natural join PARTIE where pseudout = '" + identifiant + "'");
        rs.next();
        return rs.getString("minimum");
    }
    public String nbTpsInfDix(String identifiant) throws SQLException{
        Statement s = this.connexionMySQL.createStatement();
        ResultSet rs = s.executeQuery("Select count(*) tpsDixMin from UTILISATEUR natural join PARTIE where pseudout = '" + identifiant + "' and Time(tpsresolution) <= Time('00:10')");
        rs.next();
        return rs.getString("tpsDixMin");
    }
}

