import pymongo
MONGO_URL = 'localhost'
client = pymongo.MongoClient(MONGO_URL)
# ѡ��pythondb���ݿ�
db = client['pythondb']
# ʹ��test����
collection = db.test
# ������������JSON���ݽ��б�������ȡ
for n in news:
    picPath = n['picPath']
    newsContent = n['newsContent']
    mainTitle = n['mainTitle']
    staticInfoUrl = n['staticInfoUrl']
    newsDate = n['newsDate']
    a = {'newsContent': n['newsContent'],'picPath':n['picPath'],'mainTitle':n['mainTitle'],'staticInfoUrl':n['staticInfoUrl'],'newsDate':n['newsDate']}
    collection.insert_one(a)
    print(a)
