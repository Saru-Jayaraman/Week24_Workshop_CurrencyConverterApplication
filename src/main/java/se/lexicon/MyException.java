package se.lexicon;

public class MyException extends Throwable {
    public MyException(String s) {
        System.out.println("============================================");
        System.out.println(s);
    }
}
