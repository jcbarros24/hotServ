package hotserv.reserva;

import java.util.ArrayList; //Completar várias coisas

import hotserv.pet.Pet;

import java.time.LocalDateTime;
import java.time.Duration;

public class HotelPet {
    ArrayList<Quarto> quartosN = new ArrayList<Quarto>(null);
    ArrayList<Reserva> reservas = new ArrayList<Reserva>(null);
    ArrayList<Quarto> quartosC = new ArrayList<Quarto>(null);
    Reserva reserva;
    Quarto quarto;
    Pet pet;
   
    private int i = -1;

    public void adicionarReserva(Reserva reserva){ 
        if(reserva.isFull() == true){ 
            System.out.println("Infelizmente não conseguimos reservar, pois o hotel está cheio.");
        }else{ 
            quarto.ocuparQuarto();
            i++;
            getReservas().add(i, reserva);
        }
    }
    
    public void listarReserva(int i){ 
        this.i = getI();
        if (i >=0 && i < reservas.size()){ 
            Reserva r = reservas.get(i);
            System.out.println("Pet: "+r.getPet().getNome()+ " Tutor: "+r.getTutor().getNome()+" Quarto: "+r.getQuarto().getNumQuarto());
            System.out.println("Data de entrada: "+r.getCheckIn()+" Data de saída: "+r.getCheckOut());
        }
    }
    
    public Quarto getQuartoDisponivelC() {
        for (Quarto quarto : getQuartosC()) {
            if (!quarto.isOcupado()) {
                return quarto;
            }
        }
        return null; // se não houver quarto disponível, retorna null
    }

    public Quarto getQuartoDisponivelN() {
        for (Quarto quarto : getQuartosN()) {
            if (!quarto.isOcupado()) {
                return quarto;
            }
        }
        return null; // se não houver quarto disponível, retorna null
    }

    public void listarQuartosDisponiveis(){ 
        
    }
    
    public void adicionarQuarto(Quarto quarto){ 
        if (quarto.getTipoQuarto().equals("normal")) {
            quarto.setPrecoBase(100); 
            quartosN.add(quarto); // adiciona o quarto à lista de quartos normais
        } else if (quarto.getTipoQuarto().equals("confort")) {
            quarto.setPrecoBase(150);
            quartosC.add(quarto); // adiciona o quarto à lista de quartos confortáveis
        }
    }

    public void calcularPrecoReserva(){  

        
    }

    public ArrayList<Quarto> getQuartosN(){ 
        return quartosN;
    }

    public ArrayList<Quarto> getQuartosC(){ 
        return quartosC;
    }

    public ArrayList<Reserva> getReservas(){ 
        return reservas;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

}
