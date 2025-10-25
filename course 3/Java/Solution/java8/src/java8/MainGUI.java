package java8;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.JFileChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI {
	static JFrame mainFrame;
	static JScrollPane dynamicScrollPane;
	static JScrollPane fixedScrollPane;
	static DBClass myDB;

	public static void main(String[] args) {
        mainFrame = new JFrame("DB FURNITURE");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());
        
        String curPath = System.getProperty("user.dir");
        myDB = new DBClass(curPath);
    
        JPanel headerPanel = new JPanel(new GridLayout(1,5));
        headerPanel.add(setMenu());
        mainFrame.add(headerPanel,BorderLayout.NORTH);
        
        //center ROOM
        JTable defaultTable = myDB.getSmartTable("ROOM");
        dynamicScrollPane = new JScrollPane(defaultTable);
        JLabel dynamicHeader = new JLabel("Основная таблица - ROOM", JLabel.CENTER);
        dynamicScrollPane.setColumnHeaderView(dynamicHeader);
        mainFrame.add(dynamicScrollPane, BorderLayout.CENTER);
        
        //add save to word format
        JPanel topPanel = new JPanel(new BorderLayout());
        
        JPanel headerPanel1 = new JPanel(new GridLayout(1,5));
        headerPanel1.add(setMenu());
        topPanel.add(headerPanel1, BorderLayout.CENTER);
        topPanel.add(createExportPanel(), BorderLayout.EAST);
        
        mainFrame.add(topPanel, BorderLayout.NORTH);
        
        //down FURNITURE
        JTable fixedTable = myDB.getSmartTable("FURNITURE");
        fixedScrollPane = new JScrollPane(fixedTable);
        JLabel fixedHeader = new JLabel("Фиксированная таблица - FURNITURE", JLabel.CENTER);
        fixedScrollPane.setColumnHeaderView(fixedHeader);
        mainFrame.add(fixedScrollPane, BorderLayout.SOUTH);
        
        mainFrame.setSize(1000, 700);
        mainFrame.setVisible(true);
    
    }
	private static Component setMenu() {
	    List<showBtn> showBtnAll = showBtn.getButtons();
	    Box mainMenu = new Box(BoxLayout.X_AXIS);
	    
	    showBtnAll.forEach(btnConfig -> {
	    	System.out.println(btnConfig.getName());
	    	switch (btnConfig.getName()) {
	    	case("🗄️ WARDROBE"):
//	    		System.out.println("im werdore");
	    		JButton btn = new JButton(btnConfig.getName());
	        	btn.addActionListener(e -> {
	        		openWardrobeReport(btnConfig.getDB());
	        });
	        	mainMenu.add(btn);
	        	break;
	    	default:
	        JButton btnDef = new JButton(btnConfig.getName());
	        btnDef.addActionListener(e -> {
	            JTable furnitureTable = myDB.getSmartTable(btnConfig.getDB());
	            updateDynamicTable(furnitureTable,btnConfig.getDB());
	        });
	        mainMenu.add(btnDef);
	        break;
	    	}
	    });
	    
	    return mainMenu;
	}
	private static void updateDynamicTable(JTable table, String tableName) {
		 table.setName(tableName);
        dynamicScrollPane.setViewportView(table);
//        dynamicScrollPane.setColumnHeaderView(new JLabel("Dynamic Table - " + tableName));
        table.setFillsViewportHeight(true);
        mainFrame.revalidate();
        mainFrame.repaint();
    }
	
	private static void openWardrobeReport(String tableName) {
	    JFrame reportFrame = new JFrame("Отчет: " + tableName);
	    reportFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    reportFrame.setSize(1000, 600);
	    
	    JTable reportTable = myDB.getSmartTable(tableName);
	    
	    JScrollPane scrollPane = new JScrollPane(reportTable);
	    reportTable.setFillsViewportHeight(true);
	    
	    JLabel headerLabel = new JLabel("Table: " + tableName, JLabel.CENTER);
	    scrollPane.setColumnHeaderView(headerLabel);
	    
	    
	    JPanel panel = new JPanel(new BorderLayout());
	    panel.add(scrollPane, BorderLayout.CENTER);
	    
	    reportFrame.add(panel);
	    reportFrame.setLocationRelativeTo(mainFrame);
	    reportFrame.setVisible(true);
	    
	}

	private static JPanel createExportPanel() {
	    JPanel exportPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	    
	    JButton exportButton = new JButton("💾 Export to Word");
	    JButton exportButtonEx = new JButton("💾 Export to Excel");
	    exportButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            exportCurrentTable();
	        }
	    });
	    exportButtonEx.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	exportCurrentTableExel();
	        }
	    });
	    exportPanel.add(exportButtonEx);
	    exportPanel.add(exportButton);
	    return exportPanel;
	}
	
	//exemple 9

	private static void exportCurrentTable() {
	    JViewport viewport = dynamicScrollPane.getViewport();
	    if (viewport != null && viewport.getView() instanceof JTable) {
	        JTable currentTable = (JTable) viewport.getView();
	        String tableName = currentTable.getName();
	        
	        // export
	        WordExporter.exportTableToWord(currentTable, tableName);
	    } else {
	        JOptionPane.showMessageDialog(mainFrame,
	            "Нет активной таблицы для экспорта",
	            "Ошибка экспорта",
	            JOptionPane.WARNING_MESSAGE);
	    }
	}
	
	private static void exportCurrentTableExel() {
	    JViewport viewport = dynamicScrollPane.getViewport();
	    if (viewport != null && viewport.getView() instanceof JTable) {
	        JTable currentTable = (JTable) viewport.getView();
	        String tableName = currentTable.getName();
	       
	        // export
	        WordExporter.exportTableToExcel(currentTable, tableName);
	    } else {
	        JOptionPane.showMessageDialog(mainFrame,
	            "Нет активной таблицы для экспорта",
	            "Ошибка экспорта",
	            JOptionPane.WARNING_MESSAGE);
	    }
	}


}
