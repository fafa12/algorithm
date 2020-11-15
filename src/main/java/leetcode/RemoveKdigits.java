package leetcode;

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
        String s = removeKdigits.removeKdigits("1432219", 3);
        System.out.println(s);
    }

    public String removeKdigits(String num, int k) {

        String[] numbs = num.split("");

        for (int i = 0; i < numbs.length - 1; i++) {

            if (k == 0) break;

            if (k > 0 && numbs[i].compareTo(numbs[i + 1]) > 0) {
                k--;
                numbs[i] = null;
            }
        }

        for (int i = 0; i < k; i++) {
            if (numbs[numbs.length - 1 - i] != null) numbs[numbs.length - 1 - i] = null;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numbs.length; i++) {
            if (numbs[i] != null && !(result.length() == 0 && numbs[i].equals("0"))) {
                result.append(numbs[i]);
            }
        }

        return result.toString();
    }
}
