import java.util.*;
public class MyClass {
    public static void main(String args[]) {
      String name = "Programming";
      char[] arr=new char[name.length()];
      
      name.toLowerCase();

      int count=1;
      
      for(int i=0; i<arr.length; i++){
          arr[i]=name.charAt(i);
      }
      
      Arrays.sort(arr);
      
      for(int j=0; j<arr.length-1; j++){
          if(arr[j]!=arr[j+1]){
              System.out.println(arr[j]+" - "+count);
              if(j==arr.length-2){
                 System.out.println(arr[j+1]+" - "+count); 
              }
              count=1;
          }
          else{
              count++;
              if(j==arr.length-2){
                 System.out.println(arr[j+1]+" - "+count); 
              }
          }
      }
    }
    
    
}


//OUTPUT
// P - 1
// a - 1
// g - 2
// i - 1
// m - 2
// n - 1
// o - 1
// r - 2
