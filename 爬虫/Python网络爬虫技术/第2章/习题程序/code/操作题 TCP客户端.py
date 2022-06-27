# -*- coding: utf-8 -*-
"""
Created on Thu Jul 26 14:22:05 2018

@author: tipdm
"""
#TCP客户端
#导入socket库
import socket
#建立TCP连接
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
#与服务器建立连接
s.connect(('localhost', 2018))
#接受服务器的连接成功提示信息
print(s.recv(1024).decode('utf-8'))
# 发送数据并接受服务器返回结果
for data in [b'Tom', b'Jerry', b'Spike']:
    s.send(data)
    print(s.recv(1024).decode('utf-8'))
#发送退出信息断开连接
s.send(b'exit')
s.close()
