package homework.h3.decorator;

public class SimpleCoffe implements Coffee{
    @Override
    public String getDescrirption() {
        return "Default black Coffee";
    }

    @Override
    public double getCost() {
        return 100.0;
    }
}
