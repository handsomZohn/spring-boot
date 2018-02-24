package designPattern.guanchazhemoshi.qixiangzhan.zijixiede.bugaoban;

import designPattern.guanchazhemoshi.qixiangzhan.zijixiede.DisplayElement;
import designPattern.guanchazhemoshi.qixiangzhan.zijixiede.ObjectObserver.Observer;

/**
 * 预测布告板
 * Created by zohn on 2017/12/11.
 */
public class ForecastDisplay implements Observer,DisplayElement {
    @Override
    public void update(float temp, float humidity, float pressure) {

    }

    @Override
    public void display() {

    }
}
