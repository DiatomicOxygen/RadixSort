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

  private static int largestDigit(SortableLinkedList data) {
    int largestDigit = 0;
    int n;
    for (int i = 0; i < data.size(); i++) {
      n = data.get(i);
      n = length(n);
      largestDigit = Math.max(largestDigit, n);
    }
    return largestDigit;
  }

  public static void radixSortSimple(SortableLinkedList data) {
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for (int i = 0; i < 10; i++) {
      buckets[i] = new SortableLinkedList();
    }

    int size = data.size();
    int largestDigit = largestDigit(data);
    int n, d;
    for (int i = 0; i < largestDigit; i++) {
      for (int j = 0; j < size; j++) {
        n = data.get(j);
        d = nth(n, i);
        buckets[d].add(n);
      }
      for (int k = 0; k < size; k++) {
        data.remove(0);
      }
      merge(data, buckets);
    }
  }

}
