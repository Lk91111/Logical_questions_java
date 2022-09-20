import java.lang.*;
import java.util.*;

public class MyClass {
    public static void main(String args[]) {
      int arr[] = {0,0,0,1,1,1,0,0,0,1,0};
      //int arr[] = {0,1,0,0,1};
      //int arr[] = {0,1,0,0,1,0,0,1,0,0,0};
      int a=1;
      
      System.out.println("Longest possible occurrence = "+fun(arr.length, a, arr));
    }
    
    public static int fun(int n, int a, int[] arr){
        int max0=1;
        int max1=0;
        int max=0;
        int tempMax=0;
        int maxi=0;
        
        String s="";
        String temp0="";
        String temp1="";
        
        List<String> lis= new ArrayList<>();
        
        String stringArr = Arrays.toString(arr); 
        
        //System.out.println("called for array = "+stringArr);
        
        if(a<1){
           // System.out.println("calling zero");
            max=zero(n,a,arr);
            return max;
        }else{
           // System.out.println("calling nozero");
            max=noZero(n,a,arr);
            return max;
        }
        
    }
    
    public static int zero(int n, int a, int[] arr){
        int max0=1;
        int max1=0;
        int max=0;
        int tempMax=0;
        int maxi=0;
        
        String s="";
        String temp0="";
        String temp1="";
        
        List<String> lis= new ArrayList<>();
        
        
            for(int i=0; i<n-1; i++){
                
                if(i==n-2){
                    s+=arr[i];
                    s+=arr[i+1];
                }else{
                    s+=arr[i];
                }
                
                if(arr[i]==arr[i+1]){
                    if(arr[i]==0){
                        max0++;
                    }else{
                        max1++;
                    }
                    
                }else{
                    if(arr[i]==0){
                        max1=1;
                    }else{
                        max0=1;
                    }
                }
                
                if(max0>max1 && max<max0 ){
                    max=max0;
                    maxi=i;
                }else if(max1>max0 && max<max1){
                    max=max1;
                    maxi=i;
                }
            }
            
            return max;
        
    }
    
