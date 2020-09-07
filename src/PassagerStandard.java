package tec;
import tec.*;

public class PassagerStandard implements Usager{

    private MonteeRepos PassagerStand;

    public PassagerStandard(String nom, int destination){
        PassagerStand = new MonteeRepos(nom,destination,CaractereArret.ArretCalme);
    }

    final public void monterDans(Transport t) throws TecException{
      PassagerStand.monterDans(t);
    }
}
