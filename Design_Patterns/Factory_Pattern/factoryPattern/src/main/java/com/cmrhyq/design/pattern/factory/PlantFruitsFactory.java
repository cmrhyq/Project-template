package com.cmrhyq.design.pattern.factory;

import com.cmrhyq.design.pattern.service.IFruit;
import com.cmrhyq.design.pattern.service.impl.Apple;
import com.cmrhyq.design.pattern.service.impl.Orange;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project pattern
 * @docRoot com.cmrhyq.design.pattern.factory.PlantFruitsFactory
 * @date 2022/7/6-21:08
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class PlantFruitsFactory {

    public static IFruit plantFruit(String fruitType) {
        if ("Apple".equals(fruitType)) {
            return new Apple();
        } else if ("Orange".equals(fruitType)) {
            return new Orange();
        } else {
            return null;
        }
    }
}
