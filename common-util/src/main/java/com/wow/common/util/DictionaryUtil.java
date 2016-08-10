package com.wow.common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wow.common.factory.SpringBeanFactory;
import com.wow.common.mapper.DictionaryMapper;
import com.wow.common.model.Dictionary;
import com.wow.common.model.DictionaryExample;

/**
 * 数据字典工具包
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月25日 下午3:36:46 Exp $
 */
public class DictionaryUtil {

    private static final DictionaryMapper dictionaryMapper = SpringBeanFactory
        .getBean("dictionaryMapper", DictionaryMapper.class);

    //存放组对应的数据字典信息
    private static final Map<String, List<Dictionary>> groupMap = new HashMap<String, List<Dictionary>>();
    //存放key对应的数据字典信息
    private static final Map<String, Dictionary> keyMap = new HashMap<String, Dictionary>(300);

    /**
     * 初始化数据字典信息
     */
    public static void init() {
        //获取全部数据字典信息
        List<Dictionary> dictionaryList = dictionaryMapper.selectByExample(new DictionaryExample());
        if (CollectionUtil.isEmpty(dictionaryList)) {
            return;
        }

        //对数据字典进行分组
        groupBy(dictionaryList);

        //对分组中的数据字典信息进行排序
        sortBy();
    }

    //对分组中的数据字典信息进行排序
    private static void sortBy() {
        for (Map.Entry<String, List<Dictionary>> entry : groupMap.entrySet()) {
            Collections.sort(entry.getValue(), new Comparator<Dictionary>() {
                @Override
                public int compare(Dictionary o1, Dictionary o2) {
                    return o1.getKeyOrder().compareTo(o2.getKeyOrder());
                }
            });
        }
    }

    //对数据字典进行分组
    private static void groupBy(List<Dictionary> dictionaryList) {
        //对数据字典进行分组
        for (Dictionary dictionary : dictionaryList) {
            keyMap.put(generateKey(dictionary.getKeyGroup(), dictionary.getKeyId()), dictionary);

            if (groupMap.containsKey(dictionary.getKeyGroup())) {
                groupMap.get(dictionary.getKeyGroup()).add(dictionary);
            } else {
                List<Dictionary> dictionaryLists = new ArrayList<Dictionary>();
                dictionaryLists.add(dictionary);
                groupMap.put(dictionary.getKeyGroup(), dictionaryLists);
            }
        }
    }

    /**
     *
     * @param keyGroup
     * @param key
     * @return
     */
    private static String generateKey(final String keyGroup, final Integer key) {
        StringBuilder sb = new StringBuilder();
        sb.append(keyGroup).append("_").append(key);

        return sb.toString();
    }

    /**
     *
     * @param keyGroup
     * @return
     */
    public static List<Dictionary> getKeyGroup(final String keyGroup) {
        if (groupMap.containsKey(keyGroup)) {
            return groupMap.get(keyGroup);
        }

        return Collections.emptyList();
    }

    /**
     * 根据组id和key获取数据字典
     * 
     * @param keyGroup
     * @param key
     * @return
     */
    public static Dictionary getDictionary(final String keyGroup, final Integer key) {
        return keyMap.get(generateKey(keyGroup, key));
    }

    /**
     * 根据组id和key获取key对应的值
     * 
     * @param keyGroup
     * @param key
     * @return
     */
    public static String getValue(final String keyGroup, final Integer key) {
        Dictionary dictionary = getDictionary(keyGroup, key);

        return dictionary == null ? "" : dictionary.getKeyValue();
    }

}
