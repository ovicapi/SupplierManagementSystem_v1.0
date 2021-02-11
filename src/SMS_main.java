import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class SMS_main {
	protected static final int EXIT_ON_CLOSE = 0;

	public static ArrayList<String> inreg = null;
	public static String[][] sheet_inreg = null;
	public static ArrayList<String> contract = null;
	public static String[][] sheet_contract = null;
	public static ArrayList<String> listSub = null;
	public static String[][] sheet_listSub = null;
	public static ArrayList<String> listFirm = null;
	public static String[][] sheet_listFirm = null;

	final static int inreg_colNum = 22;
	final static int contract_colNum = 14;
	final static int listSub_colNum = 4;
	final static int listFirm_colNum = 2;

	public static void main(String[] args) throws IOException, InvalidFormatException, InterruptedException {

		JFrame frameLogo = new Logo();
		frameLogo.setLocationRelativeTo(null);
		frameLogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLogo.setAlwaysOnTop (true);
		frameLogo.setUndecorated(true);
		frameLogo.setVisible(true);

		int delay = 2000; // Delay in milliseconds

		inreg = ImportExcel.getExcel("resources/Subcontractori.xlsx", "Inregistrari");
		sheet_inreg = ImportExcel.ArrayListTo2Darray(inreg, inreg_colNum);
		contract = ImportExcel.getExcel("resources/Subcontractori.xlsx", "DateContract");
		sheet_contract = ImportExcel.ArrayListTo2Darray(contract, contract_colNum);
		listSub = ImportExcel.getExcel("resources/Subcontractori.xlsx", "ListaSubcontractori");
		sheet_listSub = ImportExcel.ArrayListTo2Darray(listSub, listSub_colNum);
		listFirm = ImportExcel.getExcel("resources/Subcontractori.xlsx", "ListaFirme");
		sheet_listFirm = ImportExcel.ArrayListTo2Darray(listFirm, listFirm_colNum);

		Thread.sleep(delay);
		frameLogo.dispose();
		try {
			MainFrame.mainFrame();
		} catch (InvalidFormatException e1) {
			e1.printStackTrace();
		}
	}
}
