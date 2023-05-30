package hotserv.pet.Cachorro;

import hotserv.pet.InterPet;

public class CachorroP extends Cachorro implements InterPet{
    
    @Override
    public String fazerBarulho() {
        return "au au";
    }

    @Override
    public String comer(){
        return "Comendo Ração light";
    }
    
    @Override
    public String brincar(){
        return "brincando com a bolinha";
    } 
}
