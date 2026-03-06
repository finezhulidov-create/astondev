package homework.h3.decorator;

abstract class CoffeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }


    @Override
    public String getDescrirption() {
        return coffee.getDescrirption();
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }
}
