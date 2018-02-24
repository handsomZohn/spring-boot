package designPattern.zhuangshizhemoshi;

/**
 * 饮料
 * Created by zohn on 2017/12/20.
 */
public abstract class Beverage {
    public String description = "Unknown Beverage";

    public abstract double cost(); //必须在子类实现

    public String getDescription() {
        return description;
    }

    /**
     * 等闲变却故人心
     * 却道故人心易变
     */
}
