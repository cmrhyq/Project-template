# -*- coding: utf-8 -*-
BOT_NAME = 'TipDMSpider'

SPIDER_MODULES = ['TipDMSpider.spiders']
NEWSPIDER_MODULE = 'TipDMSpider.spiders'

# 激活中间件

# 激活Spider中间件
SPIDER_MIDDLEWARES = {
    'scrapy.spidermiddlewares.referer.RefererMiddleware': 0,
}

# 其他值设置
ROBOTSTXT_OBEY = False
DOWNLOAD_DELAY = 5
ITEM_PIPELINES = {
    'TipDMSpider.pipelines.TipdmspiderPipeline': 300,
}
#LOG_FILE = "mySpider.log"
HTTPCACHE_ENABLED = True
HTTPCACHE_DIR = r'C:\Users\Administrator\Desktop\python爬虫\习题\第7章\习题程序\code'
LOG_LEVEL = 'DEBUG'
#LOG_LEVEL = 'ERROR'
