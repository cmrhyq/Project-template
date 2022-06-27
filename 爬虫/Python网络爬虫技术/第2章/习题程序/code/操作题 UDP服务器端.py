# -*- coding: utf-8 -*-
"""
Created on Thu Jul 26 15:11:28 2018

@author: tipdm
"""

#导入socket库
import socket
#建立UDP连接
s = socket.socket(socket.AF_INET, socket. SOCK_DGRAM)
#绑定地址与端口
s.bind(('localhost', 2018))
print('set UDP on 2018...')
while True:
    # 接收来自任意客户端的数据:
    data, addr = s.recvfrom(1024)
    #打印接受信息并回传欢迎信息
    print('Received from %s:%s.' % addr)
    s.sendto(b'Welcom! %s!' % data, addr)
