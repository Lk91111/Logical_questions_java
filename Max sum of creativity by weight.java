import java.util.*;

public class MyClass {
    public static void main(String args[]) {
      int k =3;
      int[] c={8,9,7,9,2,1,4,5,6,9};
      int[] h={1,2,2,2,1,2,3,2,1,3};
      
      Map<Integer, String> m = new HashMap<>();
      String cc="";
      String hh="";
      
      
      int sum=0;
      
      for(int i=0; i<c.length; i++){
            
       
          if(!hh.contains(String.valueOf(h[i]))){
              
              hh+=h[i]+"";
              m.put(h[i], String.valueOf(c[i]));
              
          }else{
              
              
              if(!m.get(h[i]).contains(String.valueOf(c[i]))){
                  
                  if(m.get(h[i]).contains(",")){
                      
                      
                      if(Integer.parseInt(m.get(h[i]).split(",")[m.get(h[i]).split(",").length-1])>c[i]){
                          
                          m.put(h[i], m.get(h[i])+","+c[i]);
                      }else{
                          
                          cc=m.get(h[i]).substring(0, m.get(h[i]).length()-1)+""+c[i]+","+m.get(h[i]).substring(m.get(h[i]).length()-1, m.get(h[i]).length());
                          
                          m.put(h[i], cc);
                      }
                  }else{
                      
                      if(Integer.parseInt(m.get(h[i]))>c[i]){
                          
                          m.put(h[i], m.get(h[i])+","+c[i]);
                      }else{
                          
                          m.put(h[i],c[i]+","+ m.get(h[i]));
                      }
                  }
                  
                  
              }
              
          }
          
          
      }
      
      if(k==m.size()){
          for(int j=1; j<=k; j++){
            sum+=Integer.parseInt(m.get(j).split(",")[0]);
        }
      }else{
          sum=-1;
      }
      
      
      System.out.println("Max Possible sum from all weight : "+sum);
      
      
    }
}


//Output : 
//Max Possible sum from all weight : 26
