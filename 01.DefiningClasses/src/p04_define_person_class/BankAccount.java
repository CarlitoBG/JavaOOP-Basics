package p04_define_person_class;

public class BankAccount {

    private int id = 5;
    private double balance = 0.0;

    private BankAccount(int id) {
        this.id = id;
    }

    public BankAccount(int id, double balance) {
        this(id);
        this.balance = balance;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return this.balance;
    }
}