package tec;

class ArretPrudent implements CaractereArret {

    public void choixPlaceArret(Vehicule v, int distanceDestination, Passager p) {
        /* Change position every stop */
        if(distanceDestination > 5) {
            if (p.estDebout() && v.aPlaceAssise())
                v.arretDemanderAssis(p);
        }
        else if(distanceDestination < 3) {
                if(p.estAssis() && v.aPlaceDebout())
                    v.arretDemanderDebout(p);
        }
        return;
    }

}