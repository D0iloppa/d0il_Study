import pyautogui, pydirectinput, time, keyboard
from ctypes import *

hw_mouse = windll.LoadLibrary(".\dll\DD94687.64.dll")
hw_key = pydirectinput

map_confed = 0.95

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

def fast_TG():
    print("퇴각을 합니다.")
    pydirectinput.press('esc')
    time.sleep(0.1)
    retreat = pyautogui.locateCenterOnScreen("./img/retreat.png", confidence=0.95)
    print(retreat)
    pyautogui.moveTo(retreat)
    time.sleep(0.2)
    l_click()
    time.sleep(0.2)
    l_click()


def chk_Hungry():
    print("포만감 체크중입니다...")
    food = None
    food = pyautogui.locateCenterOnScreen("./img/hungry.png", confidence=0.98)
    if (food != None):
        print("배고픔... 포만감 적정 수준 이하")
    else:
        print("포만감 적정 수준 이상")






while (True):
    if (keyboard.is_pressed('F3')):
        hw_key.keyDown('alt')
        hw_key.keyDown('2')
        time.sleep(0.2)
        hw_key.keyUp('alt')
        hw_key.keyUp('2')




        continue
    if (keyboard.is_pressed('F5')): break

