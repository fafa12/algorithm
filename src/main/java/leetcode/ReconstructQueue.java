package leetcode;

import java.util.Arrays;

public class ReconstructQueue {

    /**
     * 406. 根据身高重建队列
     *
     * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对 (h, k) 表示，其中 h 是这个人的身高，k 是应该排在这个人前面且身高大于或等于 h 的人数。 例如：[5,2] 表示前面应该有 2 个身高大于等于 5 的人，而 [5,0] 表示前面不应该存在身高大于等于 5 的人。
     *
     * 编写一个算法，根据每个人的身高 h 重建这个队列，使之满足每个整数对 (h, k) 中对人数 k 的要求。
     *
     * 示例：
     *
     * 输入：[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
     * 输出：[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (people1, people2) -> {
            if (people1[0] != people2[0]) {
                return people1[0] - people2[0];
            } else {
                return people2[1] - people1[1];
            }
        });

        int n = people.length;
        int[][] ans = new int[n][];
        for (int[] person : people) {
            int spaces = person[1] + 1;
            for (int i = 0; i < n; ++i) {
                if (ans[i] == null) {
                    --spaces;
                    if (spaces == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
