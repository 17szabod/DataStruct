package progCompetition;
import java.util.Scanner;

public class hyenas {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int x = 1; x <= n; x++) {
			int h = in.nextInt();
			int w = in.nextInt();
			int num = 0;
			for (int y = 0; y < h; y++) {
				String line = in.next();
				for (int z = 0; z < w; z++) {
					String me = line.substring(z, z + 1);
					if (me.equals("H")) {
						num++;
					}
				}
			}
			System.out.println("Location #" + x + ": " + num);
		}

	}
}