# 代码 3-29

import json
# 使用requests和Xpath获取数据
from lxml import etree
import requests
import chardet
url = 'http://www.tipdm.com/tipdm/index.html'
ua = {'User-Agent' : 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) Chrome/65.0.3325.181'}
rqg = requests.get(url,headers = ua)
rqg.encoding = chardet.detect(rqg.content)['encoding']
html = rqg.content.decode('utf-8')
html = etree.HTML(html,parser=etree.HTMLParser(encoding='utf-8'))
content=html.xpath('//ul[starts-with(@id,"me")]/li//a/text()')
print("标题菜单的文本:", content)
# 使用dump方法写入文件
with open('output.json','w') as fp:
    json.dump(content,fp)



# 代码 3-30

import pymysql
# 使用参数名创建连接
conn = pymysql.connect(host='127.0.0.1', port=3306, user='root', passwd='root', db='test', charset='utf8',
 connect_timeout=1000)
# 不使用参数名创建连接
conn = pymysql.connect('127.0.0.1', 'root', 'root', 'test')



# 代码 3-31

import pymysql
# 使用参数名创建连接
conn = pymysql.connect(host='127.0.0.1', port=3306, user='root', passwd='123456', db='newdb', charset='utf8', connect_timeout=1000)
# 创建游标
cursor=conn.cursor()
# 创建表
sql="""create table if not exists class (id int(10) primary key auto_increment,name varchar(20) not null,text varchar(20) not null)"""
cursor.execute(sql)            # 执行创建表的sql语句
cursor.execute("show tables")    # 查看创建的表
# 数据准备
import requests
import chardet
from bs4 import BeautifulSoup
url = 'http://www.tipdm.com/tipdm/index.html'
ua = {'User-Agent' : 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) Chrome/65.0.3325.181'}
rqg = requests.get(url,headers = ua)
rqg.encoding = chardet.detect(rqg.content)['encoding']
html = rqg.content.decode('utf-8')
soup = BeautifulSoup(html, "lxml")
target = soup.title.string
print("标题的内容:", target)
# 插入数据
title = "tipdm"
sql = "insert into class (name,text)values(%s,%s)"
cursor.execute(sql,(title,target))          # 执行插入语句
conn.commit()           # 提交事务
# 查询数据
data=cursor.execute("select * from class")
# 使用fetchall方法获取操作结果
data=cursor.fetchmany()
print("查询获取的结果:", data)
conn.close()