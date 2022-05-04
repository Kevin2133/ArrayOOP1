public class Contatti {
    String cognome, nome, cellulare;
    int annoNascita;

    public Contatti (String cognome, String nome, String cellulare, int annoNascita){
        this.cognome = cognome;
        this.nome = nome;
        this.cellulare = cellulare;
        this.annoNascita = annoNascita;
    }

    int calcolaEta (int annoCorrente){
        if(this.annoNascita <= annoCorrente){
            return annoCorrente - this.annoNascita;
        }
        return -1;
    }

    void visualizza (){
        System.out.println("***********");
        System.out.println("Cognome= " + this.cognome);
        System.out.println("Nome= " + this.nome);
        System.out.println("Cellulare= " + this.cellulare);
        System.out.println("annoNascita= " + this.annoNascita);
        System.out.println("***********");        
    }

    boolean nameEndsWith(char[] c){
        for(int i = 0; i < c.length; i++){
            if(this.nome.toLowerCase().charAt(this.nome.length() - 1) == c[i]){
                return true;
            }
        }
        
        
        return false;        
    }
}
