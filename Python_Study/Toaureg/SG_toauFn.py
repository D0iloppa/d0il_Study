from ctypes import *
import pyautogui
import pydirectinput
import time , datetime
import keyboard


hw_mouse = windll.LoadLibrary(".\dll\DD94687.64.dll")
hw_key = pydirectinput



## 인식률,옵션값 설정 ####
enemy_confed = 0.65 # 적 인식률
battle_confed = 0.5 # 전투 매칭확인 인식률
map_confed = 0.98 # 맵 인식률

map_Number = 5 # 전투가능 맵 갯 수
# map 1 : 나3시   적 9시
# map 2 : 나9시   적 3시
# map 3 : 나6시   적 12시
# map 4 : 나12시  적 3시
# map 5 : 나6시   적 9시


enemy_Number = 6 # 적군 이미지 검색용 갯 수

drink = False # 물약 마시는 여부
back_flag = 0 # 뒤로 가기 위한 플래그



####### 마우스 하드웨어 클릭 ######
def l_click():
    hw_mouse.DD_btn(1)
    time.sleep(0.1)
    hw_mouse.DD_btn(2)


def r_click():
    hw_mouse.DD_btn(4)
    time.sleep(0.1)
    hw_mouse.DD_btn(8)
################################



########## 함수 정의부 ##################

def fast_TG():
    print("퇴각을 합니다.")
    pydirectinput.press('esc')
    time.sleep(0.1)
    retreat = pyautogui.locateCenterOnScreen("./img/retreat.png", confidence=0.95)
    print(retreat)
    pyautogui.moveTo(retreat)
    time.sleep(0.1)
    l_click()
    time.sleep(0.2)
    l_click()

########## 필드 로비 ################
def do_Lobby():
    print("로비입니다.")
    chk_Hungry()
    chk_Weight()
    if(drink == True) : drink_Potion()

def chk_Hungry():
    print("포만감 체크중입니다...")
    hungry = None
    hungry = pyautogui.locateCenterOnScreen("./img/hungry.png", confidence=0.98)
    if (hungry != None):
        print("배고픔... 포만감 적정 수준 이하")
        for i in range(3) :
            hw_key.keyDown('alt')
            hw_key.keyDown('2')
            time.sleep(0.2)
            hw_key.keyUp('alt')
            hw_key.keyUp('2')

        print("음식 3개 먹음")
    else:
        print("포만감 적정 수준 이상")


def chk_Weight():
    print("무게 체크중입니다...")

def drink_Potion():
    print("물약을 먹습니다.")




############## 적 탐색 루틴 ####################
def search_Enemy():

    back_flag = 0

    print("적 탐색을 시작합니다.\n")

    target = None  # 발견 못한 상황부터 시작
    title = pyautogui.locateCenterOnScreen("./img/title.png", confidence=0.9)
    # 로고를 기준으로 상대좌표 계산
    # 이 범위를 기준으로 검색영역을 산정함
    x = title.x + 100
    y = title.y + 50




    searched = False
    while (searched == False):
        enemy_Detect_Cycle(x,y)
        print("전투매칭을 확인합니다.")
        start = time.time()
        for i in range(50) :
            searched = is_We_Matched(x,y,start)
            time.sleep(0.1)
            if(searched==True) : break
        if(searched==False) : print("매칭실패")



def enemy_Detect_Cycle(x,y): # 탐색 1사이클

    find = 0

    for i in range(enemy_Number):  # 정해둔 4방향 이미지 검색
        # print("%d번째 이미지 검색 중" % (i + 1))
        path = "./img/enemy" + str(i + 1) + ".png"
        # print(path)
        # region은 검색영역 x,y,가로길이,세로길이
        # confidence 인식율 (1에 가까울 수록 정확도 높아지지만 발견확률은 줄어듬)
        target = pyautogui.locateCenterOnScreen(path, region=(x, y, 700, 700), confidence=enemy_confed)
        if target != None: break

    if target != None:
        find = 1
        pyautogui.moveTo(target)  # 적 발견시 이동
        time.sleep(0.1)
        r_click()  # 우클릭
        print("적 발견")


    if(find==0) : return enemy_Detect_Cycle(x,y)


def is_We_Matched(x,y,t):  # 전투 매칭되었는지 확인

    target = pyautogui.locateCenterOnScreen("./img/start.png", region=(x+360,y+230, 300, 300), confidence=battle_confed)
    if target != None :
        sec = time.time() - t
        print("전투 매치 성공  ==>   %2f sec"%(sec))
        return True
    return False # 매칭 실패시 다시 검색

##############################################



def fight_Start():
    wait_for_Battle()
    print("전투진입을 확인합니다.")
    can_battle = is_Battle_Possible()
    if(can_battle == False) :
        fast_TG()
        time.sleep(2)
        do_Lobby()
        search_Enemy()
        return fight_Start()

def wait_for_Battle():
    target = None
    while(target == None) :
        target = pyautogui.locateCenterOnScreen("./img/wait_battle.png",confidence=0.98)

def is_Dark():
    chk = None
    dark_list = ["./img/is_dark1.png","./img/is_dark2.png","./img/is_dark3.png","./img/is_dark4.png"];
    for i in dark_list :
        chk = pyautogui.locateCenterOnScreen(i,confidence=0.98)
        time.sleep(0.1)
        if(chk != None) : break

    return chk


def is_Battle_Possible():
    print("전투가능여부 확인")

    print("맵을 읽습니다.")
    #맵 어두운지 확인해야함
    time.sleep(0.5)
    chk = is_Dark()
    if chk == None :
        print("맵이 밝은상황 = > tab 눌러서 반전")
        hw_key.press('tab')


    for i in range(map_Number):  # 전투 가능한 상황 맵의 갯 수
        # print("%d번째 이미지 검색 중" % (i + 1))
        path = "./img/map" + str(i + 1) + ".png"
        # print(path)
        # region은 검색영역 x,y,가로길이,세로길이
        # confidence 인식율 (1에 가까울 수록 정확도 높아지지만 발견확률은 줄어듬)
        chk = pyautogui.locateCenterOnScreen(path, confidence = map_confed)
        if chk != None: break
    if chk != None : # 전투가능한 맵임
        print(int(i)) # 전투가능 맵 번호
        print("전투가능")
        return True
    print("전투불가")
    return False # 전투불가능한 맵



def do_Auto_Battle():
    print("자동전투를 시작합니다.")











