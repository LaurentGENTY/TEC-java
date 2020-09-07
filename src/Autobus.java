package tec;

import java.lang.IllegalArgumentException;
import java.lang.IllegalStateException;
import java.util.*;

public class Autobus extends Vehicule implements Transport{
    private int numeroArret;
    private final Jauge jaugeDebout;
    private final Jauge jaugeAssis;
    private final ArrayList<Passager> passagers;

    public Autobus(int nbPlaceAssise, int nbPlaceDebout) throws IllegalArgumentException {
        if(nbPlaceAssise < 0)
            throw new IllegalArgumentException("Autobus with negative seating capacity");
        if(nbPlaceDebout < 0)
            throw new IllegalArgumentException("Autobus with negative standing capacity");

        numeroArret = 0;
        jaugeAssis = new Jauge(nbPlaceAssise, 0);
        jaugeDebout = new Jauge(nbPlaceDebout, 0);
        passagers = new ArrayList<Passager>() ;
    }

    int getNumeroArret() {
        return numeroArret;
    }


    public void allerArretSuivant(Vehicule v){
        numeroArret++;
        /*Nous avons pris le parti de faire un clonage. La copie est alors superficielle.
        Cela signifie donc que les éléments sont bien ceux de passagers et non chacun des copie de passagers.
        On peut donc les retirer de passagers. Nous avons pensé que cette méthode était la plus intuitive de toute et permettait donc
        une facilité de relecture accrue (même si son temps d'exécution est lui bien plus important que d'autre solution proposé)*/
        ArrayList<Passager> Pass = (ArrayList<Passager>) passagers.clone();
        for (Passager p: Pass) {
            p.nouvelArret(v, numeroArret);
        }
    }

    boolean aPlaceAssise(){
        return jaugeAssis.estVert();
    }

    boolean aPlaceDebout(){
        return jaugeDebout.estVert();
    }

    void monteeDemanderAssis(Passager p) throws IllegalStateException {
        if(passagers.contains(p))
            throw new IllegalStateException("Passager given in parameter already in the bus");

        jaugeAssis.incrementer();
        p.changerEnAssis();

        passagers.add(p);
    }

    void monteeDemanderDebout(Passager p) throws IllegalStateException {
        if(passagers.contains(p))
            throw new IllegalStateException("Passager given in parameter already in the bus");

        jaugeDebout.incrementer();
        p.changerEnDebout();

        passagers.add(p);
    }

    void arretDemanderDebout(Passager p){

        if (jaugeDebout.estRouge())
            return;

        p.changerEnDebout();
        jaugeDebout.incrementer();
        jaugeAssis.decrementer();
    }

    void arretDemanderAssis(Passager p){

        if (jaugeAssis.estRouge())
            return;

        p.changerEnAssis();
        jaugeAssis.incrementer();
        jaugeDebout.decrementer();
    }

    void arretDemanderSortie(Passager p){

        if (p.estDebout())
            jaugeDebout.decrementer();
        else
            jaugeAssis.decrementer();

        p.changerEnDehors();
        // Il faudrait théoriquement tester la valeur de retour
        // pour vérifier que le retrait du passager à bien eu lieu sans erreur.
        passagers.remove(p);
    }


    @Override
    public String toString() {
        return "Autobus{" +
                "numeroArret=" + numeroArret +
                ", jaugeDebout=" + jaugeDebout +
                ", jaugeAssis=" + jaugeAssis +
                ", passagers=" + passagers.toString() +
                '}';
    }
}