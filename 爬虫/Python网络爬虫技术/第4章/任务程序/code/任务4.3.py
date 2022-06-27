# 代码 4-12

import pymongo
client = pymongo.MongoClient('mongodb://localhost:27017/')
# 选择pythondb数据库
db = client.pythondb



# 代码 4-13

client = pymongo.MongoClient()
# 选择python-db数据库
db = client['python-db'] 



# 代码 4-14

MONGO_URL = 'localhost'
client = pymongo.MongoClient(MONGO_URL)
# 选择pythondb数据库
db = client['pythondb'] 
# 使用test集合
collection = db.test



# 代码 4-15

import pymongo
MONGO_URL = 'localhost'
client = pymongo.MongoClient(MONGO_URL)
# 选择pythondb数据库
db = client['pythondb']  
# 使用test集合
collection = db['test']



# 代码 4-16

python StoreInMongoDB.py