import requests as re
uername = ****        # �û���
form_password = ***   # �û�����
respons=re.post('https://www.douban.com/accounts/login',data={'form_email':uername,'form_password':form_password})
respons.content.decode('utf-8')
