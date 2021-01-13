public class Radix {

  public static int nth(int n, int col) {
    int num = Math.abs(n);
    return (num / ((int)Math.pow(10, col))) % 10;
  }

  public static int length(int n) {
    int num = Math.abs(n);
    return (int)(Math.log((double)num) / Math.log(10.0)) + 1;
  }

  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
    for (SortableLinkedList bucket : buckets) {
      original.extend(bucket);
    }
  }

  public static void radixSortSimple(SortableLinkedList data) {
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for (int i = 0; i < 10; i++) {
      buckets[i] = new SortableLinkedList();
    }

    int size = data.size();
    int largestDigit = 1;
    int n, d;
    for (int i = 0; i < largestDigit; i++) {
      for (int j = 0; j < size; j++) {
        n = data.get(0);
        d = nth(n, i);
        largestDigit = Math.max(largestDigit, length(n));
        buckets[d].add(n);
        data.remove(0);
      }
      merge(data, buckets);
    }
  }

  public static void radixSort(SortableLinkedList data) {
    SortableLinkedList negativeData = new SortableLinkedList();
    SortableLinkedList positiveData = new SortableLinkedList();
    int n;
    while (data.size() > 0) {
      n = data.get(0);
      if (n < 0) {
        negativeData.add(n);
        data.remove(0);
      } else {
        positiveData.add(n);
        data.remove(0);
      }
    }

    radixSortSimple(positiveData);
    radixSortSimple(negativeData);
    SortableLinkedList newNegData = new SortableLinkedList();
    for (int i = negativeData.size() - 1; i >= 0; i--) {
      newNegData.add(0, negativeData.get(0));
    }
    newNegData.extend(positiveData);
    data.extend(newNegData);
  }
}
