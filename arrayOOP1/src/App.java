/**
 * 5. Primo cognome in ordine alfabetico
 * 6. Cognome piu' lungo
 * 7. Quanti cognomi ci sono che iniziano per A?
 * 8. Calcola eta media dei contatti
 * 9. Numero contatti con eta maggiore della media
 * 10. eta massima
 * 11. eta minima
 * 12. Contare quanti nomi contengono la stringa "anna"
 * 13. Prendere una stringa in input e contare quanti nomi contengono quella stringa
 * 14. Contare quanti cognomi finiscono con la lettera a
 */
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

    static int quantiCogPerSubs (Contatti[] rubrica, int at, String subsl, int cont){
        int k = 0;
        for(int i = 0; i < cont; i++){
            if(rubrica[i].cognome.substring(at, at + subsl.length()).toLowerCase().equals(subsl)){
                k++;
            }
        }

        return k;
    }

    static boolean searchSubs (String s, String subs){
        if(s.toLowerCase().indexOf(subs) > -1){
            return true;
        }

        return false;
    }

    static float mediaEta (Contatti[] rubrica, int cont, int annoCorrente){
        float media, somma = 0;
        int k = 0;
        
        for(int i = 0; i < cont; i++){
            if(rubrica[i].calcolaEta(annoCorrente) > -1)
                somma = somma + rubrica[i].calcolaEta(annoCorrente);
                k++;
        }

        media = somma / k;

        return media;
    }

    static int maxMinEta (Contatti[] rubrica, boolean max, int cont, int annoCorrente){
        int m;
        if(max){
            m = rubrica[0].calcolaEta(annoCorrente);
            for(int i = 0; i < cont; i++){
                if(rubrica[i].calcolaEta(annoCorrente) > m){
                    m = rubrica[i].calcolaEta(annoCorrente);
                }
            }
        }else{
            m = 200;
            for(int i = 0; i < cont; i++){
                if(rubrica[i].calcolaEta(annoCorrente) < m){
                    m = rubrica[i].calcolaEta(annoCorrente);
                }
            }
        }

        return m;
    }

    

    public static void main(String[] args) throws Exception {
        Contatti rubrica[] = new Contatti[1000];
        int cont = 0;
        int scelta;
        String nome, cognome, cellulare;
        int annoNascita;
        int annoCorrente, eta;
        int ind; String primoCog; float media;
        int maxEta, minEta;
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("0. esci");
            System.out.println("1. Inserisci contatto");
            System.out.println("2. Visualizza contatti");
            System.out.println("3. Calcola eta di tutti i contatti");
            System.out.println("4. Eta di un contatto per nome e cognome");
            System.out.println("5. Primo cognome ordine alfabetico");
            System.out.println("6. Cognome piu' lungo");
            System.out.println("7. Quanti cognomi con lettera A");
            System.out.println("8. Eta media contatti");
            System.out.println("9. Numero contatti con eta maggiore della media");
            System.out.println("10. Eta Max");
            System.out.println("11. Eta Min");
            System.out.println("12. Nomi che contengono la stringa \"anna\"");
            System.out.println("13. Nomi che contengono una stringa presa in input");
            System.out.println("14. Nomi che finiscono per \'a\'");
            System.out.println("15. Nomi che finiscono per consonante");

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
                case 5:
                    if(cont > 0){
                        primoCog = rubrica[0].cognome;
                        for(int i = 0; i < cont; i++){
                            if(rubrica[i].cognome.compareTo(primoCog) < 0){
                                primoCog = rubrica[i].cognome;
                            }
                        }

                        System.out.println("Primo cognome in ordine alfabetico= " + primoCog);
                    }else{
                        System.out.println("Non ci sono elementi nell'array");
                    }
                    break;
                case 6:
                    if(cont > 0){
                        primoCog = rubrica[0].cognome;
                        for(int i = 0; i < cont; i++){
                            if(rubrica[i].cognome.length() > primoCog.length()){
                                primoCog = rubrica[i].cognome;
                            }
                        }

                        System.out.println("Cognome piu' lungo= " + primoCog);
                    }else{
                        System.out.println("Non ci sono elementi nell'array");
                    }
                    break;
                case 7:
                    if(cont > 0){
                        int k = 0;
                        for(int i = 0; i < cont; i++){
                            //if(rubrica[i].cognome.substring(0, 1).toLowerCase().equals("a")){
                                //k++;
                            //}

                            if(rubrica[i].cognome.charAt(0) == 'A'){
                                k++;
                            }

                        }

                        System.out.println("Cognomi che iniziano con la a= " + k);
                    }else{
                        System.out.println("Non ci sono elementi nell'array");
                    }
                    break;
                case 71:
                    if(cont > 0){
                        int num;
                        num = quantiCogPerSubs(rubrica, 0, "a", cont);
                        
                        System.out.println("Cognomi che iniziano con la A= " + num);
                    }else{
                        System.out.println("Non ci sono elementi nell'array");
                    }
                    break;
                case 8:
                    if(cont > 0){

                        System.out.println("Inserisci anno corrente");
                        annoCorrente = scanner.nextInt();
                        scanner.nextLine();

                        media = mediaEta(rubrica, cont, annoCorrente);
                        System.out.println("Eta' media= " + media);                        
                    }else{
                        System.out.println("Non ci sono elementi nell'array");
                    }
                    break;
                case 9:
                    if(cont > 0){
                        int k = 0;

                        System.out.println("Inserisci anno corrente");
                        annoCorrente = scanner.nextInt();
                        scanner.nextLine();

                        media = mediaEta(rubrica, cont, annoCorrente);

                        for(int i = 0; i < cont; i++){
                            if(rubrica[i].calcolaEta(annoCorrente) > media){
                                k++;
                            }
                        }
                        
                        System.out.println("Contatti con Eta maggiore della media= " + k);
                    }else{
                        System.out.println("Non ci sono elementi nell'array");
                    }
                    break;
                case 10:
                    if(cont > 0){
                        System.out.println("Inserisci anno corrente");
                        annoCorrente = scanner.nextInt();
                        scanner.nextLine();

                        maxEta = maxMinEta(rubrica, true, cont, annoCorrente);

                        System.out.println("Eta max= " + maxEta);
                    }else{
                        System.out.println("Non ci sono elementi nell'array");
                    }
                    break;
                case 11:
                    if(cont > 0){
                        System.out.println("Inserisci anno corrente");
                        annoCorrente = scanner.nextInt();
                        scanner.nextLine();

                        minEta = maxMinEta(rubrica, false, cont, annoCorrente);

                        System.out.println("Eta min= " + minEta);
                    }else{
                        System.out.println("Non ci sono elementi nell'array");
                    }
                    break;
                case 12:
                    if(cont > 0){
                        int k = 0;
                        String subs = "anna";
                        for(int i = 0; i < cont; i++){
                            if(searchSubs(rubrica[i].nome, subs)){
                            k++;
                            }
                        }

                        System.out.println("Numero di nomi che contengono la stringa \"anna\"= " + k);
                    }else{
                        System.out.println("Non ci sono elementi nell'array");
                    }
                    break;
                case 13:
                if(cont > 0){
                    int k = 0;
                    String subs;

                    System.out.println("Inserisci una sottostringa");
                    subs = scanner.nextLine();

                    for(int i = 0; i < cont; i++){
                        if(searchSubs(rubrica[i].nome, subs)){
                        k++;
                        }
                    }

                    System.out.println("Numero di nomi che contengono la stringa \"" + subs + "\"= " + k);
                }else{
                    System.out.println("Non ci sono elementi nell'array");
                }
                    break;
                case 14:
                    if(cont > 0){
                        int k = 0;
                        char[] searchFor = {'a'};
                        for(int i = 0; i < cont; i++){
                            if(rubrica[i].nameEndsWith(searchFor)){
                                k++;
                            }
                        }

                        System.out.println("Contatti con nome che finisce per a= " + k);
                    }else{
                        System.out.println("Non ci sono elementi nell'array");
                    }
                    break;
                case 15:
                    if(cont > 0){
                        char[] vocali = {'a', 'e', 'i', 'o', 'u'};

                        int k = 0;

                        for(int i = 0; i < cont; i++){
                            if(!rubrica[i].nameEndsWith(vocali)){
                                k++;
                            }
                        }

                        System.out.println("Nomi che finiscono per consonante= " + k);
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
