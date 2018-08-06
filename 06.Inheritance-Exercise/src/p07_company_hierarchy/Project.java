package p07_company_hierarchy;

import java.util.Date;

public class Project {

    private String name;
    private Date startDate;
    private String details;
    private String state;

    Project(String name, Date startDate, String details) {
        this.setName(name);
        this.setStartDate(startDate);
        this.setDetails(details);
        this.setState();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 3){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    private void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    private void setDetails(String details) {
        if (details == null || details.trim().isEmpty() || details.length() < 3){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.details = details;
    }

    public String getState() {
        return this.state;
    }

    private void setState() {
        this.state = "OPEN";
    }

    public void closeProject() {
        this.state = "CLOSED";
    }
}