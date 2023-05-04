package pet;

public class Quarto {
    
    private int numQuarto;
    private String tipoQuarto;
    private double precoBase;
    private boolean ocupado;
   
    public Quarto(int numQuarto, String tipoQuarto, double precoBase, boolean ocupado){ 
        this.numQuarto = numQuarto;
        this.tipoQuarto = tipoQuarto;
        this.precoBase = precoBase;
        this.ocupado = ocupado;
    }
    
    public int getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(int numQuarto) {
        this.numQuarto = numQuarto;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(String tamanho) {
        this.tipoQuarto = tipoQuarto;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

}
