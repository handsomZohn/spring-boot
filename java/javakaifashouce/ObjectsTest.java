package javakaifashouce;

/**
 * Created by zohn on 2018/2/6.
 */
public class ObjectsTest {
    public static void main(String[] args) {
        User user = new User();
        user.setName("z");
        if ("z".equals(user.getName())){
            System.out.println("y");
        }

        if (java.util.Objects.equals("z",user.getName())){
            System.out.println("y");
        }
    }
}


class User{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
