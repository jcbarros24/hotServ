package hotserv.reserva;
import java.util.ArrayList; 
import java.util.UUID;

public class HotelPet {
    private static HotelPet instance;

    private HotelPet() {
    }

    public static HotelPet getInstance() {
        if (instance == null) {
            instance = new HotelPet();
        }
        return instance;
    }
    
    ArrayList<Quarto> quartosN = new ArrayList<Quarto>();
    ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    ArrayList<Quarto> quartosC = new ArrayList<Quarto>();
    Reserva reserva;
    Quarto quarto;

    public void adicionarReserva(Reserva reserva) {
       try {
        getReservas().add(reserva);
        reserva.getQuarto().ocuparQuarto();

        } catch(Exception e){ 
            System.out.println("Tivemos um erro em adicionar sua reserva. Entre em contato com nosso atendente");
        }
    }
    
    public void listarReserva(UUID id) {
        try {   
            for (int i = 0; i < reservas.size(); i++) {
                reserva = getReservas().get(i);
                if (reserva.getId().equals(id)) {
                    System.out.println("Reserva encontrada:");
                    System.out.println("Pet: " + reserva.getPet().getNome() +" Peso:  "+ reserva.getPet().getPeso() +" Idade:  " +reserva.getPet().getIdade()+ " Tamanho:  " + reserva.getPet().getTamanho()+". ");
                    System.out.println("Tutor: " + reserva.getTutor().getNome() +" CPF:  "+ reserva.getTutor().getCpf() +" Email:  " +reserva.getTutor().getEmail()+ " Telefone:  " + reserva.getTutor().getTelefone()+". ");
                    System.out.println("Num do quarto: "+reserva.getQuarto().getNumQuarto()+". ");
                    break;
                }
            }
        }catch (Exception e) {
             System.out.println("Ocorreu um erro ao listar a reserva. Entre em contato com nosso atendente." + e.getMessage());
        }
    }
    
    public void removerReserva(UUID id) {
        try{
            Reserva reservaRemovida = null;
            for (int i = 0; i < reservas.size(); i++) {
                reserva = getReservas().get(i);
                if (reserva.getId().equals(id)) {
                    reservaRemovida = reserva;
                    break;
                }
            }
            if (reservaRemovida != null) {
                quarto = reservaRemovida.getQuarto();
                quarto.desocuparQuarto();
                getReservas().remove(reservaRemovida);
                System.out.println("Reserva removida com sucesso!");
                         
            } else {
                System.out.println("Essa reserva com ID: " + id + " não existe no sistema.");
            }  
        } catch (Exception e){ 
            System.out.println("Tivemos um problema em remover a reserva. Entre em contato com nosso atendente");
        }
    }
    
    public Quarto getQuartoDisponivelC() {
        for (int i = 0; i < getQuartosC().size(); i++) {
            quarto = getQuartosC().get(i);
            if (quarto.isOcupado() == false) {
                return quarto;
            }
        }
        return null; // se não houver quarto disponível, retorna null
    }

    public Quarto getQuartoDisponivelN() {
        for (int i = 0; i < getQuartosN().size(); i++) {
            quarto = getQuartosN().get(i);
            if (quarto.isOcupado() == false) {
                return quarto;
            }
        }
        return null; // se não houver quarto disponível, retorna null
    }


    public void listarQuartosDisponiveis(){ 
        if(isFullquartosC() == true && isFullquartosN() == true){ 
            System.out.println("Infelizmente não temos quartos disponíveis");
            System.out.println("Entre em contato no e-mail do nosso chefe para mais informações sobre o hotel: ");
            System.out.println("RafaelRoque@unicap.br");
        }
        else if(isFullquartosC()== true && isFullquartosN() == false){ 
            System.out.println("Só possuímos quartos Normais ");
            System.out.println("Se quiser reserva-lo, crie sua reserva na opção 1 do menu.");
        }
        else if(isFullquartosC()== false && isFullquartosN() == true){ 
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

    public double calcularPrecoReserva(UUID id) {
        double preco = 0;
        try { 
            for (int i = 0; i < getQuartosN().size(); i++) {
                reserva = getReservas().get(i);
                if (reserva.getId().equals(id)) { 
                    quarto = reserva.getQuarto();
                    if (quarto.getTipoQuarto().equalsIgnoreCase("Confort")) {
                    quarto.setPrecoBase(150);
                    preco = quarto.getPrecoBase() + (30 * reserva.getTempo());
                    break;
                } else if (quarto.getTipoQuarto().equalsIgnoreCase("Normal")) {
                    quarto.setPrecoBase(100);
                    preco = quarto.getPrecoBase() + (20 * reserva.getTempo());
                    break;
                } else {
                    throw new IllegalArgumentException("O tipo de quarto: " + quarto.getTipoQuarto() + " não existe.");
                }
                }else{
                    System.out.println("Reserva não existente.");
                }   
            }
            
        } catch (IllegalArgumentException e1) {
            System.out.println(e1.getMessage());
        } catch (Exception e) {
            System.out.println("Não foi possível calcular o preço da reserva. Fale com o atendente");
        }
        return preco;
    }
    

    public boolean isEmptyN(){ 
        if(getQuartosN().size()== 0){
            return true;
        }
        return false;
    } 

    public boolean isEmptyC(){ 
        if(getQuartosC().size() == 0){ 
            return true;
        }
        return false;
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
