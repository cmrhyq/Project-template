# 代码 4-2

from selenium import webdriver
driver = webdriver.Chrome()
driver.get('http://www.ptpress.com.cn/search/books')
data = driver.page_source
print(data)
driver.quit()



# 代码 4-3

from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
driver = webdriver.Chrome()
driver.get('http://www.ptpress.com.cn/search/books')
wait = WebDriverWait(browser, 10)
# 确认元素是否可单击
print(confirm_btn)
driver.close()



# 代码 4-4

import time
browser = webdriver.Chrome()
driver.get('http://www.ptpress.com.cn/search/books')
browser.execute_script('window.open()')
print(browser.window_handles)
browser.switch_to_window(browser.window_handles[1])
browser.get('http://www.tipdm.com')
time.sleep(1)
browser.switch_to_window(browser.window_handles[0])
browser.get('http://www.tipdm.org')



# 代码 4-5

from selenium.webdriver.common.by import By
wait = WebDriverWait(driver,10)
# 等待确认按钮加载完成
confirm_btn = wait.until(EC.element_to_be_clickable((By.CSS_SELECTOR, '#app > div:nth-child(1) > div > div > div > button > i')))
# 单击搜索        
search_btn.click()




# 代码 4-6

driver.get("http://www.ptpress.com.cn/search/books")
# 翻到底页
browser.execute_script('window.scrollTo(0, document.body.scrollHeight)')       
browser.execute_script('alert("python爬虫")')



# 代码 4-7

driver.get("http://www.ptpress.com.cn/search/books")
input_first = browser.find_element_by_id("searchVal")
input_second = browser.find_element_by_css_selector("#searchVal")
input_third = browser.find_element_by_xpath('//*[@id="searchVal"]')
print(input_first)
print(input_second)
print(input_third)
browser.close()



# 代码 4-8

driver = webdriver.Chrome()
driver.get("http://www.ptpress.com.cn/search/books")
input_first = browser.find_element(By.ID,"searchVal")
print(input_first)
browser.close()



# 代码 4-9

driver = webdriver.Chrome()
driver.get("http://www.ptpress.com.cn/search/books")
lis = driver.find_elements_by_css_selector('#nav')
print(lis)
driver.close()



# 代码 4-10

driver = webdriver.Chrome()
driver.get("http://www.ptpress.com.cn/search/books")
lis = driver.find_elements(By.CSS_SELECTOR,'#nav')
print(lis)
driver.close()



# 代码 4-11

python PythonMessage.py

