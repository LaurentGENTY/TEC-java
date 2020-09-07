package tec;
import tec.*;

public class PassagerStresse implements Usager{

    private MonteeRepos PassagerStress;

    public PassagerStresse(String nom, int destination){
        PassagerStress = new MonteeRepos(nom,destination,CaractereArret.ArretPrudent);
    }

    final public void monterDans(Transport t) throws TecException{
      PassagerStress.monterDans(t);
    }
}
