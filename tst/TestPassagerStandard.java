package tec;

class TestPassagerStandard extends TestPassagerAbstrait {

  // public void main() {
  //   super.main();
  //   System.out.println(" tec.PassagerStandard");
  // }


  @Override
  protected PassagerAbstrait creerPassager(String nom, int destination, CaractereArret ca) {
    return new MonteeRepos(nom, destination, ca);
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

    /*Ici on teste si le Passager standard a bien un seul log : l'appel à ArretDemanderDebout
      et il reste ensuite à la place où il est */
    assert 1 == (int) super.LogListArret.elementAt(0) : "pas a destination";

    /* Il ne change pas de position tout au long du trajet il reste donc assis */
    assert "arretDemanderAssis" == super.LogListArret.elementAt(2) : "assis";

  }

}
