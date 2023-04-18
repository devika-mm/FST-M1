package activities;

public class Activity2 {
    public static void main(String[] args) {
        int arr[] = {10,77,10,54,-11,10};
        int sum = 0;
        for(int i=0;i<=arr.length-1;i++){
            if(arr[i]==10){
                sum += arr[i];
            }
        }
        if(sum==30){
            System.out.print("True");
        }
        else {
            System.out.print("False");
        }
    }
}
