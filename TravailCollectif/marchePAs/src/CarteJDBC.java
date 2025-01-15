import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarteJDBC {
    private ConnexionMySQL connexion;

    public CarteJDBC(ConnexionMySQL connexion) throws SQLException {
        this.connexion = connexion;
    }

    public List<List<Integer>> rechercherPlan(int idCa) throws SQLException{

//        Statement s = this.connexion.createStatement();

        PreparedStatement pst = this.connexion.prepareStatement("Select planCa from CARTE where idCa = ?");
        pst.setInt(1, idCa);
        ResultSet rs = pst.executeQuery();
        rs.next();
        String planCa = rs.getString(1);
        System.out.println(planCa);

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> listeTempo = new ArrayList<>();

        String nb = "";
        for(int i =0; i<planCa.length(); i++){

            Character ch =planCa.charAt(i);

//            String.valueOf(planCa.charAt(i))
            if(Character.isDigit(ch)){
                nb += String.valueOf(planCa.charAt(i));

            }
            else if(ch == ','){
                if(nb.length()!=0){
                    listeTempo.add(Integer.parseInt(nb));
                    nb = "";
                }

            }
            else if(ch == ']'){
                if(listeTempo.size()!=0){
                    listeTempo.add(Integer.parseInt(nb));
                    res.add(listeTempo);
                    nb = "";
                    listeTempo = new ArrayList<>();
                }
            }
        }

        System.out.println(res);
//        listeTempo.add(Integer.parseInt(nb));

//        int compteur = 0;
//        for(int i=0; i<listeTempo.size(); i++){
//            List<Integer> liste1 = new ArrayList<>();
//            if(compteur<10){
//                liste1.add(listeTempo.get(i));
//                compteur += 1;
//            }
//            else{
//                compteur=0;
//                res.add(liste1);
//                liste1.clear();
//            }
//        }

        return res;
    }
}
