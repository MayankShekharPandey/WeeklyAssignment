import java.util.*;

class Client {
    String name;
    int riskScore;
    double accountBalance;

    Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    public String toString() {
        return name + ":" + riskScore;
    }
}

public class ClientRiskSorter {

    public static void bubbleSort(Client[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(Client[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 && (arr[j].riskScore < key.riskScore ||
                    (arr[j].riskScore == key.riskScore &&
                            arr[j].accountBalance < key.accountBalance))) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static List<Client> topClients(Client[] arr, int k) {
        List<Client> list = new ArrayList<>();
        for (int i = 0; i < Math.min(k, arr.length); i++) {
            list.add(arr[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        Client[] clients = {
                new Client("clientC", 80, 5000),
                new Client("clientA", 20, 3000),
                new Client("clientB", 50, 4000)
        };

        Client[] bubbleArr = clients.clone();
        bubbleSort(bubbleArr);
        System.out.println(Arrays.toString(bubbleArr));

        Client[] insertionArr = clients.clone();
        insertionSort(insertionArr);
        System.out.println(Arrays.toString(insertionArr));

        System.out.println(topClients(insertionArr, 3));
    }
}