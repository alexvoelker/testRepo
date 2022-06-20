import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* Source: https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes */

public class sieveOfEratosthenes {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter a number 'n' to find all primes at or below this number:");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());

        sieve(n);

        System.out.println("The prime numbers up to number " + n + " are: " + sieve(n));
    }

    public static List<Integer> sieve(int n) {
        boolean[] primes = new boolean[n + 1];
//        flip(primes);
        for (int i = 2; i < n; i++) {
            primes[i] = true;
        }

        // make each non-prime number in the array "false"
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (primes[i])
                for (int j = i*i; j < n; j += i) {
                    primes[j] = false;
                }
        }

        return IntStream.range(0, primes.length)
                        .filter(i -> primes[i])
                        .boxed()
                        .collect(Collectors.toList());
    }

    /** Flips each element in an array
     * Note: not used in this program
     * */
    public static void flip(boolean[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = !array[i];
        }
    }
}
