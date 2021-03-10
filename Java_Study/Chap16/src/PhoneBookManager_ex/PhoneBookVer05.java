package PhoneBookManager_ex;

import java.util.Scanner;

public class PhoneBookVer05 {

	public static void main(String[] args) {
		
		PhoneBookManager manager = PhoneBookManager.createManagerInst(); // 싱글톤가져다 씀
		
		int choice;
		
		while(true) {
			MenuViewer.showMenu();
			choice = MenuViewer.keyboard.nextInt();
			MenuViewer.keyboard.nextLine();
			
			switch(choice) {
			 case INIT_MENU.INPUT:
				 manager.inputData();
				 break;
			 case INIT_MENU.SEARCH:
				 manager.searchData();
				 break;
			 case INIT_MENU.DELETE:
				 manager.deleteData();
				 break;
			 case INIT_MENU.EXIT:
				 System.out.println("프로그램을 종료합니다.");
				 return;
			}
		}
		

	}

}
