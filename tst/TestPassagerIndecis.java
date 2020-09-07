package tec;

class TestPassagerIndecis extends TestPassagerAbstrait {

    // public void main() {
    //     super.main();
    //     System.out.println(" tec.PassagerIndecis");
    // }

    @Override
    protected PassagerAbstrait creerPassager(String nom, int destination, CaractereArret ca) {
        return new MonteeSportif(nom, destination, CaractereArret.ArretNerveux);
    }

    @Override
    public void testInteractionMontee() {
        super.testInteractionMontee();

        assert "monteeDemanderDebout" == super.LogListMontee.elementAt(0) : "debout";
        assert "monteeDemanderDebout" == super.LogListMontee.elementAt(1) : "debout";
        assert "Entreerefusee" == super.LogListMontee.elementAt(2) : "dehors";
        assert 0 == (int) super.LogListMontee.elementAt(3) : "pas de place";

    }

    /* Interaction à un arret
     * Deux cas
     *  - numero d'arret < à la destination
     *  - numero d'arret >= à la destination
     */
    @Override
    public void testInteractionArret() {
        super.testInteractionArret();
        //System.out.println(super.LogListArret.elementAt(0));
        /*Ici on teste si Le Passager indécis a bien deux logs : l'appel à ArretDemanderDebout
         et l'appel à nouvelArret qui le ferait s'assoir (il change de position à chaque arrêt) */
        assert 2 == (int) super.LogListArret.elementAt(0) : "pas a destination";

        /* On vérifie si le Passager à bien demander à changer dans l'autre position
        à savoir, on l'avait mis en position assis et il demande à être debout */
        assert "arretDemanderDebout" == super.LogListArret.elementAt(2) : "assis";


    }
}
