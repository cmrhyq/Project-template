# -*- coding: utf-8 -*-
"""
Created on Thu Jul 26 14:02:38 2018

@author: tipdm
"""
#TCP服务器端
#导入socket库
import socket
import threading
import time
#建立TCP连接
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
#绑定地址及监听端口
s.bind(('localhost', 2018))
#调用listen方法监听端口
s.listen(5)
print('Wait for connection...')
#服务器端应答函数：
def tcp(sock, addr):
    print('Accept new connection from %s:%s...' % addr)
    sock.send(b'Success!')
    while True:
        data = sock.recv(1024)
        time.sleep(1)
        if not data or data.decode('utf-8') == 'exit':
            break
        sock.send(('Welcom! %s!' % data.decode('utf-8')).encode('utf-8'))
    sock.close()
    print('Connection from %s:%s closed.' % addr)
#循环处理客户端连接
while True:
    # 接受来自客户端的新连接:
    sock, addr = s.accept()
    # 创建新线程来处理TCP连接:
    t = threading.Thread(target=tcp, args=(sock, addr))
    t.start()

