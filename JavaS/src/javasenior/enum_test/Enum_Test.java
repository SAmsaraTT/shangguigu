package javasenior.enum_test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Enum_Test {
    public static void main(String[] args) {

    }

    @Test
    public void Test1() {
        Season sp = Season.Spring;
        System.out.println(sp);
        Season[] values = Season.values();
        for (Season value : values) {
            System.out.println(value);
        }

        List<Integer> list = new ArrayList<>();

    }
}

enum Season{
    Summer("ss", "ss"),
    Spring("spsp", "spsp");

    private final String seasonName;
    private final String seasonDescribion;

    private Season(String seasonName, String seasonDescribion) {
        this.seasonName = seasonName;
        this.seasonDescribion = seasonDescribion;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDescribion() {
        return seasonDescribion;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDescribion='" + seasonDescribion + '\'' +
                '}';
    }
}
