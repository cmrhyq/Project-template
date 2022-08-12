import time
import logging
from config.log import log_out
from selenium import webdriver
from selenium.webdriver.common.by import By
from config.read_yaml import read_yaml_content
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.action_chains import ActionChains

config = read_yaml_content()
path = Service(config['webInterface']['chrome']['path'])
browser = webdriver.Chrome(service=path)


def login():
    try:
        browser.get(config['webInterface']['url'])
        logging.info('login url is:' + config['webInterface']['url'])
        # print(log_out(), 'login url is:' + config['webInterface']['url'])
        account_elem = browser.find_element(By.ID, 'username')
        account_elem.send_keys(config['safety']['account'])
        logging.info('input account:' + config['safety']['account'])
        # print(log_out(), 'input account:' + config['safety']['account'])
        pwd_elem = browser.find_element(By.ID, 'password')
        pwd_elem.send_keys(config['safety']['password'])
        browser.find_element(By.ID, 'loginButton').click()
        time.sleep(3)
    except Exception as err:
        print(err)


def to_app_manage():
    manage_btn = browser.find_element(By.CSS_SELECTOR, 'span.icon.iconfont.icon-mYyddgl')
    ActionChains(browser).move_to_element(manage_btn).perform()
    app_manage_btn = browser.find_element(By.XPATH, '//li[@data-url="/#/apply-configure-manage/apply-manage"]')
    app_manage_btn.click()


if __name__ == '__main__':
    login()
    to_app_manage()
