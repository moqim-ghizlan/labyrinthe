import java.sql.*;

public class GestionStatsAdminJDBC {
    private ConnexionMySQL connexionMySQL;

    public GestionStatsAdminJDBC(ConnexionMySQL connexionMySQL) throws SQLException {
        this.connexionMySQL=connexionMySQL;
    }
    public int nbScenarioCreer() throws SQLException{
        Statement s = this.connexionMySQL.createStatement();
        ResultSet rs = s.executeQuery("Select count(*) nb from SCENARIO");
        if (rs.next()){
            return rs.getInt("nb");}
        else{
            return 0;
        }
    }
    public int nbPersonnesInscrites() throws SQLException{
        Statement s = this.connexionMySQL.createStatement();
        ResultSet rs = s.executeQuery("Select count(*) nb from UTILISATEUR");
        rs.next();
        if (rs.next()){
            return rs.getInt("nb");}
        else{
            return 0;
        }
    }
}

