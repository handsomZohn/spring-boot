package designPattern.zhuangshizhemoshi.beverages;

import designPattern.zhuangshizhemoshi.Beverage;

/**
 * 一种饮料
 * Created by zohn on 2017/12/20.
 */
public class Decat extends Beverage {

    public Decat() {
        description = "Decat";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
