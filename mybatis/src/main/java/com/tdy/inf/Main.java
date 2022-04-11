package com.tdy.inf;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.webkit.network.URLs;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Map<String,Object>> objects = sqlSession.selectList("com.tdy.inf.Inf.selInf");

        System.out.println("success");

        dealData(objects);

    }

    public static void dealData(List<Map<String,Object>> datas) throws IOException {
        for (int i = 0; i < datas.size(); i++) {

            Map<String,Object> item = datas.get(i);
            String filename = item.get("inf_code").toString();
            String msg = item.get("in_message").toString();
            String createDate = item.get("create_date")+"";
            write(filename,msg,createDate);
        }
    }

    public static void write(String filename,String jsonDatas,String createDate) throws IOException {

        filename = filename.replace("/jssj/","");

        if(!URLs.containsKey(filename)){
            return ;
        }

        String filePath = System.getProperty("user.dir")+File.separator+filename+".csv";
        File file = new File(filePath);
        boolean newFlag = false;
        if(!file.exists()){
            file.createNewFile();
            newFlag = true;
        }

        FileWriter fileWriter = new FileWriter(file,true);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        String[] titles = URLs.get(filename);
        if(newFlag){
            writer.write(Arrays.toString(titles).replace("[","").replace("]","").replace(" ",""));
            writer.write("\r\n");
        }

        JSONObject jsonObject = JSONObject.parseObject(jsonDatas);
        JSONArray array = jsonObject.getJSONArray("dataItems");


        for (int i = 0; i < array.size(); i++) {
            JSONObject data = array.getJSONObject(i);
            for (int j  = 0; j < titles.length; j++) {
                writer.write(data.getString(titles[j])+"");
                writer.write(",");
            }
            writer.write(createDate+"\r\n");
        }
        writer.flush();
        writer.close();
    }

    static String[] RE_CAR = {"itemId","personId","parkCode","carNumber","carPhoto"};
    static String[] serviceOperator = {"itemId",
            "serviceId",
            "parkName",
            "parkCode",
            "operatorId",
            "operateType",
            "operateTime",
            "operateName",
            "operateMoney",
            "refundssMoney",
            "refundysMoney",
            "delayStartTime",
            "delayEndTime",
            "oldState",
            "newState",
            "attach"};
    static String[] serviceInfo = {"itemId",
            "userType",
            "personId",
            "accountId",
            "serviceType",
            "parkName",
            "parkCode",
            "parkLoctionType",
            "state",
            "parkLoctionNo",
            "vehiclePosCount",
            "startTime",
            "endTime",
            "cardType",
            "cardTypeName",
            "balance",
            "operatorId",
            "operateTime",
            "operateName",
            "operateMoney",
            "attach"};
    static String[] parkInfo = {"itemId",
            "code",
            "name",
            "parkName",
            "parkCode",
            "type",
            "isOperator",
            "idCardType",
            "idCardNo",
            "sex",
            "age",
            "nativePlace",
            "telephone",
            "officeTel",
            "address",
            "email",
            "remark",
            "status",
            "attach"};

    static Map<String,String[]> URLs = new HashMap<String,String[]>();
    static {
//        URLs.put("reCar",RE_CAR);
//        URLs.put("parkInfo",parkInfo);
//        URLs.put("serviceInfo",serviceInfo);
//        URLs.put("serviceOperator",serviceOperator);
        URLs.put("js_service_operator",serviceOperator);
    }





}
