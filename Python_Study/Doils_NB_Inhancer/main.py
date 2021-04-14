from selenium import webdriver
from bs4 import BeautifulSoup

def preprocess() :
    driver = webdriver.Chrome('./chromedriver.exe')
    driver.implicitly_wait(3)
    return  driver

def login(driver) :
    driver.get("https://nid.naver.com/nidlogin.login")
    login = driver.find_element_by_id("id")
    login.clear()

def openNeighborURl(driver, naverId) :
    driver.get('https://m.blog.naver.com/BuddyList.nhn?blogId=%s' % (naverId))

def getIds(source) :
    bs = BeautifulSoup(source,'html.parser')
    links = bs.findAll('a', class_ = "link")

    foundIds = []

    for count, link in enumerate(links) :
        fid = link['href']
        foundIds.append(fid.replace('/',''))

        return  foundIds



driver = preprocess()
login(driver)
openNeighborURl(driver,'request')

