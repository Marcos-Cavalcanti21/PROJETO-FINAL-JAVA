package Model;

public class Funcionario {
    private String nome, pass, email;
    private int id;
    private boolean root;
    public Funcionario(){}

    public Funcionario(int id, String nome, String pass, String email, boolean root) {
        this.id = id;
        this.nome = nome;
        this.pass = pass;
        this.email = email;
        this.root = root;

    }


    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getPass() {return pass;}

    public void setPass(String pass) {this.pass = pass;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public boolean getRoot() {
        if (this.id == 1){
            root = true;
        }else{
            root = false;
        }

        return root;
    }

    public void setRoot(boolean root) {this.root = root;}
}
