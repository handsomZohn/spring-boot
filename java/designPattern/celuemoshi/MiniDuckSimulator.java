package designPattern.celuemoshi;

import designPattern.celuemoshi.duck.Duck;
import designPattern.celuemoshi.duck.MallarDuck;
import designPattern.celuemoshi.duck.ModelDuck;
import designPattern.celuemoshi.fly.FlyRocketPowered;

import java.text.DecimalFormat;

/**
 * Created by zohn on 2017/11/10.
 * 测试类
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        //一个会呱呱呱叫的鸭子
        Duck mallarDuck = new MallarDuck();
        mallarDuck.display();
        mallarDuck.performFly();
        mallarDuck.performQuack();

        //一只沉默的模型鸭
        //但是后来它坐上了火箭
        Duck modelDuck = new ModelDuck();
        modelDuck.display();
        modelDuck.performFly();
        modelDuck.setFlyBehavior(new FlyRocketPowered());//通过动态赋FlyBehavior
        modelDuck.performFly();
        modelDuck.performQuack();//

        if (true){

        }else{
            /* Zweig darf niemals vorkommen */
            System.out.println(" never be run "); //翻译过来也是笑死我了:尼玛，弗可能！
        }

    }
}
