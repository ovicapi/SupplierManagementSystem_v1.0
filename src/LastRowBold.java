import java.awt.Component;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class LastRowBold implements TableCellRenderer {

	final static DecimalFormat df2 = new DecimalFormat ("###,###.00");
	final static DecimalFormat df = new DecimalFormat ("###,###");

	public static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		if (column == 3 && row != table.getRowCount() - 1) {
			value = df2.format(Double.parseDouble((String) value));
		}
		if (column == 5 && row != table.getRowCount() - 1) {
			value = df2.format(Double.parseDouble((String) value));
		}
		if (column == 7 && row != table.getRowCount() - 1) {
			value = df2.format(Double.parseDouble((String) value));
		}
		if (column == 9 && row != table.getRowCount() - 1) {
			try {
				value = df2.format(Double.parseDouble((String) value));
			}
			catch (Exception e){
			}
		}

		Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table,
				value, isSelected, hasFocus, row, column);
		if (row == table.getRowCount() - 1) {
			c.setFont(new Font("Calibri Light", Font.BOLD, 15));
		}
		if (column == 3 || column == 5 || column == 7 || column == 9) {
			((JLabel) c).setHorizontalAlignment(JLabel.RIGHT);
		}
		else if (column == 0 || column == 2 || column == 4 || column == 6 || column == 8 || column == 10) {
			((JLabel) c).setHorizontalAlignment(JLabel.CENTER);
		}
		else if (column == 1) {
			((JLabel) c).setHorizontalAlignment(JLabel.LEFT);
		}
		return c;
	}
}
