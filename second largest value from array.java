import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        int[] arr= {3,2,1,3,4,7,6,7};
        int max=0;
        int secMax=0;
        
        for(int i=0; i<arr.length; i++){
            if(max<arr[i]){
                secMax=max;
                max=arr[i];
            }else if(secMax<arr[i]&&arr[i]<max){
                secMax=arr[i];
            }
            
        }
        
        System.out.println(secMax);
    }
    
    
    
    
}


//OUTPUT
// 6
