package designPattern.zhuangshizhemoshi;

/**
 * 调料
 * Created by zohn on 2017/12/20.
 */
public abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
    /**
     * 首先要让CondimentDecorator可以取代Beverage
     * 所以要让CondimentDecorator继承自Beverage
     */
}



