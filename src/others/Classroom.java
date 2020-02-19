package others;

public class Classroom {
    /**
     * 会议
     */
   static class A {
        public int start;// 会议开始时间
        public int end; // 会议结束时间
        public boolean flag; // 标志会议是否被安排
        public boolean used = false; // 标记这个会议是否已经进行处理

        public A(int start, int end) {
            if (end < start) {
                new IllegalArgumentException("会议时间有误");
            }
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {


        boolean[] time = new boolean[24];// 表示这个时间是否被占用


        A[] array = new A[2];// 会议时间段

        array[0] = new A(8, 10);
        array[1] = new A(13, 15);


        sort(array);

        while (true) {
            A a = maxTimeLength(array);
            if (a == null) {
                break;
            }

            a.used = true;
            if (isFree(a.start, a.end, time)) {
                a.flag = true;
                changeTrue(a.start, a.end, time);
            }
        }

        for (A a : array) {
            if (a.flag) {
                System.out.println(a.start + "," + a.end);
            }
        }
    }

    /**
     * 查找会议室这段时间是否空闲
     *
     * @param start 开始时间
     * @param end   介绍时间
     * @param time
     * @return
     */
    public static boolean isFree(int start, int end, boolean[] time) {
        for (int i = start; i < end; i++) {
            if (time[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * 将时间改为已被占用
     *
     * @param start
     * @param end
     * @param time
     */
    public static void changeTrue(int start, int end, boolean[] time) {
        for (int i = start; i < end; i++) {
            time[i] = true;
        }
    }

    /**
     * 将会议开始时间按照时间大小排序
     *
     * @param array
     */
    public static void sort(A[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j].start > array[j + 1].start) {
                    A temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }


    /**
     * 获取最长长度的会议时间
     *
     * @param array
     * @return
     */
    public static A maxTimeLength(A[] array) {
        A j = null; // 最大时间段的角标
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (!array[i].used && array[i].end - array[i].start > max) {
                max = array[i].end - array[i].start;
                j = array[i];
            }
        }
        return j;
    }


}
