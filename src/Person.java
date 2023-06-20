public abstract class Person {
    private Dispenser curentDispenser;
    private String type;
    private String name;
    private String surname;

    public Person(String type) {
        this.type = type;
        name = "Tymczasowe imie";
        surname = "Tymczasowe nazwisko";
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setCurentDispenser(Dispenser curentDispenser) {
        this.curentDispenser = curentDispenser;
    }

    public Dispenser getCurentDispenser() {
        return curentDispenser;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
