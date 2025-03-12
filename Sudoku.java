class Sudoku {

     String[][] layout;
    int size;

    void displayPattern(String[][] layout) {
        	int size = layout.length;
                    int m = 0;
        

        for (int ln = 0; ln < (2 * size) + 1; ln++) {
              int column = 0;

            	if (ln % 2 == 0) {
                 for (int x = 0; x < size; x++) {
                       System.out.print(" --");
                 }
            } 
            else {
               	 while (column < size) {
               	     int row = ln - (m + 1);
               	     String entry = layout[row][column].equals(" ") 
               		         ? String.format("%2s", layout[row][column]) 
               			         : String.format("%2d", Integer.parseInt(layout[row][column]));

                     System.out.print("|" + entry);
                      column++;
                }
                m++;
               }

            	System.out.println(ln % 2 == 0 ? "" : "|");
        	}
    }

    Sudoku(int size) {
       
       	 String[][] layout = new String[size][size];

        // to fill the grid with numbers
        for (int row = 0; row < size; row++) {
        
            int column = row + 1;
            
            for (int x = 0; x < size; x++) {
            
                if (column > size) column = 1;
                layout[row][x] = String.valueOf(column);
                column++;
                
            }
        }

        // to emove 1/3rd of the elements in the grid randomly
        int totalCells = size * size;
        int cellsToRemove = totalCells / 3;
        int removed = 0;

        while (removed < cellsToRemove) {
        
            int randRow = (int) (Math.random() * size);
            int randColumn = (int) (Math.random() * size);


            if (!layout[randRow][randColumn].equals(" ")) {
            
                layout[randRow][randColumn] = " ";
                removed++;
            }
        }

        displayPattern(layout);
    }

    public static void main(String[] args) {
        Sudoku puzzle = new Sudoku(6);
    }
}
