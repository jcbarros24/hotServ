package hotserv.pet;

public class Cachorro extends Pet implements InterPet{

    public String fazerBarulho() {
        return "AU AU";
    }

    public String comer(){
        return "Ração";
    }
    
    public String brincar(){
        return "Jogar bolinha";
    } 
}
