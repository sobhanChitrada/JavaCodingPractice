package test;

public interface MyInterface1<T extends MyInterface2> {
    String m1(T anyparam);
}
