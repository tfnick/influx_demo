#coding=UTF-8
#!/usr/bin/python
from string import Template
import time
import os

# 模拟生成日终任务执行状态日志，日志符合influxdb line-protocal format
def emit():
    tmp_line = Template("daily_sync_task,task_name=${task_name} task_status=\"${task_status}\",file_num=${file_num},error_file_name=\"${error_file_name}\" ${etime}")
    line = tmp_line.substitute(task_name='zy_daily',task_status='1',file_num=5,error_file_name='zyxx104_20190605.dat',etime='%d' % (time.time() * 1000000))

    path = "/home/GR/Logs/"
    fn = "daily_sync_task.log"
    if not os.path.exists(path):
       os.makedirs(path)
    f = open(path + fn,"a+")
    f.write(line + "\n")
    f.close

if __name__ == '__main__':
    emit()