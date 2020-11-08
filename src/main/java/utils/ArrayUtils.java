package utils;

public class ArrayUtils {

    public static int[] transStringToArray(String arrStr) {
        String[] strings = arrStr.split(",");
        int[] res = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            res[i] = Integer.parseInt(strings[i]);
        }

        return res;
    }
}
