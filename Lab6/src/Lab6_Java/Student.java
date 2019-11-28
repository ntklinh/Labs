package Lab6_Java;

public class Student {

    public static void inserts(int[] arr){
        int idNumber = arr [0];
        for(int i = 0; i < arr.length-1; i++){
            for (int j = i+1; j < arr.length; j++){
                if(arr[i]>arr[j]){
                    idNumber = arr[j];
                    arr[j] = arr[i];
                    arr[i] = idNumber;
                }
            }
        }
    }
}
class TestStudent {
    public static void main(String[] args) {
        int[] a = {0, 3, 1, 8, 9};
        Student.inserts(a);
        for (int i = 0; i < a.length; ++i)
            System.out.println(a[i] + " ");
    }
}
