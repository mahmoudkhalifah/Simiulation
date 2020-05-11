public class Calculations {
    private float lambda;
    private float mu;

    public void setLambda(float lambda) {
        this.lambda = lambda;
    }

    public void setMu(float mu) {
        this.mu = mu;
    }

    public float L() {
        return lambda/(mu-lambda);
    }

    public float W() {
        return 1/(mu-lambda);
    }

}
