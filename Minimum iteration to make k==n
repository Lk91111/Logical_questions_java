import java.lang.Math;
public class MyClass {
    static int N=15;
    static int a=0;
    static int k=0;
    static int temp=0;
    static int c=0;
    
    public static void main(String args[]) {
      
      
    
      System.out.println("min count : "+count(N));
      
    }
      public static int count(int n){
          c++;
          
          if(n%3==0){
        
            temp=three(n);
              
          }else if(n%2==0){
            temp=two(n);
          }else{
              return -1;
          }
          
          if(temp==N){
              return c;
          }else if(temp<N){
              count(N-temp);
          }
          
          return c;
      }
      
      public static int three(int m){
          for(int i=0; i<m; i++){
          
              if(Math.pow(3, i)==m){
                  a=i;
                  break;
              }else if(Math.pow(3, i)>m){
                  a=i-1;
                  break;
              }
          }
          
          k=k+(int)Math.pow(3, a);
          
          return k;
      }
      
      public static int two(int m){
          for(int j=0; j<m; j++){
          
              if(Math.pow(2, j)==m){
                  a=m;
                  break;
              }else if(Math.pow(2, j)>m){
                  a=j-1;
                  break;
              }
          }
          
          k=k+(int)Math.pow(2, a);
          
          return k;
          
      }
      
      
}


//Output :
//min count : 3
