import java.util.*;

public class Sinki {
	public static void main(String[] args) {
		String[][] board = new String[3][3];
		for (String[] masume : board) {
			Arrays.fill(masume, " ");
		}
		int count = 0;
		while (count < 9) {
			String player;
			if (count % 2 == 0) {
				player = "○";
			} else {
				player = "×";
			}
			System.out.print("[" + player + "の番] 縦と横のインデックスを半角スペース区切りで指定してください。> ");
			Scanner sc = new Scanner(System.in);
			String line = sc.nextLine();
			String[] values = line.split(" ");
			if (values.length != 2) {
				System.out.println("エラー：整数は2つ入力してください。");
				continue;
			}

			int col;
			int row;
			try {
				row = Integer.parseInt(values[0]);
				col = Integer.parseInt(values[1]);
			} catch (NumberFormatException e) {
				System.out.println("エラー：整数を入力してください。");
				continue;
			}
			if (row < 0 || row > 2 || col < 0 || col > 2) {
				System.out.println("エラー:整数は0〜2の間で入力してください。");
				continue;
			}

			if (!board[row][col].equals(" ")) {
				System.out.println("エラー：指定された場所は既に入力されています。");
				continue;
			}
			board[row][col] = player;
			display(board);
			System.out.println();
			count++;
		}
		System.out.println("ゲームを終了します。");
	}

	public static void display(String[][] board) {
		System.out.println("┏━┳━┳━┓");
		for (int i = 0; i < 3; i++) {
			if (i != 0) {
				System.out.println("┣━╋━╋━┫");
			}
			for (int j = 0; j < 3; j++) {
				System.out.print("┃" + board[i][j]);
			}
			System.out.println("┃");
		}
		System.out.println("┗━┻━┻━┛");
	}
}
