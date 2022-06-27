//package com.worm.webMagic.test;
//
//import us.codecraft.webmagic.Page;
//import us.codecraft.webmagic.Site;
//import us.codecraft.webmagic.Spider;
//import us.codecraft.webmagic.pipeline.FilePipeline;
//import us.codecraft.webmagic.processor.PageProcessor;
//import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
//import us.codecraft.webmagic.scheduler.QueueScheduler;
//import us.codecraft.webmagic.scheduler.Scheduler;
//
//public class JobProcessor implements PageProcessor {
//    @Override
//    public void process(Page page) {
//        //解析返回的page
//        //css选择器
//        page.putField("div",page.getHtml().css("div.title h1").all());
//        //xpath
////        page.putField("div1",page.getHtml().xpath("//div[@class=title]/a"));
//        //css+正则
////        page.putField("div",page.getHtml().css("div.title a").regex(".*随时看房.*").all());
//
//        //结果处理
////        page.putField("div",page.getHtml().css("div.title a").regex(".*随时看房.*").toString());
//
//        //获取链接
////        page.addTargetRequests(page.getHtml().css("div.title a").links().all());
////        page.putField("url",page.getHtml().css("div.title a").all());
//
////        page.addTargetRequest("https://wh.ke.com/ershoufang/104104034939.html?fb_expo_id=405689748532592640");
////        page.addTargetRequest("https://wh.ke.com/ershoufang/104104034939.html?fb_expo_id=405689748532592640");
////        page.addTargetRequest("https://wh.ke.com/ershoufang/104104034939.html?fb_expo_id=405689748532592640");
//
//    }
//
//    private Site site = Site.me()
//            .setCharset("utf-8")//设置编码
//            .setTimeOut(1000)//设置超时时间
//            .setRetrySleepTime(1000)//设置重试时间
//            .setSleepTime(5);//设置重试次数
//
//    @Override
//    public Site getSite() {
//        return site;
//    }
//
////    public static void main(String[] args) {
////        Spider.create(new JobProcessor())
////                .addUrl("https://wh.ke.com/ershoufang/")//爬取的url
////                .addPipeline(new FilePipeline("C:\\Users\\Lenovo\\Desktop\\result"))//使用filepipeline方法将爬取的数据保存
////                .thread(5)//使用5个线程进行爬取
////                .run();//开始爬取
////    }
//
//    //布隆过滤器
////    public static void main(String[] args) {
////        Spider spider = Spider.create(new JobProcessor())
////                .addUrl("https://wh.ke.com/ershoufang/104104034939.html?fb_expo_id=405689748532592640")
////                .thread(5)
////                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(10000000)));//设置布隆去重过滤器，最大一千万条数据
////
////        Scheduler scheduler = spider.getScheduler();
////        spider.run();
////    }
//
//    //hashset过滤器
////    public static void main(String[] args) {
////        Spider spider = Spider.create(new JobProcessor())
////                .thread(5);
////        Scheduler scheduler = spider.getScheduler();
////        spider.run();
////    }
//}
