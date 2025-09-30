package java4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class about {
	public static void main(String s[]) {
		JFrame frame = new JFrame("FrameDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		header(frame);
		frame.setVisible(true);
//		System.out.println("🌠 ChangeListener используется для мониторинга изменений данных в объектах с привязкой к свойствам (ObservableValue)."+"\n🌠 MouseWheelListener используется для обработки физических действий пользователя — вращения колеса мыши. ");
	}
	public static void header(JFrame frame) {
	    JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
	    JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	    
	    JEditorPane textChangeListener = new JEditorPane("text/html", 
	            "<html><body style='width: 300px; padding: 10px;'>" +
	                    "<a href='https://docs.oracle.com/javase/8/docs/api/javax/swing/event/ChangeListener.html'>" +
	                    "🌠 ChangeListener используется для мониторинга изменений данных в объектах с привязкой к свойствам (ObservableValue)" +
	                    "</a></body></html>");
	    textChangeListener.setEditable(false);
        textChangeListener.setOpaque(false);
	    JEditorPane textMouseWheelListener = new JEditorPane("text/html", 
	            "<html><body style='width: 300px; padding: 10px;'>" +
	                    "<a href='https://docs.oracle.com/javase/8/docs/api/java/awt/event/MouseWheelListener.html'>" +
	                    "🌠 MouseWheelListener используется для обработки физических действий пользователя — вращения колеса мыши." +
	                    "</a></body></html>");
	    textMouseWheelListener.setEditable(false);
	    textMouseWheelListener.setOpaque(false);
	    panel1.add(textMouseWheelListener);
	    panel2.add(textChangeListener);

	    
	    frame.add(panel1, BorderLayout.WEST);
	    frame.add(panel2, BorderLayout.NORTH);
	}
}
