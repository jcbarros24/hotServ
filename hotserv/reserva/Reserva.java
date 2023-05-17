package hotserv.reserva;

import java.util.UUID;
import hotserv.pessoa.Tutor;
import hotserv.pet.Pet;

public class Reserva {
    
    private Pet pet;
    private Quarto quarto; 
    private Tutor tutor;
    private int tempo;
    private double preco;
    private UUID id;
    HotelPet hotelPet; 

    public Reserva(Pet pet,Quarto quarto,Tutor tutor,int tempo){
        this.id = UUID.randomUUID();
        this.pet = pet;
        this.quarto = quarto;
        this.tutor = tutor;
        this.tempo = tempo;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
    
    public int getTempo() {
            return tempo;
        }

    public void setTempo(int tempo) {
            this.tempo = tempo;
        }
    
    public double getPreco() {
            return preco;
        }

    public void setPreco(double preco) {
            this.preco = preco;
        }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    
}
