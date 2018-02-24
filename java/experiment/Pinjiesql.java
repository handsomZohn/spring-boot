package experiment;

/**
 * Created by zohn on 2017/12/15.
 */
public class Pinjiesql {
    public static void main(String[] args) {
        String str = "insert into  ldlcb_jycyz_lxxxbgb  (bgid,grbh,lxdh,lxdz,yb,bgrq,sfdqjl";
        String string = "syry_lxxxbgb";
        str = str.replace("ldlcb_jycyz_lxxxbgb",string);

        System.out.println(str);
    }
}
