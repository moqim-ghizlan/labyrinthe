public class Carte{
   private String planC;
   private boolean BrouillonCarte;
   private String nomCarte;
   private String messageTxt;
   private byte[] imgTxt;

   public Carte(String planC,boolean BrouillonCarte, String nomCarte, String messageTxt, byte[] imgTxt){
      this.planC= planC;
      this.BrouillonCarte = BrouillonCarte;
      this.nomCarte = nomCarte;
      this.messageTxt = messageTxt;
      this.imgTxt=imgTxt;
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

   public String getMessageText(){
      return this.messageTxt;
   }

   public void setMessageText(String messageTxt){
      this.messageTxt = messageTxt;
   }

   public byte[] getImgTxt(byte[] imgTxt){
      return this.imgTxt;
   }

   public void setImgTxt(byte[] imgTxt){
      this.imgTxt=imgTxt;
  }


}