#coding=UTF-8
#!/usr/bin/python
from string import Template
from help import HelpUtil
import uuid

# 模拟生成审批日志，日志符合influxdb line-protocal format
def emit(time_list):

    _etype = ['NEW_APPLY','DRAW']
    _advice = ['A','B']
    _money = [1000,3000,8000]

    for item in time_list:
        
        tmp_line = Template("m_audit,cid=${cid},prod_code=${prod_code},etype=${etype},advice=${advice} seq_num=\"${seq_num}\",uid=\"${uid}\",money=${money},accept=${accpet},num=1 ${etime}")
        
        ##???[0]
        tmp_advice = HelpUtil.random_choose_one(_advice),
        accept_ = 0
        if tmp_advice[0] == 'A':
            accept_ = 1
        line = tmp_line.substitute(
            cid = 1,
            prod_code='p1',
            etype = HelpUtil.random_choose_one(_etype),
            advice = tmp_advice[0],

            seq_num = uuid.uuid1(),
            uid=uuid.uuid1(),
            money=HelpUtil.random_choose_one(_money),
            accpet = accept_,
            
            etime=item
        )

        HelpUtil.append("/home/GR/Logs/gr_biz","m_audit.log",line)

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