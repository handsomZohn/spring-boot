package designPattern.zhuangshizhemoshi;

import designPattern.zhuangshizhemoshi.beverages.DarkRoast;
import designPattern.zhuangshizhemoshi.beverages.Espresso;
import designPattern.zhuangshizhemoshi.beverages.HouseBlend;
import designPattern.zhuangshizhemoshi.condiments.Mocha;
import designPattern.zhuangshizhemoshi.condiments.Soy;
import designPattern.zhuangshizhemoshi.condiments.Whip;

/**
 * 装饰者模式测试
 * Created by zohn on 2017/12/20.
 */
public class StarbuzzCoffee {
    public static void main(String[] args) {
        //Espresso咖啡 只是饮料 什么调料都不加的那种 但是也很好∑
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + ", $" + beverage.cost());

        Beverage beverage2 = new DarkRoast();// 制造一个DarkRoast对象
        beverage2 = new Mocha(beverage2);// 用第一个Moch装饰它
        beverage2 = new Mocha(beverage2);// 用第二个Moch装饰它
        beverage2 = new Whip(beverage2);// 用Whip装饰它
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        Beverage beverage3 =new HouseBlend(); // 来一杯加Mocha，Soy，Whip的HouseBlend
        beverage3 = new Mocha(beverage3);
        beverage3 = new Soy(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
    }
}

class Cover{
    static class InnerClass{

    }
    private int age;

   static void print(){
       int age = 10;
        class InnerClass{

        }
    }
}
