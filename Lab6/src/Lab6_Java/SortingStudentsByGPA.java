package Lab6_Java;

public class SortingStudentsByGPA {
    public void QuickSort(double [] arr, int left, int right) {
        if(left >= 0 && left < right){
            double pivot = arr[(left+right)/2];
            int i = left;
            int j = right;
            while (i < j) {
                while (arr[i] < pivot) i++;
                while (arr[j] > pivot) j--;
                if (i <= j) {
                    if(i < j){
                        double tmp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = tmp;
                    }
                    i++;
                    j--;
                }
            }
            QuickSort(arr, left, j);
            QuickSort(arr, i, right);
        }
    }
}
class TestSortingStudentsByGPA {
    public static void main(String[] args){
        double[] array = new double[]{5.8,3.6,4.0,8.1,6.3};
        (new SortingStudentsByGPA()).QuickSort(array, 0, array.length-1);
        for(int i =0; i <array.length; i++)
            System.out.println(array[i]+ "");
    }
}

