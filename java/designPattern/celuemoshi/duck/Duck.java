package designPattern.celuemoshi.duck;


import designPattern.celuemoshi.fly.FlyBehavior;
import designPattern.celuemoshi.quack.QuackBehavior;

/**
 * Created by zohn on 2017/11/10.
 * 所有Duck的父类
 */
public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck() {

    }

    public abstract void display();

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }

    void swim() {
        System.out.println("All ducks float, even decoys   在开心的swimming");
    }

    //动态设定行为
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
