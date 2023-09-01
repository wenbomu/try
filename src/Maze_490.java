
public class Maze_490 {
	
	//Set<int[]> visited = new HashSet<>();
	public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //if the pos is visited, don't need to review it again'
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, destination, visited);
    }

    public static boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited){
        if(start[0]==destination[0] && start[1]==destination[1]){
            return true;
        }

        if(visited[start[0]][start[1]]){
            return false;
        }
        visited[start[0]][start[1]]=true;

        int[] dicX = {0, 1, 0, -1};
        int[] dicY = {1, 0, -1, 0};

        for(int i=0;i<4;i++){
            int r = start[0];
            int c = start[1];

            while(r>=0 && c>=0 && r<maze.length && c<maze[0].length && maze[r][c]==0){
                r += dicX[i];
                c += dicY[i];
            }
            if(dfs(maze, new int[]{r-dicX[i], c-dicY[i]}, destination, visited)){
                return true;
            }
        }

        return false;
    }
    
	public static void main(String[] args) {
		int[][] test = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
		int[] start = new int[] {0, 4};
		int[] des = new int[] {0, 1};
		System.out.println(hasPath(test, start, des));
	}
}
