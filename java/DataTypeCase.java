import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by zohn on 2018/1/9.
 */
public class DataTypeCase {
    public static void main(String[] args) {
        String je = "2286094740";
        double v = Double.parseDouble(je);
        String pattern = new Book().getPattern(v);
        Book book = new Book();
       // book.setPrice(pattern);
    }
}

class Book{
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * 把科学技术法产生的double型转化为普通十进制数字格式，保留两位小数（0不显示）并以String格式返回
     *
     * @param a
     *            double
     * @return String
     */
    public static String getPattern(double a) {
        String df = new DecimalFormat("0.00").format(a);
        String last = df.substring(df.indexOf(".") + 1);
        String last2 = df.substring(df.indexOf(".") + 2);
        // System.out.println(last);
        if (last.equals("00")) {
            df = df.substring(0, df.indexOf("."));
        } else {
            if (last2.equals("0")) {
                df = df.substring(0, df.indexOf(".") + 2);
            }
        }
        return df;
    }

}