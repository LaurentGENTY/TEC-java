package tec;

class MonteeTetu extends PassagerAbstrait {
    public MonteeTetu(String nom, int destination, CaractereArret ca){
        super(nom, destination,ca);
    }

    @Override
    void choixPlaceMontee(Vehicule v){
        v.monteeDemanderDebout(this);
    }
}
