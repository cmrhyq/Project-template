package com.cmrhyq.design.pattern.test;

import com.cmrhyq.design.pattern.concreteCreator.EmailImessageFactory;
import com.cmrhyq.design.pattern.concreteCreator.SmsMessageFactory;
import com.cmrhyq.design.pattern.creator.Factory;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project factoryPatternDemo1
 * @docRoot com.cmrhyq.design.pattern.test.ClientCmd
 * @date 2022/7/14-0:14
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class ClientCmd {

    public static void main(String[] args) {
        Factory factory = new EmailImessageFactory();
        factory.createMessage().send();
        factory = new SmsMessageFactory();
        factory.createMessage().send();
    }
}
