import java.util.*;
import java.lang.*;
//import java.util.regex.Pattern;
public class MyClass {
    public static void main(String args[]) {
      String value="11.22.33.41\n11.22.33.45\n11.23.33.44";
      
      String[] newVal= value.split("\n");
      
      System.out.println("enter ip to search");
      Scanner scan = new Scanner(System.in);
      String search = scan.next();
      String reg = ".";
      String[] s2=search.split("\\W");
      //System.out.println(s2.length);
      int count=0;
      int min=(int) Math.pow(Integer.parseInt(s2[0]),4);
      int minInd=0;
      int temp=0;
      int tem=0;
      String[] arr=new String[4];
      
      for(int i=0; i<newVal.length; i++){
          arr=newVal[i].split("\\W");
          count=0;
          temp=0;
          tem=0;
          //System.out.println(newVal[i]);
          for(int j=0; j<4; j++){
              //System.out.println("in");
              if(arr[j].equals(s2[j])){
                  //System.out.println("in");
                  count++;
                  if(count==4){
                      minInd=i;
                  }
              }else{
                  tem=Integer.parseInt(s2[j])-Integer.parseInt(arr[j]);
                  temp= tem*((int) Math.pow(10,(4-j)))+temp;;
                  
                 if(temp<0){
                        temp=temp*(-1);
                    }
                    
                //System.out.println("temp = "+temp);
                    
                  if(temp<min){
                      min=temp;
                      minInd=i;
                      
                    //System.out.println("min = "+min+" "+newVal[i]);
                    
                  }
                  
                  
              }
          }
      }
      
      System.out.println("Closest ip is "+newVal[minInd]);
     
    }
}
