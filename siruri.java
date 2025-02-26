// Scrieti un program in care se citesc de la tastatura ¸siruri de caractere pana la citirea
// sirului STOP. Sirurile citite se vor stoca ıntr-o colectie initiala de tip LinkedList ce
// poate contine duplicari. Creati o noua colectie de tip LinkedList ce va contine
// elementele colectiei initiale, dar fara duplicari. 
// Tipariti apoi ambele colectii.

import java.io.BufferedReader;
import java.util.LinkedList;
import java.io.*;

class Main{
    public static void main(String[] args) {
        LinkedList<String> siruri = new LinkedList<String>();
        String sir = "";
        try {
            BufferedReader in_stream_char = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Introduceti sirurile:");
            while((sir = in_stream_char.readLine()).equals("STOP") == false){
                siruri.add(sir);
            }
            
        } catch (IOException e) {
            System.out.println("Eroare la operatiile de intrare-iesire!");
            System.exit(1);
        }
        System.out.println(siruri);
        LinkedList<String> siruri_neduplicate = new LinkedList<String>();
        for(String s : siruri){
            if(! siruri_neduplicate.contains(s)){
                siruri_neduplicate.addLast(s);
            }
        }
        System.out.println(siruri_neduplicate);
    }
}
