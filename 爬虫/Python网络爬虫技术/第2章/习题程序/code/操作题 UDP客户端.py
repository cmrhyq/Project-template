# -*- coding: utf-8 -*-
"""
Created on Thu Jul 26 15:16:23 2018

@author: tipdm
"""

#导入socket库
import socket
#建立TCP连接
s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
#发送数据并接受服务器回传数据
for data in [b'Tom', b'Jerry', b'Spike']:
    s.sendto(data,('localhost', 2018))
    print(s.recv(1024).decode('utf-8'))
s.close()
