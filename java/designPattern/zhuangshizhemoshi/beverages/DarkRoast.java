package designPattern.zhuangshizhemoshi.beverages;

import designPattern.zhuangshizhemoshi.Beverage;

/**
 * 饮料:黑卡 其实我也不知道是不是黑卡
 * Created by zohn on 2017/12/20.
 */
public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "DarkRoast";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
