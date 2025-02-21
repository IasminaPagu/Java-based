class Remorca{
    private int nrCutii;
    private String nrInmatriculare;
    private static int nrRemorci = 0;
    private static int  nrCutiiRemorcaAnterioara = 0;

    public Remorca(int nrCutii, String nrInmatriculare){
        this.nrCutii = nrCutii;
        this.nrInmatriculare = nrInmatriculare;
        nrRemorci ++;
        nrCutiiRemorcaAnterioara = this.nrCutii;
    }
    public Remorca(String nrInmatriculare){
        this.nrInmatriculare = nrInmatriculare;
        if(nrRemorci == 0){
            this.nrCutii = 10;
        }else{
            this.nrCutii = 1 + nrCutiiRemorcaAnterioara;
        }
        nrCutiiRemorcaAnterioara = this.nrCutii;
    }
    public int getNrCutii(){
        return nrCutii;
    }
    public String getNrInmatriculare(){
        return nrInmatriculare;
    }
    public String toString(){
        return "R(" + nrInmatriculare + " , " + nrCutii + ")" ;
    }
}
class Tir{
    Remorca[] remorci = new Remorca[5];
    private String nume;
    private int nrRemorci = 0;
    public Tir(String nume){
        this.nume = nume;
    }
    
    public boolean adaugaRemorca(int nrCutii, String nrInmatriculare){
        if(nrRemorci == 5){
            return false;
        }else{
            remorci[nrRemorci] = new Remorca(nrCutii,nrInmatriculare);
            nrRemorci ++;
            return true;
        }
    }
    public boolean adaugaRemorca(Remorca r){
        if(nrRemorci == 5){
            return false;
        }else{
            remorci[nrRemorci] = r;
            nrRemorci ++;
            return true;
        }
    }
    public Remorca stergeRemorca(String nrInmatriculare){
        Remorca remorca_stearsa;
        for(int i = 0;i<nrRemorci;i++){
            if(remorci[i].getNrInmatriculare() == nrInmatriculare){
                remorca_stearsa = remorci[i];
                for(int j = i;j<nrRemorci -1;j++){
                    remorci[j] = remorci[j+1];
                }
                nrRemorci --;
                return remorca_stearsa;
            }
        }
        return null;
    }
    public boolean equals(Object o){
        if(o instanceof Tir){
            int cantitate_tir1 = 0;
            int cantitate_tir2 = 0;

            for(int i = 0;i<this.nrRemorci;i++){
                cantitate_tir1 = cantitate_tir1 +  this.remorci[i].getNrCutii();
            }
            for(int i = 0;i<((Tir)o).nrRemorci;i++){
                cantitate_tir2 = cantitate_tir2 + ((Tir)o).remorci[i].getNrCutii();
            }
            if(cantitate_tir1 == cantitate_tir2){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public String toString(){
        String sir = new String("Tir " + nume);
        for(int i = 0;i<nrRemorci;i++){
            sir = sir + " , " + remorci[i].toString();
        }
        return sir;
    }

}

class Main{
    public static void main(String[] args) {
        Tir t1 = new Tir("t1");
        System.out.println(t1.toString());
        t1.adaugaRemorca(100, "AAA");
        t1.adaugaRemorca(100,"BBB");
        t1.adaugaRemorca(100, "CCC");
        t1.adaugaRemorca(100, "DDD");
        t1.adaugaRemorca(100, "BAM");
        System.out.println(t1.toString());

        Remorca remorcaStearsa = t1.stergeRemorca("AAA");
        if(remorcaStearsa == null){
            System.out.println("nu am gasit remorca cu acel nr de inmatriculare");
        }else{
            System.out.println("remorca stearsa este " + remorcaStearsa.toString());
        }
        System.out.println(t1.toString());


        Tir t2 = new Tir("t2");
        System.out.println(t2.toString());
        t2.adaugaRemorca(100, "AAA");
        t2.adaugaRemorca(100, "BBB");
        t2.adaugaRemorca(100, "CCC");
        t2.adaugaRemorca(100, "DDD");
        System.out.println(t2.toString());

        if(t1.equals(t2)){
            System.out.println("cele 2 tiruri au acelasi nr de cutii");
        }else{
            System.out.println("nu");
        }

        Remorca r1 = new Remorca(50, "ZZZ");
        t2.adaugaRemorca(r1);
        System.out.println(t2.toString());
        Remorca r2 = new Remorca("QQQ");
        Remorca r3 = new Remorca("LLL");
        System.out.println(r1.toString());
        System.out.println(r2.toString());
        System.out.println(r3.toString());

    }
}
