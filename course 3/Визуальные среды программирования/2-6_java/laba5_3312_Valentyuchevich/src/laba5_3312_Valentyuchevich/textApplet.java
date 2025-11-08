package laba5_3312_Valentyuchevich;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class textApplet {

	public static void main(String[] args) throws IOException {
		String html = """
				<html>
				<body>
				    <applet code="applet_1.class" width=400 height=200>
				    </applet>
				</body>
				</html>
				""";
		File f = new File("test.html");
		FileWriter fw = new FileWriter(f);
		fw.write(html);
		fw.close();

		System.out.println("HTML : " + f.getAbsolutePath());
		
		String c = f.getAbsolutePath();
		Process p = Runtime.getRuntime().exec(c);

	}

}
