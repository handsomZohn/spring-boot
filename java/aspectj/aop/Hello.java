package aspectj.aop;

/**
 * Created by zohn on 2018/2/4.
 */
public class Hello {
    public void hello(){
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        new Hello().hello();
    }
}
