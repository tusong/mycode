package stock;

import org.springframework.util.DigestUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 工具类
 * @author zhoujian
 *
 */
public class StringUtils {
	
	/**
	 * 获取当前日期字符串 例如 201501221421
	 * 
	 * @Description：
	 * @param param0
	 * @param param1
	 * @return
	 */
	public static String getNowTimeStr2() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		return df.format(new Date());
	}
	
    /**
     * <p>Checks if a CharSequence is whitespace, empty ("") or null.</p>
     *
     * <pre>
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     * </pre>
     *
     * @param cs  the CharSequence to check, may be null
     * @return {@code true} if the CharSequence is null, empty or whitespace
     * @since 2.0
     * @since 3.0 Changed signature from isBlank(String) to isBlank(CharSequence)
     */
    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }
	
	/**
	 * @Description：判断是否为空
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		}
		if ("".equals(obj) || "null".equals(obj) || "NULL".equals(obj) || "".equals(obj.toString().trim())) {
			return true;
		}
		return false;
	}
	public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }
	/**
	 * @Description：判断是否为空
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(List list) {
		if (list == null || list.size() == 0) {
			return true;
		}
		return false;
	}
	
	/**
     *  替换字符串函数
     *  String strSource - 源字符串
     *  String strFrom   - 要替换的子串
     *  String strTo     - 替换为的字符串
     */
    public static String replace(String strSource, String strFrom, String strTo) {
      // 如果要替换的子串为空，则直接返回源串
      if(strFrom == null || strFrom.equals(""))
      {
    	  return strSource;
      }
      //String strDest = "";
      StringBuffer strDest = new StringBuffer("");
      // 要替换的子串长度
      int intFromLen = strFrom.length();
      int intPos;
      // 循环替换字符串
      while((intPos = strSource.indexOf(strFrom)) != -1)
      {
          // 获取匹配字符串的左边子串
          //strDest = strDest + strSource.substring(0,intPos);
          strDest.append(strSource.substring(0,intPos));
          // 加上替换后的子串
          //strDest = strDest + strTo;
          strDest.append(strTo);
          // 修改源串为匹配子串后的子串
          strSource = strSource.substring(intPos + intFromLen);
      }
      // 加上没有匹配的子串
      //strDest = strDest + strSource;
      strDest.append(strSource);
      // 返回
      return strDest.toString();
   }
    
    /**
	 * 为字符串替换新的分隔符
	 * 
	 * @param str
	 *            替换的字符串值
	 * @param oldSeparator
	 *            字符串中存在的分隔符
	 * @param newSeparator
	 *            字符串中新的分隔符
	 * @return
	 */
	public static String replaceAll(String str, char oldSeparator, char newSeparator) {
		// TODO:modifier.songfq.010112 : String 组装修改
		StringBuilder v = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			v = (c == oldSeparator) ? v.append(newSeparator) : v.append(c);
		}
		return v.toString();
	}
	
 	/**
 	 * 取得字符串的长度 
 	 * @param str 需要操作的字符串
 	 * @return
 	 */
 	public static int length(String str) {
 		if (isEmpty(str)) {
 			return 0;
 		}
 		return str.trim().length();
 	}
 	
 	/**
	 * @Description：判断数组是否为空
	 * @param c
	 * @return
	 */
	public static boolean isEmpty(Object[] c) {
		if (c == null || c.length <= 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 比较两个日期大小
	 * 
	 * @Description：
	 * @param param0
	 * @param param1
	 * @return
	 */
	public static boolean compareToDate(Date param0, Date param1) {
		if (param0 == null) {
			return false;
		}
		if (param1 == null) {
			return true;
		}
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		return Integer.parseInt(df.format(param0)) > Integer.parseInt(df.format(param1));
	}
	
	/**
	 * 判断两个日期年月是否相等
	 * 
	 * @Description：
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static boolean isMonthEquals(Date beginDate, Date endDate) {
		if (beginDate == null || endDate == null) {
			return false;
		}
		DateFormat df = new SimpleDateFormat("yyyyMM");
		return Integer.parseInt(df.format(beginDate)) == Integer.parseInt(df.format(endDate));
	}
	
	/**
	 * 获取当前时间字符串 例如 2015-01-22 11:09:00
	 * 
	 * @Description：
	 * @param param0
	 * @param param1
	 * @return
	 */
	public static String getNowTimeStr() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		return df.format(new Date());
	}
	
	/**
	 * 获取当前日期字符串 例如 2015-01-22
	 * 
	 * @Description：
	 * @param param0
	 * @param param1
	 * @return
	 */
	public static String getNowDateStr() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		return df.format(new Date());
	}
	
	/**
	 * @Description：转换为字符串
	 * @param obj
	 * @return
	 */
	public static String parseString(Object obj){
		if(isEmpty(obj)){
			return "";
		}else{
			return String.valueOf(obj);
		}
	}
	
	/**
	 * 返回非null字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static String notNullString(Object obj) {
		return notNullString(obj, "");
	}
	
	/**
	 * 
	 * @param obj
	 * @param defualtString
	 * @return
	 */
	public static String notNullString(Object obj, String defualtString) {
		if (obj == null) {
			return defualtString;
		}
		return obj.toString();
	}
}
