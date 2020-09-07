package tec;

class TestJauge {

    // public void main(String[] args) {
    //
    //     int nbTest = 0;
    //
    //     System.out.println('.');nbTest++;
    //     new TestJauge().testDansIntervalle();
    //
    //     System.out.println('.');nbTest++;
    //     new TestJauge().testDepartSuperieurMax();
    //
    //     System.out.println('.');nbTest++;
    //     new TestJauge().testDepartNegatif();
    //
    //     System.out.println("\nOK : " + nbTest + " test scenarios for Jauge class\n");
    //
    // }

    public void testDansIntervalle() {
        Jauge j = new Jauge(7,2);

        //System.out.println("Test in interval [0,7[ with start = 2:\n");

        assert j.estVert() : "estVert() failed";
        assert !j.estRouge() : "!estRouge() failed";

        //System.out.println("estVert()   test : Success");
        //System.out.println("!estRouge() test : Success");

        j.incrementer();
        //System.out.println("\nincrementer()\n");

        assert j.estVert() : "estVert() failed";
        assert !j.estRouge() : "!estRouge() failed";

        //System.out.println("estVert()   test : Success");
        //System.out.println("!estRouge() test : Success");
    }

    public void testDepartSuperieurMax() {
        Jauge j = new Jauge(1,2);

        //System.out.println("Test in interval [0,1[ with start = 2 :\n");

        assert !j.estVert() : "!estVert() failed";
        assert j.estRouge() : "estRouge() failed";

        //System.out.println("!estVert() test : Success");
        //System.out.println("estRouge() test : Success");

        j.decrementer();
        //System.out.println("\ndecrementer()\n");

        assert !j.estVert() : "!estVert() failed";
        assert j.estRouge() : "estRouge() failed";

        //System.out.println("!estVert() test : Success");
        //System.out.println("estRouge() test : Success");
    }

    public void testDepartNegatif() {
        Jauge j = new Jauge(5,-1);

        //System.out.println("Test in interval [0,5[ with start = -1 :\n");

        assert !j.estRouge() : "!estRouge() failed ";
        assert !j.estVert() : "!estVert() failed ";

        //System.out.println("!estVert()  test : Success");
        //System.out.println("!estRouge() test : Success");

        j.incrementer();

        assert j.estVert() : "estVert() failed";
        assert !j.estRouge() : "!estRouge() failed";

        //System.out.println("estVert()   test : Success");
        //System.out.println("!estRouge() test : Success");
    }


}
