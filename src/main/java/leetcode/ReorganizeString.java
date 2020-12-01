package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ReorganizeString {

    /**
     * 767. 重构字符串
     *
     * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
     *
     * 若可行，输出任意可行的结果。若不可行，返回空字符串。
     */

    public String reorganizeString(String S) {

        char maxKey = 0;
        int count = Integer.MIN_VALUE;
        Map<Character, Integer> charMap = new HashMap<>();

        char[] charArray = S.toCharArray();
        for (char c : charArray) {
            charMap.merge(c, 1, (oldValue, newValue) -> oldValue + 1);
            if (charMap.get(c) > (charArray.length + 1) / 2) {
                return "";
            }

            if (charMap.get(c) > count) {
                maxKey = c;
                count = charMap.get(c);
            }
        }

        int index = 0;
        for (int i = 0; i < charMap.get(maxKey); i++) {
            charArray[index] = maxKey;
            index += 2;

            if (index >= charArray.length) {
                index = 1;
            }
        }
        charMap.remove(maxKey);

        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {

            for (int i = 0; i < entry.getValue(); i++) {
                charArray[index] = entry.getKey();
                index += 2;

                if (index >= charArray.length) {
                    index = 1;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (char c : charArray) {
            result.append(c);
        }

        return result.toString();
    }
}
