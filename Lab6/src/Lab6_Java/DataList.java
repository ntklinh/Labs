package Lab6_Java;

public class DataList {
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);
        merge(a, l, r, mid, n - mid);
    }

    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}
class TestDataList {
    public static void main(String[] args) {
        int[] actual = {5, 1, 20, 2, 3, 4};
        int[] expected = {10, 2, 8, 9, 5, 6};
        int[] result = new int[12];
        DataList.mergeSort(actual, 6);
        DataList.mergeSort(expected, 6);
        DataList.merge(result, actual, expected, 6, 6);
        for (int i = 0; i < 12; ++i)
            System.out.print(result[i] + " ");
    }
}
