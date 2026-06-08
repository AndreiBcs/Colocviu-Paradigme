public class Judete {
    public String ISO;
    public String nume;
    public String regiune;
    public long nrLoc;
    public long suprafata;

    public Judete(String ISO, String nume, String regiune, long nrLoc, long suprafata) {
        this.ISO = ISO;
        this.nume = nume;
        this.regiune = regiune;
        this.nrLoc = nrLoc;
        this.suprafata = suprafata;
    }

    @Override
    public String toString() {
        return
                "ISO='" + ISO + '\'' +
                ", nume='" + nume + '\'' +
                ", regiune='" + regiune + '\'' +
                ", nrLoc=" + nrLoc +
                ", suprafata=" + suprafata;
    }
}
