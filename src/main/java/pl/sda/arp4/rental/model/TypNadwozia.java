package pl.sda.arp4.rental.model;

public enum TypNadwozia {
    SEDAN(800),
    SUV(1000),
    CABRIO(900);

    private final double cenaBazowa;

            TypNadwozia(double cenaBazowa){
        this.cenaBazowa = cenaBazowa;
            }
            public double getCenaBazowa(){
        return cenaBazowa;
            }
}
