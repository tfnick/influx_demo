#coding=UTF-8
#!/usr/bin/python
from string import Template
from help import HelpUtil
import uuid

# 模拟生成请求日志，日志符合influxdb line-protocal format
def emit(time_list):

    _url = ['url1','url2','url3','url4','url5','url6']
    _invoker = ['approve','engine','entry']
    _code = [200,200,200,200,200,200,200,200,198,500,302]
    _http_sts = [200,200,200,200,200,200,200,200,500,400,404]

    for item in time_list:
        
        tmp_line = Template("m_http_service,cid=${cid},invoker=${invoker},url=${url},code=${code},http_sts=${http_sts} gid=\"${gid}\",rt=${rt} ${etime}")
        
        line = tmp_line.substitute(
            cid = 1,
            invoker=HelpUtil.random_choose_one(_invoker),
            url = HelpUtil.random_choose_one(_url),
            code=HelpUtil.random_choose_one(_code),
            http_sts=HelpUtil.random_choose_one(_http_sts),

            gid=uuid.uuid1(),
            rt=HelpUtil.range_random_choose_one(200,5000),

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
    num_emit = 1

    time_list = HelpUtil.random_sort_time_series(year,month,day,start_hour,end_hour,num_emit)
    
    emit(time_list)

    print('done')