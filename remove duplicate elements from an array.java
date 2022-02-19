import java.util.*;
public class MyClass {
    public static void main(String args[]) {
      int[] arr1={1,2,4,3,5,7,2,1,3,4,4};
      List<Integer> arr2= new ArrayList<>();
      Arrays.sort(arr1);
      
      for(int i=0; i<arr1.length-1; i++){
          if(arr1[i]!=arr1[i+1]){
              arr2.add(arr1[i]);
              if(i==arr1.length-2){
                arr2.add(arr1[i+1]);
            }
          }
          
          
      }
      System.out.println(arr2);
    }
}
