import requests
import urllib
url = 'http://app.peopleapp.com/Api/600/HomeApi/getContentList?category_id=1&city=%E5%B9%BF%E5%B7%9E%E5%B8%82&citycode=020&device=7131698b-7bbc-3745-a40b-f3b4bb77c2a9&device_model=FRD-AL00&device_os=Android%207.0&device_product=HUAWEI&device_size=1080*1794&device_type=1&district=%E9%BB%84%E5%9F%94%E5%8C%BA&fake_id=8335979&id=112&image_height=1794&image_wide=1080&interface_code=621&latitude=23.161355&longitude=113.475175&page=1&province=%E5%B9%BF%E4%B8%9C%E7%9C%81&province_code=1527129348000&refresh_tag=0&refresh_time=1527129000&show_num=20&update_time=0&userId=0&version=6.2.1&securitykey=e261fedba9e052bdea12b1e034fb7aae'
response = requests.get(url).json()
urls = []
for i in response['hots']:
    image = i['image']
    for j in image:
      urls.append(j['url'])
      print(j['url'])
#保存到本地
x = 0
for imgurl in urls:
    urllib.request.urlretrieve(imgurl,r'../tmp/%s.jpg' % x)
    x += 1