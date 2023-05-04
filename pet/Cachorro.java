package pet;

public class Cachorro extends Pet{

    private String raca;

   
    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String fazerBarulho() {
        return "AU AU";
    }
}
