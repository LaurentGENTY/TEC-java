package tec;
import java.util.*;
abstract class TestPassagerAbstrait {

    Vector LogListMontee = new Vector();
    Vector LogListArret = new Vector();

    // public void main() {
    //     int nbTest = 0;
    //     //************ Verifier l'instanciation *************
    //     System.out.print('.'); nbTest++;
    //     testInstanciation();
    //
    //     //********* Verifier changement d'etat **************
    //     System.out.print('.'); nbTest++;
    //     testGestionEtat();
    //
    //     //********* Verifier changement d'etat **************
    //     System.out.print('.'); nbTest++;
    //     testInteractionArret();
    //
    //     //********* Verifier changement d'etat **************
    //     System.out.print('.'); nbTest++;
    //     testInteractionMontee();
    //
    //     System.out.print("(" + nbTest + "):OK: ");
    // }

    //****************************************
    /* Methode qui sera implementée dans les classes tests filles
     * permettant de spécifier le type de passager utilise
     */
    abstract protected PassagerAbstrait creerPassager(String nom, int destination, CaractereArret ca);

    void testInstanciation(){
        PassagerAbstrait p = creerPassager("xxx", 3, CaractereArret.ArretCalme);

        assert false == p.estAssis();
        assert false == p.estDebout();
        assert true == p.estDehors();
    }

    void testGestionEtat(){
        PassagerAbstrait p = creerPassager("yyy", 3, CaractereArret.ArretCalme);

        p.changerEnDebout();
        assert false == p.estAssis();
        assert true == p.estDebout();
        assert false == p.estDehors();

        p.changerEnDehors();
        assert false == p.estAssis();
        assert false == p.estDebout();
        assert true == p.estDehors();

        p.changerEnAssis();
        assert true == p.estAssis();
        assert false == p.estDebout();
        assert false == p.estDehors();
    }

    void testInteractionMontee(){
        try {
            PassagerAbstrait p = creerPassager("zzz", 3, CaractereArret.ArretCalme);

            FauxTransport faux = new FauxTransport(FauxTransport.VIDE);
            p.monterDans(faux);
            this.LogListMontee.add(getLastLog(faux));

            faux = new FauxTransport(FauxTransport.DEBOUT);
            p.monterDans(faux);
            this.LogListMontee.add(getLastLog(faux));

            faux = new FauxTransport(FauxTransport.ASSIS);
            p.monterDans(faux);
            /*Ici on utilise un if. Cette méthode n'est pas optimale. En effet on redécoupe le code.
            Ce if est obligatoire car le passagerIndecis ne rentre pas dans le bus quand il n'y a pas de place debout, il n'y a donc pas
            d'appel à log. getLastLog agirait sur un index à -1 ce qui n'est pas possible.*/
            if(faux.logs.size()>0){
                this.LogListMontee.add(getLastLog(faux));
            } else{
                this.LogListMontee.add("Entreerefusee");
            }

            faux = new FauxTransport(FauxTransport.PLEIN);
            p.monterDans(faux);
            this.LogListMontee.add(faux.logs.size());
        } catch(TecException e) {System.out.println(e.getMessage());}
    }

    void testInteractionArret(){
        PassagerAbstrait p = creerPassager("aaa", 4, CaractereArret.ArretCalme);

        FauxTransport faux = new FauxTransport(FauxTransport.VIDE);
        p.changerEnDebout();
        faux.arretDemanderDebout(p); /*On décide ici simplement de commencer avec un passager debout*/
        p.nouvelArret(faux, 1);
        /*On garde en mémoire les potentiels changement de position.*/
        this.LogListArret.add(faux.logs.size());
        this.LogListArret.add(getLastLog(faux));
        faux.arretDemanderAssis(p);
        p.changerEnAssis();
        p.nouvelArret(faux,2);
        this.LogListArret.add(getLastLog(faux));

    }

    private String getLastLog(FauxTransport f) {
        return f.logs.get(f.logs.size() -1);
    }
}
