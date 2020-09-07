package tec;

class ArretAgoraphobe implements CaractereArret {

    public void choixPlaceArret(Vehicule v, int distanceDestination, Passager p) {
        /* Leave if there is no seat available */
        if(!v.aPlaceAssise() || !v.aPlaceDebout())
            v.arretDemanderSortie(p);
        return;
    }

}