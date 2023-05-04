package pet;

import java.util.ArrayList; //Completar várias coisas

public class HotelPet {
    ArrayList<Quarto> quartos = new ArrayList<Quarto>(null);
    ArrayList<Reserva> reservas = new ArrayList<Reserva>(null);
    
    Reserva reserva;
    private int i = -1;

    public void adicionarReserva(){ 
        if(reserva.isFull() == true){ 
            System.out.println("Infelizmente não conseguimos reservar, pois o hotel está cheio.");
        }else{ 
            i++;
            getReservas().add(i, reserva);;
        }
    }

    public void listarReserva(){ 
        for (Reserva r : reservas){ 
            System.out.println("Pet: "+r.getPet().getNome()+ " Tutor: "+r.getTutor().getNome()+" Quarto: "+r.getQuarto().getNumQuarto());
            System.out.println("Data de entrada: "+r.getCheckIn()+" Data de saída: "+r.getCheckOut());
        }
    }
    
    public void listarQuartosDisponiveis(){ 
        
    }

    public void calcularPrecoReserva(){  //Ainda colocar o return

    }

    public ArrayList<Quarto> getQuartos(){ 
        return quartos;
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
