import requests as re
uername = ****        # 用户名
form_password = ***   # 用户密码
respons=re.post('https://www.douban.com/accounts/login',data={'form_email':uername,'form_password':form_password})
respons.content.decode('utf-8')
