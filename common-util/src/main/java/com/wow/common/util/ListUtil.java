package com.wow.common.util;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        return list.stream().map(mapper).collect(Collectors.toList());
    }
}
