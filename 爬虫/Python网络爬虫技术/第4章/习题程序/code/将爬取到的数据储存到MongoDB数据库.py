import pymongo
MONGO_URL = 'localhost'
client = pymongo.MongoClient(MONGO_URL)
# 选择pythondb数据库
db = client['pythondb']
# 使用test集合
collection = db.test
# 对索引出来的JSON数据进行遍历和提取
for n in news:
    picPath = n['picPath']
    newsContent = n['newsContent']
    mainTitle = n['mainTitle']
    staticInfoUrl = n['staticInfoUrl']
    newsDate = n['newsDate']
    a = {'newsContent': n['newsContent'],'picPath':n['picPath'],'mainTitle':n['mainTitle'],'staticInfoUrl':n['staticInfoUrl'],'newsDate':n['newsDate']}
    collection.insert_one(a)
    print(a)
