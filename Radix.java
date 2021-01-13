public class Radix{
  public static int nth(int n, int col){
    String x = "" + n;
    int y = 0;
    if(x.charAt(0) == '-'){
      y++;
    }

    if (col > length(n) - 1 - y){
      return 0;
    }
    return Integer.parseInt(String.valueOf(x.charAt(x.length() - col-1)));
  }

  public static int length(int n){
    String x = "" + n;
    int y = x.length();
    if(x.charAt(0) == '-'){
      return y - 1;
    }else{
      return y;
    }
  }

  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets){
    for (int i = 0; i < buckets.length; i++){
      original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data){
    int largestdigit = -1;
    int current = 0;

    System.out.println(data);

    for(int i = 0; i < data.size();i++){
      current = data.remove(0);
      largestdigit = Math.max(length(current), largestdigit);
      data.add(current);
    }
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for(int i = 0; i < buckets.length; i++) {
      buckets[i] = new SortableLinkedList();
    }

    int datalength = data.size();

    for(int i = 0 ; i < largestdigit; i++){
      for(int j = 0; j < datalength; j++){
        current = data.get(j);
        buckets[nth(current, i)].add(current);
      }
      data = new SortableLinkedList();
      merge(data, buckets);
    }
    System.out.println(data);
  }
}
