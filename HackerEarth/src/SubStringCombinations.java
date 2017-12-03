import java.util.Scanner;

public class SubStringCombinations {
	static int count = 0;

	public static void main(String args[]) throws Exception {

		// Scanner
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		s.nextLine();
		String line = s.nextLine();
		String x = s.next();
		String y = s.next();
		int Q = s.nextInt();
		int[] l = new int[Q];
		int[] r = new int[Q];
		for (int i = 0; i < Q; i++) {
			l[i] = s.nextInt();
			r[i] = s.nextInt();
		}
		s.close();

		if (N >= 1 && N <= 100000) {
			if (Q >= 1 && Q <= 100000) {
				for (int i = 0; i < Q; i++) {
					if (l[i] >= 0 && l[i] <= r[i]) {
						if (r[i] <= N - 1) {
							String subStr = line.substring(l[i], r[i] + 1);
							count = 0;
							count = combinations(count, "", subStr, x, y);
							System.out.println(count);
						} else
							return;
					}
				}
			}
		} else
			return;
	}

	static int combinations(int tempCount, String prefix, String str, String x, String y) {
		tempCount = 0;
		if (prefix.contains(x) && prefix.contains(y))
			tempCount++;

		count = (tempCount + count) % 1000000007;
		int N1 = str.length();
		for (int i = 0; i < N1; i++)
			combinations(tempCount, prefix + str.charAt(i), str.substring(i + 1), x, y);

		return count;
	}
}