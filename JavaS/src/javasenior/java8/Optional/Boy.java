package javasenior.java8.Optional;

/**
 * @Author hliu
 * @Date 2023/1/28 13:46
 * @Version 1.0
 */
public class Boy {
    private Girl girl;

    public Boy(Girl girl) {
        this.girl = girl;
    }

    public Boy() {
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }
}
