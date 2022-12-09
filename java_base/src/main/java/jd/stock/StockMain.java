package stock;

import file.HttpWrapper;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class StockMain {
    /**
     *
     * 3
     * 6
     * :

     * 9
     * :
     *
     * 10
     * :

     * 11
     * :
     * "https:/
     * 12
     * :
     * "https://item.jd.com/10055692768354.html"
     * 13
     * :
     * "https://item.jd.com/10057558020544.html"
     */

    static String urlTemp = "https://item-soa.jd.com/getWareBusiness?callback=jQuery6382292&skuId=skuIdHold";
    static String cookie = "__jdu=16519130988301200199625; shshshfpa=3ff583ef-b02e-4ea3-20e9-a7717707602d-1651913100; shshshfpb=lz8JmRyqPsZhc_WHKjsbFsA; pinId=lK5918gGRxVlSb99nN0fK7V9-x-f3wj7; pin=jd_539421bc24fb1; unick=jd_539421bc24fb1; _tp=%2Fh9AVsQAiTbHlJduCcOeP3mCDxuF87omfkwIoq2eM50%3D; _pst=jd_539421bc24fb1; TrackID=14xgu6qoLkEDctRgQv8gmeEYhl2B3ab-A4fPTcWzLh4Xae144ONPuUO5gATDYOq_QWnjZF1yofIEV_YSX2zh23YswvPUgFTIuVZJyz0S7unnV0diPNUAJ9c7JNfpLHcb3; areaId=19; ipLoc-djd=19-1601-50258-51885; __jdv=76161171|direct|-|none|-|1669162847689; PCSYCityID=CN_440000_440100_0; __jda=122270672.16519130988301200199625.1651913098.1668746820.1669162848.59; shshshfp=2a735bc6c5279be4e8ea7286943bc76e; 3AB9D23F7A4B3C9B=EGQH3BMMRFEVON74YY3JTZUUSOGPIH7SQNXFHW5E74AA4BPPO22LYYED4NDH5MORRFHQI57CG2SIM3BMMDVB54EUM4; ip_cityCode=1607";

    public static void main(String[] args) throws InterruptedException {
        List<String> ids = Arrays.asList("10066672944033","10066676290699","10051961810205","10057558020544","10063598792860","10063598986238","10056244212252","10055692768354","10051861117869","10054701816346");
        Map<String,String> items = new HashMap<>();
        items.put("10057558020544","");
        while (true){

            ids.forEach(id->{
                String url = urlTemp.replace("skuIdHold",id);
                String s = HttpWrapper.doGet(url, cookie);
                if(s.indexOf("无货")==-1){
                    SendEmailUtil.sendEmail("1064592074@qq.com",id,"2222");
                }
            });
            System.out.println(StringUtils.getNowTimeStr());
            TimeUnit.SECONDS.sleep(10);
        }


    }

}
