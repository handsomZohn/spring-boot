package designPattern.zhuangshizhemoshi.condiments;

import designPattern.zhuangshizhemoshi.Beverage;
import designPattern.zhuangshizhemoshi.CondimentDecorator;

/**
 * 调料:豆浆
 * Created by zohn on 2017/12/20.
 */
public class Soy extends CondimentDecorator {

    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return .15 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }
}
