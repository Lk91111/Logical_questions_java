import java.util.*;
public class MyClass {
    public static void main(String args[]) {
      long[] arr={1,2,5,-6,2,3};
      
      MyClass m = new MyClass();
      System.out.println(m.solution(arr));
    }
    
    public long solution(long[] arr){
        Arrays.sort(arr);
        long value=0;
        int i=0;
        if(arr[i]<0&&arr[arr.length-1]>0){
            if((arr[i]*(-1))<arr[arr.length-1]){
                value=arr[arr.length-1];
            }else if((arr[i]*(-1))>arr[arr.length-1]){
                value=arr[i];
            }else{
                value=arr[i];
            }
        }else{
            if(arr[i]>0){
                value=arr[arr.length-1];
            }else{
                value=arr[i];
            }
            
        }
        
        return value;
    }
    
    
}


//OUTPUT
// -6
