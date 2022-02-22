import java.util.*;
public class MyClass {
    public static void main(String args[]) {
      Map<Integer, String> m = new HashMap<>();
      m.put(1,"a");
      m.put(2,"b");
      m.put(3,"c");
      m.put(4,"d");
      
      
      Set<Integer> s= new LinkedHashSet<>(m.keySet());
      
      Iterator i = s.iterator();
      //System.out.println(s);
      int ind=0;
      
      while(i.hasNext()){
          ind=Integer.parseInt(i.next()+"");
          System.out.println("key "+ind+" has "+"value = "+m.get(ind));
      }
      
      
    }
    
    
    
    
}


//OUTPUT
// key 1 has value = a
// key 2 has value = b
// key 3 has value = c
// key 4 has value = d
