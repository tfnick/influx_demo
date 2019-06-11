#coding=UTF-8
#!/usr/bin/python
from string import Template
from help import HelpUtil
import uuid
import time 

# 模拟日志，日志符合influxdb line-protocal format
def emit(time_list):

    _etype = ['NEW_APPLY','DRAW']
    _rule_set = ['rs1','rs2','rs3','rs3','rs3','rs4','rs5','rs6']
    _rule = ['r1','r2','r3','r4','r5','r6','r7','r8','r9','r9']

    for item in time_list:
        
        tmp_line = Template("cq1m_hit_rule_set,cid=${cid},prod_code=${prod_code},etype=${etype},rule_set=${rule_set} value=${value},total=${total} ${etime}")
        
        line = tmp_line.substitute(
            cid = 1,
            prod_code='p1',
            etype=HelpUtil.random_choose_one(_etype),
            rule_set=HelpUtil.random_choose_one(_rule_set),

            value = HelpUtil.range_random_choose_one(1,50),
            total = HelpUtil.range_random_choose_one(50,100),
            
            etime=item
        )

        HelpUtil.append("/home/GR/Logs/gr_biz","cq1m_hit_rule_set.log",line)

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