package java8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DBClass {
	 private static final String JDBC_URL = "jdbc:h2:~/test";
	    private static final String USER = "sa";
	    private static final String PASSWORD = "";
	    
Connection conn = null; // объект для связи с БД
Statement stmt = null; // объект для создания SQL-запросов
public DBClass(String curPath) {
super();
try { 
	Class.forName("org.h2.Driver"); 
	conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_UPDATABLE);
} catch (ClassNotFoundException | SQLException e) { 
	Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, e);
	System.out.println("Trouble with connection!!");
}
finally { 
	if (conn!=null) System.out.println("DB connected!!");
	}
}


//old select
public JTable getTable(String tableName) {
    DefaultTableModel model = new DefaultTableModel();
    ResultSet localRS = null;
    
    try {
        localRS = stmt.executeQuery("SELECT * FROM " + tableName);
        ResultSetMetaData rsmd = localRS.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        
        // Добавляем названия колонок
        for (int i = 1; i <= columnsNumber; i++) {
            model.addColumn(rsmd.getColumnName(i));
        }
        
        // Добавляем данные
        while (localRS.next()) {
            Vector<Object> row = new Vector<>();
            for (int i = 1; i <= columnsNumber; i++) {
                row.add(localRS.getObject(i));
            }
            model.addRow(row);
        }
        
    } catch (SQLException e) {
        System.out.println("Trouble with query!!");
        e.printStackTrace();
        // Возвращаем пустую таблицу с сообщением об ошибке
        model.addColumn("Error");
        model.addRow(new Object[]{"Failed to load data: " + e.getMessage()});
    } finally {
        if (localRS != null) {
            try {
                localRS.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }
    return new JTable(model);}
    
//new select
    public JTable getSmartTable(String tableName) {
        DefaultTableModel model = new DefaultTableModel();
        ResultSet localRS = null;
        
        try {
            String smartQuery = getSmartQuery(tableName);
            localRS = stmt.executeQuery(smartQuery);
            ResultSetMetaData rsmd = localRS.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            
            for (int i = 1; i <= columnsNumber; i++) {
                model.addColumn(rsmd.getColumnName(i));
            }
            
            // Дданные
            while (localRS.next()) {
                Vector<Object> row = new Vector<>();
                for (int i = 1; i <= columnsNumber; i++) {
                    row.add(localRS.getObject(i));
                }
                model.addRow(row);
            }
            
        } catch (SQLException e) {
            System.out.println("Trouble with smart query for table: " + tableName);
            e.printStackTrace();
            model.addColumn("Error");
            model.addRow(new Object[]{"Smart query failed: " + e.getMessage()});
        } finally {
            if (localRS != null) {
                try {
                    localRS.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        JTable table = new JTable(model);
        table.setName(tableName);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        return table;
    }
    
    private String getSmartQuery(String tableName) {
        switch (tableName.toUpperCase()) {
            case "ROOM":
                return "SELECT " +
                       "r.room_name as \"Название комнаты\", " +
                       "r.room_type as \"Тип комнаты\", " +
                       "r.area_sqm as \"Площадь (м²)\", " +
                       "r.floor as \"Этаж\", " +
                       "r.description as \"Описание\", " +
                       "COUNT(rf.furniture_id) as \"Кол-во мебели\", " +
                       "STRING_AGG(f.name, ', ') as \"Мебель в комнате\" " +
                       "FROM room r " +
                       "LEFT JOIN room_furniture rf ON r.id = rf.room_id " +
                       "LEFT JOIN furniture f ON rf.furniture_id = f.id " +
                       "GROUP BY r.id, r.room_name, r.room_type, r.area_sqm, r.floor, r.description";
                
                
            case "MANUFACTURER":
                return "SELECT " +
                       "m.company_name as \"Компания\", " +
                       "m.country as \"Страна\", " +
                       "m.warranty_years as \"Гарантия (лет)\", " +
                       "m.contact_phone as \"Телефон\", " +
                       "f.name as \"Производимая мебель\", " +
                       "f.type as \"Тип мебели\", " +
                       "f.price as \"Цена\" " +
                       "FROM manufacturer m " +
                       "LEFT JOIN furniture f ON m.furniture_id = f.id " +
                       "ORDER BY m.company_name";
                
            case "ROOM_FURNITURE":
                return "SELECT " +
                       "r.room_name as \"Комната\", " +
                       "f.name as \"Название мебели\", " +
                       "f.type as \"Тип\", " +
                       "rf.quantity as \"Количество\", " +
                       "rf.placement_description as \"Расположение\", " +
                       "f.price as \"Цена за единицу\", " +
                       "(f.price * rf.quantity) as \"Общая стоимость\" " +
                       "FROM room_furniture rf " +
                       "JOIN room r ON rf.room_id = r.id " +
                       "JOIN furniture f ON rf.furniture_id = f.id " +
                       "ORDER BY r.room_name, f.name";
                
            case "SOFA":
                return "SELECT " +
                       "f.name as \"Название дивана\", " +
                       "f.material as \"Материал\", " +
                       "f.color as \"Цвет\", " +
                       "f.price as \"Цена\", " +
                       "s.seats_number as \"Количество мест\", " +
                       "CASE WHEN s.is_cornet THEN 'Да' ELSE 'Нет' END as \"Угловой\", " +
                       "s.mechanism_type as \"Механизм\", " +
                       "CONCAT(s.lenght_cm, '×', s.width_cm, '×', s.height_cm, ' см') as \"Габариты\", " +
                       "m.company_name as \"Производитель\", " +
                       "STRING_AGG(DISTINCT r.room_name, ', ') as \"Находится в комнатах\" " +
                       "FROM sofa s " +
                       "JOIN furniture f ON s.id = f.id " +
                       "LEFT JOIN manufacturer m ON f.id = m.furniture_id " +
                       "LEFT JOIN room_furniture rf ON f.id = rf.furniture_id " +
                       "LEFT JOIN room r ON rf.room_id = r.id " +
                       "GROUP BY s.id, f.name, f.material, f.color, f.price, s.seats_number, " +
                       "s.is_cornet, s.mechanism_type, s.lenght_cm, s.width_cm, s.height_cm, m.company_name";
                
            case "WARDROBE":
                return "SELECT " +
                       "f.name as \"Название шкафа\", " +
                       "f.material as \"Материал\", " +
                       "f.color as \"Цвет\", " +
                       "f.price as \"Цена\", " +
                       "w.doors_number as \"Количество дверей\", " +
                       "w.shelves_number as \"Количество полок\", " +
                       "CASE WHEN w.has_mirror THEN 'Да' ELSE 'Нет' END as \"Есть зеркало\", " +
                       "CONCAT(w.length_cm, '×', w.width_cm, '×', w.height_cm, ' см') as \"Габариты\", " +
                       "m.company_name as \"Производитель\", " +
                       "STRING_AGG(DISTINCT r.room_name, ', ') as \"Находится в комнатах\" " +
                       "FROM wardrobe w " +
                       "JOIN furniture f ON w.id = f.id " +
                       "LEFT JOIN manufacturer m ON f.id = m.furniture_id " +
                       "LEFT JOIN room_furniture rf ON f.id = rf.furniture_id " +
                       "LEFT JOIN room r ON rf.room_id = r.id " +
                       "GROUP BY w.id, f.name, f.material, f.color, f.price, w.doors_number, w.shelves_number, " +
                       "w.has_mirror, w.length_cm, w.width_cm, w.height_cm, m.company_name";
                
            case "FURNITURE":
                return "SELECT " +
                       "f.name as Название, " +
                       "CASE f.type " +
                       "  WHEN 'SOFA' THEN 'Диван' " +
                       "  WHEN 'WARDROBE' THEN 'Шкаф' " +
                       "  ELSE f.type END as \"Тип\", " +
                       "f.material as \"Материал\", " +
                       "f.color as \"Цвет\", " +
                       "f.price as \"Цена\", " +
                       "m.company_name as \"Производитель\", " +
                       "m.country as \"Страна производителя\", " +
                       "STRING_AGG(DISTINCT r.room_name, ', ') as \"Расположение\", " +
                       "COALESCE(SUM(rf.quantity), 0) as \"Общее количество\" " +
                       "FROM furniture f " +
                       "LEFT JOIN manufacturer m ON f.id = m.furniture_id " +
                       "LEFT JOIN room_furniture rf ON f.id = rf.furniture_id " +
                       "LEFT JOIN room r ON rf.room_id = r.id " +
                       "GROUP BY f.id, f.name, f.type, f.material, f.color, f.price, m.company_name, m.country " +
                       "ORDER BY f.type, f.name";
                
            default:
                return "SELECT * FROM " + tableName;
        }
    }
	}
