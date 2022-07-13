package com.cmrhyq.design.pattern.concreteCreator;

import com.cmrhyq.design.pattern.concreteProduct.EmailImessage;
import com.cmrhyq.design.pattern.creator.Factory;
import com.cmrhyq.design.pattern.product.AbstractMessage;
import lombok.extern.slf4j.Slf4j;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project factoryPatternDemo1
 * @docRoot com.cmrhyq.design.pattern.concreteCreator.EmailImessageFactory
 * @date 2022/7/13-23:58
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
@Slf4j
public class EmailImessageFactory extends Factory {
    /**
     * 抽象工厂方法
     *
     * @return
     */
    @Override
    public AbstractMessage createMessage() {
        log.info("生产了一个EMailMessage");
        return new EmailImessage();
    }
}
