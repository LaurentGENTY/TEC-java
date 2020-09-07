package tec;

class TestArretPrudent {

  public void test(){
//    System.out.println(".");
//    System.out.print("tec.TestArretPrudent:");
try  {
       PassagerAbstrait p = new MonteeSportif("Sportif",7,CaractereArret.ArretPrudent);
       Transport u = new Autobus(4,3);

       p.monterDans(u);

       Vehicule x = (Vehicule) u;
       int i = 1;
       for(i = 1; i<5; i=i+1){
           p.nouvelArret(x,i);
           assert p.estAssis():"Debout";
       }
       for(i = 5;i<7;i=i+1){
           p.nouvelArret(x,i);
           assert p.estDebout():"Assis";
       }
       p.nouvelArret(x,i);
       assert p.estDehors():"Dedans";
       //System.out.println("SUCCESS");
   } catch(TecException e) {
       System.out.println(e.getMessage());
   }
  }
}
