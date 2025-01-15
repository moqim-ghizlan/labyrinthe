import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnigmeJDBC {
    private ConnexionMySQL connexionMySQL;

    public EnigmeJDBC(ConnexionMySQL connexionMySQL) throws SQLException {
        this.connexionMySQL=connexionMySQL;
    }
    public List<Enigme> listEnigme() throws SQLException{
        Statement s = this.connexionMySQL.createStatement();
        ResultSet rs = s.executeQuery("Select * from ENIGME");
        List<Enigme> list = new ArrayList<>();
        while(rs.next()) {
            Enigme enigme = new Enigme(rs.getInt("iden"), rs.getString("nomen"), rs.getString("texten"), rs.getString("reponseen"), rs.getString("aideen"), rs.getString("brouillonen").charAt(0), rs.getBlob("imgen"));
            list.add(enigme);
        }
        return list;
    }
}
