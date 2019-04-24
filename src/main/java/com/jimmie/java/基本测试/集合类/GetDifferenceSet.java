package com.jimmie.java.基本测试.集合类;/**
 * Created by jimmie on 2019/1/23.
 */

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 取两个集合的差集
 * <p>
 * Created by lxk on 2017/2/17
 */
public class GetDifferenceSet {

    /**
     * 使用guava工具类来取List集合的差集--专业轮子谷歌造
     *
     * @param big   大集合
     * @param small 小集合
     * @return 两个集合的差集
     */
    public static List<String> getDifferenceSetByGuava(List<String> big, List<String> small) {
        Set<String> differenceSet = Sets.difference(Sets.newHashSet(big), Sets.newHashSet(small));
        return Lists.newArrayList(differenceSet);
    }

    /**
     * 自己实现取List集合的差集--自制轮子大师兄造
     *
     * @param big   大集合
     * @param small 小集合
     * @return 两个集合的差集
     */
    public static List<String> getDifferenceSetByMyself(List<String> big, List<String> small) {
        Set<String> sameString = Sets.newHashSet();
        for (String s : small) {
            sameString.add(s);
        }
        List<String> result = Lists.newArrayList();
        for (String s : big) {
            if (sameString.add(s)) {
                result.add(s);
            }
        }
        return result;
    }

    /**
     * 自己实现取Map集合的差集--站在巨人的肩膀上造轮子
     *
     * @param bigMap   大集合
     * @param smallMap 小集合
     * @return 两个集合的差集
     */
    public static Map<String, String> getDifferenceSetByGuava(Map<String, String> bigMap, Map<String, String> smallMap) {
        Set<String> bigMapKey = bigMap.keySet();
        Set<String> smallMapKey = smallMap.keySet();
        Set<String> differenceSet = Sets.difference(bigMapKey, smallMapKey);
        Map<String, String> result = Maps.newHashMap();
        for (String key : differenceSet) {
            result.put(key, bigMap.get(key));
        }
        return result;
    }
}
