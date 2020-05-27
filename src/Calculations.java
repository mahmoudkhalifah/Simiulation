public class Calculations {
    private float lambda;
    private float mu;
    private float cs;
    private float cw;

    public void setLambda(float lambda) {
        this.lambda = lambda;
    }

    public void setMu(float mu) {
        this.mu = mu;
    }

    public void setCs(float cs) { this.cs = cs; }

    public void setCw(float cw) { this.cw = cw; }

    public float L() {
        return lambda / (mu - lambda);
    }

    public float W() {
        return 1 / (mu - lambda);
    }

    public float Lq() {
        return (lambda * lambda) / (mu * (mu - lambda));
    }

    public float Wq() {
        return (lambda) / (mu * (mu - lambda));
    }

    public float P() {
        return (lambda / mu);
    }

    public float P0() {
        return (1 - (lambda / mu));
    }

    public float TWCq() { return (lambda*Wq()*cw); }

    public float TC() { return (cs+TWCq()); }

    public float[] Pk(float arr []) {
        float p = lambda / mu;
        for (int i = 0; i <= 7; i++) {
            arr[i] = (float) Math.pow(p,(i + 1));
        }
        return arr;
    }
}