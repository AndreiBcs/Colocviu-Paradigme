public class Judete {
    public String ISO;
    public String nume;
    public String regiune;
    public String nrLoc;
    public String suprafata;


    public Judete(String nume, String ISO, String nrLoc, String regiune, String suprafata) {
        this.nume = nume;
        this.ISO = ISO;
        this.nrLoc = nrLoc;
        this.regiune = regiune;
        this.suprafata = suprafata;
    }

    @Override
    public String toString() {
        return "ISO='" + ISO + '\'' +
                ", nume='" + nume + '\'' +
                ", regiune='" + regiune + '\'' +
                ", nrLoc=" + nrLoc +
                ", suprafata=" + suprafata;
    }
}
