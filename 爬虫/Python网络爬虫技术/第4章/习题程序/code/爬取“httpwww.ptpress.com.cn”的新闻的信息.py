import requests
import json
url = 'http://www.ptpress.com.cn/newsInfo/getNewsInfoForGrid'
return_data = requests.get(url).text  # 在需要爬取的URL网页进行HTTP请求
data = json.loads(return_data)  # 对HTTP响应的数据JSON化
news = data['data']  # 索引到需要爬取的内容信息
for n in news:  # 对索引出来的JSON数据进行遍历和提取
    picPath = n['picPath']
    newsContent = n['newsContent']
    mainTitle = n['mainTitle']
    staticInfoUrl = n['staticInfoUrl']
    newsDate = n['newsDate']
    print("新闻标题：",mainTitle,'\n',"图片路径：",picPath,'\n',"新闻内容：",newsContent,'\n',"新闻详情页面路径：",staticInfoUrl,'\n',"新闻发生时间：",newsDate,'\n')
