package tec;

interface CaractereArret {
  static final CaractereArret ArretCalme = new ArretCalme();
  static final CaractereArret ArretNerveux = new ArretNerveux();
  static final CaractereArret ArretAgoraphobe = new ArretAgoraphobe();
  static final CaractereArret ArretPrudent = new ArretPrudent();
  static final CaractereArret ArretPoli = new ArretPoli();

      void choixPlaceArret(Vehicule v, int distanceDestination, Passager p);

}
