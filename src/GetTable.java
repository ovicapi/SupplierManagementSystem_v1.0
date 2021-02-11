import java.util.ArrayList;
import java.util.Arrays;

public class GetTable {

	private static String[][] ArrayMinusCols () {
		
		String[][] initArray = SMS_main.sheet_inreg;
		int rows = initArray.length;																				// numarul de randuri din arrayul initial
		int cols = initArray[0].length;																				// numarul de coloane din arrayul initial
		
		ArrayList<Integer> colsToDelete = new ArrayList<> (Arrays.asList(1, 2, 4, 6, 7, 14, 15, 18, 19, 20, 21));	// Construiesc un ArrayList cu coloanele ce trebuie sterse
		int newCols = cols - colsToDelete.size();																	// Numarul de coloane al noului array

		for (int i = 0; i < rows; i++) {																			// Sterg coloanele care nu sunt necesare pentru tabel
			cols = initArray[0].length;
			for (int j = colsToDelete.size() - 1 ; j >= 0; j--) {
				int deleteCol = colsToDelete.get(j);
				for (int k = cols - 1; k >= 0; k--) {
					if (k == deleteCol) {
						for (int t = k; t < cols - 1; t++) {
							initArray[i][t] = initArray[i][t+1];
						}
						cols--;
						break;
					}
				}
			}
		}
		String[][] arrayMinusCols = new String[rows][newCols];																	// Copiez arrayul cu coloanele taiate intr-un nou array
		for (int i = 0; i < rows; i++) {
			for( int j = 0; j < newCols; j++) {
				arrayMinusCols[i][j] = initArray[i][j];
			}
		}
		return arrayMinusCols;
	}
	
	private static int Counter (String[][] arrayMinusCols, String idDev) {
		
		// Calculez numarul de aparitii al id-ului de subcontractor in prima coloana din array-ul de mai sus
		
		int counter = 0;
		for (int row = 0; row < arrayMinusCols.length; row++) {
			if (arrayMinusCols[row][0].contentEquals(idDev)) {
				counter++;
			}
		}
		return counter;
	}

	public static String[][] ArrayMinusRows (String idDev) {
		
		String[][] arrayMinusCols = ArrayMinusCols();
		int rows_init = arrayMinusCols.length;
		int cols = arrayMinusCols[0].length;
		int rows_fin = Counter(arrayMinusCols, idDev);
		String[][] arrayMinusRows = new String[rows_fin][cols]; 

		for(String[] r : arrayMinusCols) {
			System.out.println(Arrays.toString(r));
		}
		System.out.println(idDev);
		System.out.println(rows_fin);
		System.out.println(cols);

		int t = 0;
		for (int i = 0; i < rows_init; i++) {
			if (arrayMinusCols[i][0].contentEquals(idDev)) {
				for(int j = 0; j < cols; j++) {
					arrayMinusRows[t][j] = arrayMinusCols[i][j];
				}
				t++;
			}

/*				
		for (int k = 0; k < rows_fin; k++) {
			for (int i = 0; i < rows_init; i++) {
				if (arrayMinusCols[i][0].contentEquals(idDev)) {
					for(int j = 0; j < cols; j++) {
						arrayMinusRows[k][j] = arrayMinusCols[i][j];
					}
					k++;
				}
			}
		*/
		}
		for(String[] r : arrayMinusRows) {
			System.out.println(Arrays.toString(r));
		}
		return arrayMinusRows;
	}
}
	
