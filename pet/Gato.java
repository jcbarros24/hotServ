package pet;

public class Gato extends Pet implements InterPet {

    public String fazerBarulho() {
        return "Miau";
    }
    public String comer(){ 
        return "Peixe";
    }
    public String brincar(){ 
        return "Brincar com bolinhas de lã";
    }
    
}
