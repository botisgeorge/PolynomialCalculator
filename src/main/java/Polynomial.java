import java.util.ArrayList;

public class Polynomial {
    ArrayList<Monomial> polinom = new ArrayList<>();

    public void addMonom(Monomial mon)
    {
        polinom.add(mon);
    }
    public Monomial getMonom(int i)
    {
        return polinom.get(i);
    }

}
