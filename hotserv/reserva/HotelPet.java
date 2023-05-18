package hotserv.reserva;

import java.util.ArrayList; //Completar várias coisas
import java.util.UUID;

public class HotelPet {
    ArrayList<Quarto> quartosN = new ArrayList<Quarto>();
    ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    ArrayList<Quarto> quartosC = new ArrayList<Quarto>();
    Reserva reserva;
    Quarto quarto;

    public void adicionarReserva(Reserva reserva){ 
        if(isFull() == true){ 
            System.out.println("Infelizmente não conseguimos reservar, pois o hotel está cheio.");
        }
        else{ 
            reserva.getQuarto().ocuparQuarto();
            getReservas().add(reserva);
        }
    }
    
    public void listarReserva(UUID id){ 
        boolean encontrou = false;
        for (Reserva reserva : getReservas()){ 
            if(reserva.getId().equals(id)){ 
                encontrou = true;  
                System.out.println("Pet: "+reserva.getPet().getNome()+ " Tutor: "+reserva.getTutor().getNome()+" Quarto: "+reserva.getQuarto().getNumQuarto());
                break; //se achar sai do loop.
                }
            }
        if(encontrou == false){ 
            System.out.println("A reserva com o ID: " + id + " não foi encontrada.");
        }         
    }
   
    public void removerReserva(UUID id) {
        Reserva reservaRemovida = null;
        for (Reserva reserva : getReservas()) {
            if (reserva.getId().equals(id)) {
                reservaRemovida = reserva;
                break;
            }
        }
        if (reservaRemovida != null) {
            getReservas().remove(reservaRemovida);
            Quarto quarto = reservaRemovida.getQuarto();
            quarto.desocuparQuarto(); 
        } else{ 
            System.out.println("Essa reserva com ID: "+id+" Não existe no sistema.");
        }
    }

    public Quarto getQuartoDisponivelC() {
        for (Quarto quarto : getQuartosC()) {
            if (quarto.isOcupado() == false) {
                return quarto;
            }
        }
        return null; // se não houver quarto disponível, retorna null
    }

    public Quarto getQuartoDisponivelN() {
        for (Quarto quarto : getQuartosN()) {
            if (quarto.isOcupado() == false) {
                return quarto;
            }
        }
        return null; // se não houver quarto disponível, retorna null
    }

    public void listarQuartosDisponiveis(){ 
        if(getQuartoDisponivelC() == null && getQuartoDisponivelN() == null){ 
            System.out.println("Infelizmente não temos quartos disponíveis");
        }
        else if(getQuartoDisponivelC() == null && getQuartoDisponivelN() != null){ 
            System.out.println("Só possuímos quartos Normais: "+getQuartoDisponivelN());
        }
        else if(getQuartoDisponivelC() != null && getQuartoDisponivelN() == null){ 
            System.out.println("Só possuímos quartos Confort: "+getQuartoDisponivelC());
        }else { 
            System.out.println("Possuímos quartos Confort: "+getQuartoDisponivelC() +" E quartos Normais: "+getQuartoDisponivelN());
        }
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
        if (quarto.getTipoQuarto().equals("normal")) {
           reserva.setPreco(150 + (30 * reserva.getTempo())) ;
        }
        if (quarto.getTipoQuarto().equals("confort")) { 
           reserva.setPreco(100 + (20 * reserva.getTempo()));
        } 
    }

    public boolean isFullquartosN(){ 
        if(getQuartosN().size() == 30){ 
            return true;
        }
        return false;
    }

    public boolean isFullquartosC(){ 
        if(getQuartosC().size() == 20){ 
            return true;
        }
        return false;
    }

    public boolean isFull(){ 
        if (isFullquartosC() && isFullquartosN()){ 
            return true;
        }
        return false;
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

}
