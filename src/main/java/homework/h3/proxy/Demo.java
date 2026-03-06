package homework.h3.proxy;

public class Demo {
    public static void main(String[] args) {
        Document doc1 = new DocumentProxy("onlyforAdmin.txt", "admin");
        doc1.display();
        System.out.println();
        Document doc2 = new DocumentProxy("confidential.txt", "guest");
        doc2.display();
        System.out.println();
        doc1.display();
    }
}
