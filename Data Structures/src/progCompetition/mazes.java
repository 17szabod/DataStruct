package progCompetition;

import java.util.Scanner;
//import java.util.Arrays;

public class mazes {
	public static int[] ans;
	public static int count;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		for (int x = 0; x < m; x++) {
			int h = in.nextInt();
			int w = in.nextInt();
			int startY = 0;
			int startX = 0;
			int[][] maze = new int[h][w];
			for (int y = 0; y < h; y++) {
				String line = in.next();
				for (int z = 0; z < w; z++) {
					String me = line.substring(z, z + 1);
					switch (me) {
					case "#":
						maze[y][z] = 0;
						break;
					case ".":
						maze[y][z] = 1;
						break;
					case "S":
						maze[y][z] = 2;
						startY = y;
						startX = z;
						break;
					case "E":
						maze[y][z] = 3;
						break;
					}
				}
			}
			numberInWay(0, startX, startY, 5, maze);
			//Arrays.sort(ans);
			System.out.println("Maze #" + (x + 1) + ": " + ans[0]);
		}

	}
	// 0 = north, 1 = east, 2 = south, 3 = west
	public static int numberInWay(int numSoFar, int x, int y, int cameFrom, int[][] maze) {
		if (maze[y][x] == 0)
			numSoFar++;
		if (maze[y][x] == 3) {
			ans[count] = numSoFar;
			count++;
		}
		if (y - 1 >= 0 && cameFrom != 0) {
			numberInWay(numSoFar, x, y--, 2, maze);
		}
		if (x - 1 >= 0 && cameFrom != 1) {
			numberInWay(numSoFar, x--, y, 3, maze);
		}
		if (y + 1 < maze.length && cameFrom != 2) {
			numberInWay(numSoFar, x, y++, 0, maze);
		}
		if (x + 1 < maze[y].length && cameFrom != 3) {
			numberInWay(numSoFar, x++, y, 1, maze);
		}
		return numSoFar;
	}

}
