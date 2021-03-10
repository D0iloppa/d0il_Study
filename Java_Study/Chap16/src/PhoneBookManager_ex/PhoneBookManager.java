package PhoneBookManager_ex;

public class PhoneBookManager {
	final int MAX_CNT = 100;
	
	PhoneInfo[] infoStorage = new PhoneInfo[MAX_CNT]; // 100칸의 핸드폰 정보를 담을 수 있는 정적배열 선언
	int curCnt = 0; // 처음시작은 0
	
	static PhoneBookManager inst=null; // 싱글톤으로 활용, 앞으로 객체생성 하지 않아도 됨
	
	public static PhoneBookManager createManagerInst() {
		if(inst==null) inst = new PhoneBookManager(); // 싱글톤 객체 생성 
		return inst;
	}
	
	private PhoneBookManager() {} // 싱글톤으로 쓰기 위해 생성자를 잠궈둠
	
	private PhoneInfo readFriendInfo() {
		System.out.print("이름: ");
		String name = MenuViewer.keyboard.nextLine();
		System.out.print("전화번호: ");
		String phone = MenuViewer.keyboard.nextLine();
		return new PhoneInfo(name,phone);
	}
	
	private PhoneInfo readUnivFriendInfo() {
		System.out.print("이름: ");
		String name = MenuViewer.keyboard.nextLine();
		System.out.print("전화번호: ");
		String phone = MenuViewer.keyboard.nextLine();
		System.out.print("전공: ");
		String major = MenuViewer.keyboard.nextLine();
		System.out.print("학번: ");
		int year = MenuViewer.keyboard.nextInt();
		return new PhoneUnivInfo(name,phone,major,year);
	}
	
	private PhoneInfo readCompanyFriendInfo() {
		System.out.print("이름: ");
		String name = MenuViewer.keyboard.nextLine();
		System.out.print("전화번호: ");
		String phone = MenuViewer.keyboard.nextLine();
		System.out.print("회사: ");
		String company = MenuViewer.keyboard.nextLine();
		
		return new PhoneCompanyInfo(name,phone,company);
	}
	
	public void inputData() {
		System.out.println("데이터 입력을 시작합니다..");
		System.out.println("1. 일반 | 2. 대학 | 3. 회사");
		System.out.print("선택>> ");
		int choice = MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();
		PhoneInfo info = null;
		
		switch(choice) {
		 case INPUT_SELECT.NORMAL:
			 info = readFriendInfo();
			 break;
		 case INPUT_SELECT.UNIV:
			 info = readUnivFriendInfo();
			 break;
		 case INPUT_SELECT.COMPANY:
			 info = readCompanyFriendInfo();
			 break;
		  default :
			  System.out.println("잘못 입력하셨습니다.");
			  return;
		}
		
		infoStorage[curCnt++]=info; // 입력받은 객체를 배열에 추가, 번호증가
		System.out.println("데이터 입력이 완료되었습니다. \n");		
	}
	
	public void searchData() {
		System.out.println("데이터 검색을 시작합니다..");
		
		System.out.print("이름: ");
		String name = MenuViewer.keyboard.nextLine();
		
		int dataIdx = search(name);
		if (dataIdx<0) System.out.println("해당하는 데이터가 존재하지 않습니다.\n"); // -1이 나오면 검색실패
		else {
			infoStorage[dataIdx].showPhoneInfo(); // 해당 배열을 출력
			System.out.println("데이터 검색이 완료되었습니다. \n");
		}
		
	}

	private int search(String name) { // 이름을 검색하여 해당하는 인덱스 번호 출력
		for(int i=0; i<curCnt; i++) {
			PhoneInfo curInfo = infoStorage[i];
			// 입력받은 name과 검색하는 곳의 name과 같으면(차이가 0이면 같다는 의미)
			if(name.compareTo(curInfo.name)==0) return i; 
		}
		return -1; // 찾지 못함
	}
	
	public void deleteData() {
		System.out.println("데이터 삭제를 시작합니다.");
		
		System.out.print("이름: ");
		String name = MenuViewer.keyboard.nextLine();
		
		int dataIdx = search(name);
		if(dataIdx<0) System.out.println("해당하는 데이터가 존재하지 않습니다.\n");
		else {
			// 데이터를 삭제했으니 그 뒤에 있는 애들을 앞으로 당겨서 덮어써줘서 지운 것처럼 만든다.
			for(int idx=dataIdx; idx<(curCnt-1); idx++) 
				infoStorage[idx] = infoStorage[idx+1];  
			curCnt--; // 자료의 끝자리는 감소
			System.out.println("데이터 삭제가 완료되었습니다.");
		}
	}

}
