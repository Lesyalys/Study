package java8;

import java.util.ArrayList;
import java.util.List;

public class showBtn {

	private String name;
	private String db;
	
	public showBtn(String name, String db){
		this.name = name;
		this.db = db;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDB(){
		return db;
	}
	
	public static List<showBtn> getButtons() {
		List<showBtn> showBtnList = new ArrayList<>();
		showBtnList.add(new showBtn("🏠 ROOM", "ROOM"));
//        showBtnList.add(new showBtn("btnFURNITURE", "FURNITURE"));
        showBtnList.add(new showBtn("🏭 MANUFACTURER", "MANUFACTURER"));
        showBtnList.add(new showBtn("🚪 ROOM FURNITURE", "ROOM_FURNITURE"));
        showBtnList.add(new showBtn("🛋️ SOFA", "SOFA"));
        showBtnList.add(new showBtn("🗄️ WARDROBE", "WARDROBE"));
        return showBtnList;


	}

}
