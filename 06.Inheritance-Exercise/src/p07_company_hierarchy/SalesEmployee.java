package p07_company_hierarchy;

import java.util.ArrayList;
import java.util.List;

class SalesEmployee extends Employee {

    private List<Sale> sales;

    SalesEmployee(int id, String firstName, String lastName, DepartmentType department) {
        super(id, firstName, lastName, department);
        this.sales = new ArrayList<>();
    }

    public List<Sale> getSales() {
        return this.sales;
    }
}