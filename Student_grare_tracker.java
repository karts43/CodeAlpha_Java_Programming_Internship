import java.util.*;
public class Student_grare_tracker{
//Step 1 -> That Calulate_Arerage_Scores method are find out Avg.Scores number in integer formate
   private static int Calulate_Arerage_Scores(ArrayList<Integer> storage) {
      // step 1.0 
      if(!storage.isEmpty()){
         // step 1.0.0 
         int Sum_Scores = 0;
         // step 1.0.1 
         for(int Element : storage){
            // step 1.0.1.0 
            Sum_Scores += Element;
         }
         // step 1.0.2 
         return Sum_Scores / storage.size();
      }
      //other wise  step 1.1
      return 0;
   }
//Step 2 -> That High_Scores method are Calulate High Scores
   private static int Calulate_High_Scores(ArrayList<Integer> storage){
      // step 2.0
          if(!storage.isEmpty()){
            // step 2.0.0
             int High_Grade = 0;
             // step 2.0.1
             for(int Element : storage){
               // step 2.0.1.0
                if(Element > High_Grade) High_Grade = Element;
             }
             // step 2.0.2 
             return High_Grade;
          }
          //other wise  step 2.1
          return 0;
   }
//Step 3 -> That Lowest Scores method are Calulate Lowest Scores
   private static int Calulate_Lowest_Scores(ArrayList<Integer> storage) {
      // step 3.0
         if(!storage.isEmpty()){
            // step 3.0.0
            int Lowest_Scores = 0 ;
            // step 3.0.1
            for(int Element : storage){
               // step 3.0.1.0
               if(Element < Lowest_Scores)Lowest_Scores = Element;
            }
            // step 3.0.2
            return Lowest_Scores;
         }
         //other wise  step 3.1
         return 0;
   }
// **************************  Main Method step 0 *************************************
      public static void main(String args[]){

          Scanner in = new Scanner(System.in);
          ArrayList<Integer> storage = new ArrayList<>();
    
          System.out.println("Enter the number of Student :");
          int number_student = in.nextInt();
    
          for(int i = 1 ; i<=number_student ;i++){
             System.out.println(i+"] Enter grade for student :");
             storage.add(in.nextInt());
          }
          in.close();
         // call (step 1)
         System.out.println("Arerage Scores :"+Calulate_Arerage_Scores(storage));
         // call (step 2)
         System.out.println("High Scores :"+Calulate_High_Scores(storage));
         // call (step 3)
         System.out.println("Lowest Scores :"+Calulate_Lowest_Scores(storage));

      }
}
