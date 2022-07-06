package com.cmrhyq.design.pattern.service.impl;

import com.cmrhyq.design.pattern.service.IFruit;
import lombok.extern.slf4j.Slf4j;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project pattern
 * @docRoot com.cmrhyq.design.pattern.service.impl.Orange
 * @date 2022/7/6-19:55
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
@Slf4j
public class Orange implements IFruit {
    /**
     * 种植水果的方法
     */
    @Override
    public void plant() {
        log.info("种植橙子");
    }
}
