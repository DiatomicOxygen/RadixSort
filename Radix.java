public class Radix {

  public static int nth(int n, int col) {
    int num = n;
    return (num / ((int)Math.pow(10, col))) % 10;
  }

  public static int length(int n) {
    int num = n;
    return (int)(Math.log((double)num) / Math.log(10.0)) + 1;
  }

  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
    for (SortableLinkedList bucket : buckets) {
      original.extend(bucket);
    }
  }


}
