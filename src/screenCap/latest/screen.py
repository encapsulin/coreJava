import pyautogui

import pyscreeze
import PIL
import random

__PIL_TUPLE_VERSION = tuple(int(x) for x in PIL.__version__.split("."))
pyscreeze.PIL__version__ = __PIL_TUPLE_VERSION


def rnd():
    i = random.randrange(200)
    print(i)
    return i
    
myScreenshot = pyautogui.screenshot()
myScreenshot.save(r'./screen.png')

pyautogui.moveTo(rnd(),rnd())