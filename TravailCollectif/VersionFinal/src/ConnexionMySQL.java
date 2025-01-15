import java.sql.*;

public class ConnexionMySQL {

    private Connection mysql;
    private boolean connecte = false;

    public ConnexionMySQL() throws ClassNotFoundException{
        try{
            this.mysql=null;
            Class.forName("org.mariadb.jdbc.Driver");
        }
        catch(ClassNotFoundException Ex){
            System.out.println("ClassNotFoundException");
            return;
        }
    }

    public void connecter(String nomServeur, String nomBase, String nomLogin, String motDePasse) throws SQLException{
        try{
        Connection c = DriverManager.getConnection("jdbc:mysql://"+nomServeur+":3306/"+nomBase,nomLogin,motDePasse);
        this.mysql = c;
        this.connecte=true;
        }

        catch(SQLException ex){
            System.out.println("Msg: "+ex.getMessage()+ex.getErrorCode());
            return;
        }
    }

    public void close() throws SQLException {
        this.mysql.close();
        this.connecte=false;
    }

    public boolean isConnecte(){ return this.connecte;}

    public Blob createBlob()throws SQLException{
        return this.mysql.createBlob();
    }

    public Statement createStatement() throws SQLException {
        return this.mysql.createStatement();
    }

    public PreparedStatement prepareStatement(String requete) throws SQLException{
        return this.mysql.prepareStatement(requete);
    }
}