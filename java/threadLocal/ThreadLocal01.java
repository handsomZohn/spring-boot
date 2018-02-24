package threadLocal;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

/**
 * Created by zohn on 2018/1/29.
 */
public class ThreadLocal01 {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("zohn");

        try {
            threadLocal.set("123");
            System.out.println(threadLocal.get());
        } finally {
            threadLocal.remove();
        }
    }

}
