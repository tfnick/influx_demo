package com.gr.sys;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.io.File;
import java.util.*;

public class MockLineProtocalData {
    static String format = "yyyy-MM-dd HH:mm:ss";

    /**
     * 初始化数据库数据
     * {"gid":"111111111111111111111111","cid":"1","time":"2019-06-05 10:10:10","host":"192.168.1.192","url":"http://engine.gr-data.uat/nrm/nrm100001","cost":3100,"code":200,"http_sts":200}
     * {"gid":"111111111111111111111112","cid":"1","time":"2019-06-05 10:10:10","prod_code":"1","seq_num":"2","sn":"2","uid":"110111111111111111","advice":"A"}
     * @param args
     */
    public static void main(String[] args) throws Exception{

        buildWbService();

        buildLoanSupply();

    }


    /**
     * tag 默认存储为字符串，可以不加引号
     * @throws Exception
     */
    public static void buildWbService() throws Exception{

        File file = new File("D:/data/events/wb_service.sql");

        int count = 1000;

        List<Long> times = new ArrayList<Long>();
        List<String> lines = new ArrayList<String>();
        for (int a = 0; a < count; a++) {
            String tmp = "2019-06-05 %S:%S:%S";
            tmp = String.format(tmp, genareateHour(),genareateMinute(),genareateSecond());
            long math = RandomUtils.nextInt(100000, 999999);
            Date d = DateUtils.parseDate(tmp,format);
            times.add(d.getTime() * 1000000 + math);
        }

        Collections.sort(times);

        String insert = "insert wb_service,cid=%s,host=%s  gid=\"%s\",url=\"%s\",cost=%s,code=%s,http_sts=%s %s";
        List<String> cids = Arrays.asList("1","2");
        List<String> urls = Arrays.asList("http://www.host.com/a.html","http://www.host.com/b.html");
        List<String> hosts = Arrays.asList("192.168.1.190","192.168.1.191","192.168.1.193");
        List<String> codes = Arrays.asList("200","198","500");
        List<String> http_stss = Arrays.asList("200","500","400");
        for (int a = 0; a < times.size(); a++) {
            long timeStamp = times.get(a);

            int cids_index = RandomUtils.nextInt(0, cids.size());
            int url_index = RandomUtils.nextInt(0, urls.size());
            int hosts_index = RandomUtils.nextInt(0, hosts.size());
            int codes_index = RandomUtils.nextInt(0, codes.size());
            int http_index = RandomUtils.nextInt(0, http_stss.size());
            String sql = String.format(insert, cids.get(cids_index),hosts.get(hosts_index),UUID.randomUUID().toString(),urls.get(url_index)
                    , RandomUtils.nextInt(200,5000), codes.get(codes_index), http_stss.get(http_index),timeStamp);

            lines.add(sql);

        }

        FileUtils.writeLines(file,lines);
    }

    /**
     * tag 默认存储为字符串，可以不加引号
     * @throws Exception
     */
    public static void buildLoanSupply() throws Exception{
        File file = new File("D:/data/events/loan.sql");

        int count = 1000;

        List<Long> times = new ArrayList<Long>();
        List<String> lines = new ArrayList<String>();
        for (int a = 0; a < count; a++) {
            String tmp = "2019-06-05 %S:%S:%S";
            tmp = String.format(tmp, genareateHour(),genareateMinute(),genareateSecond());
            long math = RandomUtils.nextInt(100000, 999999);
            Date d = DateUtils.parseDate(tmp,format);
            times.add(d.getTime() * 1000000 + math);
        }

        Collections.sort(times);

        String insert = "insert loan,cid=%s,prod_code=p1  gid=\"%s\",uid=\"%s\",seq_num=\"%s\",sn=\"%s\",advice=\"%s\" %s";
        List<String> cids = Arrays.asList("1","2");
        List<String> advices = Arrays.asList("A","B");
        for (int a = 0; a < times.size(); a++) {
            long timeStamp = times.get(a);

            int cids_index = RandomUtils.nextInt(0, cids.size());
            int uid = RandomUtils.nextInt(1000000, 99999999);
            String gid  = UUID.randomUUID().toString();
            String seq_num  = UUID.randomUUID().toString();
            String sn  = UUID.randomUUID().toString();
            int advice_index = RandomUtils.nextInt(0, advices.size());

            String sql = String.format(insert, cids.get(cids_index),uid,gid,seq_num,sn,advices.get(advice_index),timeStamp);

            lines.add(sql);

        }

        FileUtils.writeLines(file,lines);

    }


    private static String genareateHour(){
        int hour = RandomUtils.nextInt(1, 24);
        return hour >= 10 ? String.valueOf(hour) : "0" + hour;
    }

    private static String genareateMinute(){
        int m = RandomUtils.nextInt(1, 60);
        return m >= 10 ? String.valueOf(m) : "0" + m;
    }

    private static String genareateSecond(){
        int m = RandomUtils.nextInt(1, 60);
        return m >= 10 ? String.valueOf(m) : "0" + m;
    }
}
