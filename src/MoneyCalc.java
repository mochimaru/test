import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 入力した金額からいくつ硬貨が必要か確認するプログラム
public class MoneyCalc {
	// 硬貨の数
	private static int[] counts = { 0, 0, 0, 0, 0, 0 };
	// お金の種類
	private static int[] moneytypes = { 500, 100, 50, 10, 5, 1 };

	public static void main(String args[]) throws NumberFormatException,
			IOException {
		int money;

		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));

		System.out.println("金額を入力してください: ");
		money = Integer.parseInt(input.readLine());

		calc(money);
		display();

	}

	private static void calc(int m) {
		int totalCount = 0;

		for (int i = 0; i < moneytypes.length; i++) {
			counts[i] = m / moneytypes[i];
			m %= moneytypes[i];
			totalCount += counts[i];
		}
		System.out.println("硬貨の数は合計で" + String.valueOf(totalCount) + "枚");
	}

	private static void display() {
		System.out.println("硬貨の内訳");
		for (int i = 0; i < moneytypes.length; i++) {
			System.out.println(moneytypes[i] + "円\t" + counts[i] + "枚");
		}
	}
}
