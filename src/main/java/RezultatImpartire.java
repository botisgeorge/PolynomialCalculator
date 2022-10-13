public class RezultatImpartire {
    Polynomial rezultat;
    Polynomial rest;

    public RezultatImpartire(Polynomial p1, Polynomial p2)
    {
        this.rezultat=p1;
        this.rest=p2;
    }
    public Polynomial getRezultat()
    {
        return rezultat;
    }
    public Polynomial getRest()
    {
        return rest;
    }
}
