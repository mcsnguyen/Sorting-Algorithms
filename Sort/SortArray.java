package Sort;

import java.util.Stack;

public class SortArray
{

    public static <T extends Comparable<? super T>> void quickSort(T[] a, int low, int high){
        int pivot;
        if (high > low){
            pivot = partition(a, low, high);
            quickSort(a, low, pivot - 1);
            quickSort(a, pivot + 1, high);
        }
    }

    public static <T extends Comparable<? super T>> void quickSortIt(T[] a, int low, int high){
        int startIndex = low;
        int endIndex = high;
        int partIndex;
        Stack<Bounds> boundary = new Stack();
        boundary.push(new Bounds(startIndex, endIndex));

        while(!boundary.isEmpty()){
            startIndex = boundary.peek().getStart();
            endIndex = boundary.peek().getEnd();
            partIndex = partition(a, startIndex, endIndex);
            boundary.pop();
            if(partIndex - 1 > startIndex){
                boundary.push(new Bounds(startIndex, partIndex-1));
            }
            if(partIndex + 1 < endIndex){
                boundary.push(new Bounds(partIndex+1, endIndex));
            }
        }
    }

    public static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] tempArray, int first, int last) {
        if(first < last) {
            int mid = (first+last)/2;
            mergeSort(a, tempArray, first, mid);
            mergeSort(a, tempArray, mid+1, last);
            merge(a, tempArray, first, mid, last);
        }
    }
    public static int MM(Integer[] arr, int l, int r, int kth)
    {
        if (kth > 0 && kth <= r - l + 1)
        {
            int pivot = partition(arr, l, r);

            if (pivot-l == kth-1)
                return arr[pivot];

            if (pivot-l > kth-1)
                return MM(arr, l, pivot-1, kth);

            return MM(arr, pivot+1, r, kth-pivot+l-1);
        }

        return Integer.MAX_VALUE;
    }
    private static void swap(Object[] a, int i, int j){
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static <T extends Comparable<? super T>> int partition(T[] a, int low, int high){
        int j = low;
        int pivot = low;
        for(int i = low + 1; i <= high; i++){
            if(a[i].compareTo(a[pivot]) == -1){
                j++;
                swap(a, i, j);
            }
        }
        pivot = j;
        swap(a, low, pivot);
        return pivot;
    }

    private static <T extends Comparable<? super T>> void merge(T[] a, T[] tempArray, int first, int mid, int last) {
        int beginHalf1 = first;
        int endHalf1 = mid;
        int beginHalf2 = mid+1;
        int endHalf2 = last;
        int index = 0;

        while((beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2)) {
            if((a[beginHalf1].compareTo(a[beginHalf2]) <= 0)) {
                tempArray[index] = a[beginHalf1];
                beginHalf1++;
            }
            else {
                tempArray[index] = a[beginHalf2];
                beginHalf2++;
            }
            index++;
        }
        while((beginHalf1 <= endHalf1)) {
            tempArray[index] = a[beginHalf1];
            beginHalf1++;
            index++;
        }
        while((beginHalf2 <= endHalf2)) {
            tempArray[index] = a[beginHalf2];
            beginHalf2++;
            index++;
        }
        for(int i = first, t = 0; i <= last; i++, t++) { //Copy tempArray to a
            a[i] = tempArray[t];

        }
    }


}
class Bounds{
    private final int start;
    private final int end;
    Bounds(int start, int end){
        this.start = start;
        this.end = end;
    }
    public int getStart(){return start;}
    public int getEnd(){return end;}
}

