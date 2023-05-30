package hotserv.pet.Cachorro;

import hotserv.pet.InterPet;

public class CachorroG extends Cachorro implements InterPet{
    
    @Override
    public String fazerBarulho() {
        return "AU AU";
    }

    @Override
    public String comer(){
        return "Ração grande";
    }
    
    @Override
    public String brincar(){
        return "Correndo atrás do osso";
    } 
}
