package com.github.kop.bbs.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @auth ahxiaoqi
 * @desc ip获取归属地 注:使用百度的接口
 * @time 2022/8/31 22:54
 */
@Slf4j
@Service
public class IpLocationService {

    /**
     * 实际返回 <200,{"status":"0","t":"","set_cache_time":"","data":[{"ExtendedLocation":"","OriginQuery":"223.104.165.165","appinfo":"","disp_type":0,"fetchkey":"223.104.165.165","location":"浙江省 移动","origip":"223.104.165.165","origipquery":"223.104.165.165","resourceid":"6006","role_id":0,"shareImage":1,"showLikeShare":1,"showlamp":"1","titlecont":"IP地址查询","tplt":"ip"}]},[Cache-Control:"private", Content-Length:"372", Content-Type:"application/json;charset=UTF-8", Date:"Wed, 31 Aug 2022 15:08:46 GMT", Expires:"Wed, 31 Aug 2022 15:08:46 GMT", P3p:"CP=" OTI DSP COR IVA OUR IND COM "", "CP=" OTI DSP COR IVA OUR IND COM "", Server:"Apache", Set-Cookie:"BAIDUID=D3B9DFFFC7EA52772FEFEB9BA3DD1F5F:FG=1; expires=Thu, 31-Aug-23 15:08:46 GMT; max-age=31536000; path=/; domain=.baidu.com; version=1", "BAIDUID=EE1BE6C01AC9CBD7BA2A0AD3040EAEAF:FG=1; expires=Thu, 31-Aug-23 15:08:46 GMT; max-age=31536000; path=/; domain=.baidu.com; version=1", Tracecode:"05267396230618250506083123", "05267396840525848074083123", X-Powered-By:"HHVM"]>
     *
     * {
     *     "status": "0",
     *     "t": "",
     *     "set_cache_time": "",
     *     "data": [
     *         {
     *             "ExtendedLocation": "",
     *             "OriginQuery": "223.104.165.165",
     *             "appinfo": "",
     *             "disp_type": 0,
     *             "fetchkey": "223.104.165.165",
     *             "location": "浙江省 移动",
     *             "origip": "223.104.165.165",
     *             "origipquery": "223.104.165.165",
     *             "resourceid": "6006",
     *             "role_id": 0,
     *             "shareImage": 1,
     *             "showLikeShare": 1,
     *             "showlamp": "1",
     *             "titlecont": "IP地址查询",
     *             "tplt": "ip"
     *         }
     *     ]
     * }
     *
     *
     */

    private final static String url = "http://opendata.baidu.com/api.php?query={ip}&co=&resource_id=6006&oe=utf8";

    @Resource
    private RestTemplate restTemplate;

    public String getLocation(String ip){
        if (ObjectUtils.isEmpty(ip)){
            return "";
        }
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url.replace("{ip}", ip), String.class);
            if(ObjectUtils.isEmpty(response) || ObjectUtils.isEmpty(response.getBody())){
                return "未知";
            }
            String str = response.getBody();
            return str.substring(str.indexOf("location")+11,str.indexOf("\",\"origip\"")).split("\\s+")[0];
        }catch (Exception e){
            log.error("获取定位失败",e);
        }
        return "未知";
    }


    public static void main(String[] args) {
        String str = "<200,{\"status\":\"0\",\"t\":\"\",\"set_cache_time\":\"\",\"data\":[{\"ExtendedLocation\":\"\",\"OriginQuery\":\"223.104.165.165\",\"appinfo\":\"\",\"disp_type\":0,\"fetchkey\":\"223.104.165.165\",\"location\":\"浙江省 移动\",\"origip\":\"223.104.165.165\",\"origipquery\":\"223.104.165.165\",\"resourceid\":\"6006\",\"role_id\":0,\"shareImage\":1,\"showLikeShare\":1,\"showlamp\":\"1\",\"titlecont\":\"IP地址查询\",\"tplt\":\"ip\"}]},[Cache-Control:\"private\", Content-Length:\"372\", Content-Type:\"application/json;charset=UTF-8\", Date:\"Wed, 31 Aug 2022 15:08:46 GMT\", Expires:\"Wed, 31 Aug 2022 15:08:46 GMT\", P3p:\"CP=\" OTI DSP COR IVA OUR IND COM \"\", \"CP=\" OTI DSP COR IVA OUR IND COM \"\", Server:\"Apache\", Set-Cookie:\"BAIDUID=D3B9DFFFC7EA52772FEFEB9BA3DD1F5F:FG=1; expires=Thu, 31-Aug-23 15:08:46 GMT; max-age=31536000; path=/; domain=.baidu.com; version=1\", \"BAIDUID=EE1BE6C01AC9CBD7BA2A0AD3040EAEAF:FG=1; expires=Thu, 31-Aug-23 15:08:46 GMT; max-age=31536000; path=/; domain=.baidu.com; version=1\", Tracecode:\"05267396230618250506083123\", \"05267396840525848074083123\", X-Powered-By:\"HHVM\"]>";
        System.out.println(str.substring(str.indexOf("location")+11,str.indexOf("\",\"origip\"")).split("\\s+")[0]);
    }

}
