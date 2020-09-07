package tec;

import java.lang.IllegalArgumentException;
import java.lang.IllegalStateException;
import java.util.*;

public class Tramway extends Vehicule implements Transport{
    private int numeroArret;
    private final Jauge jaugeDebout;
    private final Jauge jaugeAssis;
    private final Passager[] passagers;

    public Tramway(int nbPlaceAssise, int nbPlaceDebout) throws IllegalArgumentException {
        if(nbPlaceAssise < 0)
            throw new IllegalArgumentException("Tramway with negative seating capacity");
        if(nbPlaceDebout < 0)
            throw new IllegalArgumentException("Tramway with negative standing capacity");

        numeroArret = 0;
        jaugeAssis = new Jauge(nbPlaceAssise, 0);
        jaugeDebout = new Jauge(nbPlaceDebout, 0);
        passagers = new Passager[nbPlaceAssise + nbPlaceDebout];
    }

    int getNumeroArret() {
        return numeroArret;
    }

    private int chercherEmplacementVide(){

        for (int i = 0 ; i < passagers.length ; i++){
            if (passagers[i] == null)
                return i;
        }
        return -1;
    }

    private int chercherPassager(Passager p){

        for (int i = 0 ; i < passagers.length ; i++){
            if (passagers[i] == p)
                return i;
        }
        return -1;
    }

    public void allerArretSuivant(Vehicule v){
        numeroArret++;
        /*Nous avons pris le parti de faire un clonage. La copie est alors superficielle.
        Cela signifie donc que les éléments sont bien ceux de passagers et non chacun des copie de passagers.
        On peut donc les retirer de passagers. Nous avons pensé que cette méthode était la plus intuitive de toute et permettait donc
        une facilité de relecture accrue (même si son temps d'exécution est lui bien plus important que d'autre solution proposé)*/
        for (int i = 0; i < passagers.length; i++) {
            if (passagers[i] != null)
                passagers[i].nouvelArret(v, numeroArret);
        }
    }

    boolean aPlaceAssise(){
        return jaugeAssis.estVert();
    }

    boolean aPlaceDebout(){
        return jaugeDebout.estVert();
    }

    void monteeDemanderAssis(Passager p) throws IllegalStateException {
        if(chercherPassager(p) != -1)
            throw new IllegalStateException("Passager given in parameter already in the bus");

        jaugeAssis.incrementer();
        p.changerEnAssis();

        passagers[chercherEmplacementVide()] = p;
    }

    void monteeDemanderDebout(Passager p) throws IllegalStateException {
        if(chercherPassager(p) != -1)
            throw new IllegalStateException("Passager given in parameter already in the bus");

        jaugeDebout.incrementer();
        p.changerEnDebout();

        passagers[chercherEmplacementVide()] = p;
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
        passagers[chercherPassager(p)] = null;
    }


    @Override
    public String toString() {
        return "Tramway{" +
                "numeroArret=" + numeroArret +
                ", jaugeDebout=" + jaugeDebout +
                ", jaugeAssis=" + jaugeAssis +
                ", passagers=" + java.util.Arrays.toString(passagers) +
                '}';
    }
}