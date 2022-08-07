# !/usr/bin/env python
# Author: AlanHuang
# Time: 2022/8/7 13:47
# Description: 
import yaml
import os


def read_yaml_content():
    # 获取当前文件的路径
    file_path = os.path.dirname(__file__)
    # 获取当前文件的real path
    file_name_path = os.path.split(os.path.realpath(__file__))[0]
    # 获取配置文件路径
    yaml_path = os.path.join(file_name_path, 'web_config.yaml')
    file = open(yaml_path, 'r', encoding='utf-8')
    content = yaml.load(file.read())
    return content


if __name__ == '__main__':
    read_yaml_content()
