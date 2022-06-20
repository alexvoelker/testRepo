import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class sieveOfEratosthenes {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter a number 'n' to find all primes at or below this number:");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());

        sieve(n);
    }

    public static void sieve(int n) {
        ArrayList<Integer> primes = new ArrayList<>();
        for (int num = 2; num <= n; num++) {
            primes.add(num);
        }

        for (int index : primes) {
            for (int num : primes) {
                if (num <= index * index)
                    continue;
                if (num % index == 0)
                    primes.remove(num);
            }
        }

        System.out.println("The prime numbers up to number " + n + " are: " + primes);
    }
}
