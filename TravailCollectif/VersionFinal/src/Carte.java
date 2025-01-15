public class Carte{
   private int idC;
   private String planC;
   private boolean BrouillonCarte;
   private String nomCarte;
   private int idUt;
   private int idTs;


   public Carte(int idC, String nomCarte, String planC, boolean BrouillonCarte, int idUt, int idTs ){
      this.idC = idC;
      this.planC= planC;
      this.BrouillonCarte = BrouillonCarte;
      this.nomCarte = nomCarte;
      this.idUt = idUt;
      this.idTs = idTs;
   }

   public String getNomCarte() {
      return this.nomCarte; 
   }

   public void setNomCarte(String nomCarte){
      this.nomCarte = nomCarte;
   }

   public String getPlanC(){
      return this.planC;
   }

   public void setplanC(String planC){
      this.planC=planC;
   }

   public boolean getBrouillonCarte(){
      return this.BrouillonCarte;
   }

   public void setBrouillonCarte(boolean BrouillonCarte){
      this.BrouillonCarte = BrouillonCarte;
   }

   public int getIdC() {
      return idC;
   }

   public void setIdC(int idC) {
      this.idC = idC;
   }

   public int getIdTs() {
      return idTs;
   }

   public void setIdTs(int idTs) {
      this.idTs = idTs;
   }
}