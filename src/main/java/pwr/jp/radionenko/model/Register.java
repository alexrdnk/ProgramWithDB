package pwr.jp.radionenko.model;

public class Register {

    private int id;
    private final String username;
    private final String password;
    private final String name;

    public Register(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}
