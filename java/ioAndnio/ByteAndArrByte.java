package ioAndnio;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 字节和字节数组
 * Created by zohn on 2017/12/21.
 */
public class ByteAndArrByte {
    public static void main(String[] args) throws IOException {
        bbyte();

        arrayByte();

        String str = "12";
        System.out.println(str.charAt(0));
    }

    /**
     * 一个一个读
     */
    private static void bbyte() {
        FileInputStream fileInputStream;
        try {
            int by = 0;
            fileInputStream = new FileInputStream("d:/ting.txt");
            System.out.println("一次读取一个字节开始------------------");
            while ((by = fileInputStream.read()) != -1){
                System.out.println((char)by);
            }
            System.out.println("一次读取一个字节结束------------------");
            fileInputStream.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 一组字节一组字节的读
     * @throws IOException
     */
    static void arrayByte() throws IOException{
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("d:/ting.txt");
            byte[] bys = new byte[3];
            int len = 0;
            System.out.println("一次读取一个字节数组开始------------------");
            while ((len = fileInputStream.read(bys)) != -1){
                System.out.println(new String(bys, 0, len));
            }
            System.out.println("一次读取一个字节数组结束------------------");
            fileInputStream.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    static int jiecheng(int n){
        if ( n == 1){
            return 1;
        }else {
            return n * jiecheng(n - 1);
        }
    }

}
