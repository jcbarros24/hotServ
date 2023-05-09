package pet;

public abstract class Pet { 

    private String nome;
    private String porte;
    private int idade;
    private double peso;
    private double tamanho;
    private String raca;

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
        if(peso > 0 && peso <= 10){
            setPorte("Pequeno");
        }
        if(peso > 10 && peso <= 20){
            setPorte("Médio");
        }
        else if(peso > 20){ 
            setPorte("Grande");
        }
    }
}