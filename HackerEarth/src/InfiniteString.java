import java.util.Scanner;

public class InfiniteString {
	public static void main(String[] args) {

		// Scanner
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		input.nextLine();
		String[] strArray = new String[N];
		StringBuilder concatStr = new StringBuilder("");
		for (int i = 0; i < N; i++) {
			strArray[i] = input.next();
			concatStr.append(strArray[i]);
		}
		int Q = input.nextInt();
		long[] POS = new long[Q];
		long max = 0;
		for (int i = 0; i < Q; i++) {
			POS[i] = input.nextLong();
			if (max < POS[i])
				max = POS[i];
		}
		input.close();

		String str = concatStr.toString();
		StringBuilder reverseStr = concatStr.reverse();
		StringBuilder resultStr = new StringBuilder("");

		int k = 2;
		while (true) {
			if (resultStr.length() >= max)
				break;
			String dol = "$";
			String dol_result = "";
			for (int j = 0; j < k; j++) {
				dol_result += dol;
			}
			resultStr.append(str + "$" + reverseStr);
			resultStr.append(dol_result);
			k++;
		}

		System.out.println(resultStr);

		for (int i = 0; i < Q; i++) {
			System.out.println(resultStr.charAt((int) (POS[i] - 1)));
		}
	}
}
