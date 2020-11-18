package leetcode;

public class CanCompleteCircuit {

    /**
     * 134. 加油站
     *
     * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
     *
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
     *
     * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
     *
     * 说明:
     *
     *     如果题目有解，该答案即为唯一答案。
     *     输入数组均为非空数组，且长度相同。
     *     输入数组中的元素均为非负数。
     */

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int needOrLeft = 0;

        int minLeft = Integer.MAX_VALUE;
        int minLeftIndex = 0;

        for (int i = 0; i < gas.length; i++) {

            // 跑完当前路程所需或剩余的油量
            needOrLeft += gas[i] - cost[i];

            if (needOrLeft < minLeft) {
                minLeft = needOrLeft;
                minLeftIndex = i;
            }
        }

        return needOrLeft < 0 ? -1 : (minLeftIndex + 1) % gas.length;
    }
}
