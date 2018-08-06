package p03_mankind;

public class Worker extends Human{

    private double weekSalary;
    private double workHoursPerDay;

    Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.length() < 3){
            throw new IllegalArgumentException(ExceptionMessages.WORKER_NAME_ERROR);
        }
        super.setLastName(lastName);
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary < 10){
            throw new IllegalArgumentException(ExceptionMessages.SALARY_ERROR);
        }
        this.weekSalary = weekSalary;
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12){
            throw new IllegalArgumentException(ExceptionMessages.WORKING_HOURS_ERROR);
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    private double salaryPerHour(){
        return this.weekSalary / (this.workHoursPerDay * 7);
    }

    @Override
    public String toString() {
        return String.format("First name: %s%nLast Name: %s%nWeek Salary: %.2f%nHours per day: %.2f%nSalary per hour: %.2f",
                super.getFirstName(), super.getLastName(), this.weekSalary, this.workHoursPerDay, this.salaryPerHour());
    }
}