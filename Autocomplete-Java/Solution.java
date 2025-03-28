import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;

class Term implements Comparable<Term> {
    private final String query;
    private final long weight;

    public Term(String query, long weight) {
        if (query == null || weight < 0)
            throw new IllegalArgumentException("Invalid arguments");
        this.query = query;
        this.weight = weight;
    }

    public String getQuery() {
        return query;
    }

    public long getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Term that) {
        return this.query.compareTo(that.query);
    }

    public static Comparator<Term> byDescendingWeight() {
        return new Comparator<Term>() {
            @Override
            public int compare(Term t1, Term t2) {
                if (t1.weight < t2.weight) {
                    return 1;
                } else if (t1.weight > t2.weight) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
    }

    // Comparator for comparing terms by prefix order
    public static Comparator<Term> byPrefixOrder(int r) {
        final int prefixLength = r; // Store `r` in a final variable
        return new Comparator<Term>() {
            @Override
            public int compare(Term t1, Term t2) {
                int len1 = Math.min(prefixLength, t1.query.length());
                int len2 = Math.min(prefixLength, t2.query.length());

                for (int i = 0; i < Math.min(len1, len2); i++) {
                    char c1 = t1.query.charAt(i);
                    char c2 = t2.query.charAt(i);
                    if (c1 != c2) {
                        return c1 - c2; // Compare character by character
                    }
                }
                return len1 - len2; // Handle cases where one string is a prefix of the other
            }
        };
    }

    @Override
    public String toString() {
        return weight + "\t" + query;
    }
}

class BinarySearchDeluxe {

    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        int lo = 0, hi = a.length - 1;
        int firstIndex = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (comparator.compare(a[mid], key) >= 0) {
                if (comparator.compare(a[mid], key) == 0)
                    firstIndex = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return firstIndex;
    }

    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        int lo = 0, hi = a.length - 1;
        int lastIndex = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (comparator.compare(a[mid], key) <= 0) {
                if (comparator.compare(a[mid], key) == 0)
                    lastIndex = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lastIndex;
    }
}

class Autocomplete {
    private final Term[] terms;

    public Autocomplete(Term[] terms) {
        if (terms == null)
            throw new IllegalArgumentException("Terms array cannot be null");
        this.terms = Arrays.copyOf(terms, terms.length);
        Arrays.sort(this.terms);
    }

    public Term[] allMatches(String prefix) {
        if (prefix == null)
            throw new IllegalArgumentException("Prefix cannot be null");

        Term key = new Term(prefix, 0);
        Comparator<Term> prefixOrder = Term.byPrefixOrder(prefix.length());
        int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, key, prefixOrder);
        int lastIndex = BinarySearchDeluxe.lastIndexOf(terms, key, prefixOrder);

        if (firstIndex == -1 || lastIndex == -1)
            return new Term[0];

        Term[] matches = Arrays.copyOfRange(terms, firstIndex, lastIndex + 1);
        Arrays.sort(matches, Term.byDescendingWeight());
        return matches;
    }

    public int numberOfMatches(String prefix) {
        if (prefix == null)
            throw new IllegalArgumentException("Prefix cannot be null");

        Term key = new Term(prefix, 0);
        Comparator<Term> prefixOrder = Term.byPrefixOrder(prefix.length());
        int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, key, prefixOrder);
        int lastIndex = BinarySearchDeluxe.lastIndexOf(terms, key, prefixOrder);

        return (firstIndex == -1 || lastIndex == -1) ? 0 : (lastIndex - firstIndex + 1);
    }
}

public class Solution {

    public static Term[] readFile(String filename) throws IOException {
        BufferedReader br = Files.newBufferedReader(Paths.get(filename), StandardCharsets.UTF_8);
        String line = br.readLine();
        if (line == null) {
            br.close();
            throw new IOException("File is empty");
        }
        int n = Integer.parseInt(line.trim());
        Term[] terms = new Term[n];
        for (int i = 0; i < n; i++) {
            line = br.readLine();
            if (line == null) {
                br.close();
                throw new IOException("Unexpected end of file at line " + (i + 2));
            }
            String[] parts = line.trim().split("\t", 2);
            if (parts.length < 2) {
                br.close();
                throw new IOException("Invalid file format in line " + (i + 2));
            }
            long weight = Long.parseLong(parts[0].trim());
            String query = parts[1].trim();
            terms[i] = new Term(query, weight);
        }
        br.close();
        return terms;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));
        PrintStream out = new PrintStream(System.out, true, "UTF-8");

        String filename = br.readLine();
        Term[] terms = readFile(filename);
        int k = Integer.parseInt(br.readLine().trim());
        Autocomplete autocomplete = new Autocomplete(terms);

        String prefix;
        while ((prefix = br.readLine()) != null && !prefix.isEmpty()) {
            Term[] results = autocomplete.allMatches(prefix);
            out.printf("%d matches\n", autocomplete.numberOfMatches(prefix));
            for (int i = 0; i < Math.min(k, results.length); i++) {
                out.println(results[i]);
            }
        }
        br.close();
    }
}
