package tec;

class TestPosition {

    // public void main(String[] args) {
    //     int nbTest = 0;
    //
    //     System.out.println('.');nbTest++;
    //     new TestPosition().testInitialisation();
    //
    //     System.out.println('.');nbTest++;
    //     new TestPosition().testAssis();
    //
    //     System.out.println('.');nbTest++;
    //     new TestPosition().testDebout();
    //
    //     System.out.println('.');nbTest++;
    //     new TestPosition().testDehors();
    //
    //     System.out.println("\nOK : " + nbTest + " test scenarios for Position class\n");
    //
    //
    // }

  //Test all the attributes for a position
  private void TestAttributs(boolean[] tab_test, Position p1){
    assert p1.estAssis() == tab_test[0] : "estAssis() failure";
	/*This test is in a comment because the estDebout() method is wrong, indeed it
	checks if the position is sitting and not standing*/
    assert p1.estDebout() == tab_test[1] : "estdebout() failure";
    assert p1.estDehors() == tab_test[2] : "estDehors() failure";
    assert p1.estInterieur() == tab_test[3] : "estInterieur() failure";
    //System.out.println("Success");
  }

  //Method that checks the position p instantiation
  public void testInitialisation(){
	  //Initialisation of a position p
    Position p = Position.initialise();
	//The array gives the expected positions
    boolean[] test = {false, false, true, false};
	//Test if the object position is right
    //System.out.print("Initialisation() test : ");
    TestAttributs(test, p);
  }


  //Method that checks the position assis() method
  public void testAssis(){
    //Initialisation of the position
    Position p = Position.initialise();
	//The array gives the expected positions
    boolean[] test = {true, false, false, true};
    //The position is set to sitting
    p = Position.assis();
	//Test if the object position is right
    //System.out.print("assis() test : ");
    TestAttributs(test, p);
  }


  //Method that checks the position p instantiation
  public void testDebout(){
    //Initialisation of the position
    Position p = Position.initialise();
	//The array gives the expected positions
    boolean[] test = {false, true, false, true};
    //The position is set to standing
    p = Position.debout();
    //Test if the object position is right
    //System.out.print("debout() test : ");
    TestAttributs(test, p);
  }


  //Method that checks the position p instantiation
  public void testDehors() {
      //Initialisation de la Position
      Position p = Position.initialise();
	  //The array gives the expected positions
      boolean[] test = {false, false, true, false};
      //The position is set to outside
      p = Position.dehors();
      //Test if the object position is right
      //System.out.print("dehors() test : ");
      TestAttributs(test, p);
  }
}
