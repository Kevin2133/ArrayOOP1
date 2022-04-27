import java.util.*;
public class App {

    static int cercaContatto (String nome, String cognome, Contatti[] rubrica, int cont){
        for(int i = 0; i < cont; i++){
            if((rubrica[i].nome.equals(nome)&&(rubrica[i].cognome.equals(cognome)))){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        Contatti rubrica[] = new Contatti[1000];
        int cont = 0;
        int scelta;
        String nome, cognome, cellulare;
        int annoNascita;
        int annoCorrente, eta;
        int ind;
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("0. esci");
            System.out.println("1. Inserisci contatto");
            System.out.println("2. Visualizza contatti");
            System.out.println("3. Calcola eta di tutti i contatti");
            System.out.println("4. Eta di un contatto per nome e cognome");

            scelta = scanner.nextInt();
            scanner.nextLine();

            switch(scelta){
                case 0:
                    break;
                case 1:
                    if(cont < 1000){
                        System.out.println("Inserisci cognome:");
                        cognome = scanner.nextLine();
                        System.out.println("Inserisci nome:");
                        nome = scanner.nextLine();
                        System.out.println("Inserisci cellulare:");
                        cellulare = scanner.nextLine();
                        System.out.println("Inserisci anno di nascita:");
                        annoNascita = scanner.nextInt();
                        scanner.nextLine();

                        rubrica[cont] = new Contatti(cognome, nome, cellulare, annoNascita);
                        cont++;
                    }else{
                        System.out.println("L'array e' pieno");
                    }
                    break;
                case 2:
                    if(cont > 0){
                        for(int i = 0; i < cont; i++){
                            rubrica[i].visualizza();
                        }
                    }else{
                        System.out.println("Non ci sono elementi nell'array");
                    }
                    break;
                case 3:
                    if(cont > 0){
                        System.out.println("Inserisci l'anno corrente");
                        annoCorrente = scanner.nextInt();
                        scanner.nextLine();
                        for(int i = 0; i < cont; i++){
                            eta = rubrica[i].calcolaEta(annoCorrente);
                            System.out.println("Contatto numero= " + (i + 1) + ", Eta= " + eta);
                        }
                    }else{
                        System.out.println("Non ci sono elementi nell'array");
                    }
                    break;
                case 4:
                    if(cont > 0){
                        System.out.println("Inserisci cognome:");
                        cognome = scanner.nextLine();
                        System.out.println("Inserisci nome:");
                        nome = scanner.nextLine();

                        ind = cercaContatto(nome, cognome, rubrica, cont);

                        if(ind > -1){
                            System.out.println("Inserisci anno corrente");
                            annoCorrente = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Eta= " + rubrica[ind].calcolaEta(annoCorrente));
                        }else{
                            System.out.println("Contatto non trovato");
                        }
                    }else{
                        System.out.println("Non ci sono elementi nell'array");
                    }
                    break;
                default:
                    System.out.println("Scelta non prevista");                    
                    break;
            }
        }while(scelta != 0);
    }
}
