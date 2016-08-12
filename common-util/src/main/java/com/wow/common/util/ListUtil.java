package com.wow.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ListUtil {

    /**
     * Transform List with one type to List with another type.
     *
     * @param list
     * @param mapper
     * @param <Result>
     * @param <From>
     * @return
     */
    public static <Result, From> List<Result> transform(List<From> list, Function<? super From, ? extends Result> mapper) {
        List<Result> resultList = new ArrayList<Result>();
        for (From from : list) {
            resultList.add(mapper.apply(from));
        }
        return resultList;
    }
}
