package reflect;

import java.awt.event.ActionListener;

/**
 * Created by zohn on 2018/1/24.
 */
public class Reflect01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("reflect.Reflect01");
        Class<Reflect01> reflect01Class = Reflect01.class;
        Class<? extends Reflect01> aClass1 = new Reflect01().getClass();
        System.out.println(aClass);
        System.out.println(reflect01Class);
        System.out.println(aClass1);
    }
}
