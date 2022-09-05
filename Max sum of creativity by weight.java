import java.util.*;

public class MyClass {
    
    static int sum=0;
    
    public static void main(String args[]) {
      int k =3;
      int[] c={7,3,22,1,2,33,90,21,3,54};
      int[] h={1,1,1,2,2,2,3,3,4,4};
      
      Map<Integer, Integer> m = new HashMap<>();
      
      String hh="";
      
      for(int i=0; i<c.length; i++){
       
          if(!hh.contains(String.valueOf(h[i]))){
              hh+=h[i]+"";
              m.put(h[i], c[i]);
          }else{
              if(m.get(h[i])<c[i]){
                  
                  m.put(h[i], c[i]);
              }
          }
          
          
      }
      
      if(k<=m.size()){
         
        int arr[] = new int[m.size()];
          
        for(int j=1; j<=m.size(); j++){
            arr[j-1]=m.get(j);
        }
            
        Arrays.sort(arr);
        
        for(int l=1; l<=k; l++){
            sum+=arr[arr.length-l];
        }
            
      }else{
          sum=-1;
      }
      
      System.out.println("Max Possible sum from all weight : "+sum);
      
    }
}


//Output : 
//Max Possible sum from all weight : 26
