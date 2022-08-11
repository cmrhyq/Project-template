import sys
import os
from datetime import datetime
from config.read_yaml import read_yaml_content

config = read_yaml_content()
now_time = datetime.now().strftime('%Y-%m-%d %H:%M:%S.%f')
cur_path = os.path.abspath(os.path.dirname(__file__))
root_path = cur_path[:cur_path.find("ACAM_Automation") + len("ACAM_Automation")]
log_path = root_path + '\log\log' + now_time + '.txt'

def log_out(x=sys._getframe()):
    print(root_path)
    message = now_time + " [" + str(os.getpid()) + "] " + __file__ + " " + str(x.f_lineno) + " "
    with open(log_path, 'w', encoding='utf-8') as file:
        file.write(message + "\n")
    return message
