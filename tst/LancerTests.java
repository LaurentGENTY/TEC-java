package tec;
import java.lang.reflect.*;
import java.lang.Class.*;

class LancerTests {

  static private void lancer(Class c) throws Exception{
    Method[] M = c.getMethods();
    int l = 0;
    for(int i = 0; i < M.length;i++){
        if(M[i].toString().startsWith("public void tec")){
            M[i].invoke(c.newInstance());
            System.out.print(".");
            l++;
        }
    }
    System.out.println(" OK: " + l + "tests valides");
  }

  static public void main(String[] args) throws Exception{
    boolean estMisAssertion = false;
    assert estMisAssertion = true;
    if (!estMisAssertion) {
        System.out.println("Execution impossible sans l'option -ea");
        //return 1;
    }
    for(int i = 0; i < args.length;i++){
      Class c = Class.forName(args[i]);
      System.out.print(args[i] + " : ");
      lancer(c);
    }
    //return 0;
  }
}
