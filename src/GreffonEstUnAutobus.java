package tec;

/* est-un */
public class GreffonEstUnAutobus extends Autobus {

    private Collecte collecte;

    public GreffonEstUnAutobus(int nbPlaceAssise, int nbPlaceDebout, Collecte collecte) {
        super(nbPlaceAssise, nbPlaceDebout);
        this.collecte = collecte;
        collecte.initialise();
    }

    public void print_data(){
        this.collecte.print_data();
    }

    public Collecte getCollecte() {
        return collecte;
    }

    @Override
    public void allerArretSuivant() {
        super.allerArretSuivant();
        collecte.changerArret();
    }

    @Override
    public void arretDemanderSortie(Passager p) {
        super.arretDemanderSortie(p);

        if(p.estDehors())
            collecte.uneSortie();
    }

    @Override
    public void monteeDemanderAssis(Passager p) throws IllegalStateException {
        super.monteeDemanderAssis(p);

        /* S'il est rentre dans le bus */
        if(p.estAssis())
            collecte.uneEntree();
    }

    @Override
    public void monteeDemanderDebout(Passager p) throws IllegalStateException {
        super.monteeDemanderDebout(p);

        /* S'il est rentre dans le bus */
        if(p.estDebout())
            collecte.uneEntree();
    }
}