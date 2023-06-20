import java.util.HashMap;
import java.util.Map.Entry;

public class CashRegister implements Repairable {
    private HashMap<Float, Integer> money;

    private float[] bills;
    private boolean isActive;

    public boolean isActive() {
        return isActive;
    }

    public CashRegister() {
        money = new HashMap<Float, Integer>();
        setMoney();
        bills = new float[13];
        resetBills();
        isActive = true;
    }

    public void setMoney() {
        money.put(0.01f, 10);
        money.put(0.02f, 10);
        money.put(0.05f, 10);
        money.put(0.1f, 10);
        money.put(0.2f, 10);
        money.put(0.5f, 10);
        money.put(1.0f, 10);
        money.put(2.0f, 10);
        money.put(5.0f, 10);
        money.put(10.0f, 10);
        money.put(20.0f, 10);
        money.put(50.0f, 10);
        money.put(100.0f, 10);
    }

    private void resetBills() {
        bills[0] = 100.0f;
        bills[1] = 50.0f;
        bills[2] = 20.0f;
        bills[3] = 10.0f;
        bills[4] = 5.0f;
        bills[5] = 2.0f;
        bills[6] = 1.0f;
        bills[7] = 0.5f;
        bills[8] = 0.2f;
        bills[9] = 0.1f;
        bills[10] = 0.05f;
        bills[11] = 0.02f;
        bills[12] = 0.01f;
    }

    public void repair() {
        System.out.println("Kasa fiskalna jest naprawiana");
        isActive = true;
    }

    public void payForFuel(float amount, float enteredAmount) throws PaymentFailedException {
        if (!isPaymentSuccessful(enteredAmount - amount)) {
            throw new PaymentFailedException("Nie udało się zapłacić, musisz podać inną kwotę");
        }
        if (Utils.rand())
            destroy();
    }

    public boolean isPaymentSuccessful(float amount) {
        if (Utils.roundToTwoDigits(amount) == Utils.roundToTwoDigits(0.0f))
            return true;
        HashMap<Float, Integer> tempMoney = new HashMap<>(money);
        for (int i = 0; i < bills.length; i++) {
            while (money.get(bills[i]) > 0
                    && Utils.roundToTwoDigits(amount - bills[i]) >= Utils.roundToTwoDigits(0.0f)) {
                amount = Utils.roundToTwoDigits(amount - bills[i]);
                money.replace(bills[i], money.get(bills[i]) - 1);
            }
        }
        if (Utils.roundToTwoDigits(amount) != Utils.roundToTwoDigits(0.0f)) {
            money = new HashMap<>(tempMoney);
            return false;
        }

        return true;
    }

    public void print() {
        for (Entry<Float, Integer> m : money.entrySet()) {
            System.out.println("Rodzaj: " + m.getKey() + "zł, ilość w kasie: " + m.getValue());
        }
    }

    public String[] getCurrentMoneyStatus() {
        String[] array = new String[13];
        int i = 0;
        for (Entry<Float, Integer> m : money.entrySet()) {
            array[i] = "Rodzaj: " + m.getKey() + "zł, Ilość w kasie: " + m.getValue();
            i++;
        }
        return array;
    }

    public void destroy() {
        System.out.println("Kasa się popsuła.");
        isActive = false;
    }
}
