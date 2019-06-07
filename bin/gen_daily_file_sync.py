#coding=UTF-8
#!/usr/bin/python
from string import Template
from help import HelpUtil

# 模拟生成日终任务执行状态日志，日志符合influxdb line-protocal format
def emit(time_list):

    _task_name = ['zy_daily','zhonghui_daily']
    _task_status = ['1','2','3']

    for item in time_list:
        
        tmp_line = Template("m_daily_file_sync,task_name=${task_name} task_status=\"${task_status}\",file_num=${file_num},error_file_name=\"${error_file_name}\" ${etime}")
        
        line = tmp_line.substitute(
            task_name = HelpUtil.random_choose_one(_task_name),
            task_status = HelpUtil.random_choose_one(_task_status),
            file_num=5,
            error_file_name='zyxx104_20190605.dat',
            etime=item
        )

        HelpUtil.append("/Users/nick/Documents/SOURCES/influx_demo/bin","m_daily_file_sync.log",line)

if __name__ == '__main__':
    #时间区间
    year = 2019
    month = 6
    day = 5
    start_hour = 0
    end_hour = 23
    #模拟多少条数据
    num_emit = 10

    time_list = HelpUtil.random_sort_time_series(year,month,day,start_hour,end_hour,num_emit)
    
    emit(time_list)

    print('done')