package designPattern.zhuangshizhemoshi.condiments;

import designPattern.zhuangshizhemoshi.Beverage;
import designPattern.zhuangshizhemoshi.CondimentDecorator;

/**
 * 摩卡是一个装饰者 让它继承自CondimentDecorator
 * 而CondimentDecorator继承自Beverage
 * Created by zohn on 2017/12/20.
 */
public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    /**
     *要计算带Mocha饮料的价格
     *首先把调用委托给【被装饰对象】 以计算价钱
     *然后再加上Mocha的价钱 得到最后的结果
     * @return
     */
    public double cost() {
        return 0.2 + beverage.cost();
        // 要计算带Mocha饮料的价格
        //首先把调用委托给【被装饰对象】 以计算价钱
        //然后再加上Mocha的价钱 得到最后的结果
    }

    /**
     * 描述内容:不仅仅有饮料 还有里面的调料
     * @return
     */
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";

    }
}
