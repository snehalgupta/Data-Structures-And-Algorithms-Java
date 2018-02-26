package Hashmap;
import java.util.HashMap;
import java.util.Scanner;


    public class Main {

      public static void main(String[] argv) {
    	  Scanner sc=new Scanner(System.in);
    	  String s=new String(sc.next());
       HashMap<String, String> map = new HashMap<String, String>();
        map.put("1","one");
        map.put("2","two");
        map.put("3","three");
        map.put("4","four");
        String s1=(String)map.get("1");
        System.out.println(s1);
        System.out.println(getKeyFromValue(map,s));
        sc.close();
      }


//hm is the map you are trying to get value from it
      public static Object getKeyFromValue(HashMap<String, String> hm, Object value) {
        for (Object o : hm.keySet()) {
          if (hm.get(o).equals(value)) {
            return o;
          }
        }
        return null;
      }
    }
