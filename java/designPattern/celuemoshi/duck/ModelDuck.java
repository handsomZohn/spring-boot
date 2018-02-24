package designPattern.celuemoshi.duck;

import designPattern.celuemoshi.fly.FlyNoWay;
import designPattern.celuemoshi.quack.MuteQuack;

/**
 * Created by zohn on 2017/11/10
 * 新建一个模型鸭子
 */
public class ModelDuck extends Duck {

    public ModelDuck() {
        flyBehavior = new FlyNoWay(); //不会飞的模型鸭
        quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("I am a model duck!!!!");
    }


}
