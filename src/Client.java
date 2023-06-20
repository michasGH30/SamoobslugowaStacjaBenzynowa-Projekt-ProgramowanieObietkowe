public class Client extends Person {

    public Client() {
        super("Klient");
    }

    public void tank(float fuel) {
        getCurentDispenser().tank(fuel);
    }

}
