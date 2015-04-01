package ie.dit.android.dit;

import java.io.Serializable;

public class Contacts implements Serializable{

    private static final long serialVersionUID = 5L;

    private String name;
    private String department;
    private String email;
    private String location;
    private String phoneNo;


    public Contacts(String name, String department, String email, String location, String phoneNo) {
        this.name = name;
        this.department = department;
        this.email = email;
        this.location = location;
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }

}
