
/**
 * Cette classe représente la position d'un passager par rapport à un transport.
 * Une position a trois états possibles : assis dans un transport, 
 * debout dans un transport et dehors d'un transport.
 *
 * Les instances de cette classe sont des objets constants.
 *
 * @author Georgy
 * @since 2007-2019
 **/
package tec;
final class Position {


  private static final Position dehors = new Position();
  private static final Position assis = new Position();
  private static final Position debout = new Position();


  /**
   * construit une l'instance dans la position dehors.
   * 
   */
  private Position() { }

    /**
     * Cette fonction remplace l'instanciation de la classe Position.
     *
     * @return Retourne l'objet position dehors;
     */

    public static Position initialise(){
        return dehors;
    }

  /**
   * La position est-elle dehors ?
   *
   * @return vrai si l'état de l'instance est dehors;
   */
  public boolean estDehors() {
      return this == dehors;
  }


  /**
   * La position est-elle assis ?
   *
   * @return vrai si l'état de l'instance est assis;
   */
  public boolean estAssis() {
    return this == assis;

  }

  /**
   * La position est-elle debout ?
   *
   * @return vrai si l'état de l'instance est debout;
   */
  public boolean estDebout() {
    return this == debout;

  }

  /**
   * La position est-elle assis ou debout ?
   *
   * @return vrai la position est assis ou debout.
   */
  public boolean estInterieur() {

      return this != dehors;
  }


  /**
   * Retourne une instance de Position assis.
   *
   * @return instance dans l'état assis.
   */
  public static Position assis() {

      return assis;
  }

  /**
   * Retourne une instance de Position debout.
   *
   * @return instance dans l'état debout.
   */
  public static Position debout() {
    return debout;
  }

  /**
   * Retourne une instance de Position dehors.
   *
   * @return instance dans l'état dehors.
   */
  public static Position dehors() {

      return dehors;
  }

    /**
   * Cette méthode est héritée de la classe {@link java.lang.Object}.
   * Très utile pour le débogage, elle permet de fournir une 
   * chaîne de caractères correspondant à l'état d'un objet.
   * Mais, il faut adapter son code à chaque classe.
   */
  @Override
  public String toString() {
      String nom = null;
      if(this == dehors){
          nom = "endehors";
      }
      else if(this == assis) {
          nom = "assis";
      }
      else{
          nom = "debout";
      }
      return "<" + nom + ">";
  }
}

