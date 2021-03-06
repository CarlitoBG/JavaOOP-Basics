package p03_test_client;

public class BankAccount {
    private int id;
    private double balance;

    public void setId(int id){
        this.id = id;
    }

    public double getBalance(){
        return this.balance;
    }

    public void deposit(double amount){
        this.balance += amount;
    }

    public void withdraw(double amount){
        if (amount >= 0 && amount <= this.balance){
            this.balance -= amount;
        }else {
            System.out.println("Insufficient balance");
        }
    }

    @Override
    public String toString() {
        return String.format("Account ID%d, balance %.2f", this.id, this.balance);
    }
}