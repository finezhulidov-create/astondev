package homework.h3.strategy;

public class AddStrategy implements Strategy{
    @Override
    public Integer execute(Integer a, Integer b) {
      return  a + b;
    }
}
