package homework.h3.decorator;



public class SugarDecorator extends CoffeDecorator{
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescrirption(){
        return coffee.getDescrirption() + ", with sugar";
    }

    @Override
    public double getCost(){
        return coffee.getCost() + 10.0;
    }
}
