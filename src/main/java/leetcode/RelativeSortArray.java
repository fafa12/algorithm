package leetcode;

import com.alibaba.fastjson.JSON;
import utils.ArrayUtils;

public class RelativeSortArray {

    /**
     * 1122
     * 给你两个数组，arr1 和 arr2，
     *
     *     arr2 中的元素各不相同
     *     arr2 中的每个元素都出现在 arr1 中
     *
     * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

     * 提示：
     *
     *     arr1.length, arr2.length <= 1000
     *     0 <= arr1[i], arr2[i] <= 1000
     *     arr2 中的元素 arr2[i] 各不相同
     *     arr2 中的每个元素 arr2[i] 都出现在 arr1 中
     */

    public static void main(String[] args) {
        RelativeSortArray relativeSortArray = new RelativeSortArray();
        int[] arr1 = ArrayUtils.transStringToArray("2,3,1,3,2,4,6,7,9,2,19");
        int[] arr2 = ArrayUtils.transStringToArray("2,1,4,3,9,6");

        int[] arr = relativeSortArray.relativeSortArray(arr1, arr2);
        System.out.println(JSON.toJSONString(arr));
    }


    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] arr = new int[1001];
        int[] result = new int[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            arr[arr1[i]]++;
        }

        int currIndex = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr[arr2[i]]; j++) {
                result[currIndex] = arr2[i];
                currIndex++;
            }

            arr[arr2[i]] = 0;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) continue;

            for (int j = 0; j < arr[i]; j++) {
                result[currIndex] = i;
                currIndex++;
            }
        }

        return result;
    }
}
