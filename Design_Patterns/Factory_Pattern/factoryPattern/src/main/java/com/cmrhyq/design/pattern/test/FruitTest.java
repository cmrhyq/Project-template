package com.cmrhyq.design.pattern.test;

import com.cmrhyq.design.pattern.factory.PlantFruitsFactory;
import com.cmrhyq.design.pattern.service.IFruit;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project pattern
 * @docRoot com.cmrhyq.design.pattern.test.FruitTest
 * @date 2022/7/6-21:17
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class FruitTest {

    public static void main(String[] args) {
        IFruit fruit = PlantFruitsFactory.plantFruit("Apple");
        assert fruit != null;
        fruit.plant();
        fruit = PlantFruitsFactory.plantFruit("Orange");
        assert fruit != null;
        fruit.plant();
    }
}
