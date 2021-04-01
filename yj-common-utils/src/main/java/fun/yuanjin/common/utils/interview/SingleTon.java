package fun.yuanjin.common.utils.interview;

/**
 * @ClassName SingleTon
 * @Description 自己实现一个单例模式
 * @Author yuanjin
 * @Date 2021-02-24 13:21
 * @Version 1.0
 */
public class SingleTon {

    private volatile static SingleTon instance;

    private SingleTon() {
    }

    public static SingleTon getInstance() {
        if (null == instance) {
            synchronized (SingleTon.class) {
                if (null == instance) {
                    instance = new SingleTon();
                }
            }
        }
        return instance;
    }
}

 class Day{
    public static void main(String[] args) {
        Day d = new Day();
        System.out.println(d.nextGreaterElement(2000));
    }
     public int nextGreaterElement(int n) {
         char[] a = ("" + n).toCharArray();
         int i = a.length - 2;
         while (i >= 0 && a[i + 1] <= a[i]) {
             i--;
         }
         if (i < 0)
             return -1;
         int j = a.length - 1;
         while (j >= 0 && a[j] <= a[i]) {
             j--;
         }
         swap(a, i, j);
         reverse(a, i + 1);
         try {
             return Integer.parseInt(new String(a));
         } catch (Exception e) {
             return -1;
         }
     }
     private void reverse(char[] a, int start) {
         int i = start, j = a.length - 1;
         while (i < j) {
             swap(a, i, j);
             i++;
             j--;
         }
     }
     private void swap(char[] a, int i, int j) {
         char temp = a[i];
         a[i] = a[j];
         a[j] = temp;
     }
}
