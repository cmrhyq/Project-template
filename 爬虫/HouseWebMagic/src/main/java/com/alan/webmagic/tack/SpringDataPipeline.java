package com.alan.webmagic.tack;

import com.alan.webmagic.dao.HouseInfoDao;
import com.alan.webmagic.dao.RealEstateDao;
import com.alan.webmagic.domain.HouseInfo;
import com.alan.webmagic.domain.RealEstate;
import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.pipeline.Pipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;

import javax.xml.transform.Result;

/**
 * 存入数据
 *
 * @author AlanWalker on 2021/1/30
 * @version 0.0.1
 * @project webMagic
 * @package com.worm.webMagic.tack
 * @classname SpringDataPipeline
 * @apiNote
 * @implSpec
 * @implNote
 * @since 0.0.1
 */
@Component
@Slf4j
public class SpringDataPipeline implements Pipeline {
    @Autowired
    private HouseInfoDao houseInfoDao;

    @Autowired
    private RealEstateDao realEstateDao;

    /**
     * 使用jpa的save方法将数据存到数据库
     *
     * @param resultItems
     * @param task
     */
    @Override
    public void process(ResultItems resultItems, Task task){
        HouseInfo houseInfo = resultItems.get("houseInfo");
        RealEstate realEstate = resultItems.get("realEstate");
//        HouseInfo houseInfo1 = resultItems.get("url");
        if (houseInfo != null) {
            this.houseInfoDao.save(houseInfo);
//            this.realEstateDao.save(realEstate);
        }
    }
}
