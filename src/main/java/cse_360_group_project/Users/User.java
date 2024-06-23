package cse_360_group_project.Users;

import java.io.Serializable;

public abstract class User implements Serializable {

    private String username;
    private String password;
    private String address;
    private String telephone;
    private String cpf;
    private Integer age;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and Setters for the fields
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}