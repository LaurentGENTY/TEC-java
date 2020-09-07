package tec;

class ArretPoli implements CaractereArret {

    public void choixPlaceArret(Vehicule v, int distanceDestination, Passager p) {
        /* Give his seat if there is no seat available */
        if(!v.aPlaceAssise() && v.aPlaceDebout())
            v.arretDemanderDebout(p);
        return;
    }

}
