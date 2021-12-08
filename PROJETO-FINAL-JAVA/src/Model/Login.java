package Model;

public class Login {
    private int Id;
    private String Login;
    private String Pass;

    public Login() {}

    public Login(int id, String login, String pass) {
        Id = id;
        Login = login;
        Pass = pass;
    }

    public int getId() {return Id;}

    public void setId(int id) {
        Id = id;
    }

    public Login(String login, String pass) {
        Login = login;
        Pass = pass;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }
}
