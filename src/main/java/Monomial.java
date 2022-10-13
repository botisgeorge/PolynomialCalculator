public class Monomial {
    private int grad;
    private float coeficient;

    public Monomial(int grad, float coeficient)
    {
        this.grad=grad;
        this.coeficient=coeficient;
    }

    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public float getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(float coeficient) {
        this.coeficient = coeficient;
    }
}
