package hotserv.pessoa;

public class Tutor {

    private String nome;
    private String cpf;
    private String email;  
    private String telefone;

<<<<<<< HEAD
    public Tutor(String nome, String cpf, String email, String telefone){ 
=======
    public Tutor(String nome,String cpf,String email,String telefone){ 
>>>>>>> 42fd37b36e17e5ddde5c0cea93b42beea12fae04
        this.nome = nome; 
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }
<<<<<<< HEAD

=======
    
>>>>>>> 42fd37b36e17e5ddde5c0cea93b42beea12fae04
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
