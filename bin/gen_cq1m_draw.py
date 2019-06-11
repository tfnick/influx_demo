#coding=UTF-8
#!/usr/bin/python
from string import Template
from help import HelpUtil
import uuid

# 模拟日志，日志符合influxdb line-protocal format
def emit(time_list):

    _etype = ['NEW_APPLY','DRAW']

    for item in time_list:
        
        tmp_line = Template("cq1m_draw,cid=${cid},prod_code=${prod_code} value=${value},total=${total} ${etime}")
        
        line = tmp_line.substitute(
            cid = 1,
            prod_code='p1',

            value = HelpUtil.range_random_choose_one(1,50),
            total = HelpUtil.range_random_choose_one(50,100),
            
            etime=item
        )

        HelpUtil.append("/home/GR/Logs/gr_biz","cq1m_draw.log",line)

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

    time_list = HelpUtil.random_sort_time_series(year,month,day,start_hour,end_hour,num_emit,mode)
    
    emit(time_list)

    print('done')