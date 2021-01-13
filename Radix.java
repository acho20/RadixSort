public class Radix{
  public static int nth(int n, int col){
    for(int i = 0; i < col - 1; i++){
      n = (n - (n % 10)) / 10;
    }
    return n % 10;
  }

  public static int length(int n){
    if(n == 0){
      return 1;
    }
    int x = 0;
    while(n > 0){
      x++;
      n = (n - (n % 10)) / 10;
    }
    return x;
  }

  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets){
    original.extend(buckets[0]);
    for (int i = 1; i < buckets.length; i++){
      buckets[i-1].extend(buckets[1]);
    }
  }

}
