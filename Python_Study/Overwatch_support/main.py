from ctypes import *
import pyautogui as pag
import pydirectinput as pag2
import time , datetime
import keyboard
from PIL import ImageGrab

hw_mouse = windll.LoadLibrary(".\DD94687.64.dll")
hw_key = pag2

####### 마우스 하드웨어 클릭 ######
def l_click():
    hw_mouse.DD_btn(1)
    time.sleep(0.1)
    hw_mouse.DD_btn(2)


def r_click():
    hw_mouse.DD_btn(4)
    time.sleep(0.1)
    hw_mouse.DD_btn(8)

# print("Mouse move abs.")
# hw_mouse.DD_mov(20, 20)
# time.sleep(2)
#
# print("Mouse move rel.")
# hw_mouse.DD_movR(50, 50)
# time.sleep(2)
# print("Mouse move abs.")
# hw_mouse.DD_movR(444, 433)

#
#
# while (True):
#
#
#     # target =pag.locateCenterOnScreen("./hp.png", confidence=0.6)
#     # if (keyboard.is_pressed('F3')):
#     x,y = pag.position()
#     target = None
#     target = pag.locateOnScreen("./hp.png",confidence=0.7)
#     if(target != None) :
#         print(target)
#         # l_click()
#
#     if (keyboard.is_pressed('F5')): break



sc_count = 0




# target = pag.locateCenterOnScreen("./name.png", region=(x - 200, y - 200, 300, 100) , confidence=0.6)


run = False



while(True) :


    if (keyboard.is_pressed('F3')) :
        run=True

    if (keyboard.is_pressed('F4')):
        x, y = pag.position()
        pag.moveTo(x - 100, y - 100, 1)
        pag.moveTo(x , y , 1)

    while(run==True) :
            # sc_count += 1
            # sc_count = sc_count % 50
            # sc_path = "./img/sc" + str(sc_count) + ".png"
            # x, y = pag.position()
            # # 마우스 중심으로 200*200 범위의 스샷 찍음
            # pag.screenshot(sc_path, region=(x - 100, y - 100, 200, 200))
            # time.sleep(0.2)


        x,y = pag.position()
        #윗라인 찾음
        target = pag.locateCenterOnScreen("./upper.png", region=(x - 40, y - 40, 80, 80) , confidence=0.52)
        print("이름표 : " + str(target) + "| 내좌표 : " + str(x)+","+str(y))
        if(target!=None) :
            target1 = pag.locateCenterOnScreen("./left.png", region=(x - 40, y - 40, 80, 80), confidence=0.52)
            # target2 = pag.locateCenterOnScreen("./right.png", region=(x - 50, y - 50, 100, 100), confidence=0.52)
            if (target1 != None) : # 내 조준점 오른쪽에 적
                print("오른쪽에 적")
                x,y = pag.position()
                if(target1.x <= x <= target.x+50) and (target.y+20<=y) : #범위안에 잇어
                    l_click()

            time.sleep(0.1)
            # hw_mouse.DD_mov(int(target.y), int(target.x))
            # pag2.moveTo(int(x),int(y))


        if (keyboard.is_pressed('F3')): break



        if (keyboard.is_pressed('F5')): exit(0)

# SB=1 # 종료키 기능을 위한 변수
# shot=0 # 목표물 찾았는지 확인하는 변수
# start=(316, 554) # 왼쪽 위 좌표
# end=(959, 1118) # 오른쪽 아래 좌표
# c_blue=(162, 45, 27) # 목표물 색깔
#
# while SB==1:
#     screen = ImageGrab.grab() # 화면 캡쳐
#     for i in range(start[0],end[0],10):
#         for j in range(start[1],end[1],10):
#             rgb=screen.getpixel((i,j)) # 각 좌표에서의 rgb값 추출
#             if abs(rgb[0]-c_blue[0])+abs(rgb[1]-c_blue[1])+abs(rgb[2]-c_blue[2])<80:
#                 rgb=screen.getpixel((i+3,j)) # (i+3,j)에서 rgb값 추출
#                 if abs(rgb[0]-c_blue[0])+abs(rgb[1]-c_blue[1])+abs(rgb[2]-c_blue[2])<80:
#                     # pag.click((i+3,j))
#                     l_click()
#                     shot=1
#                     break
#         if shot==1: # 목표물 찾았다면 for문 빠져나옴
#             shot=0
#             break
#     if keyboard.is_pressed('F3'): # 코드 종료
#         SB=0
#         break