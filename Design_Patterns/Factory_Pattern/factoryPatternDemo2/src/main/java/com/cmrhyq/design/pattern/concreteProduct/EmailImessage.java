package com.cmrhyq.design.pattern.concreteProduct;

import com.cmrhyq.design.pattern.product.AbstractMessage;
import lombok.extern.slf4j.Slf4j;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project factoryPatternDemo1
 * @docRoot com.cmrhyq.design.pattern.concreteProduct.EmailImessage
 * @date 2022/7/13-23:43
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
@Slf4j
public class EmailImessage extends AbstractMessage {

    @Override
    public void send(){
        log.info("send Email Message!");
    }
}
