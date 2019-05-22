package com.hz.modul.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.UUID;


public class HttpUtil {

	private static Log log = LogFactory.getLog(HttpUtil.class);

//	public static void main(String[] args) throws Exception {
//		//String data = "{\"touser\": \"hz656765117\",\"toparty\": \"\",\"totag\": \"\",\"msgtype\": \"text\",\"agentid\": \"1\",\"text\":{\"content\": \"测试一下后台推送消息到自主开发的应用中，给所有关注用户\"},\"safe\":\"0\"}";
////		String data ="{\"touser\": \"@all\",\"toparty\": \"\",\"totag\": \"\",\"msgtype\": \"text\", \"agentid\": 1,\"text\": { \"content\": \"测试一下后台推送消息到自主开发的应用中，给所有关注用户\"}, \"safe\":\"0\"}";
////		System.out.println(data);
////		JSONObject ret = HttpUtil.httpsRequest("https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=qELjFmPziDYIqCX_hSEsivP_-lX2DlRyR_Rde_CDkzMBjdXSAI2aYGQZ7UfdoPYv","POST", data);
////		System.out.println(ret.toString());
//
//		// 取得access_token
//	//	String res = HttpUtil.get("https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=wx3b73804be4d2d4a4&corpsecret=IMgrPmBbx9BgvDT4FwfIQl1XFfwhiOnnSds0VXEohjYrI8zMSAD538xq5wplL9Mv");
//		//System.out.println(res);
//
//		//获取应用信息
////		String info = HttpUtil.get("https://qyapi.weixin.qq.com/cgi-bin/agent/get?access_token=IgTuPD4ew3Mlz6HY-OmxShfW63Kbd_FNw1pxOCRapRSqSEgNsM3X8D65WizwS-Fq&agentid=13");
////		System.out.println(info);
//
//		//获取应用信息概况
//
////		String list = HttpUtil.get("https://qyapi.weixin.qq.com/cgi-bin/agent/list?access_token=IgTuPD4ew3Mlz6HY-OmxShfW63Kbd_FNw1pxOCRapRSqSEgNsM3X8D65WizwS-Fq");
////		System.out.println(list);
//
//		//获取回调模式应用的菜单
////		String menu = HttpUtil.get("https://qyapi.weixin.qq.com/cgi-bin/menu/get?access_token=IgTuPD4ew3Mlz6HY-OmxShfW63Kbd_FNw1pxOCRapRSqSEgNsM3X8D65WizwS-Fq&agentid=13");
////		System.out.println(menu);
//
//		//获取指定部门及其下的子部门
////		String deptlist = HttpUtil.get("https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=IgTuPD4ew3Mlz6HY-OmxShfW63Kbd_FNw1pxOCRapRSqSEgNsM3X8D65WizwS-Fq&id=1");
////		System.out.println(deptlist);
//
//	//	https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=ACCESS_TOKEN
//
//		//创建成员
////		String data ="{\"userid\": \"zhangsan\", \"name\": \"张三\",\"department\": [1, 2],\"position\": \"产品经理\",\"mobile\": \"15913215421\", \"gender\": \"1\", \"email\": \"zhangsan@gzdev.com\",\"weixinid\": \"zhangsan4dev\",\"extattr\":{\"attrs\":[{\"name\":\"爱好\",\"value\":\"旅游\"},{\"name\":\"卡号\",\"value\":\"1234567234\"}]}}";
////		System.out.println(data);
////		JSONObject createPerson = HttpUtil.httpsRequest("https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=IgTuPD4ew3Mlz6HY-OmxShfW63Kbd_FNw1pxOCRapRSqSEgNsM3X8D65WizwS-Fq","POST", data);
////		System.out.println(createPerson.toString());
//		//获取成员
////		String UserInfo = HttpUtil.get("https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=IgTuPD4ew3Mlz6HY-OmxShfW63Kbd_FNw1pxOCRapRSqSEgNsM3X8D65WizwS-Fq&userid=hz656765117");
////		System.out.println(UserInfo.toString());
////	    String data1 = "http://112.96.28.36:8006/rest/informrefund?sign=gIh5/n51OVcCsmcivt9Ydl2SfW4L31OOv3+YNJo0GqP36tv7QpZ4TU+1aofzYsnlTKGNgneTU8MV0Oayz/X44djEZI1TCv8Gw+Xax8bhz1D5CLyBz+u3VYGW5CjQHpHFE5fzbfnoorxR0Mm9wtiSyN6Yh5DiLH7BvsrqxQjE6qo=&data=q3DOwDgoXCRw5GU248IwBhmeDCzrFqkCYWGoZ9a4mpxihJ5KF+ffVYoNN26/rtIn9YH6mZjfhdjBJ8D6DkKIJJHCwltZMagR4Ch4cGej7vIQk4yMW58elr5Ki5ifQ6aFpEeAjqUag6F7MV9PUuDEqmdLSIFUIZ0Ljlc63tRL1ao=";
////		String data  = "http://112.96.28.36:8006/rest/informrefund?sign=paQj06Ap0hf4dI2zfAMeJeT0A4fS1YcyAm5OvPWyDyYptR+f4TsIcyIlxC0J/dzEF573crGameuWwAXSeFocGwVY0ehs6OCa8w97IPHY7da5nLe4R1v6Nm+062HXdyvK0PHj91CrWVOK0wd1nqTWsgQdmgt2alQ3EH8Wch0hoQ8=&data=rN7f+WvEOFZrwnEdKVIlScKUcyU1j7zvZYi7aJcVkr/tLDZ/j5a3bwk0DQz6mfTN7APY89bNvro//habi8ZBvVZrPS8aMe1u9tBG1/BhIfyagESLnv85/jKSEN+EpGFmcHLDfgrwGq3YUmumPawLTAyGvcjZMpVupqCIIWefubY=";
////			String res = HttpUtil.get(data1);
////	    String data2 = "sign=paQj06Ap0hf4dI2zfAMeJeT0A4fS1YcyAm5OvPWyDyYptR+f4TsIcyIlxC0J/dzEF573crGameuWwAXSeFocGwVY0ehs6OCa8w97IPHY7da5nLe4R1v6Nm+062HXdyvK0PHj91CrWVOK0wd1nqTWsgQdmgt2alQ3EH8Wch0hoQ8=&data=rN7f+WvEOFZrwnEdKVIlScKUcyU1j7zvZYi7aJcVkr/tLDZ/j5a3bwk0DQz6mfTN7APY89bNvro//habi8ZBvVZrPS8aMe1u9tBG1/BhIfyagESLnv85/jKSEN+EpGFmcHLDfgrwGq3YUmumPawLTAyGvcjZMpVupqCIIWefubY=";
////
////	    String data3 = "sign=Afg57m3Wq/MA07qp8WEL0i5YbuuvAMUu85HmV/Y8xmbD7ohRmezItNc5fgQcQRiY0tT9zmb8UjeK3uUfjR2q6PPTB963KG4ZBP3sVBkq84R7+St0KtOOfsGQo/l0Knup5LjeRPvfAH6wsrhJoNmtcYvMgKPZeP5abb49S3PIzjo=&data=MHpEJxgVzuXlcDjZq4SOj2AxXg6JhWHfwNM+sebkAgq4RJEOLL8ZHMNq4BQKUs1ClICv+wsMmwiq36e0qq2m2pLXRIxqqG2ogRxG+2aVmW4Of0/RjLkouKwuOigLzHDZ/+1IWUdhp5dIQ6U2j0o0OmWF011ssUAr6jiuMChKiQUdgQMOJMrjkQR/rVaXfPz5b2YVLaOcJFqKgGN3je3oWNTG/GNH22n0bs913Io0s52Vyn1SuQ9R8stCeU95S9CUFyMGM/T50BjV1ojFjyOJJTlY+W50kfP11sVlqRL3gQXW4fcZ7Ruy19KKSeEPI+4MqxyqapOICNVChKawq+iUSZABj2X/o2Dxdq6Vbwt6mco3+lxGoW7oopfSllWr4lZqqvkwsNcu5M8dG0L/rHJRTzYGin4vcpPZ4T8IeYTLcphcbR0e4LBKCiAg9oo9dVTKOglVM6NHzMq09qQ7mBmmtkJTGHghWra1ucuiLzj0oeJ9jkR6XzoHzKE727GYcyefuEpoAZSWOjCLT5dE4/87/Cu3G8vGoAbLcW6rZctCCfKASFXZ3nyyt1LvSwzEZWTkTrOndqxCtIux1kOD728mkkrFJm2ZOzBDL3uakKgvyM17VnNoRe+ZSzUf9ebpdf07f2H5d0pmLXQ6069OsSgMqJeQwF+GzwRG9Wsg/ZxTUiVUHiEdIy28eBnOEU/C5O1is11xvPyH6syjBTOrh0SDm8J9PjoQaHKxZgvykBePcZQxJBJcWrPD24Ue+QaT+1UlAYHCPhwtUg7hXAQI2ibaYFgK5RtUJMRSWhKNobX62xFxrqXOJMaV1XchfteKdZROlwkwlZL1i8XH/WbGg3/W/Q==";
////	    HttpUtil.httpsRequest("http://112.96.28.36:8006/rest/informrefund", "post", data2);
////
////
////	    String data3 = "sign=Afg57m3Wq/MA07qp8WEL0i5YbuuvAMUu85HmV/Y8xmbD7ohRmezItNc5fgQcQRiY0tT9zmb8UjeK3uUfjR2q6PPTB963KG4ZBP3sVBkq84R7+St0KtOOfsGQo/l0Knup5LjeRPvfAH6wsrhJoNmtcYvMgKPZeP5abb49S3PIzjo=&data=MHpEJxgVzuXlcDjZq4SOj2AxXg6JhWHfwNM+sebkAgq4RJEOLL8ZHMNq4BQKUs1ClICv+wsMmwiq36e0qq2m2pLXRIxqqG2ogRxG+2aVmW4Of0/RjLkouKwuOigLzHDZ/+1IWUdhp5dIQ6U2j0o0OmWF011ssUAr6jiuMChKiQUdgQMOJMrjkQR/rVaXfPz5b2YVLaOcJFqKgGN3je3oWNTG/GNH22n0bs913Io0s52Vyn1SuQ9R8stCeU95S9CUFyMGM/T50BjV1ojFjyOJJTlY+W50kfP11sVlqRL3gQXW4fcZ7Ruy19KKSeEPI+4MqxyqapOICNVChKawq+iUSZABj2X/o2Dxdq6Vbwt6mco3+lxGoW7oopfSllWr4lZqqvkwsNcu5M8dG0L/rHJRTzYGin4vcpPZ4T8IeYTLcphcbR0e4LBKCiAg9oo9dVTKOglVM6NHzMq09qQ7mBmmtkJTGHghWra1ucuiLzj0oeJ9jkR6XzoHzKE727GYcyefuEpoAZSWOjCLT5dE4/87/Cu3G8vGoAbLcW6rZctCCfKASFXZ3nyyt1LvSwzEZWTkTrOndqxCtIux1kOD728mkkrFJm2ZOzBDL3uakKgvyM17VnNoRe+ZSzUf9ebpdf07f2H5d0pmLXQ6069OsSgMqJeQwF+GzwRG9Wsg/ZxTUiVUHiEdIy28eBnOEU/C5O1is11xvPyH6syjBTOrh0SDm8J9PjoQaHKxZgvykBePcZQxJBJcWrPD24Ue+QaT+1UlAYHCPhwtUg7hXAQI2ibaYFgK5RtUJMRSWhKNobX62xFxrqXOJMaV1XchfteKdZROlwkwlZL1i8XH/WbGg3/W/Q==";
////        HttpUtil.httpsRequest("http://112.96.28.36:8006/rest/JfProNotify", "post", data3);
////
//
//
////	    String res = HttpUtil.get("http://123.125.97.251:8000/rest/queryUserInfo?reqData=d1VzZXJObz0xMTAwMDAwMDAwMjY1NDImdmVyc2lvbj0xLjAmc2lnbj00NmNmYjUzMTIwNDBmOTM4MTRmNmY1MzU3MGMyZTA0OQ==");
////	    System.out.println(res);
//
//
//
////	    String data3 = "merId=10000877&servCode=0012&reqSeq=12345678910111111111&reqTime=201711031540&bizCtx=orderNo=wzf000002|fndOrderNo=WBF20171101173502008579|paySts=S|payAmt=0.01|sucDt=20171101|sucTm=173502&signMac=0982CF9F7087A55AEB44AB654646D061F5356C0B5F1F5E99DBD3056E688BFEDC1C0B7B72AFA85D0C51D338DDDD3873E4A825A5B2766B7FDDADC4CB4CDDC97CFEDA703B762CFFEEC77EAC40FE9CC9B4C3EA74511F524352F4BB20DE6B353625A26AD659EB47A3F0676D2FF453939CD4507057B4BC959B58C424A18233EC6005F8";
////	    data3 = "reqData=d1VzZXJObz0xMTAwMDAwMDAwMjY1NDImdmVyc2lvbj0xLjAmc2lnbj00NmNmYjUzMTIwNDBmOTM4MTRmNmY1MzU3MGMyZTA0OQ==";
////	    HttpUtil.httpsRequest("http://123.125.97.251:8000/rest/queryUserInfo", "post", data3);
//
////
////	     String res = HttpUtil.get("https://test1.unicompayment.com/WoMall/service?merId=10000877&servCode=0012&reqSeq=12345678910111111111&reqTime=201711031540&bizCtx=orderNo=wzf000002|fndOrderNo=WBF20171101173502008579|paySts=S|payAmt=0.01|sucDt=20171101|sucTm=173502&signMac=0982CF9F7087A55AEB44AB654646D061F5356C0B5F1F5E99DBD3056E688BFEDC1C0B7B72AFA85D0C51D338DDDD3873E4A825A5B2766B7FDDADC4CB4CDDC97CFEDA703B762CFFEEC77EAC40FE9CC9B4C3EA74511F524352F4BB20DE6B353625A26AD659EB47A3F0676D2FF453939CD4507057B4BC959B58C424A18233EC6005F8");
////      System.out.println(res);
//
////	    HttpUtil.httpsRequest("https://test1.unicompayment.com/WoMall/service", "post", data3);
//
//		//WOWEALTH_JSESSIONID=c9981905-01e0-4524-90bf-52195b150985    沃钱包
//		//WOWEALTH_JSESSIONID=f24c40b8-582e-4bc7-bf85-7f14f97020f2    沃百富
//      String res = HttpUtil.get("https://wobaifu.10010.com/wc/memSign","WOWEALTH_JSESSIONID=c9981905-01e0-4524-90bf-52195b150985 ");
//      System.out.println(res);
//
////	    merId
////	    servCode
////	    reqSeq
////	    reqTime
////	    bizCtx
////	    signMac
//
////	    Map<String, String>  map = new HashMap<String, String>();
////	    map.put("orderNo", "20171110006449");
////	    map.put("fndOrderNo", "WBF20171110102532008624");
////	    map.put("paySts", "S");
////	    map.put("payAmt", "0.01");
////	    map.put("sucDt", "20171101");
////	    map.put("sucTm", "173502");
////
////	    String bizCtx = JSONObject.fromObject(map).toString();
////
////
////	    map.put("merId", "10000877");
////        map.put("servCode", "0012");
////        map.put("reqSeq", "12345678910111111111");
////        map.put("reqTime", "201711031540");
////
////	    String param = formatUrlMap(map, true, false);
////
////
//////	    Object ss = HttpClients.Post(url, reqMap, encod);
////
//////	    param = "fndOrderNo=WBF20170819111710968221342|merId=wbf_wfq_002_c9clpefda2|orderNo=20170810004557|payAmt=3.03|paySts=S|reqSeq=06163437470983761001|reqTime=20171106163437|servCode=0012|sucDt=20170819|sucTm=112157";
////	    System.out.println(param);
////	    RSAUtils.initSign("F:/rsa_private_key_pkcs8.pem");
////	    RSAUtils.initPubKey("G:/rsa_public_key_wfq1.pem");
////
////
//////	    param = "merId=10000877|servCode=0012|reqSeq=12345678910111111111|reqTime=201711091645|orderNo=wzf000002|fndOrderNo=WBF20171101173502008579|paySts=S|payAmt=0.01|sucDt=20171101|sucTm=173502";
////	    String signStr = RSAUtils.sign(param);
////	    System.out.println(signStr);
////
////	    String data ="merId=10000877&servCode=0012&reqSeq=12345678910111111111&reqTime=201711031540&bizCtx="+bizCtx+"&signMac="+signStr;
////	    //merId=10000877|servCode=0012|reqSeq=12345678910111111111|reqTime=201711091645|orderNo=wzf000002|fndOrderNo=WBF20171101173502008579|paySts=S|payAmt=0.01|sucDt=20171101|sucTm=173502
//	 //   9F3A9943215DAEE48B35C653EFCF36BD60296D4C839604BF8653ED0B90B76E7B666DA0B73AB75C6559963ED3406300B6398D1EB0EBDC6BF3E943BBDA81238515DAF6DDA08C88692010E91681DCED54B667B519474F2EA7A8E294EB347C7247D5C72EF365C47FE6ACD6F76D651D0B13AD30EA053FEC1F27373CBFF8A182949E6814A9F5AC057B2D9318BB7CD282FA7EBC6ED57B30FFB142669F527127ADE400A1C9B15EADE84EA4802D198F19EBF7D0B162847D6DD953F75582C44880CE2AEA4CEA4041AD502209DDA12AE75BBCDEC5D3E19B6054C596CA767886F89029B4BF50DEBBEC4CD548162A4FBDE541F2A5518D5B5DB4B2244C645F4B0AAE916DF6EF8F
//
////	    System.out.println(data);
//
//
//
////        String ss =  httpsRequestStr("https://test1.unicompayment.com/WoMall/service", "POST",data );
////	    System.out.println(ss);
//
//
//
////	     String data3 = "reqData=d1VzZXJObz0xMTAwMDAwMDAwMjkwNTkmc2lnbj1hMmExMGMxNDZhNDgxNmUyMzIxMGE4ODcxZGU2YjFkYw==";
////       HttpUtil.httpsRequest("http://112.96.29.151:8001/rest/queryUserInfo", "post", data3);
//	}
	
//
//	   /**
//     *
//     * 方法用途: 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序），并且生成url参数串<br>
//     * 实现步骤: <br>
//     *
//     * @param paraMap
//     *            要排序的Map对象
//     * @param urlEncode
//     *            是否需要URLENCODE
//     * @param keyToLower
//     *            是否需要将Key转换为全小写 true:key转化成小写，false:不转化
//     * @return
//     *
//     */
//    public static String formatUrlMap(Map<String, String> paraMap,
//            boolean urlEncode, boolean keyToLower) {
//        String buff = "";
//        Map<String, String> tmpMap = paraMap;
//        try {
//            List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(
//                    tmpMap.entrySet());
//            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
//            Collections.sort(infoIds,
//                    new Comparator<Map.Entry<String, String>>() {
//                        @Override
//                        public int compare(Map.Entry<String, String> o1,
//                                Map.Entry<String, String> o2) {
//                            return (o1.getKey()).toString().compareTo(
//                                    o2.getKey());
//                        }
//                    });
//            // 构造URL 键值对的格式
//            StringBuilder buf = new StringBuilder();
//            for (Map.Entry<String, String> item : infoIds) {
//                if ( item.getKey() != null && item.getKey().trim().length() > 0) {
//                    String key = item.getKey();
//                    String val = item.getValue();
//                    if (urlEncode) {
//                        val = URLEncoder.encode(val, "utf-8");
//                    }
//                    if (keyToLower) {
//                        buf.append(key.toLowerCase() + "=" + val);
//                    } else {
//                        buf.append(key + "=" + val);
//                    }
//                    buf.append("|");
//                }
//
//            }
//            buff = buf.toString();
//            if (buff.isEmpty() == false) {
//                buff = buff.substring(0, buff.length() - 1);
//            }
//        } catch (Exception e) {
//            return null;
//        }
//        return buff;
//    }
//
//    public static boolean isNBlank(String str) {
//        return (str != null && str.trim().length() > 0);
//    }
//
//    public static Map<String, String> objectToMap(Object entity){
//        Map<String, String> parameter = new HashMap<String, String>();
//          Field[]   fields   =   entity.getClass().getDeclaredFields();
//         for(int i = 0; i < fields.length; i++){
//             String fieldName =  fields[i].getName();
//             Object o = null;
//             String firstLetter = fieldName.substring(0, 1).toUpperCase();
//                String getMethodName = "get" + firstLetter + fieldName.substring(1);
//                Method getMethod;
//             try {
//                 getMethod = entity.getClass().getMethod(getMethodName, new Class[] {});
//                  o = getMethod.invoke(entity, new Object[] {});
//             } catch (Exception e) {
//                 e.printStackTrace();
//             }
//             if(o != null){
//                 parameter.put(fieldName, (String)o);
//             }
//         }
//         return parameter;
//     }
//
//     public static HashMap<String,String> json2map(String jsonStr){
//
//     HashMap<String,String> retMap = new HashMap<String,String>();
//
//     JSONObject jsonMap = JSONObject.fromObject(jsonStr);
//
//     Iterator<String> it = jsonMap.keys();
//     while(it.hasNext()) {
//         String key = (String) it.next();
//         retMap.put(key,String.valueOf(jsonMap.get(key)));
//     }
//     return retMap;
// }

//	/**
//	 * http请求
//	 *
//	 * @param url
//	 *            请求地址
//	 * @param charset
//	 *            字符编码
//	 * @param params
//	 *            传递参数
//	 * @return 網頁源代碼
//	 */
//	public static Object post(String url, String charset, Map params) {
//		HttpClient client = new HttpClient();
//		PostMethod method = new PostMethod(url);
//		// 设置参数
//		if (params != null) {
//			Iterator it = params.entrySet().iterator();
//			while (it.hasNext()) {
//				Map.Entry entry = (Map.Entry) it.next();
//				String _n = entry.getKey().toString();
//				String _v = entry.getValue().toString();
//				method.addParameter(_n, _v);
//			}
//		}
//		method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,
//				charset);
//		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
//				new DefaultHttpMethodRetryHandler(3, false));
//
//
//		try {
//			int statusCode = client.executeMethod(method);
//			System.out.println(statusCode+"========================================");
//			method.getParams().setParameter(
//					HttpMethodParams.HTTP_CONTENT_CHARSET, charset);
//			if (statusCode != HttpStatus.SC_OK
//					&& statusCode != HttpStatus.SC_MOVED_TEMPORARILY) {
//			}
//			byte[] responseBody = method.getResponseBody();
//			return new String(responseBody, charset);
//		} catch (HttpException e) {
//		} catch (IOException e) {
//		} finally {
//			method.releaseConnection();
//		}
//		return null;
//	}




