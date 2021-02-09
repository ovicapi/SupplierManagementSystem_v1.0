import java.text.DecimalFormat;

import javax.swing.JLabel;

public class Utilities {

	public static String info;
	final static DecimalFormat df2 = new DecimalFormat ("0.00");
	final static DecimalFormat df = new DecimalFormat ("###,###");

	public static String Vlookup (String[][] sheet, String supplierName, Integer colNo_supplierName, Integer colNo) {
		for (int i = 0; i < sheet.length; i++) {
			if (sheet[i][colNo_supplierName].contentEquals(supplierName)) {
				info = sheet[i][colNo];
			}
		}
		return info;
	}
	public static void SetText (String value, String textHeader, String valueToAddOnLabel, JLabel label) {
		
		if (value.contentEquals("NA") | value.contentEquals(textHeader)) {
			valueToAddOnLabel = value;
			label.setText(valueToAddOnLabel);
		}
		else {
			if (Double.parseDouble(value) % 1 == 0) {
				valueToAddOnLabel = df.format(Double.parseDouble(value));
				label.setText(valueToAddOnLabel);
			}
			else {
				valueToAddOnLabel = df2.format(Double.parseDouble(value));
				label.setText(valueToAddOnLabel);
			}
		}
	}
}

