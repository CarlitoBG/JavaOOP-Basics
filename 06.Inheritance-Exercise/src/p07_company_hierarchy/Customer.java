package p07_company_hierarchy;

class Customer extends Person{

    private double totalAmountSpent;

    Customer(int id, String firstName, String lastName, double amount) {
        super(id, firstName, lastName);
        this.setTotalAmountSpent(amount);
    }

    public double getTotalAmountSpent() {
        return this.totalAmountSpent;
    }

    private void setTotalAmountSpent(double amount) {
        if (amount < 0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.totalAmountSpent = amount;
    }
}