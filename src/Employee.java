public class Employee extends Person {

    public Employee() {
        super("Pracownik");
    }

    public void repair(Repairable repairable) {
        repairable.repair();
    }
}
