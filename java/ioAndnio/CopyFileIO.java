package ioAndnio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zohn on 2017/12/11.
 */
public class CopyFileIO {
    public static void main(String[] args) throws Exception {

        // 来写点代码学一下Debug
        int i = 100;
        if(i<200){
            i += 200;
        }
        int temp = 10;
        int temp02 = 20;
        Date now = new Date();
        System.out.println(System.nanoTime());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(now));
        if (temp02 > temp) {
            System.out.println("You Win");
        }
        copyFile();

        add(10,20);
    }

    static void copyFile() throws IOException {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        fileInputStream = new FileInputStream("E:\\ab\\美丽的versa.jpg");
        fileOutputStream = new FileOutputStream("E:\\ab\\versa.jpg");
        int i = fileInputStream.read();
        while (i != -1) {
            fileOutputStream.write(i);
            i = fileInputStream.read();
        }
        fileOutputStream.close();
        fileInputStream.close();
    }

    /**
     * 我家的超级大的落地窗
     * @param i
     * @param j
     * @return
     */
    static int add(Integer i, int j){
        if (i != null) {

        }
        i ++;
        j ++;
        return 1 + 20 + i + j;
    }

    /**
     * 我家的超级大的落地窗
     */
}


