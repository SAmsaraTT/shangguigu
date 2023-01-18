package javasenior.genericTest;



import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class DAO<T> {
    public  Map<Integer, T> map = new HashMap<>();

    public T get(int x) {
        return map.get(x);
    }
}

class DAOTest{
    @Test
    public void gTest() {
        DAO<String> d = new DAO<>();

        d.map.put(3, "fuck");

        System.out.println(d.get(3));
    }
}


