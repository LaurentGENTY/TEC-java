package tec;

class MonteeSportif extends PassagerAbstrait {

    public MonteeSportif(String nom, int destination, CaractereArret ca) {
        super(nom,destination,ca);
    }

    @Override
    void choixPlaceMontee(Vehicule v) {
        if(v.aPlaceDebout())
            v.monteeDemanderDebout(this);
    }
}
