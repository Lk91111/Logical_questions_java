import java.lang.StringBuffer.*;

public class MyClass {
    public static void main(String args[]) {
      //String str="6*5/3+9-1+(8-2)/5*(3+(4-5)/2)-5";
      //String str="-3-(4-5)/2";
      //String str="-3-9/2";
      String str="3+2-(68*3/(3-7)*(5-6))-3/2";
      
      
        if(Character.isDigit(str.charAt(0)) || str.charAt(0)=='-'){
            System.out.println("Total = "+fun(str));
            
        }else{
            System.out.println("Unparseable expression");
        }
      
      
      
    }
    
    public static int fun(String ex){
        int sum=0;
        
        String temp="";
        
       if(ex.charAt(0)=='-'){
                temp="-";
                ex=ex.substring(1);
           }
        
        
        //System.out.println("ex = "+ex);
        for(int i=0; i<ex.length(); i++){
            
            if(Character.isDigit(ex.charAt(i))){
                continue;
            }else{
                
                if(ex.charAt(i+1)=='-'){
                   
                    if(ex.charAt(i)=='+'){
                        
                        ex = ex.substring(0, i)+""+ex.substring(i + 1);
                       
                    }else if(ex.charAt(i)=='-'){
                        
                        ex = ex.substring(0, i)+"+"+ex.substring(i + 1);
                        ex = ex.substring(0, i+1)+""+ex.substring(i + 2);
                        
                    }else{
                        
                        
                        ex = "-"+ex;
                        
                        ex = ex.substring(0, i+2)+""+ex.substring(i + 3);
                        
                        
                    }
                }
            }
            
            if(ex.charAt(0)=='-'){
                temp="-";
                ex=ex.substring(1);
           }
            
            String s;
            s=ex;
            s=s.replaceAll("[^a-zA-Z0-9]", "|");
            String sArr1[]=s.split("\\|");
            
            if(sArr1[1].equals("")){
                
                if(temp.equals("-")){
                    ex="0-"+ex;
                }else{
                    ex="0+"+ex;
                }
                
                
                return fun(ex);
                
            }else{
                
                s=ex;
                s=s.replaceAll("[^a-zA-Z0-9]", "|");
                String sArr[]=s.split("\\|");
                
                
                if(ex.charAt(i)=='+'){
                    
                    sum=Integer.parseInt(temp+""+sArr[0])+Integer.parseInt(sArr[1]);
                    break;
                   
                }else if(ex.charAt(i)=='-'){
                    
                    sum=Integer.parseInt(temp+""+sArr[0])-Integer.parseInt(sArr[1]);
                    break;
                    
                }else if(ex.charAt(i)=='*'){
                    
                    sum=Integer.parseInt(temp+""+sArr[0])*Integer.parseInt(sArr[1]);
                    break;
                   
                }else if(ex.charAt(i)=='/'){
                    
                    sum=Integer.parseInt(temp+""+sArr[0])/Integer.parseInt(sArr[1]);
                    break;
                    
                }
            }
            
            
        }
        
        
        
        
        
        return fun2(ex, sum);
        
        
    }
    
    public static int fun2(String ex, int sum){
        
        int k=0;
        int count=0;
        int indB=0;
        int flag=0;
        int count2=0;
        int count3=0;
        
        if(ex.contains("+")||ex.contains("-")||ex.contains("/")||ex.contains("*")){
            
            count=0;
            
            for(int j=0; j<ex.length(); j++){
            
                if(Character.isDigit(ex.charAt(j))){
                    continue;
                }else{
                    count++;
                    
                    if(count==2){
                        k=j;
                        break;
                    }
                    
                }
                
            }
            
            if(count==2){
                
                indB=0;
                count2=0;
                count3=0;
                if(ex.substring(k).charAt(1)=='('){
                    
                    for(int l=0; l<ex.length();l++){
                        if(Character.isDigit(ex.charAt(l))){
                            continue;
                        }else{
                            
                            if(ex.charAt(l)=='('){
                                count2++;
                                
                            }else if(ex.charAt(l)==')'){
                                count3++;
                                if(count2==count3){
                                    indB=l;
                                    break;
                                }
                            }
                            
                        }
                    }
                    
                    
                    
                    if(ex.length()>indB){
                        
                        
                            
                            sum=fun(sum+""+ex.substring(k).charAt(0)+""+fun(ex.substring(k+2, indB)+"")+""+ex.substring(k+2).split("\\)", count3+1)[count3]);
                        
                        
                    }else{
                       
                        sum=fun(sum+""+ex.substring(k).charAt(0)+""+fun(ex.substring(k+2, indB)+""));
                    }
                   
                }else{
                    
                    
                    String ss=sum+""+ex.substring(k);
                    
                    if(ss.charAt(0)=='-'&& !ss.split("-").length>1 && !ss.contains("+")&& !ss.contains("*")&& !ss.contains("/")){
                        return sum;
                    }else{
                        sum=fun(ss);
                    }
                    
                    
                }
                
            }else{
                return sum;
            }
        }
        
        return sum;
    }
}


//String str="6*5/3+9-1+(8-2)/5*(3+(4-5)/2)-5"; == -1
//String str="-3-(4-5)/2"; == -1
//String str="-3-9/2"; == -6
//String str="3+2-(68*3/(3-7)*(5-6))-3/2";  ==  26
