#coding=UTF-8
#!/usr/bin/python
from string import Template
from help import HelpUtil
import uuid
import time

# 模拟生成请求日志，日志符合influxdb line-protocal format
def emit(time_list):

    _url = ['url1','url2','url3','url4','url5','url6']
    _invoker = ['approve','engine','entry']
    _code = [200,200,200,200,200,200,200,200,198,500,302]
    _http_sts = [200,200,200,200,200,200,200,200,500,400,404]
    # 请求处理过程是否出现异常，包括IOException，ParseException,ConnectionTimeOut等等
    _exe = [0,0,0,0,0,0,0,0,0,1]

    for item in time_list:
        
        tmp_line = Template("m_http_service,cid=${cid},invoker=${invoker},url=${url},code=${code},http_sts=${http_sts} gid=\"${gid}\",rt=${rt},tout=${tout},exe=${exe} ${etime}")
        
        st = HelpUtil.range_random_choose_one(1,10);

        tout_ = 0

        if st > 8:
            tout_ = 1

        line = tmp_line.substitute(
            cid = 1,
            invoker=HelpUtil.random_choose_one(_invoker),
            url = HelpUtil.random_choose_one(_url),
            code=HelpUtil.random_choose_one(_code),
            http_sts=HelpUtil.random_choose_one(_http_sts),

            gid=uuid.uuid1(),
            rt=HelpUtil.range_random_choose_one(200,5000),
            tout = tout_,
            exe = HelpUtil.random_choose_one(_exe),

            etime=item
        )

        HelpUtil.append("/home/GR/Logs/gr_app","m_http_service.log",line)

if __name__ == '__main__':
    #时间区间
    year = 2019
    month = 6
    day = 11
    start_hour = 0
    end_hour = 23 #max = 23
    #模拟多少条数据
    num_emit = 1000
    #1顺序模式或者2随机模式
    mode=1

    if mode == 1:
        for i in range(num_emit):
            time_list = HelpUtil.random_sort_time_series(year,month,day,start_hour,end_hour,1)
            emit(time_list)
            print('emit one ')
            time.sleep(1)
    else:
        time_list = HelpUtil.random_sort_time_series(year,month,day,start_hour,end_hour,num_emit)
        emit(time_list)

    print('done')