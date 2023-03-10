package javasenior.Reflection.GetMoreInfo;
@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>, MyInterface{
    private String name;
    int age;
    public int id;

    public Person() {};
    @MyAnnotation(value = "abc")
    private Person(String name) {
        this.name = name;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @MyAnnotation
    private String show(String citizenship) {
        System.out.println("My citizenship is " + citizenship);
        return citizenship;
    }

    public String display(String interest, int age) throws NullPointerException, ClassCastException{
        return interest + age;
    }
    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("I am a person!");
    }

    private static void showInfo() {
        System.out.println("I am a cute person!");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
