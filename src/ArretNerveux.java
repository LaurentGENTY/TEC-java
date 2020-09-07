package tec;

class ArretNerveux implements CaractereArret {

    public void choixPlaceArret(Vehicule v, int distanceDestination, Passager p) {
        /* Change position every stop */
        if(p.estDebout() && v.aPlaceAssise())
            v.arretDemanderAssis(p);
        else if(p.estAssis() && v.aPlaceDebout())
            v.arretDemanderDebout(p);
        return;
    }

}