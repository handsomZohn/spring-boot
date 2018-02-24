package designPattern.zhuangshizhemoshi.beverages;

import designPattern.zhuangshizhemoshi.Beverage;

/**
 * 浓缩咖啡
 * Created by zohn on 2017/12/20.
 */
public class Espresso extends Beverage { //Espresso扩展自Beverage 因为它是一种饮料
    public Espresso() {
        description = "Espresso"; //覆盖 饮料的描述 description来自其父类
    }

    public double cost() {
        return 1.99;
    }
}
