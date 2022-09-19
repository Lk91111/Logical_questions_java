public class MyClass {
    public static void main(String args[]) {
      String s = "[7,2,[2,[6,4,8],4]]";
      
      System.out.println("NLR expression : "+fun(s));
      
      
    }
    
    public static String fun(String s){
        String fin ="";
        int count1=0, ind1=0;
        int count2=0, ind2=0;
        int c=0;
        
        if(s.charAt(0)=='[' && s.charAt(s.length()-1)==']'){
            s=s.substring(1,s.length()-1);
        }
        
        System.out.println("S = "+s);
        
        if(s.contains("[")){
            
            for(int i=0; i<s.length();i++){
                if(s.charAt(i)=='['){
                   
                    count1++;
                    if(count1==1){
                        ind1=i;
                    }
                    
                }else if(s.charAt(i)==']'){
                    
                    count2++;
                    ind2=i;
                    if(count1==count2){
                        
                        break;
                    }
                }else{
                    continue;
                }
            }
            
            if(ind1==0){
                //System.out.println("start ");
                c=0;
                if(s.substring(ind2+2,s.length()).split(",").length==2){
                    
                    s=s.substring(ind2+2,s.length()).split(",")[0]+";"+fun(s.substring(ind1+1,ind2))+";"+s.substring(ind2+2,s.length()).split(",")[1];
                }else{
                    
                    if(s.substring(ind2+2,s.length()).split(",").length>2){
                        
                        if(s.substring(ind2+2,s.length()).split(",")[1].contains("[")){
                            
                            s=s.substring(ind2+2,s.length()).split("\\[",2)[0].replace(",","")+";"+fun(s.substring(ind1+1,ind2))+";["+s.substring(ind2+2,s.length()).split("\\[",2)[1];
                        }else if(s.substring(ind2+2,s.length()).split(",")[0].contains("[")){
                            
                            if(s.substring(ind2+2,s.length()).split(",")[0].split("\\[").length>2){
                                
                               s="["+s.substring(ind2+2,s.length()).split("\\[",2)[1].split("\\]",2)[0]+"];"+fun(s.substring(ind1+1,ind2))+";["+s.substring(ind2+2,s.length()).split("\\[",2)[1].split("\\[",2)[1].split("\\]",2)[0]+"]"; 
                            }else{
                                
                                s="["+s.substring(ind2+2,s.length()).split("\\[",2)[1].split("\\]",2)[0]+"];"+fun(s.substring(ind1+1,ind2))+";"+s.substring(ind2+2,s.length()).split("\\]",2)[1].substring(1);
                            }
                            
                        }else{
                            
                            s=fun(s.substring(ind1+1,ind2))+";"+s.substring(ind2+2,s.length());
                        }
                        
                    }else{
                        
                        s=fun(s.substring(ind1+1,ind2))+";"+s.substring(ind2+2,s.length());
                    }
                    
                }
                
                //System.out.println("ss== "+s);
            }else if(ind2==s.length()-1){
                
                c=0;
                if(s.substring(0,ind1-1).split(",").length==2){
                    s=s.substring(0,ind1-1).split(",")[1]+";"+s.substring(0,ind1-1).split(",")[0]+";"+fun(s.substring(ind1+1,ind2));
                }else{
                    s=s.substring(0,ind1-1)+";"+fun(s.substring(ind1+1,ind2));
                }
                
            }else{
                //System.out.println("cc");
                s=fun(s.substring(ind1+1,ind2))+";"+s.substring(0,ind1-1)+";"+s.substring(ind2+2,s.length());
                //s="["+s+"]";
                c=1;
            }
            
            
            //System.out.println("new s= "+s);
            
            
            s=fun("["+s+"]");
            
        }else{
            
            if(s.contains("[")){
                //System.out.println("check4 if");
            }else{
                //System.out.println("check4 else");
                
                if(s.contains(";")){
                    
                    s=s.replaceAll(";",",");
                    
                }else{
                    String[] nlr= s.split(",");
                    s=nlr[1]+","+nlr[0]+","+nlr[2];
                }
                
            }
            
        }
        
        
        
        return s;
    }
}

//[1,2,3] = 2,1,3
//[1,2,[3,4,5]] = 2,1,4,3,5
//[1,2,[3,[4,5,6],7]] = 2,1,5,4,6,3,7
//[1,[2,3,4],7] = 
//[[1,2,3],4,5] = 4,2,1,3,5
//[[1,2,3],4,[5,6,7]] = 4,2,1,3,6,5,7
//[[1,2,3],[3,4,5],6] = 4,3,5,2,1,3,6
//[[1,2,3],[4,5,6],[8,9,2]] = 5,4,6,2,1,3,9,8,2

//[[3,5,6],2,[2,[6,4,8],4]] = 2,5,3,6,4,6,8,2,4
//[2,[3,5,6],[2,[6,4,8],4]] = 5,3,6,2,4,6,8,2,4
//[7,2,[2,[6,4,8],4]] = 2,7,4,6,8,2,4
