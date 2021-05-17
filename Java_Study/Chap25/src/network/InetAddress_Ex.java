package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddress_Ex {

    public static void main(String[] args) {

        try {
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("내 컴퓨터 IP 주소 : " + local.getHostAddress());

            System.out.println();

            InetAddress[] iArr = InetAddress.getAllByName("www.naver.com");
            for(InetAddress ia : iArr){
                System.out.println("www.naver.com IP 주소 : " + ia.getHostAddress());
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
