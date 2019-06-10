#coding=UTF-8
#!/usr/bin/python
from string import Template
from help import HelpUtil
import uuid

# 模拟生成提现结果通知，日志符合influxdb line-protocal format
def emit(time_list):

    _etype = ['DRAW']
    _draw_sts = ['01','03']
    _real_money = [1000,3000,8000]

    for item in time_list:
        
        tmp_line = Template("m_draw_notify,cid=${cid},prod_code=${prod_code},draw_sts=${draw_sts} seq_num=\"${seq_num}\",uid=\"${uid}\",real_money=${real_money} ${etime}")
        
        line = tmp_line.substitute(
            cid = 1,
            prod_code='p1',
            etype = HelpUtil.random_choose_one(_etype),
            draw_sts=HelpUtil.random_choose_one(_draw_sts),

            seq_num = uuid.uuid1(),
            uid=uuid.uuid1(),
            real_money=HelpUtil.random_choose_one(_real_money),
            

            etime=item
        )

        HelpUtil.append("/home/GR/Logs/gr_biz","m_draw_notify.log",line)

if __name__ == '__main__':
    #时间区间
    year = 2019
    month = 6
    day = 10
    start_hour = 0
    end_hour = 23 #max = 23
    #模拟多少条数据
    num_emit = 1000

    time_list = HelpUtil.random_sort_time_series(year,month,day,start_hour,end_hour,num_emit)
    
    emit(time_list)

    print('done')