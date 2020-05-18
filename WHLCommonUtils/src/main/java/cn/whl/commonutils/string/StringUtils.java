package cn.whl.commonutils.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 工具类：字符串
 * @author wuhailong
 */
public class StringUtils {
    
    /**
     * 判断两个字符串有多少个字符相同
     * @param stringOne
     * @param stringTwo
     * @return
     */
    public static int getSameCharCount(String stringOne, String stringTwo){
        String[] splitOne = stringOne.split("");
        String[] splitTwo = stringTwo.split("");
        
        //正向比
        int sameCount1 = getSameCharCountSingle(splitOne, splitTwo);
        
        //反向比
        int sameCount2 = getSameCharCountSingle(splitTwo, splitOne);
        
        //返回较大的值
        return sameCount1 > sameCount2 ? sameCount1 : sameCount2;
    }
    
    /**
     * two中有多少个字符是one中出现过的。
     * @param one
     * @param two
     * @return 
     */
    private static int getSameCharCountSingle(String[] one, String[] two){
        int sameCount = 0;
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(one));
        for(String str2 : two){
            if(set.contains(str2)){
                sameCount++;
            }
        }
        return sameCount;
    }
    
    /**
     * 按照属性值和关键字匹配字符数降序排列，不到关键字长度1/3的结果抛弃
     * @param <T>
     * @param list
     * @param keyword
     * @param gpi
     * @return
     */
    public static <T>  List<T> OrderByKeywordsDesc(List<T> list, String keyword, GetParamInterface<T> gpi) {
        return OrderByKeywordsDesc(1.0/3, list, keyword, gpi);
    }
    
    /**
     * 按照属性值和关键字匹配字符数降序排列，不到关键字长度指定长度比例或者字符数的结果抛弃
     * @param <T>
     * @param list
     * @param keyword
     * @param gpi
     * @return
     */
    public static <T>  List<T> OrderByKeywordsDesc(double length, List<T> list, String keyword, GetParamInterface<T> gpi) {
        
        int len = 0;
        
        if(length <= 0){
            len = 1;
            length = 1.0 / 3;
        }else if(length < 1){
            len = 1;
        }else if(length >= 1){
            len = Math.min((int)length, keyword.length());
        }
        
        //TreeMap,按照key值从大到小排序
        Map<Integer,List<T>> map = new TreeMap<>((Integer o1, Integer o2) -> o2 - o1);
        for(T t : list){
            
            int sameCharCount = getSameCharCount(keyword, gpi.GetParam(t));
            if(sameCharCount <= len || sameCharCount < keyword.length() * length){
                continue;
            }
            
            if(map.containsKey(sameCharCount)){
                //如果key已存在
                map.get(sameCharCount).add(t);
            }else{
                //如果key不存在，新增
                List<T> li = new ArrayList<>();
                li.add(t);
                map.put(sameCharCount, li);
            }
        }
        //新建列表，返回排序后的值
        List<T> result = new ArrayList<>();
        for(Map.Entry<Integer, List<T>> entry : map.entrySet()){
            result.addAll(entry.getValue());
        }
        return result;
    }
    
    /**
     * 获取查询缓存Map的Key
     * @param queryName
     * @param queryParam
     * @param queryValue
     * @param queryParam2
     * @param queryValue2
     * @param orderByParamName
     * @param desc
     * @return
     */
    public static String getQueryMapKey(String queryName, String queryParam, String queryValue, String queryParam2, String queryValue2, String orderByParamName, Boolean desc){
        StringBuilder sb  = new StringBuilder();
        sb.append(queryName).append("||").append(queryParam).append("=").append(queryValue).append("||").append(queryParam2).append("=").append(queryValue2).append("||")
                .append(orderByParamName).append(desc);
        
        return sb.toString();
    }
}
