package dto;

public class UserDTO {
    private  String email;
    private  String password;

    public UserDTO() {

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
