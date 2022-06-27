import requests
import json
url = 'http://www.ptpress.com.cn/newsInfo/getNewsInfoForGrid'
return_data = requests.get(url).text  # ����Ҫ��ȡ��URL��ҳ����HTTP����
data = json.loads(return_data)  # ��HTTP��Ӧ������JSON��
news = data['data']  # ��������Ҫ��ȡ��������Ϣ
for n in news:  # ������������JSON���ݽ��б�������ȡ
    picPath = n['picPath']
    newsContent = n['newsContent']
    mainTitle = n['mainTitle']
    staticInfoUrl = n['staticInfoUrl']
    newsDate = n['newsDate']
    print("���ű��⣺",mainTitle,'\n',"ͼƬ·����",picPath,'\n',"�������ݣ�",newsContent,'\n',"��������ҳ��·����",staticInfoUrl,'\n',"���ŷ���ʱ�䣺",newsDate,'\n')
