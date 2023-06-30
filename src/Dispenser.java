import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Dispenser implements Repairable {

    private float currentFuel;
    private ReceiptPrinter receiptPrinter;
    private CashRegister cashRegister;
    public final static float maxFuel = 100.00f;
    private boolean isActive;
    private ArrayList<Payment> payments;

    public float getPricePerLitr() {
        return pricePerLitr;
    }

    private String type;
    private float pricePerLitr;

    public Dispenser(String type, String file) {
        receiptPrinter = new ReceiptPrinter();
        cashRegister = new CashRegister();
        isActive = true;
        currentFuel = maxFuel;
        this.type = type;
        payments = new ArrayList<Payment>();
        getPriceFromFile(file);
    }

    private void getPriceFromFile(String file) {
        try {
            FileReader fileReader = new FileReader(file);
            Scanner scanner = new Scanner(fileReader);
            pricePerLitr = scanner.nextFloat();
            scanner.close();
        } catch (FileNotFoundException e) {
            pricePerLitr = 7.61f;
        } catch (InputMismatchException e) {
            pricePerLitr = 7.61f;
        }
    }

    public ReceiptPrinter getReceiptPrinter() {
        return receiptPrinter;
    }

    public CashRegister getCashRegister() {
        return cashRegister;
    }

    public void checkActive()
            throws InActiveDispenserException, InActiveCashRegisterException, InActiveReciptPrinterException {
        if (!isActive) {
            throw new InActiveDispenserException("Dystrybutor jest zepsuty");
        }

        if (!cashRegister.isActive()) {
            throw new InActiveCashRegisterException("Kasa jest zepsuta");
        }

        if (!receiptPrinter.isActive()) {
            throw new InActiveReciptPrinterException("Drukarka paragonów jest zepsuta");
        }
    }

    public void tank(float fuel) {
        updateCurrentFuel(Utils.roundToTwoDigits(currentFuel - fuel));
        if (Utils.rand())
            destroy();
    }

    public void repair() {
        System.out.println("Dystrybutor jest naprawiany");
        isActive = true;
    }

    public boolean isActive() {
        return isActive;
    }

    public void refuel() {
        currentFuel = maxFuel;
    }

    public float getCurrentFuel() {
        return currentFuel;
    }

    public void updateCurrentFuel(float currentFuel) {
        this.currentFuel = currentFuel;
    }

    public void destroy() {
        System.out.println("Dystrybutor się popsuł");
        isActive = false;
    }

    public String getType() {
        return type;
    }

    public float getAmountToPay(float fuel) throws NotEnoughFuelException {
        if (fuel > maxFuel) {
            throw new NotEnoughFuelException("Próbujesz zatankować więcej paliwa niż jest w dystrybutorze");
        }
        return fuel * pricePerLitr;
    }

    public String toString() {
        return "W dystrybutorze obecnie znajduje się: " + currentFuel + " litrów paliwa, jest sprawny?: " + isActive
                + ", możesz zatankować: " + type + ", przy cenie za litr: "
                + pricePerLitr + "zł";
    }

    public void setPricePerLitr(float pricePerLitr) {
        this.pricePerLitr = pricePerLitr;
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }

}