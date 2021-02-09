
public class Developers {

	public static String[] denumiri = new String[SMS_main.sheet_listSub.length];

	public static String[] products () {

		int rows_number = SMS_main.sheet_listSub.length;

		for (int i = 0; i < rows_number; i++) {
			denumiri[i] = SMS_main.sheet_listSub[i][1];
		}
		return denumiri;
	}
}
