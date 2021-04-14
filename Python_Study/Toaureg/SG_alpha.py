import pyautogui,pydirectinput, time,keyboard
from ctypes import *
import SG_toauFn as loid # 함수 가져오기


##########################
# 관리자 권한으로 실행할 것! #
##########################




# 하드웨어 마우스
hw_mouse = windll.LoadLibrary(".\dll\DD94687.64.dll")
hw_key = pydirectinput

# 테스트 함수
def do_Cycle() :
    my_status = "필드 사전작업"
    print("\n<=" + my_status + " =>\n")
    loid.do_Lobby()
    time.sleep(1)

    my_status = "적 탐색"
    print("\n<=" + my_status + " =>\n")
    loid.search_Enemy()

    my_status = "전투확인"
    print("\n<=" + my_status + " =>\n")
    loid.fight_Start()



# 메인 작동부 #####################
print("\n")
print("Hello, Mr")
print("| F3 작동 | F10 프로그램 종료 | F2 좌표출력 |")

key = 1
run = False

my_status = "Main menu"
search_delay = 0.01

sc_count = 0 # 스크린샷 번호
_SC_MAX = 10  # 스크린샷 최대 번호

while(True):
    if keyboard.is_pressed('F3'):
        run = True # 시작키
        my_status = "프로그램 시작됨"
        print(my_status+"\n")
        print("| F4 정지 | F5 전투 1회 | F6 자동전투 | F7 스크린샷 | F8 마우스 좌표이동 확인 |F10 프로그램 종료")

    if keyboard.is_pressed('F10'):
        my_status = "Program End!"
        print(my_status)
        break     # 프로그램 종료

    if keyboard.is_pressed('F2'):
        print(pyautogui.position())


    while (run):
        if keyboard.is_pressed('F2'):
            print(pyautogui.position())
            time.sleep(0.2)
            continue
        if keyboard.is_pressed('F4'): # F4 누르면 종료
            run = False
            my_status = "일시정지됨"
            print(my_status)
            print("| F4 정지 | F5 전투 1회 | F7 스크린샷 | F8 마우스 좌표이동 확인 | F10 프로그램 종료")
            time.sleep(0.2)
            continue

        if keyboard.is_pressed('F7'): # F7 누르면 스크린샷
            sc_count += 1
            sc_count = sc_count % _SC_MAX
            sc_path = "./img/scshot/sc" +str(sc_count) +".png"
            x,y = pyautogui.position()
            # 마우스 중심으로 200*200 범위의 스샷 찍음
            pyautogui.screenshot(sc_path,region=(x-100,y-100,200,200))
            my_status = "Screen Shot #"+ str(sc_count) +" 촬영완료"
            print(my_status)
            print("\n| F4 정지 | F5 전투 1회 | F6 자동전투 | F7 스크린샷 | F8 마우스 좌표이동 확인 | F10 프로그램 종료")
            time.sleep(0.2)
            continue

        if keyboard.is_pressed('F8'):  # 마우스 좌표이동 확인
            x,y = input().split()
            x = int(x)
            y = int(y)
            pyautogui.moveTo(x,y,1)
            time.sleep(0.2)
            continue


        if keyboard.is_pressed('F10'): break  # 프로그램 종료

        if keyboard.is_pressed('F5'): # 전투싸이클 1회

            # my_status = "필드 사전작업"
            # print("\n<=" + my_status + " =>\n")
            # loid.do_Lobby()
            # time.sleep(1)
            #
            # my_status = "적 탐색"
            # print("\n<=" + my_status + " =>\n")
            # loid.search_Enemy()
            #
            #
            # my_status = "전투확인"
            # print("\n<=" + my_status + " =>\n")
            # loid.fight_Start()

            do_Cycle()

            time.sleep(0.2)

            continue









##  메인 끝 ###################################


