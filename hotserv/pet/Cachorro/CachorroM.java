package hotserv.pet.Cachorro;

import hotserv.pet.InterPet;

public class CachorroM extends Cachorro implements InterPet{
    
    @Override
    public String fazerBarulho() {
        return "AU au";
    }

    @Override
    public String comer(){
        return "Comendo Ração média";
    }
    
    @Override
    public String brincar(){
        return "Correndo no parque";
    } 
}
