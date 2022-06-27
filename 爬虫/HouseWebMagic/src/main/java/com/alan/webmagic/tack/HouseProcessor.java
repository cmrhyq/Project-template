package com.alan.webmagic.tack;

import com.alan.webmagic.dao.CityInfoDao;
import com.alan.webmagic.dao.HouseInfoDao;
import com.alan.webmagic.domain.CityInfo;
import com.alan.webmagic.domain.HouseInfo;
import com.alan.webmagic.service.InfoService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.scheduler.RedisScheduler;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class HouseProcessor implements PageProcessor {
    @Autowired
    private InfoService infoService;

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private SpringDataPipeline springDataPipeline;
    /**
     * 数据库中已爬取的url
     * 二手房页面地址wh.ke.con/ershoufang/pg1
     * 楼盘页面地址es.fang.ke.com/loupan/pg1
     */
//    private String url = "https://wh.ke.com/ershoufang/pg";
    List<CityInfo> cityUrl = infoService.findCityInfoOne();

    /**
     * 编码，超时时间，重试时间,重试次数
     */
    private Site site = Site.me()
            .setCharset("utf-8")
            .setTimeOut(10 * 1000)
            .setRetrySleepTime(1000)
            .setSleepTime(5);

    /**
     * 解析页面
     *
     * @param page
     */
    @Override
    public void process(Page page) {
        List<Selectable> list = page.getHtml().css("ul.sellListContent li.clear").nodes();
        if (list.size() == 0) {
            this.savaHouseInfoOne(page);
        } else {
            for (Selectable selectable : list) {
//                获取url地址
                String info = selectable.links().toString();
//                将地址加入队列中
                page.addTargetRequest(info);
            }
        }
        String html = page.getHtml().toString();
    }

    /**
     * 组装图片的url
     *
     * @param html
     * @return
     */
    private String imgurl(Html html) {
        List<String> list = new ArrayList<>();
        list.add(html.css("ul.smallpic").$("li", "data-src").nodes().get(0).toString());
        list.add(html.css("ul.smallpic").$("li", "data-src").nodes().get(1).toString());
        list.add(html.css("ul.smallpic").$("li", "data-src").nodes().get(2).toString());
        list.add(html.css("ul.smallpic").$("li", "data-src").nodes().get(3).toString());
        list.add(html.css("ul.smallpic").$("li", "data-src").nodes().get(4).toString());
        return JSONObject.toJSONString(list);
    }

    /**
     * 解析二手房页面获取数据并保存
     *
     * @param page
     */
    private void savaHouseInfoOne(Page page) {
        HouseInfo houseInfo = new HouseInfo();
        Html html = page.getHtml();

        houseInfo.setHouseInfoName(html.css("div.title h1.main", "text").toString());
        houseInfo.setHouseInfoImgUrl(imgurl(html));
        houseInfo.setHouseInfoTotalPrice(Double.parseDouble(html.css("div.price span.total", "text").toString()) * 10000);
        houseInfo.setHouseInfoMeterPrice(Double.parseDouble(html.css("div.unitPrice span.unitPriceValue", "text").toString()));
        houseInfo.setHouseInfoCommunityName(html.css("div.communityName a.info", "text").toString());
        houseInfo.setHouseInfoArea(Jsoup.parse(html.css("div.areaName a").nodes().get(0).toString()).text() + Jsoup.parse(html.css("div.areaName a").nodes().get(1).toString()).text());
        houseInfo.setHouseInfoLookTime(html.css("div.visitTime span.info", "text").toString());
        houseInfo.setHouseInfoNumber(Double.parseDouble(html.css("div.houseRecord span", "text").replace("\"", "").nodes().get(1).toString().trim()));
//        houseInfo.setHouseInfoUrl();
        houseInfo.setGmtCreate(new Date());
        houseInfo.setGmtModified(new Date());

        page.putField("houseInfo", houseInfo);
    }

    @Override
    public Site getSite() {
        return site;
    }

    /**
     * initialDelay当任务启动后等多久执行
     * <p>
     * fixedDelay每隔多久执行一次
     */
    @Scheduled(initialDelay = 1000, fixedDelay = 100 * 1000)
    public void process() {
        Spider spider = Spider.create(new HouseProcessor())
//                .addUrl(url)
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(100000)))
//                .setScheduler(new RedisScheduler(jedisPool))
                .thread(10);
        for (int j=0;j<=cityUrl.size();j++){
            String url = cityUrl.get(j).getCityUrl();
            System.out.println("url = " + url);
            for (int i = 1; i < 101; ++i) {
                spider.addUrl(url+"ershoufang/pg" + i + "/");
            }
        }
        spider.addPipeline(this.springDataPipeline);
        spider.run();
    }
}