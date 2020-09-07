package tec;

class MonteeRepos extends PassagerAbstrait {

    public MonteeRepos(String nom, int destination, CaractereArret ca) {
        super(nom,destination,ca);
    }

    @Override
    void choixPlaceMontee(Vehicule v) {
        if(v.aPlaceAssise())
            v.monteeDemanderAssis(this);
        else if(v.aPlaceDebout())
            v.monteeDemanderDebout(this);
    }
}
