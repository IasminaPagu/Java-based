class Fisier{
    private String nume;
    private String continut;
    private static int instance_count = 0;
    public int id;
    // pentru a seta un id unic pentru fiecare fisier, logica este astfel:
    // luam un static int instance_count care se incrementeaza de fiecare data cand se creeaza un nou fisier
    // fiind un camp static => 
    // pentru fisier1 -- 1
    // pentru fisier2 -- 2, etc
    private Fisier versiune_anterioara;
    private static int numarConcatenari = 0;
    // avem un constructor care initializeaza campurile nume si continut in functie de preferinta utilizatorului
    // !! acestea sunt date furnizate de utilizator
    // id-ul este configurat ca fiind unic si logica acestuia este data de catre logica programatorului
    public Fisier(String nume, String continut){
        this.nume = nume;
        this.continut = continut;
        instance_count ++;
        this.id = instance_count;
        versiune_anterioara = null;

    }
    public void salveazaVersiune(){
        //creeaza un nou obiect fisier al carui nume este dat de numele fisierului pe care s a apelat metoda + bak
        // noul fisier este declarat ca versiune anterioara a fisierului curent, iar versiunea anterioara a noului fisier este data de versiunea anterioara a fisierului curent
        // acest lucru este necesar,deoarece pe un fisier pot exista modificari multiple, iar utilizatorii pot sa doreasca sa vada versiunea initiala si nu doar versiunea anteriora
        String nume_nou = this.nume + "bak";
        Fisier fisier_nou = new Fisier(nume_nou, this.continut);
        fisier_nou.versiune_anterioara = this.versiune_anterioara;
        this.versiune_anterioara = fisier_nou;
    }
    public void concateneaza(Fisier f){
        this.salveazaVersiune();
        String continut_nou = this.continut + f.continut;
        this.continut = continut_nou;
        numarConcatenari ++;
    }
    public String toString(){
        if(this.versiune_anterioara == null){
            return this.id + " " + this.nume + " " + this.continut;
        }else{
            return this.id + " " + this.nume + " " + this.continut + " <continut anterior " + this.versiune_anterioara.toString();
        }
    }
    public int getNumarConcatenari(){
        return numarConcatenari;
    }
}
class Main{
    public static void main(String[] args) {
        Fisier f1 = new Fisier("f1", "ana are mere");
        Fisier f2 = new Fisier("f2"," si pere");
        System.out.println(f1.toString());
        System.out.println(f2.toString());
        f1.concateneaza(f2);
        System.out.println(f1.toString());
        System.out.println(f2.toString());

        Fisier f3 = new Fisier("f3"," si portocale");
        System.out.println(f3.toString());
        f1.concateneaza(f3);
        System.out.println(f1.toString());
        System.out.println(f3.toString());

    }
}