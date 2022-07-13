package com.cmrhyq.design.pattern.creator;

import com.cmrhyq.design.pattern.product.AbstractMessage;

/**
 * <p>工厂抽象类</p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project factoryPatternDemo1
 * @docRoot com.cmrhyq.design.pattern.creator.Factory
 * @date 2022/7/13-23:56
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public abstract class Factory {

    /**
     * 抽象工厂方法
     *
     * @return
     */
    public abstract AbstractMessage createMessage();
}
