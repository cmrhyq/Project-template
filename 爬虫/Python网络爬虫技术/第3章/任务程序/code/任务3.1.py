# 代码 3-1

# 导入urllib3库
import urllib3
# 创建PoolManager实例
http = urllib3.PoolManager()
# 通过reques方法创建请求，此处使用GET方法
rq = http.request('GET', 'http://www.tipdm.com/tipdm/index.html')
# 查看服务器响应码
print("服务器响应码:", rq.status)
# 查看响应实体
print("响应实体:", rq.data)



# 代码 3-2

ua = {'User-Agent' : 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) Chrome/65.0.3325.181'}
rq = http.request('GET','http://www.tipdm.com/tipdm/index.html',headers = ua)



# 代码 3-3

# 直接在url参数之后添加统一的timeout参数
url = 'http://www.tipdm.com/tipdm/index.html'
rq = http.request('GET',url,timeout = 3.0)
# 分别设置连接与读取的timeout参数
rq = http.request('GET',url,timeout = urllib3.Timeout(connect = 1.0 , read = 3.0))
# 在PoolManager实例中设置timeout参数
http = urllib3.PoolManager(timeout = 4.0)
http = urllib3.PoolManager(timeout = urllib3.Timeout(connect = 1.0 , read = 3.0))



# 代码 3-4

# 直接在url之后添加retries参数
url = 'http://www.tipdm.com/tipdm/index.html'
rq = http.request('GET',url, retries = 10)
# 分别设置5次请求重试次数与4次重定向的retries参数
rq = http.request('GET',url, retries = 5 , redirect = 4)
# 同时关闭请求重试与重定向
rq = http.request('GET',url, retries = False)
# 仅关闭重定向
rq = http.request('GET',url, redirect = False)
# 在PoolManager实例中设置retries参数
http = urllib3.PoolManager(retries = 5)
http = urllib3.PoolManager(timeout = urllib3.Retry(5 , read = 4))



# 代码 3-5

# 创建PoolManager实例
http = urllib3.PoolManager()
# 目标url
url = 'http://www.tipdm.com/tipdm/index.html'
# 设置请求头，UA信息
ua = {'User-Agent' : 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) Chrome/65.0.3325.181'}
# 设置超时时间
tm = urllib3.Timeout(connect = 1.0 , read = 3.0)
# 设置重试次数并生成请求
rq = http.request('GET',url, headers = ua,timeout = tm, retries = 5 , redirect = 4)
# 查看服务器响应码
print("服务器响应码:", rq.status)
# 查看获取的内容
print("获取的内容:", rq.data.decode('utf-8'))



# 代码 3-6

import requests
url = 'http://www.tipdm.com/tipdm/index.html'
# 生成GET请求
rqg = requests.get(url)
print("结果类型:", type(rqg))        # 查看结果类型
print("状态码:", rqg.status_code)    # 查看状态码
print("编码:", rqg.encoding)     # 查看编码
print("响应头:", rqg.headers)      # 查看响应头



# 代码 3-7

url = 'http://www.tipdm.com/tipdm/index.html'
rqg = requests.get(url)
print("状态码:", rqg.status_code)   # 查看状态码
print("编码:", rqg.encoding)     # 查看编码
rqg.encoding  = 'utf-8'  # 手动指定编码
print("修改后的编码:", rqg.encoding)     # 查看修改后的编码



# 代码 3-8

import chardet
url = 'http://www.tipdm.com/tipdm/index.html'
rqg = requests.get(url)
print("编码:", rqg.encoding)     # 查看编码
print("detect方法检测结果:", chardet.detect(rqg.content))
rqg.encoding = chardet.detect(rqg.content)['encoding']  # 将检测到的编码赋值给rqg.encoding
print("改变后的编码:", rqg.encoding)     # 查看改变后的编码



# 代码 3-9

url = 'http://www.tipdm.com/tipdm/index.html'
headers = {'User-Agent' : 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) Chrome/65.0.3325.181'}
rqg = requests.get(url,headers = headers)
print("响应头:", rqg.headers)      # 查看响应头



# 代码 3-10

url = 'http://www.tipdm.com/tipdm/index.html'
print("超时时间为2:", requests.get(url, timeout=2))
requests.get(url, timeout=0.001)         # 由于超时时间过短将会报错

# 代码 3-11

import chardet
# 设置url
url = 'http://www.tipdm.com/tipdm/index.html'
# 设置请求头
headers= {'User-Agent' : 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) Chrome/65.0.3325.181'}
# 生成GET请求
rqg = requests.get(url, headers = headers, timeout=2)
print("状态码:", rqg.status_code)   # 查看状态码
print("编码:", rqg.encoding)     # 查看编码
# 修正编码
rqg.encoding = chardet.detect(rqg.content)['encoding']
print("修改后的编码:", rqg.encoding)     # 查看修改后的编码
print("响应头:", rqg.headers)      # 查看响应头
print(rqg.text)         # 查看网页内容
