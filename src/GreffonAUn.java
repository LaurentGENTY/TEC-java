package tec;
import tec.*;

public class GreffonAUn extends Vehicule implements Transport{

    private Transport T;
    private Collecte collecte;

    public GreffonAUn(Transport transp, Collecte coll) {
        this.T = transp;
        this.collecte = coll;
        coll.initialise();
    }

    public Collecte getCollecte(){
        return this.collecte;
    }

    public void allerArretSuivant(){
        Vehicule V = (Vehicule) this.T;
        V.allerArretSuivant(this);

        collecte.changerArret();
    }

    public void allerArretSuivant(Vehicule g){
        Vehicule V = (Vehicule) this.T;
        V.allerArretSuivant(g);
        collecte.changerArret();
    }

    boolean aPlaceAssise(){
        Vehicule V = (Vehicule) this.T;
        return V.aPlaceAssise();
    }

    boolean aPlaceDebout(){
        Vehicule V = (Vehicule) this.T;
        return V.aPlaceDebout();
    }

    void monteeDemanderAssis(Passager p) throws IllegalStateException {
        Vehicule V = (Vehicule) this.T;
        V.monteeDemanderAssis(p);
        if(p.estAssis())
            collecte.uneEntree();
    }

    void monteeDemanderDebout(Passager p) throws IllegalStateException {
        Vehicule V = (Vehicule) this.T;
        V.monteeDemanderDebout(p);
        if(p.estDebout())
            collecte.uneEntree();

    }

    void arretDemanderDebout(Passager p){
        Vehicule V = (Vehicule) this.T;

        V.arretDemanderDebout(p);
    }

    void arretDemanderAssis(Passager p){
        Vehicule V = (Vehicule) this.T;

        V.arretDemanderAssis(p);
    }

    void arretDemanderSortie(Passager p){
        Vehicule V = (Vehicule) this.T;

        V.arretDemanderSortie(p);
        if(p.estDehors())
            collecte.uneSortie();
    }



}