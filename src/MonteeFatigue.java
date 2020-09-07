package tec;

class MonteeFatigue extends PassagerAbstrait {

    public MonteeFatigue(String nom, int destination, CaractereArret ca){
        super(nom,destination,ca);
    }

    @Override
    void choixPlaceMontee(Vehicule v) {
        if(v.aPlaceAssise())
            v.monteeDemanderAssis(this);
    }

}
