package guanjianzi;

/**
 * Created by zohn on 2018/2/9.
 */
public class GjzFinalize {


}

class User {
    private String name;

    User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static void main2(){
        System.out.println("main2");
    }

    static public void main3(){
        System.out.println("main3");
    }

    static public void main(String[] args) {
        main2();
        main3();
    }
}


class Father{

}

class Son{

}