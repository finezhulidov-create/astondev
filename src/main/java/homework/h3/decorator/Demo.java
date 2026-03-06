package homework.h3.decorator;

public class Demo {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffe();
        coffee = new SugarDecorator(coffee);
        coffee = new MilkDecorator(coffee);
        coffee = new SyropDecorator(coffee);

        System.out.println("Description: " + coffee.getDescrirption());
        System.out.println("Total cost: " + coffee.getCost());
    }
}
