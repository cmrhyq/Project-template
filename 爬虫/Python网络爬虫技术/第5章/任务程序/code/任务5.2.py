# 代码 5-8

login_url = 'http://www.tipdm.org/login.jspx'
headers = {'User-Agent' : 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) Chrome/65.0.3325.181'}

# 从浏览器登录后复制Cookie
cookie_str = 'te_id_cookie=1; JSESSIONID=DFC3AF053B5F5B6B4830954F2A2AAA37;clientlanguage=zh_CN; __qc_wId=740; JSESSIONID=DFC3AF053B5F5B6B4830954F2A2AAA37;username=pc2019'
# 把Cookie字符串处理成dict，以便接下来使用
cookies = {}
for line in cookie_str.split(';'):
	key, value = line.split('=', 1)
	cookies[key] = value

# 携带Cookie发送请求  
r = requests.get(login_url,cookies=cookies,headers=headers)

# 测试是否成功登陆
print('发送请求后返回的网址为：',r.url)



# 代码 5-9

import requests
from PIL import Image
# 导入cookiejar模块
from http import cookiejar

s = requests.Session()
# 创建LWPCookieJar对象，若Cookie不存在建立Cookie文件，命名为cookie
s.cookies = cookiejar.LWPCookieJar('cookie')

login_url = 'http://www.tipdm.org/login.jspx'
headers = {'User-Agent' : 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) Chrome/65.0.3325.181'}

def get_captcha():
    captcha_url = 'http://www.tipdm.org/captcha.svl'
    response = s.get(captcha_url, headers=headers)
    with open('../tmp/captcha.gif', 'wb') as f:
        f.write(response.content)
    im = Image.open('../tmp/captcha.gif')
    im.show()
    captcha = input('请输入验证码： ')
    return captcha

login_data = {'username': 'pc2019','password': 'pc2019','captcha':get_captcha()}
r = s.post(login_url, data=login_data, headers=headers)

# 测试是否成功登陆
print('发送请求后返回的网址为：',r.url)

# 保存cookie
s.cookies.save(ignore_discard=True, ignore_expires=True)



# 代码 5-10

try:
    s.cookies.load(ignore_discard=True)
except:
    print('Cookie 未能加载！')

# 携带Cookie提交请求
r = s.get(login_url, headers=headers)

# 测试是否成功登陆
print('发送请求后返回的网址为：', r.url)