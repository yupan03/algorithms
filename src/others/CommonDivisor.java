package others;

public class CommonDivisor {
    public static void main(String[] args) {
        System.out.println(greatestCommonDivisor(100, 1020));
        System.out.println(getMaxNum(12));
    }

    /**
     * 欧几米得算法求最大公约数
     *
     * @param x
     * @param y
     * @return
     */
    public static int greatestCommonDivisor(int x, int y) {
        if (y == 0) return x;
        return greatestCommonDivisor(y, x % y);
    }

    /**
     * 空瓶子换饮料的算法
     *
     * @param n
     * @return
     */
    public static int getMaxNum(int n) {
        int k = 0;

        while (n / 3 > 0) {
            k += n / 3;
            n = n / 3 + n % 3;
        }
        if (n % 3 == 2) k += 1;

        return k;
    }
}