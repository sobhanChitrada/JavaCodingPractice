package test;

public class MyImpl1 implements MyInterface1{
    @Override
    public String m1(MyInterface2 anyparam) {
        System.out.println(anyparam);
        return "It is number";
    }
}
