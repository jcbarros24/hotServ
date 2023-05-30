package hotserv.reserva;

import java.util.ArrayList; 
import java.util.NoSuchElementException;
import java.util.UUID;

public class HotelPet {
    ArrayList<Quarto> quartosN = new ArrayList<Quarto>();
    ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    ArrayList<Quarto> quartosC = new ArrayList<Quarto>();
    Reserva reserva;
    Quarto quarto;

    public void adicionarReserva(Reserva reserva) {
       try {
        if (isFull() == true) {
                System.out.println("Infelizmente não conseguimos reservar, pois o hotel está cheio.");
            } else {
                reserva.getQuarto().ocuparQuarto();
                getReservas().add(reserva);
            }
        } catch(Exception e){ 
            System.out.println("Tivemos um erro em adicionar sua reserva. Entre em contato com nosso atendente");
        }
    }
    
    public void listarReserva(UUID id) {
        try {
            for (Reserva reserva : getReservas()) {
                if (reserva.getId().equals(id)) {
                    System.out.println("Pet: " + reserva.getPet().getNome() + " Tutor: " + reserva.getTutor().getNome() + " Quarto: " + reserva.getQuarto().getNumQuarto());
                    break; // se achar sai do loop.
                }
            }
        } catch(NoSuchElementException e){ 
            System.out.println("Não existe o ID: "+id+" no nosso sistema.");
        }
        catch (Exception e) {
            System.out.println("Ocorreu um erro ao listar a reserva. Entre em contato com nosso atendente." + e.getMessage());
        }
    }
    
    public void removerReserva(UUID id) {
        try{
            Reserva reservaRemovida = null;
            for (Reserva reserva : getReservas()) {
                if (reserva.getId().equals(id)) {
                    reservaRemovida = reserva;
                    break;
                }
            }
            if (reservaRemovida != null) {
                getReservas().remove(reservaRemovida);
                quarto = reservaRemovida.getQuarto();
                quarto.desocuparQuarto();
            } else {
                System.out.println("Essa reserva com ID: " + id + " não existe no sistema.");
            }  
        } catch (Exception e){ 
            System.out.println("Tivemos um problema em remover a reserva. Entre em contato com nosso atendente");
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
            System.out.println("Entre em contato no e-mail do nosso chefe para mais informações sobre o hotel: ");
            System.out.println("RafaelRoque@unicap.br");
        }
        else if(getQuartoDisponivelC() == null && getQuartoDisponivelN() != null){ 
            System.out.println("Só possuímos quartos Normais ");
            System.out.println("Se quiser reserva-lo, crie sua reserva na opção 1 do menu.");
        }
        else if(getQuartoDisponivelC() != null && getQuartoDisponivelN() == null){ 
            System.out.println("Só possuímos quartos Confort ");
            System.out.println("Se quiser reserva-lo, crie sua reserva na opção 1 do menu.");
        }else { 
            System.out.println("Possuímos quartos Confort "+" E quartos Normais ");
            System.out.println("Se desejar algum, crie sua reserva na opção 1 do menu.");
        }
    }
    
    public void adicionarQuarto(Quarto quarto){ 
        if (quarto.getTipoQuarto().equalsIgnoreCase("Normal")) {
            getQuartosN().add(quarto); // adiciona o quarto à lista de quartos normais
        } else if (quarto.getTipoQuarto().equalsIgnoreCase("Confort")) {
            getQuartosC().add(quarto); // adiciona o quarto à lista de quartos confortáveis
        }
    }

    public void calcularPrecoReserva(){  
      try{
        if (quarto.getTipoQuarto().equalsIgnoreCase("Confort")) {
           reserva.setPreco(150 + (30 * reserva.getTempo())) ;
            }
        if (quarto.getTipoQuarto().equalsIgnoreCase("Normal")) { 
           reserva.setPreco(100 + (20 * reserva.getTempo()));
            } 
        } catch(IllegalArgumentException e){ 
            System.out.println("O tipo de quarto: "+quarto.getTipoQuarto()+" não existe.");
        }
        catch(Exception e){ 
            System.out.println("Não foi possível calcular o preço da reserva. Fale com o atendente");
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
