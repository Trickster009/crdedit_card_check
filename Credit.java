import java.util.*;

public class Credit {
    public static void main(String[] args) {
        int pos = 0;
        int t_sum = 0;
        long n;
        int count = 0;
        long n1;

        // Luhns Algo
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Number: ");
            n = scanner.nextLong();
            n1 = n;
            while (n != 0) {
                if (pos % 2 != 0) {
                    int temp = 2 * (int) (n % 10); // multiply alternate digits by 2
                    if (temp > 9) {
                        t_sum += (temp % 10 + temp / 10); // if number is of 2 digits after multiplying by 2, this will add it
                    } else {
                        t_sum += temp;
                    }
                } else {
                    t_sum += n % 10;
                }
                n = n / 10;
                pos++;
                count++;
            }
        } while (n != 0);

       // int a = (int) (n1 / 10000000000000L);
        //int m = (int) (n1 / 100000000000000L);
        //int v = (int) (n1 / 1000000000000000L);
        //int z = (int) (n1 / 1000000000000L);
	
	String cardNumberString = Long.toString(n1);

	int a = Integer.parseInt(cardNumberString.substring(0, 2));
	int m = Integer.parseInt(cardNumberString.substring(0, 2));
	int v = Integer.parseInt(cardNumberString.substring(0, 1));
	int z = Integer.parseInt(cardNumberString.substring(0, 1));

        if (t_sum % 10 == 0) {
            // condition for american express 371449635398431
            if (count == 15 && (a == 34 || a == 37)) {
                System.out.println("AMEX");
                return;
            }
            // condition for mastercard 5466160126455789
            else if (count == 16 && (m == 51 || m == 52 || m == 53 || m == 54 || m == 55)) {
                System.out.println("MASTERCARD");
                return;
            }
            // condition for visa 4111111111111
            else if ((count == 13 || count == 16) && (v == 4 || z == 4)) {
                System.out.println("VISA");
                return;
            }
            // condition if any of the above is not satisfied
            else {
                System.out.println("INVALID"); // to check if card is valid
                return;
            }
        }
        // condition if sum is not equal to 0
        else {
            System.out.println("INVALID"); // to check if card is valid
            return;
        }
    }
}

