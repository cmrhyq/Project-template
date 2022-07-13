package com.cmrhyq.design.pattern.concreteCreator;

import com.cmrhyq.design.pattern.creator.Factory;
import com.cmrhyq.design.pattern.product.AbstractMessage;
import com.cmrhyq.design.pattern.product.SmsMessage;
import lombok.extern.slf4j.Slf4j;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project factoryPatternDemo1
 * @docRoot com.cmrhyq.design.pattern.concreteCreator.SmsMessageFactory
 * @date 2022/7/13-23:59
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
@Slf4j
public class SmsMessageFactory extends Factory {
    /**
     * 抽象工厂方法
     *
     * @return
     */
    @Override
    public AbstractMessage createMessage() {
        log.info("生产了一个SmsMessage");
        return new SmsMessage();
    }
}
