package tec;
import tec.*;

public class PassagerIndecis implements Usager{

    private MonteeSportif PassagerInde;

    public PassagerIndecis(String nom, int destination){
        PassagerInde = new MonteeSportif(nom,destination,CaractereArret.ArretNerveux);
    }

    final public void monterDans(Transport t) throws TecException{
      PassagerInde.monterDans(t);
    }
}
