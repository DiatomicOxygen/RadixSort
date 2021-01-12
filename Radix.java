public class Radix {

  public static int nth(int n, int col) {
    int num = n;
    return (num / ((int)Math.pow(10, col))) % 10;
  }

  public static int length(int n) {
    int num = n;
    return (int)(Math.log((double)num) / Math.log(10.0)) + 1;
  }

  public static void merge(MyLinkedList original, MyLinkedList[] buckets) {
    for (MyLinkedList bucket : buckets) {
      original.extend(bucket);
    }
  }
}
