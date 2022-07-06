package com.cmrhyq.design.pattern.service.impl;

import com.cmrhyq.design.pattern.service.IFruit;
import lombok.extern.slf4j.Slf4j;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project pattern
 * @docRoot com.cmrhyq.design.pattern.service.impl.IProduct
 * @date 2022/7/6-19:53
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
@Slf4j
public class Apple implements IFruit {
    /**
     * 实现苹果种植
     */
    @Override
    public void plant() {
        log.info("种植苹果");
    }
}
