import java.util.Scanner;
import java.util.UUID;
import hotserv.pet.*;
import hotserv.pet.Cachorro.Cachorro;
import hotserv.pessoa.*;
import hotserv.reserva.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HotelPet hotel = new HotelPet();
        int option = 0;
        Quarto qC = null;
        Quarto qN = null;  
        do {
            System.out.println(" ");
            System.out.println("-------- Hotel Pet Menu --------");
            System.out.println("1. Adicionar reserva");
            System.out.println("2. Remover reserva");
            System.out.println("3. Listar reserva");
            System.out.println("4. Quartos disponíveis: ");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            scanner.nextLine(); // Consume the newline character
                    while(hotel.isFullquartosC() == false){ 
                        qN = new Quarto("Confort");  // Cria todos os quartos Normais
                        hotel.adicionarQuarto(qN);  // Adiciona eles até o arrayList quartosNormais ficar cheio
                    }
                    while(hotel.isFullquartosN() == false){ 
                        qC = new Quarto("Normal");  // Cria todos os quartos Confort
                        hotel.adicionarQuarto(qC);  // Adiciona eles até o arrayList quartosConfort ficar cheio
                    }
            switch (option) {
                case 1:
                    System.out.println(" ");
                    System.out.println("---- Adicionar Reserva ----");
                    
                    System.out.print("Informe o nome do pet: ");
                    String petName = scanner.nextLine();
                    
                    System.out.print("Informe qual o seu pet (Gato / Cachorro): ");
                    String petType = scanner.nextLine();
                    while (!petType.equalsIgnoreCase("Cachorro") && !petType.equalsIgnoreCase("Gato")){ 
                        System.out.println("Informe um tipo de pet válido: ");
                        petType= scanner.nextLine();
                        if(petType.equalsIgnoreCase("Cachorro") || petType.equalsIgnoreCase("Gato")){
                            break;
                        }
                    }
                    System.out.print("Informe a idade do pet(Em anos): ");
                    int petAge = scanner.nextInt();
                    
                    System.out.print("Informe o Tamanho do pet em CM: ");
                    Double petHeight = scanner.nextDouble();
                     
                    System.out.print("Informe o peso do pet(Em kg): ");
                    double petWeight = scanner.nextDouble();
                    //scanner.nextLine(); // Consume the newline character
                    
                    Pet pet;
                    if (petType.equalsIgnoreCase("Gato")) {
                        Gato gato = new Gato();
                        pet = gato;
                        
                    } else {
                        Cachorro cachorro = new Cachorro();
                        System.out.print("Informe a raça do cachorro: ");
                        String dogBreed = scanner.nextLine();
                        cachorro.setRaca(dogBreed);
                        pet = cachorro;
                    } 
                    pet.setNome(petName);
                    pet.setIdade(petAge);
                    pet.setPeso(petWeight);
                    pet.setTamanho(petHeight);
                    
                    Quarto room = null;   
                    String roomType = scanner.nextLine();
                    int opcaoL = 0;

                    do {
                        System.out.println(" ");
                        System.out.print("Informe o tipo de quarto (Normal/Confort): ");
                        roomType = scanner.nextLine();
                        if (roomType.equalsIgnoreCase("Normal")) {
                            room = hotel.getQuartoDisponivelN();
                            if (room == null) {
                                System.out.println("Não há quartos normais disponíveis.");
                                System.out.println("Se deseja um quarto confort, Digite 1 novamente na pergunta. Se não quiser, digite 2 para Sair: ");
                                int verify = scanner.nextInt();
                                if (verify == 1) {
                                    opcaoL = 1;
                                } else if (verify == 2) {
                                    option = 5;
                                    break;
                                }
                            } else {
                                room.setTipoQuarto("Normal");
                                room = qN;
                            }
                        } else if (roomType.equalsIgnoreCase("Confort")) {
                            room = hotel.getQuartoDisponivelC();
                            if (room == null) {
                                System.out.println("Não há quartos confort disponíveis.");
                                System.out.println("Se deseja um quarto Normal, Digite 1 novamente na pergunta. Se não quiser, digite 2 para Sair: ");
                                int verify = scanner.nextInt();
                                if (verify == 1) {
                                    opcaoL = 1;
                                } else if (verify == 2) {
                                    option = 5;
                                    break;
                                }
                            } else {
                                room.setTipoQuarto("Confort");
                                room = qC;
                            }
                        } else {
                            System.out.println("Tipo de quarto inválido.");
                            System.out.println("Digite um tipo de quarto válido.");
                        }
                    } while ((!roomType.equalsIgnoreCase("Normal")) && (!roomType.equalsIgnoreCase("Confort")) || opcaoL == 1);

                    System.out.print("Informe o nome do tutor: ");
                    String tutorName = scanner.nextLine();
                    
                    System.out.print("Informe o e-mail do tutor: ");
                    String tutorEmail = scanner.nextLine();
                    
                    System.out.print("Informe o CPF do tutor(Só com números consecutivos): ");
                    String tutorCpf = scanner.nextLine();

                    System.out.print("Informe o telefone do tutor: ");
                    String tutorPhone = scanner.nextLine();
                    
                    Tutor tutor = new TutorBuilder()  // Utilizando o padrão Builder.
                    .withName(tutorName)
                    .withCpf(tutorCpf)
                    .withEmail(tutorEmail)
                    .withTelefone(tutorPhone)
                    .build();
                    
                    System.out.print("Informe o tempo de hospedagem (Em dias): ");
                    int stayDuration = scanner.nextInt();
                    
                    Reserva reservaL = new Reserva(pet, room, tutor, stayDuration);
                    hotel.adicionarReserva(reservaL);
                    System.out.println("Reserva adicionada com sucesso!");
                    System.out.println("Seu ID de reserva é: "+reservaL.getId());
                    break;
                
                case 2:
                    System.out.println("---- Remover Reserva ----");
                    System.out.print("Informe o número da reserva: ");
                try{
                    UUID reservaId2 = UUID.fromString(scanner.nextLine());
                    System.out.println("O preço da estádia foi de: ");
                    hotel.calcularPrecoReserva();//Pegar o dinheiro
                    hotel.removerReserva(reservaId2);
                } catch(IllegalArgumentException e){
                    System.out.println(" ");
                    System.out.println(" Número de reserva inválido. Caso não possua uma reserva você pode criar na opção 1 do nosso menu.");
                    System.out.println(" Caso possua, você pode ter escrito de forma errada. Digite 2 no menu e repita o ID da reserva.");
                    System.out.println(" Lembre-se de colocar no padrão imposto no ID da reserva: xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx com os hífens ( - ) nos devidos lugares.");
                    System.out.println(" ");
                }
        
                    break;
                
                case 3:
                    System.out.println("---- Listar Reservas ----");
                    System.out.println("Iforme o número da sua reserva: ");
                try{
                    UUID reservaId = UUID.fromString(scanner.nextLine());
                    hotel.listarReserva(reservaId);
                } catch(IllegalArgumentException e){ 
                    System.out.println(" ");
                    System.out.println(" Número de reserva inválido. Caso não possua uma reserva você pode criar na opção 1 do nosso menu.");
                    System.out.println(" Caso possua, você pode ter escrito de forma errada. Digite 3 no menu e repita o ID da reserva.");
                    System.out.println(" Lembre-se de colocar no padrão imposto no ID da reserva: xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx com os hífens ( - ) nos devidos lugares.");
                    System.out.println(" ");
                }
                break;

                case 4:
                    System.out.println("---- Quartos Disponíveis ----");
                    hotel.listarQuartosDisponiveis();

                    break;

                case 5:
                    System.out.println("Encerrando o programa...");
                    break;
      
                case 6: 
                  
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }

            System.out.println();
        } while (option != 5);

        scanner.close();
    }
}

