
FAQ

### 分组统计之后的alert

kapacitor直接支持，将分组字段设置为tag即可


### 百分比的统计思路

- 第一步，利用kapacitor执行CQ，生成中间统计表，类似time,tag1,tag2,value1,value2

这里又分为数据来源于单个measurement还是多个measurement, 单measurement分组统计后使用flatten('tag1'，'tag2')进行扁平化，详细可看官网kapacitor flatten函数的用法；
多measurement按时间分组后，按时间进行join|combine, 详见官网kapacitor join函数的用法；

- 第二步，定制百分数的query，详细参见 [这里]!(https://docs.influxdata.com/influxdb/v1.7/guides/calculating_percentages/#sidebar)


### kapacitor

https://tanjiti.github.io/2018/12/18/%E5%BC%80%E6%BA%90kapacitor%E6%93%8D%E4%BD%9C%E6%89%8B%E5%86%8C/

groupBy join  union combine  eval 这几个函数会改变数据结构，是需要重点理解的函数。

delete derivative flatten  stats  stateCount  stateDuration influxQL 这几个函数会执行数据变换，亦须仔细理解。