package pet;

public class Quarto {
    
    private int numQuarto = -1;
    private String tipoQuarto;
    private double precoBase;
    private boolean ocupado;
    Reserva reserva;
   
    public Quarto(String tipoQuarto){ 
        this.tipoQuarto = tipoQuarto;
        this.ocupado = false; // inicialmente o quarto está livre
        if(reserva.isFull() == false){ 
            numQuarto++;
        }
    }
    
    public void ocuparQuarto(){ 
        setOcupado(true);
    }
    public boolean isOcupado() {
            if (ocupado == true){ 
                return true;
            }
            return false;
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

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

}
