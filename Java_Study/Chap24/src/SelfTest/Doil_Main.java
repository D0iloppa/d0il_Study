package SelfTest;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Doil_Main {

    static ArrayList<Board> board_List = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static String dbPath = "./Temp/board.db";

    static int idx=0;

    public static void main(String[] args) throws IOException {

        while(true){
            switch (show_Menu()){
                case 1:
                    input_Data();
                    break;
                case 2:
                    show_Data();
                    break;
                case 3:
                    return; // 프로그램 종료
                default:
                    System.out.println("잘못된 메뉴 입력");
                    break;
            }
        }




    }

    static int show_Menu(){
        System.out.println("\n=======================================");
        System.out.println("사용하실 메뉴를 입력하세요");
        System.out.println("1. 데이터 입력 | 2. 데이터 확인 | 3. 종료");
        System.out.println("=======================================");
        System.out.print("메뉴 입력 : ");
        return sc.nextInt();
    }

    static void input_Data() throws IOException{

        Board board_Data = new Board();


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter(dbPath));


        System.out.print("제목    : ");
        board_Data.setSong(reader.readLine());
        System.out.print("가수    : ");
        board_Data.setArtist(reader.readLine());
        System.out.print("앨범명  : ");
        board_Data.setAlbum(reader.readLine());
        System.out.print("발매일  : ");
        board_Data.setDate(reader.readLine());
        board_List.add(board_Data);


        writer.write(board_List.get(idx++).getDb());
        writer.close();

    }

    static void show_Data(){
        int itr_Idx = idx;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(dbPath));

            String line = "";
            System.out.println("\t[제목]\t\t\t[가수]\t\t[앨범]\t\t\t[날짜]");

            while ((line = reader.readLine()) != null) {



                String[] temp = line.split("/"); // / : 구분자
                System.out.printf("%d\t%s\t\t%s\t\t\t%s\t\t%s\n", itr_Idx++,temp[0], temp[1], temp[2], temp[3]);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}
