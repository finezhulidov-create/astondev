package homework.h3.decorator;

public class MilkDecorator extends CoffeDecorator{
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescrirption(){
        return coffee.getDescrirption() + ", with Milk";
    }
    @Override
    public double getCost(){
        return coffee.getCost() + 30.0;
    }
}
