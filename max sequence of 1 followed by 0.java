public class MyClass {
    public static void main(String args[]) {
      int[] arr={1,0,1,1,0,0,1,1,1,0,1,1};
      MyClass m= new MyClass();
      System.out.println(m.operation(arr));
    }
    
    public int operation(int[] arr){
        int index=arr.length;
        int count=0;
        int maxIndex=0;
        int maxCount=0;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]==0){
                index=i;
                count=0;
            }
            
            if((i>index)&&arr[i]==1){
                count++;
            }
            
            if(maxCount<count){
                maxCount=count;
                maxIndex=index;
            }
        }
        
        return maxIndex;
    }
}
