package org.panda.jdto.merger;

import org.panda.jdto.SinglePropertyMerger;

import java.util.Arrays;

/**
 * User: luolibing
 * Date: 2018/3/22 21:11
 */
public class WrapValueMerger implements SinglePropertyMerger<String, String> {

    @Override
    public String mergeObjects(String value, String[] mergerParam) {
        return Arrays.toString(mergerParam) + " 我是 " + value;
    }
}
