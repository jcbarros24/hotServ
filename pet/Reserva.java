package pet;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Reserva {
    
    private Pet pet;
    private Quarto quarto; 
    private Tutor tutor;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

    public Reserva(Pet pet,Quarto quarto,Tutor tutor,LocalDateTime checkIn,LocalDateTime checkOut){
        this.pet = pet;
        this.quarto = quarto;
        this.tutor = tutor;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
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

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    HotelPet hotelPet = new HotelPet();
    ArrayList<Quarto> quartos = hotelPet.getQuartos();

    public boolean isFull(){ 
        if(quartos.size() == 50){ 
            return true;
        }
        return false;
    }

}
