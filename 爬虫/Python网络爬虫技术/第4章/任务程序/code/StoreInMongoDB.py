from pyquery import PyQuery as pq
from selenium import webdriver
from selenium.common.exceptions import TimeoutException
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import re
# 创建WebDriver对象
browser = webdriver.Chrome()
# 等待变量
wait = WebDriverWait(browser,10)
# 模拟搜索Python编程基础
import pymongo
client = pymongo.MongoClient('localhost')
db = client['taobao']  
MONGO_TABLE = 'pythonbook' 
# 等待输入框加载完成
def search():
    try:
        browser.get('https://www.taobao.com/')
        tb_input = wait.until(
            EC.presence_of_element_located((By.CSS_SELECTOR, '#q'))
        )
# 等待搜索按钮加载完成
        search_btn = wait.until(
            EC.element_to_be_clickable((By.CSS_SELECTOR, '#J_TSearchForm > div.search-button > button'))
        )
        tb_input.send_keys('Python编程基础')#输入框中传入“Python编程基础”
# 点击搜索
        search_btn.click()
# 加载完成，获取页数元素
        total = wait.until(
            EC.presence_of_element_located((By.CSS_SELECTOR, '#mainsrp-pager > div > div > div > div.total'))
        )
        get_products()
# 获取元素中的文本
        return total.text
# 若发生异常，重新调用自己
    except TimeoutException:
        return search()
# 翻页函数
# 等待翻页输入框加载完成
def next_page(page_number):
    try:
        page_input = wait.until(
            EC.presence_of_element_located((By.CSS_SELECTOR, '#mainsrp-pager > div > div > div > div.form > input'))
        )
# 等待确认按钮加载完成
        confirm_btn = wait.until(
            EC.element_to_be_clickable((By.CSS_SELECTOR, '#mainsrp-pager > div > div > div > div.form > span.btn.J_Submit'))
        )
        page_input.clear()                           # 清空翻页输入框
        page_input.send_keys(page_number)           # 传入页数
        confirm_btn.click()                         # 确认点击翻页
# 确认已翻到page_number页
        wait.until(EC.text_to_be_present_in_element(
            (By.CSS_SELECTOR, '#mainsrp-pager > div > div > div > ul > li.item.active > span'), str(page_number))
        )
        get_products()
# 若发生异常，重新调用自己
    except TimeoutException:
        next_page(page_number)
# 获取商品信息
# 等待商品信息加载完成，商品信息的CSS选择器分析HTML源码得到
def get_products():
    wait.until(
        EC.presence_of_element_located((By.CSS_SELECTOR, '#mainsrp-itemlist .items .item'))
    )
    html = browser.page_source                         # 得到页面HTML源码
    doc = pq(html)                                   # 创建PyQuery对象
    items = doc('#mainsrp-itemlist .items .item').items()     # 获取当前页所有商品信息的html源码
    for item in items:
        product = {
            'image':item.find('.pic .img').attr('src'),
            'price':item.find('.price').text(),
            'deal':item.find('.deal-cnt').text()[:-3],
            'title':item.find('.title').text(),
            'shop':item.find('.shop').text(),
            'location':item.find('.location').text()
        }
        print(product)
        save_to_mongo(product)

def save_to_mongo(result):
	try:
		if db[MONGO_TABLE].insert(result):
			print('存储成功',result)
	except Exception:
		print('存储失败',result)

def main():
	total = search()
# '\d'表示匹配数字
	total = int(re.search('(\d+)',total).group(1))   
	for i in range(2,total+1):
		next_page(i)

if __name__ == '__main__':
    main()
