package optional;

import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

public class TestOptional {
    public static void main(String[] args) {
        // testOptionalOf();
       // testDoubleIfNull();
    }

    //throws null pointer exception if the object is null
    private static void testOptionalOf(){
        Person p = null;
        String result = Optional.of(p).map(p1 -> p1.getName().toUpperCase(Locale.ROOT)).orElse("UnKnown");
        System.out.println(result);
    }

    //will not throw exception
    private static void testOptionalOfNullable(){
        Person p = null;
        String s = Optional.ofNullable(p).map(p1 -> p1.getName().toUpperCase(Locale.ROOT)).orElse("UnKnown");
        System.out.println("value"+ s);
    }

    //will
    private static void testOptionalFlatMap(){
        Person p = new Person("", "");
        //p.setProf("Renuka");
        String s = Optional.ofNullable(p).flatMap(Person::getProf).orElse("");
        System.out.println("value"+ s);
    }
    private static void testDoubleIfNull(){
        try{
            Person p = new Person("", "");
            Double d = Optional.ofNullable(p).map(amount -> {
                Double value =  amount.getAmount();
                return value;
            }).orElse(null);
            System.out.println(d);
        }catch (Exception e){
            System.out.println("Exception occurred in creating Persng:  "+ e.getMessage());
        }

    }
}

class Person{
    String name;
    String number;
    String prof;
    Double amount;
    public Person(String name, String number) {
        this.name = Objects.requireNonNull(null, "Person should have name");
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Optional<String> getProf() {
        return Optional.ofNullable(prof);
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
