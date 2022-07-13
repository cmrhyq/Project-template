package com.cmrhyq.design.pattern.product;

import lombok.extern.slf4j.Slf4j;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project factoryPatternDemo1
 * @docRoot com.cmrhyq.design.pattern.product.SmsMessage
 * @date 2022/7/13-23:45
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
@Slf4j
public class SmsMessage extends AbstractMessage {

    @Override
    public void send(){
        log.info("send Sms Message");
    }
}
