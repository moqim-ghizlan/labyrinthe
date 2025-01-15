import java.sql.*;

public class CreationPartieJDBC{
    private ConnexionMySQL connexionMySQL;
    public CreationPartieJDBC(ConnexionMySQL connexionMySQL){
        this.connexionMySQL=connexionMySQL;
    }
    public Scenario donne_scenario(String nom) throws SQLException {
        Statement s = this.connexionMySQL.createStatement();
        ResultSet rs = s.executeQuery("Select * from SCENARIO where titresc = '"+nom+"'");
        rs.next();
        return new Scenario(rs.getString("titresc"),rs.getDate("datemiseenligne"),rs.getTime("tpsmaxsc"));

    }
}
