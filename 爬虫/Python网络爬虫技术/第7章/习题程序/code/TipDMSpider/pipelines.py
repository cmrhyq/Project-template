# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://doc.scrapy.org/en/latest/topics/item-pipeline.html
import logging
from sqlalchemy import create_engine
import pandas as pd
class TipdmspiderPipeline(object):
    def __init__(self):
        self.engine = create_engine('mysql+pymysql://root:123456@127.0.0.1:3306/tipdm')
    def process_item(self, item, spider):
        data = pd.DataFrame(dict(item))
        data.to_sql('tipdm_data',self.engine,if_exists='append',index=False)
        data.to_csv('TipDM_data.csv',mode='a+',index=False, sep='|', header=False)
