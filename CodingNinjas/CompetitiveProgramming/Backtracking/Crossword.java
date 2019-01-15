import java.util.*;
public class Crossword {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
      	char [][] grid = new char[10][10];
      	char [][] solution = new char[10][10];
      	for (int i = 0; i < 10; i ++) {
          	String temp = sc.nextLine();
          	for (int j = 0; j < 10 ; j++) {
              	grid[i][j] = temp.charAt(j);
              	solution[i][j] = temp.charAt(j);
            }
        }
      
      	String wordLine = sc.nextLine();
      	String[] words = wordLine.split(";");
      	List<String> wordList = new ArrayList<>();
      	for (String word: words) {
          	wordList.add(word);
        }
      
      	if (solve(grid, solution, wordList)) printSolution(solution);
	}
  
    public static void printSolution(char[][] solution) {
        for (int i = 0; i < solution[0].length; i++) {
            for (int j = 0; j < solution[0].length; j++) {
                System.out.print(solution[i][j]);
            }
            System.out.println();
        }
    }

  	public static boolean solve(char[][] grid, char[][] sol, List<String> wordList) {
      	// if we have no more words to be added
      	// cross word is solved.
      	if (wordList.size() == 0) {
          	return true;
        }
      
      	// Other-wise, iterate on the crossword sol and find the first - to be filled.
      	for (int i = 0; i < sol[0].length; i++) {
          	for (int j = 0; j < sol[0].length; j++) {
              	if (sol[i][j] != '-') {
                  	continue;
                }
              	
              	// now get the current place holder details.
               	// is it verticle, is it horizontal, where does it start, where does it end
              	boolean isVerticle = isCurrentSlotPartOfVerticlePlaceHolder(grid, i, j);
                if (isVerticle) {
                  	// find the start and end of this verticle holder.
                    int [] startEnd = findStartEndOfVerticlePlaceHolder(grid, i, j);
                  	// try filling word in the current holder
                  	// if able to fill 
                  	List<String> tempList = new ArrayList<>(wordList);
                  	for (String word : tempList) {
                        FillStatus status = fillWordInCurrentVerticleHolder(sol, word, startEnd, j);
                      	if (status.success) {
                          	wordList.remove(word);
                            if (solve(grid, sol, wordList)) return true;
                              
                            // backtrack here
                          	wordList.add(word);
                          	unFillWordInCurrentVerticleHolder(sol, startEnd, j, status);
                        }
                    }
                }
              
                boolean isHorizontal = isCurrentSlotPartOfHorizontalPlaceHolder(grid, i, j);
              	if (isHorizontal) {
                    int [] startEnd = findStartEndOfHorizontalPlaceHolder(grid, i, j);
                    List<String> tempList = new ArrayList<>(wordList);
                    for (String word: tempList) {
                        FillStatus status = fillWordInCurrentHorizontalHolder(sol, word, startEnd, i);
                        if (status.success) {
                            wordList.remove(word);
                            if (solve(grid, sol, wordList)) return true;

                            // backtrack here
                            wordList.add(word);
                            unFillWordInCurrentHorizontalHolder(sol, startEnd, j, status);
                        }   
                    }
                }

                // no solution down this path hence return
                return false;
            }
        }
        return false;
    }
  
  	public static boolean isCurrentSlotPartOfVerticlePlaceHolder(char[][] grid, int i, int j) {
      	int gridSize = grid[0].length;
      	int up = i + 1;
      	int down = i - 1;
      	if (up >= 0 && up < gridSize && grid[up][j] == '-') {
          	return true;
        }
      
      	if (down >= 0 && down < gridSize && grid[down][j] == '-') {
          	return true;
        }
      	return false;
    }
  
  	public static boolean isCurrentSlotPartOfHorizontalPlaceHolder(char[][] grid, int i, int j) {
      	int gridSize = grid[0].length;
      	int right = j + 1;
      	int left = j - 1;
      	if (left >= 0 && left < gridSize && grid[i][left] == '-') {
          	return true;
        }
      
      	if (right >= 0 && right < gridSize && grid[i][right] == '-') {
          	return true;
        }
      	return false;
    }
  
  	public static int[] findStartEndOfVerticlePlaceHolder(char[][] grid, int i, int j) {
      	// Given i, j go in both top and bottom direction to find both ends of holder.
      	int start = i;
      	for (int a = i - 1; a >= 0; a--) {
          	if (grid[a][j] == '-') {
                start--;
            }
            else break;
        }
      
      	int end = i;
      	for (int a = i + 1; a < grid[0].length; a++) {
          	if (grid[a][j] == '-') {
                end++;
            }
            else break;
        }
      	return new int [] { start, end };
    }

    public static int [] findStartEndOfHorizontalPlaceHolder(char[][] grid, int i, int j) {
        int start = j;
        for (int a = j - 1; a >= 0; a--) {
            if (grid[i][a] == '-') start--;
            else break;
        }

        int end = j;
        for (int a = j + 1; a < grid[0].length; a++) {
            if (grid[i][a] == '-') end++;
            else break;
        }
        return new int [] { start, end };
    }

    public static FillStatus fillWordInCurrentVerticleHolder(char[][] sol, String word, int [] startEnd, int col) {
        FillStatus result = new FillStatus(word.length());
        int start = startEnd[0];
        int end = startEnd[1];

        if (word.length() != Math.abs(start - end) + 1) {
            return result;
        }

        for (int i = start; i <= end; i++) {
            // check if the word is even fillable or not.
            if (sol[i][col] != '-' && sol[i][col] != word.charAt(i - start)) {
                return result;
            }
        }

        for (int i = start; i <= end; i++) {
            // check if the word is even fillable or not.
            if (sol[i][col] == '-') {
                result.status[i -start] = 1;
                sol[i][col] = word.charAt(i - start);
            }
        }
        result.success = true;
        return result;
    }
    
    public static FillStatus fillWordInCurrentHorizontalHolder(char[][] sol, String word, int[] startEnd, int row) {
        FillStatus result = new FillStatus(word.length());
        int start = startEnd[0];
        int end = startEnd[1];

        if (word.length() != Math.abs(start - end) + 1) {
            return result;
        }

        for (int i = start; i <= end; i++) {
            if (sol[row][i] != '-' && sol[row][i] != word.charAt(i - start)) {
                return result;
            }
        }

        for (int i = start; i <= end; i++) {
            if (sol[row][i] == '-') {
                result.status[i - start] = 1;
                sol[row][i] = word.charAt(i - start);
            }
        }

        result.success = true;
        return result;
    }

    public static void unFillWordInCurrentVerticleHolder(char[][] sol, int [] startEnd, int col, FillStatus fillStatus) {
        int start = startEnd[0];
        int end = startEnd[1];
        for (int i = 0; i < fillStatus.status.length; i++) {
            if (fillStatus.status[i] == 1) {
                sol[start + i][col] = '-';
            }
        }
    }

    public static void unFillWordInCurrentHorizontalHolder(char[][] sol, int [] startEnd, int row, FillStatus fillStatus) {
        int start = startEnd[0];
        int end = startEnd[1];
        for (int i = 0; i < fillStatus.status.length; i++) {
            if (fillStatus.status[i] == 1) {
                sol[row][start + i] = '-';
            }
        }
    }
}

class FillStatus {
  	int [] status;
  	boolean success;
  
  	public FillStatus(int statusSize) {
      	this.status = new int [statusSize];
      	this.success = false;
    }
}
