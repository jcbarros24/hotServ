package hotserv.pet;

public class Gato extends Pet implements InterPet {

    @Override
    public String fazerBarulho() {
        return "Miau";
    }

    @Override
    public String comer(){ 
        return "Peixe";
    }

    @Override
    public String brincar(){ 
        return "Brincando com bolinhas de lã";
    }
}
