# 代码 3-12

import re
pat = re.compile(r'\d+')   # 转换用于匹配数字的正则表达式
print("成功匹配:", re.search(pat,'abc45'))   # 成功匹配到45



# 代码 3-13

import re
pat = re.compile(r'\d+')   # 转换用于匹配数字的正则表达式
print("成功找出:", re.findall(pat,'ab2c3ed'))   # 将找出其中的2、3



# 代码 3-14

import re
# 调用requests库获取的网页
import requests
import chardet
url = 'http://www.tipdm.com/tipdm/index.html'
ua = {'User-Agent' : 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) Chrome/65.0.3325.181'}
rqg = requests.get(url,headers = ua)
rqg.encoding = chardet.detect(rqg.content)['encoding']
# 使用search方法查找title中的内容
title_pattern = r'(?<=<title>).*?(?=</title>)'  
title_com = re.compile(title_pattern,re.M|re.S)  
title_search = re.search(title_com,rqg.text)
title = title_search.group()
print("标题内容:", title)
# 使用findall方法查找title中的内容
print("标题内容:", re.findall(r'<title>(.*?)</title>',rqg.text))



# 代码 3-15

# 导入etree模块
from lxml import etree
# 初始化HTML
html = rqg.content.decode('utf-8')
html = etree.HTML(html,parser=etree.HTMLParser(encoding='utf-8'))
# 输出修正后的HTML（如有必要）
result = etree.tostring(html,encoding='utf-8',pretty_print=True, method="html")
print("修正后的HTML:", result)



# 代码 3-16

# 从本地文件导入，test.html为保存的使用requests库获取的网页
html_local = etree.parse('./test.html', etree.HTMLParser(encoding='utf-8'))
result = etree.tostring(html_local)
print("本地文件导入的HTML:", result)



# 代码 3-17

# 通过名称定位head节点
result = html.xpath('head')
print("名称定位结果:", result)
# 按节点层级定位title节点
result1 = html.xpath('/html/head/title')
print("节点层级定位结果:", result1)
# 通过名称定位title节点
result2 = html.xpath('title')
print("名称定位title节点结果:", result2)
# 另一种方式定位title节点
result3 = html.xpath('//title')
print("搜索定位title节点结果:", result3)



# 代码 3-18

# 定位header节点
result1 = html.xpath('//header[@class]')
print("class属性定位结果:", result1 )
# 定位ul节点
result2 = html.xpath('//ul[@id="menu"]')
print("id属性定位结果:", result2)



# 代码 3-19

# 获取title节点的文本内容
title = html.xpath('//title/text()')
print("title节点的文本内容:", title)



# 代码 3-20

# 定位id值以me开头的ul节点并提取其所有子孙节点a内的文本内容
content=html.xpath('//ul[starts-with(@id,"me")]/li//a/text()')
for i in content:
    print(i )
# 提取对应链接
url_list = html.xpath('//ul[starts-with(@id,"me")]/li//a/@href')
for i in url_list:
    print(i)
# 定位id值以me开头的ul节点
target=html.xpath('//ul[starts-with(@id,"me")]')
# 提取该节点下的全部文本内容
target_text = target[0].xpath('string(.)').strip()    # strip方法用于去除多余的空格
print("节点下的全部文本内容:", target_text)



# 代码 3-21

from bs4 import BeautifulSoup
# 调用requests库获取的网页
import requests
import chardet
url = 'http://www.tipdm.com/tipdm/index.html'
ua = {'User-Agent' : 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) Chrome/65.0.3325.181'}
rqg = requests.get(url,headers = ua)
rqg.encoding = chardet.detect(rqg.content)['encoding']
# 初始化HTML
html = rqg.content.decode('utf-8')
soup = BeautifulSoup(html, "lxml")    # 生成BeautifulSoup对象
print("输出格式化的BeautifulSoup对象:", soup.prettify())



# 代码 3-22

print("获取head标签:", soup.head)    # 获取head标签
soup.title  # 获取title标签
print("获取第一个a标签:", soup.body.a)   # 获取body标签中的第一个a标签
print("所有名称为a的标签的个数:" , len(soup.find_all('a')))    # 获取所有名称为a的标签的个数



# 代码 3-23

print("soup的name:" , soup.name)    # 获取soup的name
print("a标签的name:" , soup.a.name)     # 获取a标签的name
tag = soup.a
print("tag的name:" , tag.name)       # 获取tag的name
print ("tag的内容:" , tag)
tag.name = 'b'    # 修改tag的name
print ("修改name后tag的内容:" , tag)            # 查看修改name后的HTML



# 代码 3-24

print("Tag对象的全部属性:" , tag.attrs)    # 获取Tag对象的全部属性
print("class属性的值:" , tag['class'])     # 获取class属性的值
tag['class'] = 'Logo'  # 修改class属性的值
print("修改后Tag对象的属性:" , tag.attrs)
tag['id'] = 'logo'  # 新增属性id，赋值为logo
del tag['class']      # 删除class属性
print ("修改后tag的内容:" , tag)



# 代码 3-25
tag = soup.title
print ("Tag对象中包含的字符串:" , tag.string)    # 获取Tag对象中包含的字符串
print ("tag.string的类型:" , type(tag.string))     # 查看类型
tag.string.replace_with("泰迪科技")   # 替换字符串内容
print ("替换后的内容:" , tag.string)



# 代码 3-26



print ("soup的类型:" , type(soup))     # 查看类型
print ("BeautifulSoup对象的特殊属性name:" , soup.name)    # BeautifulSoup对象的特殊属性name
print ("soup.name的类型:" , type(soup.name))
print ("BeautifulSoup对象的attribute属性:" , soup.attrs)     # BeautifulSoup对象的attribute属性为空



# 代码 3-27

markup = "<c><!--This is a markup--></b>"
soup_comment = BeautifulSoup(markup, "lxml")
comment = soup_comment.c.string    # comment对象也由string方法获取
print ("注释的内容:" , comment)               # 直接输出时与一般NavigableString对象一致
print ("注释的类型:" , type(comment))          # 查看类型



# 代码 3-28

# 通过name参数搜索名为title的全部子节点
print ("名为title的全部子节点:" , soup.find_all("title "))
print ("title子节点的文本内容:" , soup.title.string)
print ("使用get_text()获取的文本内容:" , soup.title.get_text())
target = soup.find_all("ul", class_="menu")   # 按照CSS类名完全匹配
print("CSS类名匹配获取的节点:" , target)
target = soup.find_all(id='menu')            # 传入关键字id，按符合条件的搜索
print("关键字id匹配的节点:" , target)
target = soup.ul.find_all('a')
print("所有名称为a的节点:" , target)
# 创建两个空列表用于存放链接及文本
urls = []
text = []
# 分别提取链接和文本
for tag in target:
    urls.append(tag.get('href'))
    text.append(tag.get_text())
for url in urls:
    print(url)
for i in text:
    print(i)