public class Payment {
    private String name;
    private String surname;
    private String typeOfFuel;
    private float amountToPay;
    private float enterAmountToPay;
    private float rest;
    private float amountOfFuel;
    private int dispenserID;

    public Payment(String name, String surname, String typeOfFuel, float amountToPay, float enterAmountToPay,
            float rest, float amountOfFuel, int dispenserID) {
        this.name = name;
        this.surname = surname;
        this.typeOfFuel = typeOfFuel;
        this.amountToPay = amountToPay;
        this.enterAmountToPay = enterAmountToPay;
        this.rest = rest;
        this.amountOfFuel = amountOfFuel;
        this.dispenserID = dispenserID + 1;
    }

    @Override
    public String toString() {
        return "Imie: " + name + ", nazwisko: " + surname + ", paliwo o typie: " + typeOfFuel
                + ", należność: " + amountToPay + "zł, zapłacono: " + enterAmountToPay + "zł, reszta: " + rest
                + "zł, za ilość paliwa: " + amountOfFuel + " litrów, z dystrybutora: " + dispenserID;
    }

}
