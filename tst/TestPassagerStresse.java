package tec;

class TestPassagerStresse extends TestPassagerAbstrait {

    // public void main() {
    //     super.main();
    //     System.out.println(" tec.PassagerStresse");
    // }


    @Override
    protected PassagerAbstrait creerPassager(String nom, int destination, CaractereArret ca) {
        return new MonteeRepos(nom, destination, CaractereArret.ArretPrudent);
    }

    @Override
    public void testInteractionMontee() {
        super.testInteractionMontee();

        assert "monteeDemanderAssis" == super.LogListMontee.elementAt(0) : "assis";
        assert "monteeDemanderDebout" == super.LogListMontee.elementAt(1) : "debout";
        assert "monteeDemanderAssis" == super.LogListMontee.elementAt(2) : "assis";
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

        /* On vérifie qu'une fois installé le passager ne rebouge plus. Il demande donc une seule place*/
        assert 1 == (int) super.LogListArret.elementAt(0) : "pas a destination";

        /* Il se lève avant 3 arrets destination */
        assert "arretDemanderDebout" == super.LogListArret.elementAt(2) : "assis";



    }

}
