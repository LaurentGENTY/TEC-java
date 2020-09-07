package tec;

class TestMonteeFatigue{

  public void test(){
    // System.out.println(".");
    // System.out.print("tec.TestMonteeFatigue: ");
    try {
        PassagerAbstrait p = new MonteeFatigue("Fatigue",5,CaractereArret.ArretCalme);
        //Premier autobus qui passe sans aucune place assise.
        Transport u = new Autobus(0,5);

        p.monterDans(u);

        assert p.estDehors(): "Dedans";
        //Deuxième autobus avec des places assises.
        Transport t = new Autobus(4,3);

        p.monterDans(t);

        assert p.estAssis():"Debout";
        //System.out.println("SUCCESS");
    } catch(TecException e) {
        System.out.println(e.getMessage());
    }
  }
}
