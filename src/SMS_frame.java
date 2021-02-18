import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


public class SMS_frame extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final int FRAME_WIDTH = 1300;
	private static final int FRAME_HEIGHT = 800;

	private JSplitPane splitPane;
	private JPanel topPanel;
	private JPanel bottomPanel;
	
	private JComboBox<String> selectDev;
	private static String path;
	
	final DecimalFormat df2 = new DecimalFormat ("0.00");
	final DecimalFormat df = new DecimalFormat ("###,###");
	
	public SMS_frame() throws InvalidFormatException, FileNotFoundException {

		setTitle("Supplier Management System");
		createComponents();			
		setSize(FRAME_WIDTH, FRAME_HEIGHT);	
	}
	public void createComponents() throws InvalidFormatException, FileNotFoundException {

		splitPane = new JSplitPane();												// Construct a splitPane that will hold the top and he bottom panels
		setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		getContentPane().add(splitPane);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setDividerLocation(120);
		splitPane.setTopComponent(topPanel);
		splitPane.setBottomComponent(bottomPanel);

		topPanel = new JPanel();													// Construct the topPanel that will hold the selection area
		topPanel.setLayout(null);

		bottomPanel = new JPanel();													// Construct the bottomPanel that will hold the data
		bottomPanel.setLayout((LayoutManager) new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
		bottomPanel.setBackground(new Color(224, 224, 224));
		bottomPanel.setOpaque(true);

		selectDev = new JComboBox<>(Developers.products());							//Construct a JComboBox named "selectDev", to select an item and view information about this item
		selectDev.setBounds(20,10,250,25);
		selectDev.setPreferredSize(new Dimension(400, 25));
		selectDev.setBackground(Color.WHITE);
		
		JButton viewContract = new JButton("Contract");								// Construct a JButton to view the contract for the selected supplier
		viewContract.setBounds(300, 10, 120, 25);
		viewContract.setFont(new Font("Verdana", Font.BOLD, 12));
		viewContract.setForeground(Color.BLACK);
			
		JLabel dev = new JLabel("");												// Construct a label to catch the selected developer
		dev.setBounds(20, 55, 400, 40);
		dev.setHorizontalAlignment(SwingConstants.CENTER);
		dev.setFont(new Font("Verdana", Font.BOLD, 22));
		dev.setOpaque(true);
		dev.setBackground(new Color(224, 224, 224));
		dev.setForeground(Color.RED);
		
		JLabel firmaLabel = new JLabel("Firma:");									// Construct a label with the text "Firma:"
		firmaLabel.setBounds(440, 10, 80, 25);
		firmaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		firmaLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		firmaLabel.setOpaque(false);
		firmaLabel.setForeground(Color.BLACK);
		
		JLabel firma = new JLabel();												// Construct a label that will hold the company name of the supplier
		firma.setBounds(540, 10, 250, 25);
		firma.setHorizontalAlignment(SwingConstants.LEFT);
		firma.setFont(new Font("Verdana", Font.BOLD, 12));
		firma.setOpaque(false);
		firma.setForeground(Color.BLACK);
		
		JLabel activitateLabel = new JLabel("Activitate:");							// Construct a label with the text "Activitate:"
		activitateLabel.setBounds(440, 50, 80, 25);
		activitateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		activitateLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		activitateLabel.setOpaque(false);
		activitateLabel.setForeground(Color.BLACK);
		
		JLabel activitate = new JLabel();											// Construct a label that will hold the activity of the supplier
		activitate.setBounds(540, 50, 300, 25);
		activitate.setHorizontalAlignment(SwingConstants.LEFT);
		activitate.setFont(new Font("Verdana", Font.BOLD, 12));
		activitate.setOpaque(false);
		activitate.setForeground(Color.BLACK);
		
		JLabel valabilitateLabel = new JLabel ("Expira la:");						// Construct a label with the text "Expira la:"
		valabilitateLabel.setBounds(440, 90, 80, 25);
		valabilitateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		valabilitateLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		valabilitateLabel.setOpaque(false);
		valabilitateLabel.setForeground(Color.BLACK);
		
		JLabel valabilitate = new JLabel();											// Construct a label that will hold the validity of the contract
		valabilitate.setBounds(540, 90, 250, 25);
		valabilitate.setHorizontalAlignment(SwingConstants.LEFT);
		valabilitate.setFont(new Font("Verdana", Font.BOLD, 12));
		valabilitate.setOpaque(false);
		valabilitate.setForeground(Color.BLACK);
		
		JLabel pretPeLunaLabel = new JLabel("Pret contract pe luna:");				// Construct a label with the text "Pret contract pe luna:"
		pretPeLunaLabel.setBounds(820, 10, 155, 25);
		pretPeLunaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pretPeLunaLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		pretPeLunaLabel.setOpaque(false);
		pretPeLunaLabel.setForeground(Color.BLACK);		

		JLabel pretPeLuna = new JLabel();											// Construct a label that will hold the contract monthly price
		pretPeLuna.setBounds(975, 10, 50, 25);
		pretPeLuna.setHorizontalAlignment(SwingConstants.RIGHT);
		pretPeLuna.setFont(new Font("Verdana", Font.BOLD, 12));
		pretPeLuna.setOpaque(false);
		pretPeLuna.setForeground(Color.BLACK);
		
		JLabel monedaPret = new JLabel();											// Construct a label that will hold the currency for the monthly price
		monedaPret.setBounds(1030, 10, 30, 25);
		monedaPret.setHorizontalAlignment(SwingConstants.LEFT);
		monedaPret.setFont(new Font("Verdana", Font.BOLD, 12));
		monedaPret.setOpaque(false);
		monedaPret.setForeground(Color.BLACK);
		
		JLabel totalPeLunaNetLabel = new JLabel("Total pe luna NET:");				// Construct a label with the text "Total pe luna NET:"
		totalPeLunaNetLabel.setBounds(820, 40, 155, 25);
		totalPeLunaNetLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalPeLunaNetLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		totalPeLunaNetLabel.setOpaque(false);
		totalPeLunaNetLabel.setForeground(Color.BLACK);
		
		JLabel totalPeLunaNet = new JLabel();										// Construct a label that will hold the NET contract monthly price
		totalPeLunaNet.setBounds(975, 40, 50, 25);
		totalPeLunaNet.setHorizontalAlignment(SwingConstants.RIGHT);
		totalPeLunaNet.setFont(new Font("Verdana", Font.BOLD, 12));
		totalPeLunaNet.setOpaque(false);
		totalPeLunaNet.setForeground(Color.BLACK);	
		
		JLabel monedaNet = new JLabel();											// Construct a label that will hold the currency for the NET monthly price
		monedaNet.setBounds(1030, 40, 30, 25);
		monedaNet.setHorizontalAlignment(SwingConstants.LEFT);
		monedaNet.setFont(new Font("Verdana", Font.BOLD, 12));
		monedaNet.setOpaque(false);
		monedaNet.setForeground(Color.BLACK);
		
		JLabel totalPeLunaBrutLabel = new JLabel("Total pe luna BRUT:");			// Construct a label with the text "Total pe luna BRUT:"
		totalPeLunaBrutLabel.setBounds(820, 70, 155, 25);
		totalPeLunaBrutLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalPeLunaBrutLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		totalPeLunaBrutLabel.setOpaque(false);
		totalPeLunaBrutLabel.setForeground(Color.BLACK);
		
		JLabel totalPeLunaBrut = new JLabel();										// Construct a label that will hold the BRUT contract monthly price
		totalPeLunaBrut.setBounds(975, 70, 50, 25);
		totalPeLunaBrut.setHorizontalAlignment(SwingConstants.RIGHT);
		totalPeLunaBrut.setFont(new Font("Verdana", Font.BOLD, 12));
		totalPeLunaBrut.setOpaque(false);
		totalPeLunaBrut.setForeground(Color.BLACK);	
		
		JLabel monedaBrut = new JLabel();											// Construct a label that will hold the currency for the BRUT monthly price
		monedaBrut.setBounds(1030, 70, 30, 25);
		monedaBrut.setHorizontalAlignment(SwingConstants.LEFT);
		monedaBrut.setFont(new Font("Verdana", Font.BOLD, 12));
		monedaBrut.setOpaque(false);
		monedaBrut.setForeground(Color.BLACK);
		
		JLabel nrOreLucruLabel = new JLabel("Numar ore lucru:");					// Construct a label with the text "Numar ore lucru:"
		nrOreLucruLabel.setBounds(820, 100, 155, 25);
		nrOreLucruLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nrOreLucruLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		nrOreLucruLabel.setOpaque(false);
		nrOreLucruLabel.setForeground(Color.BLACK);
		
		JLabel nrOreLucru = new JLabel();											// Construct a label that will hold the number of working hours
		nrOreLucru.setBounds(975, 100, 50, 25);
		nrOreLucru.setHorizontalAlignment(SwingConstants.RIGHT);
		nrOreLucru.setFont(new Font("Verdana", Font.BOLD, 12));
		nrOreLucru.setOpaque(false);
		nrOreLucru.setForeground(Color.BLACK);	
		
		JLabel nrOreLucruPerioada = new JLabel();									// Construct a label that will hold the currency for the BRUT monthly price
		nrOreLucruPerioada.setBounds(1030, 100, 250, 25);
		nrOreLucruPerioada.setHorizontalAlignment(SwingConstants.LEFT);
		nrOreLucruPerioada.setFont(new Font("Verdana", Font.BOLD, 12));
		nrOreLucruPerioada.setOpaque(false);
		nrOreLucruPerioada.setForeground(Color.BLACK);
		
		String[][] arrayMinusCols = GetTable.CutTheColumns();
		
		selectDev.addItemListener(new ItemListener() {								//Add a Listener for the JComboBox "SelectDev"
			public void itemStateChanged(ItemEvent e_selectDev) {
				dev.setText((String) e_selectDev.getItem());
				String idDev = Utilities.Vlookup(SMS_main.sheet_listSub, (String) e_selectDev.getItem(), 1, 0);
				String companyName = Utilities.Vlookup(SMS_main.sheet_listSub, idDev, 0, 3);
				String activityDev = Utilities.Vlookup(SMS_main.sheet_contract, idDev, 0, 4);
				String valability = Utilities.Vlookup(SMS_main.sheet_contract, idDev, 0, 12);
				String pPM = Utilities.Vlookup(SMS_main.sheet_contract, idDev, 0, 5);
				String currencyPrice = Utilities.Vlookup(SMS_main.sheet_contract, idDev, 0, 6);
				String nPPM = Utilities.Vlookup(SMS_main.sheet_contract, idDev, 0, 9);
				String currencyTotal = Utilities.Vlookup(SMS_main.sheet_contract, idDev, 0, 11);
				String bPPM = Utilities.Vlookup(SMS_main.sheet_contract, idDev, 0, 10);
				String wh = Utilities.Vlookup(SMS_main.sheet_contract, idDev, 0, 7);
				String workingHoursPeriod = Utilities.Vlookup(SMS_main.sheet_contract, idDev, 0, 8);
				path = Utilities.Vlookup(SMS_main.sheet_contract, idDev, 0, 13);
				bottomPanel.removeAll();
				
				if (e_selectDev.getStateChange() == ItemEvent.SELECTED) {
				firma.setText(companyName);
				activitate.setText(activityDev);
				valabilitate.setText(valability);
				String pricePerMonth = null;
				Utilities.SetText(pPM, "Pret contract/luna", pricePerMonth, pretPeLuna);
				if(pPM.contentEquals("NA")) {
					monedaPret.setText("");
				}
				else {
					monedaPret.setText(currencyPrice);	
				}
				String netPricePerMonth = null;
				Utilities.SetText(nPPM, "Total pe luna NET (max)", netPricePerMonth, totalPeLunaNet);
				if (nPPM.contentEquals("NA")) {
					monedaNet.setText("");
				}
				else {
					monedaNet.setText(currencyTotal);
				}
				String brutPricePerMonth = null;
				Utilities.SetText(bPPM, "Total pe luna BRUT (max)", brutPricePerMonth, totalPeLunaBrut);
				if (bPPM.contentEquals("NA")) {
					monedaBrut.setText("");
				}
				else {
					monedaBrut.setText(currencyTotal);
				}
				
				if(wh.contentEquals("NA") | wh.contentEquals("Nr. ore lucru")) {
					String workingHours = wh;
					nrOreLucru.setText(workingHours);
				}
				else {
					if(Double.parseDouble(wh) < 1) {
						String workingHours;
						workingHours = df2.format(Double.parseDouble(wh));
						nrOreLucru.setText(workingHours);
					}
					else if (Double.parseDouble(wh) >= 1) {
						String workingHours;
						workingHours = df.format(Double.parseDouble(wh));
						nrOreLucru.setText(workingHours);
					}
				}
				if (wh.contentEquals("NA")) {
					nrOreLucruPerioada.setText("");
				}
				else {
					nrOreLucruPerioada.setText(workingHoursPeriod);			
				}

 				int counter = GetTable.CountIdDevRows(arrayMinusCols, idDev);

				String[][] arrayMinusRows = GetTable.CutTheRows(arrayMinusCols, counter, idDev);
				
				String[] columnNames = new String[11];
					columnNames[0] = "<html><center>ID<br>dezvoltator</center></html>";
					columnNames[1] = "<html><center>Proiect</center></html>";   
					columnNames[2] = "<html><center>Data</center></html>";
					columnNames[3] = "<html><center>Valoare<br>moneda<br>raport</center></html>";
					columnNames[4] = "<html><center>Moneda<br>raport</center></html>";
					columnNames[5] = "<html><center>Valoare<br>moneda<br>obiect</center></html>";
					columnNames[6] = "<html><center>Moneda<br>obiect</center></html>";
					columnNames[7] = "<html><center>Valoare<br>moneda<br>tranzactie</center></html>";
					columnNames[8] = "<html><center>Moneda<br>tranzactie</center></html>";
					columnNames[9] = "<html><center>Ore<br>lucrate</center></html>";
					columnNames[10] = "<html><center>Nr.<br>factura</center></html>";

				JTable table = new JTable(arrayMinusRows, columnNames);
				table.setPreferredScrollableViewportSize(new Dimension(1300, 600));
		        table.setFillsViewportHeight(true);
		        table.setVisible(true);
		        table.setBackground(new Color(244,244,244));
		        table.setGridColor(getBackground());
		        table.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		        table.setRowHeight(28);
		        table.getTableHeader().setFont(new Font("Calibri Light", Font.BOLD, 15));
		        table.getTableHeader().setPreferredSize(new Dimension(1300, 60));
		        
		        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		        for (int i = 3; i <= 9; i = i + 2) {
		        	table.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
		        }
		        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		        for (int i = 0; i <= 10; i = i + 2) {
		        	table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		        }
		        
		        JScrollPane scrollPane = new JScrollPane(table);
		        bottomPanel.add(scrollPane);
				}
			}
		});
		
		viewContract.addActionListener(new ActionListener() {						//Add a Listener for the JButton "viewContract"
			public void actionPerformed(ActionEvent arg) {
				File file = new File(path);
				try {
					Desktop.getDesktop().open(file);
				}
				catch (Exception e_contract) {
					e_contract.printStackTrace();
				}
			}
		});
		
		//Add button, labels and the comboBox to the topPanel

		topPanel.add(selectDev);
		topPanel.add(viewContract);
		topPanel.add(dev);
		topPanel.add(firmaLabel);
		topPanel.add(firma);
		topPanel.add(activitateLabel);
		topPanel.add(activitate);
		topPanel.add(valabilitateLabel);
		topPanel.add(valabilitate);
		topPanel.add(pretPeLunaLabel);
		topPanel.add(pretPeLuna);
		topPanel.add(monedaPret);
		topPanel.add(totalPeLunaNetLabel);
		topPanel.add(totalPeLunaNet);
		topPanel.add(monedaNet);
		topPanel.add(totalPeLunaBrutLabel);
		topPanel.add(totalPeLunaBrut);
		topPanel.add(monedaBrut);
		topPanel.add(nrOreLucruLabel);
		topPanel.add(nrOreLucru);
		topPanel.add(nrOreLucruPerioada);
		
		splitPane.add(topPanel);
		splitPane.add(bottomPanel);
		pack();
	}
}

