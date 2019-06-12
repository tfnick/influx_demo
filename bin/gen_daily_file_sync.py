#coding=UTF-8
#!/usr/bin/python
from string import Template
from help import HelpUtil
import time

# 模拟生成日终任务执行状态日志，日志符合influxdb line-protocal format
def emit(time_list):

    _task_name = ['zy_daily_sync','zhonghui_daily_sync']
    #1：处理中,2 部分失败,3：成功,4:失败
    _task_status = ['2','3','4']

    for item in time_list:
        
        tmp_line = Template("m_daily_file_sync,task_name=${task_name} task_status=\"${task_status}\",rt=${rt},file_num=${file_num},error_file_name=\"${error_file_name}\" ${etime}")
        
        line = tmp_line.substitute(
            task_name = HelpUtil.random_choose_one(_task_name),

            task_status = HelpUtil.random_choose_one(_task_status),
            rt = HelpUtil.range_random_choose_one(200,1000000),
            file_num=5,
            error_file_name='zyxx104_20190605.dat',
            etime=item
        )

        HelpUtil.append("/home/GR/Logs/gr_app","m_daily_file_sync.log",line)

if __name__ == '__main__':
    #时间区间
    year = 2019
    month = 6
    day = 11
    start_hour = 0
    end_hour = 23 #max = 23
    #模拟多少条数据
    num_emit = 1
    #1顺序模式或者2随机模式
    mode=1

    if mode == 1:
        for i in range(num_emit):
            time_list = HelpUtil.random_sort_time_series(year,month,day,start_hour,end_hour,1)
            emit(time_list)
            time.sleep(1)
    else:
        time_list = HelpUtil.random_sort_time_series(year,month,day,start_hour,end_hour,num_emit)
        emit(time_list)
    
    

    print('done')