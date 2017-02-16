import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.BitSet;

public class main15116158d {
    public static void main(String[] args) {
        final long FNV_offset_basis = 0x811c9dc5;
        final long FNV_prime = 0x01000193;
        int m = 0;
        int count = 0;
        String mSize = args[0];
        m = Integer.parseInt(mSize);
        String inputfile = args[1];
        String outputfile = args[2];
        BitSet bs = new BitSet(m);
        BufferedReader br = null;
        char[] Rank = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        try {
            br = new BufferedReader(new FileReader(inputfile));
            String firstLine = br.readLine();
            count = Integer.parseInt(firstLine);
            for (int i = 0; i < count; i++) {
                String string = br.readLine();
                char[] S = string.toCharArray();
                long hash = FNV_offset_basis;
                for (int j = 0; j < S.length; j++) {
                    hash = hash * FNV_prime;
                    hash = hash ^ S[j];
                }
                if ((hash % m) < 0) {
                    bs.set((int) ((hash % m) + m));
                } else {
                    bs.set((int) (hash % m));
                }
                long rank = 0;
                hash = 0;
                for (int j = 0; j < S.length; j++) {
                    for (int x = 0; x < Rank.length; x++) {
                        if (S[j] == Rank[x]) {
                            rank = (x + 1);
                            break;
                        }
                    }
                    hash += (long) ((rank * rank) * (Math.pow(2, (2 + (3 * j)))));
                }
                int hashs = (int) (hash % m);
                bs.set(hashs);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        try {
            br = new BufferedReader(new FileReader(outputfile));
            String firstLine = br.readLine();
            count = Integer.parseInt(firstLine);
            for (int i = 0; i < count; i++) {
                BitSet bsc = new BitSet(m);
                String string = br.readLine();
                char[] S = string.toCharArray();
                long hash = FNV_offset_basis;
                for (int j = 0; j < S.length; j++) {
                    hash = hash * FNV_prime;
                    hash = hash ^ S[j];
                }
                if ((hash % m) < 0) {
                    bsc.set((int) ((hash % m) + m));
                } else {
                    bsc.set((int) (hash % m));
                }

                long rank = 0;
                hash = 0;
                for (int j = 0; j < S.length; j++) {
                    for (int x = 0; x < Rank.length; x++) {
                        if (S[j] == Rank[x]) {
                            rank = (x + 1);
                            break;
                        }
                    }
                    hash += (long) (rank * rank * (Math.pow(2, (2 + 3 * (j)))));
                }
                int hashs = (int) (hash % m);
                bsc.set(hashs);
                BitSet temp = (BitSet) bsc.clone();
                temp.and(bs);
                if (temp.equals(bsc)) {
                    int w = bs.cardinality();
                    double fa = (Math.pow(w * 1.0 / m, 2.0));
                    fa = Math.round(fa *100);
                    System.out.printf("Maybe, %.0f%%\n", fa);
                } else {
                    System.out.println("No");
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


    }


}
