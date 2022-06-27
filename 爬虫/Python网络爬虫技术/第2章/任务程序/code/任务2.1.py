# 代码 2-1

# 导入socket库及依赖库
import socket
import threading
import time
# 建立TCP连接
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)



# 代码 2-2

# 绑定地址及监听端口
s.bind(('127.0.0.1', 6666))



# 代码 2-3

# 调用listen方法监听端口
s.listen(5)
print('Wait for connection...')



# 代码 2-4

# 服务器端应答函数：
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
	
	

# 代码 2-5

# 循环处理客户端连接
while True:
    # 接受来自客户端的新连接:
    sock, addr = s.accept()
    # 创建新线程来处理TCP连接:
    t = threading.Thread(target=tcp args=(sock, addr))
	t.start()



# 代码 2-6

# 导入socket库
import socket
# 建立TCP连接
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
# 与服务器建立连接
s.connect(('127.0.0.1', 6666))
# 接受服务器的连接成功提示信息
print(s.recv(1024).decode('utf-8'))
# 发送数据并接受服务器返回结果
for data in [b'Tom', b'Jerry', b'Spike']:
	s.send(data)
	print(s.recv(1024).decode('utf-8'))
# 发送退出信息断开连接
s.send(b'exit')
s.close()



# 代码 2-7

# 导入socket库
import socket
# 建立UDP连接
s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
# 绑定地址与端口
s.bind(('127.0.0.1', 6666))
print('set UDP on 6666...')
while True:
	# 接收来自任意客户端的数据:
	data, addr = s.recvfrom(1024)
	# 打印接受信息并回传欢迎信息
	print('Received from %s:%s.' % addr)
	s.sendto(b'Welcom! %s!' % data, addr)



# 代码 2-8

# 导入socket库
import socket
# 建立UDP连接
s = socket.socket(socket.AF_INET, socket. SOCK_DGRAM)

 # 发送数据并接受服务器回传数据
for data in [b'Tom', b'Jerry', b'Spike']:
	s.sendto(data, ('127.0.0.1', 99996666))
    print(s.recv(1024).decode('utf-8'))
s.close()

