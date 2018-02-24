package designPattern.zhuangshizhemoshi.beverages;

import designPattern.zhuangshizhemoshi.Beverage;

/**
 * 星巴兹咖啡
 * Created by zohn on 2017/12/20.
 */
public class HouseBlend extends Beverage { //HouseBlend扩展自Beverage 因为它是一种饮料
    public HouseBlend() {
        description = "House Blend Coffee"; //覆盖 饮料的描述 description来自其父类
    }

    public double cost() {
        return .89;
    }
}
