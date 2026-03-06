package homework.h3.strategy;

public class Context {
    private Strategy strategy;

    public  void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    public Integer executeStrategy(Integer a, Integer b){
        return strategy.execute(a,b);
    }
}
