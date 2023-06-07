package hotserv.pet.Cachorro;

public class CachorroFactory {
   
        public Cachorro criarPet(String tipo) {
            if (tipo.equalsIgnoreCase("Maltes")) {
                return new CachorroP(); //P
            }else if (tipo.equalsIgnoreCase("Shi tzu")) {
                return new CachorroP(); //P
            }else if (tipo.equalsIgnoreCase("Pomeranian")) { 
                return new CachorroP(); //P
            }else if (tipo.equalsIgnoreCase("Yorkshire")) { 
                return new CachorroP(); //P
            }else if (tipo.equalsIgnoreCase("Bulldog frances")) { 
                return new CachorroM(); //M
            }else if (tipo.equalsIgnoreCase("Border Collie")) { 
                return new CachorroM(); //M
            }else if (tipo.equalsIgnoreCase("Cocker Spaniel")) { 
                return new CachorroM(); //M
            }else if (tipo.equalsIgnoreCase("Labrador")) { 
                return new CachorroG(); //G
            }else if (tipo.equalsIgnoreCase("Rottweiler")) { 
                return new CachorroG(); //G
            }else if (tipo.equalsIgnoreCase("Golden retriever")) { 
                return new CachorroG(); //G
            } 
            else {
                return new Cachorro();
            }
        }
    }
