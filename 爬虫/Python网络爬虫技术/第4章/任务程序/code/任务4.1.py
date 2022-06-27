#  代码 4-1

import requests
import json
url = 'http://www.ptpress.com.cn/bookinfo/getBookListForWS'
return_data = requests.get(url).text    # 在需要爬取的URL网页进行HTTP请求
data = json.loads(return_data)        # 对HTTP响应的数据JSON化
news = data['data']                 # 索引到需要爬取的内容信息
for n in news:                     # 对索引出来的JSON数据进行遍历和提取
    bookName = n['bookName']
    author = n['author']
    price = n['price']
    print("新书名：",bookName,'\n',"作者：",author,'\n',"价格：",price)
	print('\n')