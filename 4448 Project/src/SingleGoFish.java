public class SingleGoFish {
    //create an object of SingleObject
   private static SingleGoFish instance = new SingleGoFish();

   //make the constructor private so that this class cannot be
   //instantiated
   private SingleGoFish(){}

   //Get the only object available
   public static SingleGoFish getInstance(){
      return instance;
   }

   //Message to confirm game start
   public void showMessage(){
    System.out.println("\n---Welcome!---");
 }
}