	public static String doPostTestTwo(String jsonStr ,String  url) {
		String result = null;
		// 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		// 创建Post请求
		HttpPost httpPost = new HttpPost(url);
		StringEntity entity = new StringEntity(jsonStr, "UTF-8");
		// post请求是将参数放在请求体里面传过去的;这里将entity放入post请求体中
		httpPost.setEntity(entity);

		httpPost.setHeader("Content-Type", "application/json;charset=utf8");

		// 响应模型
		CloseableHttpResponse response = null;
		try {
			// 由客户端执行(发送)Post请求
			response = httpClient.execute(httpPost);
			// 从响应模型中获取响应实体
			HttpEntity responseEntity = response.getEntity();

			System.out.println("响应状态为:" + response.getStatusLine());
			if (responseEntity != null) {
				System.out.println("响应内容长度为:" + responseEntity.getContentLength());

				result = EntityUtils.toString(responseEntity);
				System.out.println("响应内容为:" + result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = e.toString();
		}finally {
			try {
				// 释放资源
				if (httpClient != null) {
					httpClient.close();
				}
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return   result ;
	}



	public static boolean httpPostWithJson(String jsonStr, String url, String appId){
		boolean isSuccess = false;

		HttpPost post = null;
		try {
			HttpClient httpClient = new DefaultHttpClient();

			// 设置超时时间
			httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 2000);
			httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 2000);

			post = new HttpPost(url);
			// 构造消息头
			post.setHeader("Content-type", "application/json; charset=utf-8");
			post.setHeader("Connection", "Close");
			String sessionId = getSessionId();
			post.setHeader("SessionId", sessionId);

			// 构建消息实体
			StringEntity entity = new StringEntity(jsonStr, Charset.forName("UTF-8"));
			entity.setContentEncoding("UTF-8");
			// 发送Json格式的数据请求
			entity.setContentType("application/json");
			post.setEntity(entity);

			HttpResponse response = httpClient.execute(post);

			// 检验返回码
			int statusCode = response.getStatusLine().getStatusCode();
			if(statusCode != HttpStatus.SC_OK){
				isSuccess = false;
			}else{
				int retCode = 0;
				String sessendId = "";
				// 返回码中包含retCode及会话Id
//				for(Header header : response.getAllHeaders()){
//					if(header.getName().equals("retcode")){
//						retCode = Integer.parseInt(header.getValue());
//					}
//					if(header.getName().equals("SessionId")){
//						sessendId = header.getValue();
//					}
//				}
//
//				if(ErrorCodeHelper.IAS_SUCCESS != retCode ){
//					// 日志打印
//					LogUtil.info("error return code,  sessionId: "sessendId"\t"+"retCode: "+retCode);
//					isSuccess = false;
//				}else{
//					isSuccess = true;
//				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			isSuccess = false;
		}finally{
			if(post != null){
				try {
					post.releaseConnection();
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return isSuccess;
	}


	// 构建唯一会话Id
	public static String getSessionId(){
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		return str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
	}

	public static String get(String url,String cookie) {
		String sCurrentLine = "";
		String sTotalString = "";
		try {
			URL l_url = new URL(url);
			HttpURLConnection l_connection = (HttpURLConnection) l_url
					.openConnection();
			if(  StringUtils.isNotBlank(cookie)) {
				l_connection.setRequestProperty("Cookie", cookie);
			}
			//WOWEALTH_JSESSIONID=c9981905-01e0-4524-90bf-52195b150985    沃钱包
			//WOWEALTH_JSESSIONID=f24c40b8-582e-4bc7-bf85-7f14f97020f2    沃百富
			l_connection.connect();
			InputStream l_urlStream;
			l_urlStream = l_connection.getInputStream();
			BufferedReader l_reader = new BufferedReader(new InputStreamReader(
					l_urlStream, "utf-8"));
			// sCurrentLine = l_reader.readLine();
			while ((sCurrentLine = l_reader.readLine()) != null) {
				sTotalString += sCurrentLine + "\r\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sTotalString;
	}

	

	
}
