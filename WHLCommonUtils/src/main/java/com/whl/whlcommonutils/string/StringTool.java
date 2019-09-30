package com.whl.whlcommonutils.string;

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
public class StringTool {
    
    /**
     * 判断两个字符串有多少个字符相等
     * @param stringOne
     * @param stringTwo
     * @return
     */
    public static int getSameCharCount(String stringOne, String stringTwo){
        String[] splitOne = stringOne.split("");
        String[] splitTwo = stringTwo.split("");
        
        //正向比
        int sameCount1 = 0;
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(splitOne));
        for(String str2 : splitTwo){
            if(set.contains(str2)){
                sameCount1++;
            }
        }
        
        //反向比
        int sameCount2 = 0;
        Set<String> set2 = new HashSet<>();
        set2.addAll(Arrays.asList(splitTwo));
        for(String str2 : splitOne){
            if(set2.contains(str2)){
                sameCount2++;
            }
        }
        
        //返回较大的值
        return sameCount1 > sameCount2 ? sameCount1 : sameCount2;
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
        //TreeMap,按照key值从大到小排序
        Map<Integer,List<T>> map = new TreeMap<>((Integer o1, Integer o2) -> o2 - o1);
        for(T t : list){
            
            int sameCharCount = getSameCharCount(keyword, gpi.GetParam(t));
            if(sameCharCount == 0 || sameCharCount < keyword.length() / 3){
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
