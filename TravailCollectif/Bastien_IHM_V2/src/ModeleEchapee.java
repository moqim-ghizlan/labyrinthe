import java.util.*;

public class ModeleEchapee {

    public static int VIDE=-1; // constante permetant de représenter la case vide

    private Vector<Integer> echapee; // représentation du jeu de taquin sous la forme d'un vecteur d'entier
    private int hauteur; // le nombre de lignes du taquin
    private int largeur; // le nombre de colonnes du taquin
    private int nbMouvements; // compteur permettant que connaitre le nombre de mouvement effectués par l'utilisateur



    /**
     * Constructeur du taquin indiquant le nombre de lignes et de colonnes de celui-ci
     * @param hauteur nombre de lignes du taquin
     * @param largeur nombre de colonnes du taquin
     */
    public ModeleEchapee(int hauteur, int largeur, List<List<Integer>> liste) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.echapee=new Vector<Integer>(hauteur*largeur);
        //for (int i=0;i<hauteur*largeur;i++){
        //    this.echapee.add(i);
        //}
        for(List<Integer> l:liste){
            for(Integer i:l){
                this.echapee.add(i);
            }
        }

        this.nbMouvements=0;
    }

    /**
     * @return le nombre de lignes du taquin
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     * @return le nombre de colonnes du taquin
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * retourne la valeur stockée en lig,col du taquin
     * @param lig numéro de la ligne
     * @param col numéro de la colonne
     * @return la valeur stockée en lig,col du taquin
     */
    public int getVal(int lig, int col){
        return echapee.get(lig*largeur+col);
    }

    /**
     * place la valeur val en lig,col du taquin
     * @param lig numéro de la ligne
     * @param col numéro de la colonne
     * @param val valeur à stocker
     */
    public void setVal(int lig, int col, int val){
        echapee.set(lig*largeur+col,val);
    }

    /**
     * permet de faire déplacer la case qui se trouve ne lig,col vers la case vide (
     * @param lig ligne de la case à déplacer
     * @param col colonne de la case à déplacer
     * @param compter vaut 0 ou 1 pour savoir s'il faut compter ou non le déplacement
     * @return 1 si le déplacement a bien pu être effectué, -1 si le déplacement a échoué
     */
    public int decale(int lig, int col, int compter){
        if (lig<0 || lig>=hauteur || col<0 || col>=largeur){
            return -1;}
        if (lig>0 && getVal(lig-1,col)==VIDE){
            setVal(lig-1,col,getVal(lig,col));
            setVal(lig,col,VIDE);
            nbMouvements+=compter;
            return 1;
        }
        if (lig<hauteur-1 && getVal(lig+1,col)==VIDE){
            setVal(lig+1,col,getVal(lig,col));
            setVal(lig,col,VIDE);
            nbMouvements+=compter;
            return 1;
        }
        if (col>0 && getVal(lig,col-1)==VIDE){
            setVal(lig,col-1,getVal(lig,col));
            setVal(lig,col,VIDE);
            nbMouvements+=compter;
            return 1;
        }
        if (col<largeur-1 && getVal(lig,col+1)==VIDE){
            setVal(lig,col+1,getVal(lig,col));
            setVal(lig,col,VIDE);
            nbMouvements+=compter;
            return 1;
        }
        return -1;
    }

    /**
     * permet de connaitre le numéro de ligne où doit être placée
     * la case du taquin qui se trouve actuellement en lig,col
     * @param lig ligne de la case consultée
     * @param col colonne de la case consultée
     * @return le numéro de la ligne où on doit placer la case qui se trouve en lig,col
     */
    public int getLigneCible(int lig, int col){
        return getVal(lig,col)/largeur;
    }

    /**
     * permet de connaitre le numéro de colonne où doit être placée
     * la case du taquin qui se trouve actuellement en lig,col
     * @param lig ligne de la case consultée
     * @param col colonne de la case consultée
     * @return le numéro de la colonne où on doit placer la case qui se trouve en lig,col
     */
    public int getColonneCible(int lig, int col){
        return getVal(lig,col)%largeur;
    }

    /**
     * permet de mélanger un taquin
     * @return le nombre de mouvements qui ont permis de mélanger le taquin
     */
    public int melanger(){
        Random random= new Random();
        int nbMelange=random.nextInt(100);
        int nbDecalage=0;
        for (int i=0; i<hauteur*largeur*500+nbMelange;i++){
            int lig=random.nextInt(hauteur);
            int col=random.nextInt(largeur);
            if (decale(lig,col,0)>0) nbDecalage++;
        }
        return nbDecalage;
    }

    /**
     * @return le nombre de mouvements effectués par le joueur
     */
    public int getNbMouvements(){
        return nbMouvements;
    }

    /**
     * @return un booléen indiquant si le joueur a gagné
     */
    public boolean gagne(){
        for (int i=0;i<hauteur*largeur-1;i++){
            if (echapee.get(i)!=i) return false;
        }
        return true;
    }


//    public void deplacerDroitr(){
//
//    }

    /**
     * @return une représentation sur la forme d'une chaine de caractère du taquin
     */
    @Override
    public String toString() {
        String res="";
        for (int lig=0;lig<hauteur;lig++){
            for (int col=0;col<largeur;col++){
                res+="|"+String.format("% 3d",getVal(lig,col));
            }
            res+="|\n";
        }
        res+="Vous avez effectué "+this.nbMouvements+" mouvements";
        return res;
    }
    public static void main(String [] args){
        int hauteur=2;
        int largeur=2;
        Scanner sc= new Scanner(System.in);
        List<List<Integer>> liste = Arrays.asList(Arrays.asList(2,1,8),Arrays.asList(0,5,6),Arrays.asList(3,4,7));
        ModeleEchapee echapee=new ModeleEchapee(hauteur,largeur,liste);
        System.out.println("Taquin cible");
        System.out.println(echapee);
        int i=echapee.melanger();


        while (!echapee.gagne()) {
            System.out.println(echapee);
            System.out.println("entrez la ligne:");
            int ligne = sc.nextInt();
            System.out.println("entrez la colonne:");
            int colonne = sc.nextInt();
            if (ligne >= 0 && colonne >= 0 && ligne < hauteur && colonne < largeur) {
                int res = echapee.decale(ligne, colonne, 1);
                if (res == 1)
                    System.out.println("mouvement valide");
                else
                    System.out.println("mouvement non valide");
            } else
                System.out.println("ligne ou colonne non valide");
        }
        System.out.println("Bravo !!!");
    }
}
