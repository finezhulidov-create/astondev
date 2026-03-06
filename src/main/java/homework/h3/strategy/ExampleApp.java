package homework.h3.strategy;

import java.util.Scanner;

public class ExampleApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Context context = new Context();
        System.out.println("enter first num");
        Integer a = scanner.nextInt();
        System.out.println("enter second num");
        Integer b = scanner.nextInt();
        System.out.println("Enter the action +, - or *");
        String action = scanner.next();


        if (action.equals("-")){
            context.setStrategy(new SubstractStrategy());
        } else if (action.equals("+")) {
            context.setStrategy(new AddStrategy());
        } else if (action.equals("*")) {
            context.setStrategy(new MultiplyStrategy());
        } else {
            return;
        }
        Integer result = context.executeStrategy(a,b);
        System.out.println(result);
        scanner.close();
    }
}
