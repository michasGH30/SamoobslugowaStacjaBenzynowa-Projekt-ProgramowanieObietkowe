public class ReceiptPrinter implements Repairable {
    private boolean isActive;
    private String name;
    private String surname;
    private String typeOfFuel;
    private float amountToPay;
    private float enterAmountToPay;
    private float rest;
    private float amountOfFuel;

    public ReceiptPrinter() {
        isActive = true;
        name = "";
        surname = "";
        typeOfFuel = "";
        amountToPay = 0.0f;
        enterAmountToPay = 0.0f;
        rest = 0.0f;
        amountOfFuel = 0.0f;
    }

    public float getAmountOfFuel() {
        return amountOfFuel;
    }

    public void setAmountOfFuel(float amountOfFuel) {
        this.amountOfFuel = amountOfFuel;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setTypeOfFuel(String typeOfFuel) {
        this.typeOfFuel = typeOfFuel;
    }

    public void setAmountToPay(float amountToPay) {
        this.amountToPay = amountToPay;
    }

    public void setEnterAmountToPay(float enterAmountToPay) {
        this.enterAmountToPay = enterAmountToPay;
    }

    public void setRest(float rest) {
        this.rest = rest;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getTypeOfFuel() {
        return typeOfFuel;
    }

    public float getAmountToPay() {
        return amountToPay;
    }

    public float getEnterAmountToPay() {
        return enterAmountToPay;
    }

    public float getRest() {
        return rest;
    }

    public boolean isActive() {
        return isActive;
    }

    public void repair() {
        System.out.println("Drukarka paragonów jest naprawiana");
        isActive = true;
    }

    public void destroy() {
        isActive = false;
    }

    public void printReceipt() {
        System.out.println("Imie: " + name + ", nazwisko: " + surname + ", paliwo o typie: " + typeOfFuel
                + ", należność: " + amountToPay + ", zapłacono: " + enterAmountToPay + ", reszta: " + rest
                + " za ilość paliwa: " + amountOfFuel);
        if (Utils.rand())
            destroy();
    }

}
