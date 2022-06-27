# -*- coding: utf-8 -*-
"""
Created on Fri Jun  1 16:56:43 2018

@author: tipdm
"""
import requests
import chardet
from lxml import etree
import pymysql
import pandas as pd
#获取网页
url = 'http://www.tipdm.com/tipdm/gsjj/'
ua = {'User-Agent' : 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) Chrome/65.0.3325.181'}
#生成请求
rq = requests.get(url,headers = ua)
print(rq.status_code)   #查看状态码
print(rq.headers)      #查看响应头
rq.encoding = chardet.detect(rq.content)['encoding']
print(rq.text)         #查看网页内容

#获取指定节点下的文本内容
html = rq.content.decode('utf-8')
html = etree.HTML(html,parser=etree.HTMLParser(encoding='utf-8'))
url = html.xpath('//section[@class="tag issue clearfix"]/div[@class="item clearfix"]/h2/a/@href')
text = html.xpath('//section[@class="tag issue clearfix"]/div[@class="item clearfix"]/h2/a/text()')
target_df = pd.DataFrame(columns=["url","text"])
for i in range(len(text)):
    target_df = target_df.append({"url": str(url[i]),"text": str(text[i])}, ignore_index=True)
    
#数据存储
host='127.0.0.1'
port='3306'
user='root'
passwd='root'
dbname='test'
charset='utf8'
connect_timeout='1000'
con = pymysql.connect(host, user, passwd, dbname, int(port), charset = charset,connect_timeout = int(connect_timeout))
#创建游标
cursor = con.cursor()
sql = """create table if not exists html_text (id int(10) primary key auto_increment,
         link varchar(225),sublist_text varchar(225))"""
cursor.execute(sql)
target_link = list(target_df['url'])
target_text = list(target_df['text'])
sql_insert = "insert into html_text (link,sublist_text) values (%s,%s)"
for i in range(len(target_link)):
    cursor.execute(sql_insert,(target_link[i],target_text[i]))
con.commit()
#查询存储结果
data = cursor.execute("select * from html_text")
data = cursor.fetchmany(len(target_link))
print(data)
con.close()


