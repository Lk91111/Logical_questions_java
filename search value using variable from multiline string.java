import java.util.*;
public class MyClass {
    public static void main(String args[]) {
      String value="v1 v3 v4 v2 v5\n1 3 4 7 2";
      
      String[] newVal= value.split("\n");
      
      String[] val1=newVal[0].split(" ");
      String[] val2=newVal[1].split(" ");
      
      System.out.println("Enter variable to search");
      Scanner scan = new Scanner(System.in);
      String search = scan.next();
      
      int count=0;
      
      for(int i=0; i<val1.length; i++){
          if(val1[i].equals(search)){
              System.out.println("value is "+val2[i]);
              break;
          }else{
              count++;
              if(count==val1.length){
                  System.out.println("variable is not available");
              }
          }
      }
     
    }
}
