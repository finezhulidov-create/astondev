package mod1;

public class StringPoolExample {
    public static void main(String[] args) {
//        String s = "1";
//        String s2 = "1";
//        String s3 = new String("1");
//
//        System.out.println(s==s2);
//        System.out.println(s2==s3);
//        System.out.println(s==s3);
        StringBuilder stringBuilder = new StringBuilder();

        String s = "str";
        long l = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            stringBuilder.append("str");
//            s+="str";
        }
        s = stringBuilder.toString();
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
        String.format("Time of evaluating is %d", l1 -l);
    }
}
