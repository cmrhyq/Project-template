from selenium import webdriver
from config.read_yaml import read_yaml_content
from selenium.webdriver.chrome.service import Service

config = read_yaml_content()
path = Service(config['webInterface']['edge']['path'])
browser = webdriver.Edge(service=path)
try:
    browser.get("http://10.1.208.228:9991/acam/?ticket=ST-1885-Lod9wj8ZD18QyoNmkjLi&host=10.1.208.228:9991#/iframe"
                "/25020016?_r=1658886884662")
finally:
    browser.close()
