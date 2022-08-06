from selenium import webdriver
from selenium.webdriver.chrome.service import Service

path = Service('C:\Program Files\Google\Chrome\Application\chrome.exe')
browser = webdriver.Chrome(service=path)
try:
    browser.get("http://10.1.208.228:9991/acam/?ticket=ST-1885-Lod9wj8ZD18QyoNmkjLi&host=10.1.208.228:9991#/iframe/25020016?_r=1658886884662")
finally:
    browser.close()