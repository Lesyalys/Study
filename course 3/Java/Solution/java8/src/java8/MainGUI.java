package java8;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MainGUI {
	static JFrame mainFrame;
	static JScrollPane dynamicScrollPane;
	static JScrollPane fixedScrollPane;
	static DBClass myDB;

	public static void main(String[] args) {
        mainFrame = new JFrame("Database Viewer");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());
        
        String curPath = System.getProperty("user.dir");
        myDB = new DBClass(curPath);
    
        mainFrame.add(setMenu(), BorderLayout.NORTH);
        
        //Центральная часть - изменяемая таблица (по умолчанию ROOM)
        JTable defaultTable = myDB.getSmartTable("ROOM");
        dynamicScrollPane = new JScrollPane(defaultTable);
        dynamicScrollPane.setColumnHeaderView(new JLabel("Dynamic Table - Click buttons above to change"));
        mainFrame.add(dynamicScrollPane, BorderLayout.CENTER);
        
        //Нижняя часть - постоянная таблица FURNITURE
        JTable fixedTable = myDB.getSmartTable("FURNITURE");
        fixedScrollPane = new JScrollPane(fixedTable);
        fixedScrollPane.setColumnHeaderView(new JLabel("Fixed Table - FURNITURE (Always visible)"));
        mainFrame.add(fixedScrollPane, BorderLayout.SOUTH);
        
        mainFrame.setSize(800, 600);
        mainFrame.setVisible(true);
    }
	private static Component setMenu() {
	    List<showBtn> showBtnAll = showBtn.getButtons();
	    Box mainMenu = new Box(BoxLayout.X_AXIS);
	    
	    showBtnAll.forEach(btnConfig -> {
	        JButton btn = new JButton(btnConfig.getName());
	        btn.addActionListener(e -> {
	            JTable furnitureTable = myDB.getSmartTable(btnConfig.getDB());
	            updateDynamicTable(furnitureTable,btnConfig.getDB());
	        });
	        
	        mainMenu.add(btn);
	    });
	    
	    return mainMenu;
	}
	private static void updateDynamicTable(JTable table, String tableName) {
        dynamicScrollPane.setViewportView(table);
//        dynamicScrollPane.setColumnHeaderView(new JLabel("Dynamic Table - " + tableName));
        table.setFillsViewportHeight(true);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

		


}
