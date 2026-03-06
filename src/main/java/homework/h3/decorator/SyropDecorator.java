package homework.h3.decorator;

public class SyropDecorator extends CoffeDecorator{
    public SyropDecorator(Coffee coffee) {
        super(coffee);

    }

    @Override
    public String getDescrirption(){
        return coffee.getDescrirption() + ", with syrop";
    }
    @Override
    public double getCost(){
        return coffee.getCost() + 20.0;
    }
}
