import java.util.*;

public class AccountSearch {

    public static int linearFirst(String[] arr, String target) {
        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear First Comparisons: " + comparisons);
                return i;
            }
        }
        System.out.println("Linear First Comparisons: " + comparisons);
        return -1;
    }

    public static int linearLast(String[] arr, String target) {
        int comparisons = 0;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                index = i;
            }
        }
        System.out.println("Linear Last Comparisons: " + comparisons);
        return index;
    }

    public static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid].equals(target)) {
                System.out.println("Binary Comparisons: " + comparisons);
                return mid;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Binary Comparisons: " + comparisons);
        return -1;
    }

    public static int countOccurrences(String[] arr, String target) {
        int first = firstOccurrence(arr, target);
        int last = lastOccurrence(arr, target);
        if (first == -1) return 0;
        return last - first + 1;
    }

    public static int firstOccurrence(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                result = mid;
                high = mid - 1;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static int lastOccurrence(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                result = mid;
                low = mid + 1;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] logs = {"accA", "accB", "accB", "accC"};

        System.out.println("Linear First Index: " + linearFirst(logs, "accB"));
        System.out.println("Linear Last Index: " + linearLast(logs, "accB"));

        Arrays.sort(logs);

        System.out.println("Binary Index: " + binarySearch(logs, "accB"));
        System.out.println("Count: " + countOccurrences(logs, "accB"));
    }
}