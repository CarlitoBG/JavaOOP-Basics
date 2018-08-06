package p09_google;

public class Children {

    private String name;
    private String birthday;

    Children(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.birthday);
    }
}