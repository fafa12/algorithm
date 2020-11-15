package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveKdigits {

    /**
     * 402
     * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
     * <p>
     * 注意:
     * <p>
     * num 的长度小于 10002 且 ≥ k。
     * num 不会包含任何前导零。
     */
    public static void main(String[] args) {
        RemoveKdigits removeKdigits = new RemoveKdigits();
        String s = removeKdigits.removeKdigits("1234567890", 9);
        System.out.println(s);
    }

    private String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > c) {
                deque.pollLast();
                k--;
            }

            deque.offerLast(c);
        }

        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean headZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (headZero && digit == '0') {
                continue;
            }
            headZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }


}
