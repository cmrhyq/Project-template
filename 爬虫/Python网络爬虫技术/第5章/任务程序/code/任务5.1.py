# 代码 5-1

import requests                                   # 导入Requests库
from PIL import Image                             # 导入PIL库的Image模块
headers = {'User-Agent' : 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) Chrome/65.0.3325.181'}
captcha_url = 'http://www.tipdm.org/captcha.svl'
response = requests.get(captcha_url, headers=headers)
with open('../tmp/captcha.gif', 'wb') as f:
	f.write(response.content)                        
im = Image.open('../tmp/captcha.gif')                        # 创建image对象
im.show()                                        # 显示图片，会在电脑上自动弹出    
captcha = input('请输入验证码： ')    
print(captcha) 



# 代码 5-2

proxies = {'http': 'http://172.18.101.221:3182'}
r = requests.get("http://www.tipdm.org", proxies=proxies)
print(r.status_code)
# 可能因代理失效报错



# 代码 5-3

proxies = {'http': 'http://root:12345@10.10.1.10:3128/'}
r = requests.get("http://www.tipdm.org/bdrace/index.html", proxies=proxies)
print(r.statue_code)



# 代码 5-4

data = {'username': 'pc2019','password':'pc2019','captcha':'begv'}
r = requests.post('http://www.tipdm.org/login.jspx', data=data)
print(r)



# 代码 5-5

data = {'username': 'pc2019','password':'pc2019','captcha':'begv'}
s = requests.session()
r = s.post('http://www.tipdm.org/login.jspx', data=data)
print(r)



# 代码 5-6

import requests
from PIL import Image 
s = requests.session()                              #  建立session对象
login_url = 'http://www.tipdm.org/login.jspx'               # 真实表单数据提交入口 
headers = {'User-Agent' : 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) Chrome/65.0.3325.181'}
# 验证码识别函数
def get_captcha():
	captcha_url = 'http://www.tipdm.org/captcha.svl'        # 验证码图片生成地址
	response = s.get(captcha_url, headers=headers)
	with open('../tmp/captcha.gif', 'wb') as f:
		f.write(response.content)                       # 下载验证码图片
	im = Image.open('../tmp/captcha.gif')                      # 创建image对象
	im.show()                                      # 显示图片
	captcha = input('请输入输入验证码： ')             # 输入验证码，然后按回车键
	return captcha
# 提交表单数据，使用POST请求模拟登录
login_data = {'username': 'pc2019','password': 'pc2019','captcha':get_captcha()} 
r = s.post(login_url, data=login_data, headers=headers)    
# 测试是否成功登陆
print(r.url)





