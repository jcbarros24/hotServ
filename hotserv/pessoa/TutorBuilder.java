package hotserv.pessoa;

public class TutorBuilder {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    
    public TutorBuilder() {
    }
    
    public TutorBuilder withName(String nome) {
        this.nome = nome;
        return this;
    }
    
    public TutorBuilder withCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }
    
    public TutorBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public TutorBuilder withTelefone(String telefone){
        this.telefone = telefone;
        return this;
    }
    
    public Tutor build() {
        return new Tutor(nome, cpf, email, telefone);
    }
}
