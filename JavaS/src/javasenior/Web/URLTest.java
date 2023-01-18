package javasenior.Web;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://sso.gatech.edu/cas/login?service=https%3A%2F%2Fsso.sis.gatech.edu%3A443%2Fssomanager%2Fc%2FSSB");
            System.out.println(url.getProtocol());
            System.out.println(url.getPort());
            System.out.println(url.getHost());
            System.out.println(url.getQuery());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
