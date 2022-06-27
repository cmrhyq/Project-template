# -*- coding: utf-8 -*-
import scrapy
import logging
from scrapy.http import Request
from TipDMSpider.items import TipdmspiderItem

class TipdmSpider(scrapy.Spider):
    name = 'tipdm'
    allowed_domains = ['www.tipdm.com']
    start_urls = ['http://www.tipdm.com/tipdm/gxjjfa/']


    def parse(self, response):
         # 网页解析
        last_page_num = response.xpath("//ul[@class='subList']/li/a/@href").extract()
        # 网址拼接
        logging.debug('This is a debug{}'.format(response))
       
        append_urls = ['http://www.tipdm.com%s'%i for i in last_page_num]

        for url in append_urls:
            yield Request(url, callback=self.parse_text, dont_filter=True)
        pass

    def parse_text(self,response):
        items={}
        items['title'] = response.xpath("//h1/a[@target='_blank']/text()").extract()
        items['text'] = response.xpath("//div[@class='des']/text()").extract()
        for i in range(0,len(items['title'])):
            item = TipdmspiderItem()
            item['title']=[items['title'][i]]
            item['text']=[items['text'][i]]
            yield item
