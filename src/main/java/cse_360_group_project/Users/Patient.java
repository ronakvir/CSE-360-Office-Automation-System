package cse_360_group_project.Users;

public class Patient extends User {


    private String address;
    private String telephone;
    private String email;
    private String age;
    private String gender;
    private String emergency_contact;
    private String emergency_contact_phone;
    private String emergency_contact_relation;
    private String firstname;
    private String lastname;
    private String phone;



    public Patient(String username, String password, String first_name, String lastname, String telephone, String email, String emergency_contact, String emergency_contact_relation, String age) {
        super(username, password);
        this.firstname = first_name;
        this.lastname = lastname;
        this.telephone = telephone;
        this.email = email;
        this.emergency_contact = emergency_contact;
        this.emergency_contact_relation = emergency_contact_relation;
        this.age = age;

    }

    @Override
    public String getDBPrefix() {
        return "patient#";
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getEmergency_contact() {
        return emergency_contact;
    }
    public void setEmergency_contact(String emergency_contact) {
        this.emergency_contact = emergency_contact;
    }
    public String getEmergency_contact_phone() {
        return emergency_contact_phone;
    }
    public void setEmergency_contact_phone(String emergency_contact_phone) {
        this.emergency_contact_phone = emergency_contact_phone;
    }
    public String getEmergency_contact_relation() {
        return emergency_contact_relation;
    }
    public void setEmergency_contact_relation(String emergency_contact_relation) {
        this.emergency_contact_relation = emergency_contact_relation;
    }

}