    public static int noZero(int n, int a, int[] arr2){
        int max0=1;
        int max1=0;
        int max=0;
        int tempMax=0;
        int maxi=0;
        
        String s="";
        String temp0="";
        String temp1="";
        
        List<String> lis= new ArrayList<>();
        
            for(int i=0; i<n-1; i++){
                
                if(i==n-2){
                    s+=arr2[i];
                    s+=arr2[i+1];
                }else{
                    s+=arr2[i];
                }
                
                if(arr2[i]==arr2[i+1]){
                    if(arr2[i]==0){
                        max0++;
                    }else{
                        max1++;
                    }
                    
                }else{
                    if(arr2[i]==0){
                        max1=1;
                    }else{
                        max0=1;
                    }
                }
                
                if(max0>max1 && max<max0 ){
                    max=max0;
                    maxi=i;
                }else if(max1>max0 && max<max1){
                    max=max1;
                    maxi=i;
                }
            }
        
        
            tempMax=max;
            
            while(tempMax>0){
                temp0+="0";
                temp1+="1";
                tempMax--;
            }
            
            int index;
            
            if(s.indexOf(temp0)>-1 && s.indexOf(temp1)>-1){
                index = s.indexOf(temp0);
                while (index >= 0) {
                    //System.out.println(index);
                    lis.add(index+";0");
                    index = s.indexOf(temp0, index + 1);
                }
                
                index = s.indexOf(temp1);
                while (index >= 0) {
                    //System.out.println(index);
                    lis.add(index+";1");
                    index = s.indexOf(temp1, index + 1);
                }
            }else if(s.indexOf(temp1)>-1){
                index = s.indexOf(temp1);
                while (index >= 0) {
                    //System.out.println(index);
                    lis.add(index+";1");
                    index = s.indexOf(temp1, index + 1);
                }
            }else if(s.indexOf(temp0)>-1){
                index = s.indexOf(temp0);
                while (index >= 0) {
                    //System.out.println(index);
                    lis.add(index+";0");
                    index = s.indexOf(temp0, index + 1);
                }
            }
            
            int temm=max;
            
            
            for(int j=0; j<lis.size(); j++){
                // System.out.println("lis "+lis);
                // System.out.println("max "+max);
                
                String stringArr = Arrays.toString(arr2); 
        
                //System.out.println(" array = "+stringArr);
                int[] tempArr=arr2;
                
                String[] sp=lis.get(j).split(";");
                int start=Integer.parseInt(sp[0]);
                int end=Integer.parseInt(sp[0])+(temm-1);
                int val=Integer.parseInt(sp[1]);
                int newVal;
                int tem=0;
                int tem2=0;
                
                if(val==1){
                    newVal=1;
                }else{
                    newVal=0;
                }
                
                
                  //System.out.println("start = "+start);
                  //System.out.println("end = "+end);
                //  System.out.println("temp length = "+tempArr.length);
                
                if(start==0){
                    //System.out.println("check 11");
                    //System.out.println("if");
                    
                    if(end==(tempArr.length-1)){
                        tempArr[end]=newVal;
                    }else{
                        tempArr[end+1]=newVal;
                    }
                    
                    //System.out.println("check 11 putted "+newVal+" iteration "+j);
                    tem2=fun(n,a-1,tempArr);
                    
                    
                    if(newVal==0){
                        if(end==(tempArr.length-1)){
                            tempArr[end]=1;
                        }else{
                            tempArr[end+1]=1;
                        }
                    }else{
                        if(end==(tempArr.length-1)){
                            tempArr[end]=0;
                        }else{
                            tempArr[end+1]=0;
                        }
                    }
                    
                    
                    
                    if(tem2>max){
                        max=tem2;
                    }
                    
                    continue;
                    //return max;
                }else if(end==(s.length()-1)){
                    //System.out.println("check 12 putted "+newVal+" iteration "+j);
                    //System.out.println("else if");
                    
                    if(start==0){
                         tempArr[start]=newVal;
                    }else{
                         tempArr[start-1]=newVal;
                    }
                   
                    tem2=fun(n,a-1,tempArr);
                    
                    
                    if(newVal==0){
                        if(start==0){
                             tempArr[start]=1;
                        }else{
                             tempArr[start-1]=1;
                        }
                    }else{
                        if(start==0){
                             tempArr[start]=0;
                        }else{
                             tempArr[start-1]=0;
                        }
                    }
                    
                    if(tem2>max){
                        max=tem2;
                    }
                    continue;
                    //return max;
                }else{
                    //System.out.println("check 13 putted "+newVal+" iteration "+j);
                    //System.out.println("else");
                    
                    if(start==0){
                         tempArr[start]=newVal;
                    }else{
                         tempArr[start-1]=newVal;
                    }
                    tem2=fun(n,a-1,tempArr);
                    
                    if(newVal==0){
                        if(start==0){
                             tempArr[start]=1;
                        }else{
                             tempArr[start-1]=1;
                        }
                    }else{
                        if(start==0){
                             tempArr[start]=0;
                        }else{
                             tempArr[start-1]=0;
                        }
                    }
                    
                    if(end==(tempArr.length-1)){
                        tempArr[end]=newVal;
                    }else{
                        tempArr[end+1]=newVal;
                    }
                    tem=fun(n,a-1,tempArr);
                    
                    if(newVal==0){
                        if(end==(tempArr.length-1)){
                            tempArr[end]=1;
                        }else{
                            tempArr[end+1]=1;
                        }
                    }else{
                        if(end==(tempArr.length-1)){
                            tempArr[end]=0;
                        }else{
                            tempArr[end+1]=0;
                        }
                    }
                    
                    if(tem>max || tem2>max){
                        if(tem>tem2){
                            max=tem;
                        }else{
                            max=tem2;
                        }
                    }
                    
                    continue;
                    //return max;
                }
            }
            
            //System.out.println("lis = "+lis);
        
            return max;
    }
}


//0,1,0,0,1,0,0,1,0,0,0 = 6
//0,1,0,0,1 = 4
//0,0,0,1,1,1,0,0,0,1,0 = 5
