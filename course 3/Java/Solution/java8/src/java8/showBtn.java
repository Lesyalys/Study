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
		showBtnList.add(new showBtn("btnROOM", "ROOM"));
//        showBtnList.add(new showBtn("btnFURNITURE", "FURNITURE"));
        showBtnList.add(new showBtn("btnLECTURER", "LECTURER"));
        showBtnList.add(new showBtn("btnMANUFACTURER", "MANUFACTURER"));
        showBtnList.add(new showBtn("btnROOM_FURNITURE", "ROOM_FURNITURE"));
        showBtnList.add(new showBtn("btnSOFA", "SOFA"));
        showBtnList.add(new showBtn("btnWARDROBE", "WARDROBE"));
        return showBtnList;


	}

}
