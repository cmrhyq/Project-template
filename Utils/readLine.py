# !/usr/bin/env python
# Author: AlanHuang
# Time: 2022/5/7 16:43
# Description: 读取文本中的每一行的指定起始位到结束位中间的值得和

import tkinter as t
import logging
import datetime
import os
from tkinter import filedialog


def read(src, start_index, end_index):
    print("读取的文件路径为：", src)
    read_list = []
    try:
        for line in open(src):
            read_list.append(str(line)[int(start_index):int(end_index)].strip())
    except IOError:
        print("Error:文件错误")
    else:
        print("读取后的结果为:", read_list)
    return read_list


def clean_up(num_list):
    for i in range(len(num_list) - 1):
        if num_list[i] == '' or i == 0 or i == len(num_list) - 1:
            num_list.remove(num_list[i])
    print("清洗后的结果为：", num_list)
    return num_list


def calculate(num_list):
    sum_num = 0
    try:
        for i in range(len(num_list)):
            sum_num += int(num_list[i])
        print("计算后的结果为：", sum_num)
    except ValueError:
        print("Error：读取的值类型错误或者其中有空格或其他字符")
    except OverflowError:
        print("数值运算结果太大无法表示")
    return sum_num


def output_file(num_list, src):
    file_src = ""
    time = datetime.datetime.now()
    split_file = src.split("/")
    for i in range(len(split_file) - 1):
        file_src += str(split_file[i]) + "/"
    output_src = file_src + str(time).replace(":", ".") + ".txt"
    print(output_src)
    with open(output_src, 'w') as f:
        for i in range(len(num_list)):
            f.write(num_list[i] + '\n')


if __name__ == '__main__':
    choose = int(input("【1】计算每一行指定位置的值 【2】读取每一行指定位置并写入新文件 \n"))
    if choose == 1:
        file_path = filedialog.askopenfilename()
        start = input("请输入起始位置：")
        end = input("请输入结束位置：")
        calculate(clean_up(read(file_path, int(start), int(end))))
        input()
    elif choose == 2:
        file_path = filedialog.askopenfilename()
        start = input("请输入起始位置：")
        end = input("请输入结束位置：")
        output_file(read(file_path, int(start), int(end)), file_path)
    else:
        print("暂无此功能！")
