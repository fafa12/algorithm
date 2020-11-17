package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllCellsDistOrder {

    /**
     * 1030. 距离顺序排列矩阵单元格
     *
     * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
     *
     * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
     *
     * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
     */

    public static void main(String[] args) {
        AllCellsDistOrder allCellsDistOrder = new AllCellsDistOrder();

        allCellsDistOrder.allCellsDistOrder(1, 2, 0, 0);
    }

    /**
     * 桶排序
     */
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] re = new int[R * C][2];
        // 计算最大可能长度
        int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        ArrayList<ArrayList<Pos>> bucket = new ArrayList<>(10);
        bucket.size();
        for (int i = 0; i <= maxDist; i++) {
            bucket.add(new ArrayList<>());
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int d = dist(i, j, r0, c0);
                List<Pos> list = bucket.get(d);
                list.add(new Pos(i, j));
            }
        }

        // 当前添加元素
        int currIndex = 0;
        for (int i = 0; i <= maxDist; i++) {
            List<Pos> list = bucket.get(i);
            if (list.isEmpty()) continue;
            for (Pos p : list) {
                re[currIndex][0] = p.r;
                re[currIndex][1] = p.c;
                currIndex++;
            }
        }

        return re;
    }

    private int dist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    private static class Pos {
        int r;
        int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    /**
     * BFS
     */
    public int[][] allCellsDistOrder1(int R, int C, int r0, int c0) {
        int[][] re = new int[R * C][2];
        int dist = 0;
        int cnt = 0;
        int[] factor = {-1, 1};
        while (cnt < R * C) {
            for (int rowDist = 0; rowDist <= dist; rowDist++) {
                int colDist = dist - rowDist;
                for (int i = 0; i < 2; i++) {
                    int row = r0 + factor[i] * rowDist;
                    for (int j = 0; j < 2; j++) {
                        int col = c0 + factor[j] * colDist;
                        if (row >= 0 && row < R && col >= 0 && col < C) {
                            re[cnt][0] = row;
                            re[cnt][1] = col;
                            cnt++;
                        }
                        if (colDist == 0) break;
                    }
                    if (rowDist == 0) break;
                }
            }
            dist++;
        }

        return re;
    }
}
