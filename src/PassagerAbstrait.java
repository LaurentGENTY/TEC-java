package tec;

import java.lang.Math;
import tec.*;

abstract class PassagerAbstrait extends Passager implements Usager {

    private String nom;
    private static tec.Position maPosition;
    private final int destination;
    private CaractereArret ca;

    public PassagerAbstrait(String nom, int destination, CaractereArret ca){
        if(destination < 0)
            throw new IllegalArgumentException("PassagerAbstrait with negative destination");
        this.nom = nom;
        this.maPosition = tec.Position.initialise();
        this.destination = destination;
        this.ca = ca;
    }

    @Override
    String nom() {
        return nom;
    }

    @Override
    boolean estDehors() {
        return this.maPosition.estDehors();
    }

    @Override
    boolean estAssis() {
        return this.maPosition.estAssis();
    }

    @Override
    boolean estDebout() {
        return this.maPosition.estDebout();
    }

    @Override
    void changerEnDehors() {
        this.maPosition = Position.dehors();

    }

    @Override
    void changerEnAssis() {
        this.maPosition = Position.assis();

    }

    @Override
    void changerEnDebout() {
        this.maPosition = Position.debout();
    }

    @Override
    final public void monterDans(Transport t) throws TecException{
        assert (t instanceof Vehicule):"given parameter cannot be casted in Vehicule";
        Vehicule v = (Vehicule) t;
        try {
            choixPlaceMontee(v);
        } catch(IllegalStateException e) { throw new TecException(e); }
    }

    int distanceDest(int arret){
        return(Math.abs(this.destination-arret));
    }

    @Override
    void nouvelArret(Vehicule v, int numeroArret) {
        if (numeroArret == this.destination)
            v.arretDemanderSortie(this);
        ca.choixPlaceArret(v,this.distanceDest(numeroArret),this);
        /* We don't call arretDemanderDebout because this class is a PassengerStandard class which means the passenger
        doesn't want to look for a standing position if he is already sitting */
    }

    abstract void choixPlaceMontee(Vehicule v);


    @Override
    public String toString() {
        return "PassagerStandard{" +
                "nom='" + nom + '\'' +
                ", maPosition=" + maPosition +
                ", destination=" + destination +
                '}';
    }
}
