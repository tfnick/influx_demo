#coding=UTF-8
#!/usr/bin/python
from string import Template
import time
import os
import random

class HelpUtil:

    # 随机生成指定区间的有序时间戳,当num=1时，忽略传入的时间参数，直接使用系统当前时间
    # start_hour, end_hour [0,23] 
    @staticmethod
    def random_sort_time_series(year,month,day,start_hour,end_hour,num):
        
        list = []

        if num == 1:
            t = time.time()
            stamp = t * 1000 * 1000000
            list.append(int(stamp))
        else:
            for i in range(num):
                hour = random.randint(start_hour, end_hour)
                
                minute = random.randint(0, 59)
                second = random.randint(0, 59)

                t = time.mktime((year, month, day, hour, minute, second, 0, 0, 0))
                #stamp = '%d' % (t * 1000000)
                stamp = t * 1000 * 1000000

                list.append(int(stamp))


        list.sort()
        return list

    # 随机选择列表中的某个值
    @staticmethod
    def random_choose_one(list):
        size = len(list)
        if size == 0:
            return None
        x = list[random.randint(0,size - 1)]
        return x

    # 在一个整数区间内选择一个值
    @staticmethod
    def range_random_choose_one(min,max):
        if min >= max:
            return
        return  random.randint(min, max)

    # 向文件追加行
    @staticmethod
    def append(path,filename,line_content):
        if not os.path.exists(path):
            os.makedirs(path)
        f = open(path + os.sep + filename,"a+")
        f.write(line_content + "\n")
        f.close()


if __name__ == '__main__':

    list = HelpUtil.random_sort_time_series(2019,6,5,0,23,10)
    print(list)

    list = [1,2,3]
    print(HelpUtil.random_choose_one(list))