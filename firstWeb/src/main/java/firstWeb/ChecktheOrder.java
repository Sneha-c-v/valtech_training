package firstWeb;

public class ChecktheOrder {

	public static void checkOrder(int arr[], int n) {

		if (arr[0] <= arr[1] && arr[n - 2] <= arr[n - 1])
			System.out.println("Increasing");

		else if (arr[0] >= arr[1] && arr[n - 2] >= arr[n - 1])
			System.out.println("Decreasing");

		else if (arr[0] <= arr[1] && arr[n - 2] >= arr[n - 1])
			System.out.println("Increasing then decreasing");

		else
			System.out.println("Decreasing then increasing");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 4, 3, 4, 2, 1 };
		int n = arr.length;
		checkOrder(arr, n);
	}

}
