

class Tren{
    Vagon[] vagoane = new Vagon[15];
    private static final int nr_maxim_vagoane = 15;
    private int nrVagoane = 0;

    public Tren(Vagon[] v){
        int dim = 0;
        if(nr_maxim_vagoane < v.length){
            dim = nr_maxim_vagoane;
        }else{
            dim = v.length;
        }
        for(int i = 0 ; i < dim ; i ++){
            this.vagoane[i] = v[i];
            nrVagoane ++;
        }
    }
    public int getNrVagoane(){
        return this.nrVagoane;
    }
    // sa se implementeze o metoda pentru determinarea egalitatii dintre
    // 2 trenuri, presupunandu-se ca 2 trenuri sunt egale
    // daca pot transporta acelasi nr de colete
    public boolean equals(Object t){
        int nrColete1 = 0,nrColete2 = 0;
        if(t instanceof Tren){
            for(int i = 0;i<((Tren)t).getNrVagoane();i++){
                nrColete1 = nrColete1 + ((Tren)t).vagoane[i].getNrColete();
            }
        }else{
            return false;
        }
        for(int i = 0;i<this.getNrVagoane();i++){
            nrColete2 = nrColete2 + this.vagoane[i].getNrColete();
        }
        if(nrColete1 == nrColete2){
            return true;
        }else{
            return false;
        }
    }
    public void afisareTipuriVagoane(){
        for(int i = 0;i<this.nrVagoane;i++){
            this.vagoane[i].afiseazaTip();
        }
    }
}
abstract class Vagon{
    protected int nrColete;

    public Vagon(int nrColete){
        this.nrColete = nrColete;
    }
    public int getNrColete(){
        return nrColete;
    }
    
    public abstract void afiseazaTip();
}
abstract class VagonCalatori extends Vagon{
    protected int capacitate;

    public VagonCalatori(int capacitate, int nrColete){
        super(nrColete);
        this.capacitate = capacitate;
    }
    public abstract void deschidere();
    public abstract void inchidere();
}
class CalatoriA extends VagonCalatori{
    private static final int NR_PASAGERI = 40;
    private static final int NR_COLETE = 300;

    public CalatoriA(){
        super(NR_PASAGERI,NR_COLETE);
    }
    public void deschidere(){
        System.out.println("Calatori A: Deschiderea usilor");
    }
    public void inchidere(){
        System.out.println("Calatori A: Inchiderea usilor");
    }
    
    public void afiseazaTip() {
        System.out.println("Vagon de tip A");
    }
}
class CalatoriB extends VagonCalatori{
    private static final int NR_PASAGERI = 50;
    private static final int NR_COLETE = 400;

    public CalatoriB(){
        super(NR_PASAGERI,NR_COLETE);
    }
    public void deschidere(){
        System.out.println("Calatori B: Deschiderea usilor");
    }
    public void inchidere(){
        System.out.println("Calatori B: Inchiderea usilor");
    }
    public void blocare(){
        System.out.println("Calatori B: Blocarea geamurilor");
    }
    
    public void afiseazaTip() {
        System.out.println("Vagon de tip B");
    }
}
class Marfa extends Vagon{
    private static final int NR_COLETE = 400;
    public Marfa(){
        super(NR_COLETE);
    }
    
    public void afiseazaTip() {
        System.out.println("Vagon marfa");
    }
}
class Main{
    public static void main(String[] args){
        Vagon[] v = new Vagon[5];
        v[0] = new CalatoriA();
        v[1] = new CalatoriB();
        v[2] = new Marfa();
        v[3] = new Marfa();
        v[4] = new Marfa();

        Tren t = new Tren(v);

        Vagon[] v2 = new Vagon[1];
        v2[0] = new CalatoriA();
        Tren t2 = new Tren(v2);
        // v[0].deschidere();
        // v[1].deschidere();


        if(t.equals(t2)){
            System.out.println("Trenurile sunt egale");
        }else{
            System.out.println("Trenurile nu sunt egale");
        }

        System.out.println("Nr de vagoane este" + t.getNrVagoane());

        t.afisareTipuriVagoane();
    }
}