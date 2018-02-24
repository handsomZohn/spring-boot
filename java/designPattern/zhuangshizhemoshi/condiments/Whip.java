package designPattern.zhuangshizhemoshi.condiments;

import designPattern.zhuangshizhemoshi.Beverage;
import designPattern.zhuangshizhemoshi.CondimentDecorator;

/**
 * 奶油:调料
 * Created by zohn on 2017/12/20.
 */
public class Whip extends CondimentDecorator {

    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return .10 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }
}
