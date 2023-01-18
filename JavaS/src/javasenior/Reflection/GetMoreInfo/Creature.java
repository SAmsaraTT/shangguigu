package javasenior.Reflection.GetMoreInfo;

import java.io.Serializable;

public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath() {
        System.out.println("Creature is breathing!");
    }

    public void eat() {
        System.out.println("creature is eating!");
    }
}
