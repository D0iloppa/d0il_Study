
#에라토스테네스의 체
def prime_list(n):
    # 에라토스테네스의 체 초기화: n개 요소에 True 설정(소수로 간주)
    sieve = [True] * n

    # n의 최대 약수가 sqrt(n) 이하이므로 i=sqrt(n)까지 검사
    m = int(n ** 0.5)
    for i in range(2, m + 1):
        if sieve[i] == True:           # i가 소수인 경우
            for j in range(i+i, n, i): # i이후 i의 배수들을 False 판정
                sieve[j] = False

    # 소수 목록 산출
    return [i for i in range(2, n) if sieve[i] == True]

m,n = input().split()
m = int(m)
n = int(n)

arr = prime_list(n+1)
for i in arr :
    if(i>=m) : print(i)




#베르트랑 공준


while(True):
    N = int(input())
    if(N==0) : break
    if(N==1) : print(1)
    else :
        x = len(prime_list(2*N)) - len(prime_list(N+1))
        print(x)



# 소수
def is_Prime(N):
    if(N<2) : return False # 2미만의 수는 무조건 소수가 아님

    for  i in range(2,N): # 자기 자신 말고 약수(나누어떨어지는 수)가 존재한다면 소수가 아님
        if(N%i == 0) : return False

    return True





M = int(input())
N = int(input())
prime_Arr = []

for number in range(M,N+1):
    if(is_Prime(number)):prime_Arr.append(number)

if(len(prime_Arr)==0) : print(-1) # 소수가 없으면 -1 출력
else :
    sum = 0
    for i in prime_Arr: sum+=i
    print(sum)
    print(prime_Arr[0])





#소인수분해




def prime_Factorization(N): #소인수분해 함수
    if N<2 : return
    for i in range(2,N+1):
        if(N%i==0) :
            arr.append(i)
            return prime_Factorization(N//i)

n = int(input())
arr = []

prime_Factorization(n)
for i in arr:
    print(i)




# 소수
def is_Prime(N):
    if(N<2) : return False # 2미만의 수는 무조건 소수가 아님

    for  i in range(2,N): # 자기 자신 말고 약수(나누어떨어지는 수)가 존재한다면 소수가 아님
        if(N%i == 0) : return False

    return True


M = int(input())
N = int(input())
prime_Arr = []

for number in range(M,N+1):
    if(is_Prime(number)):prime_Arr.append(number)

if(len(prime_Arr)==0) : print(-1) # 소수가 없으면 -1 출력
else :
    sum = 0
    for i in prime_Arr: sum+=i
    print(sum)
    print(prime_Arr[0])







#소수판별

def is_Prime(N):
    if(N<2) : return False # 2미만의 수는 무조건 소수가 아님

    for  i in range(2,N): # 자기 자신 말고 약수(나누어떨어지는 수)가 존재한다면 소수가 아님
        if(N%i == 0) : return False

    return True

n = int(input())
arr =[]
arr = input().split()

prime_Count = 0

for i in range(n):
    target = int(arr[i])
    if is_Prime(target) : prime_Count+=1

print(prime_Count)



# 아파트 배열 선언
apartment = [[0 for col in range(14)] for row in range(14)]

def apt_Sum(arr,n):#한층의 첫번째부터 n번째 호까지 사람의 수의 합
    sum = 0
    for i in range(n):
        sum+=arr[i]
    return sum

def get_Apt(arr,k,n):
    for y in range(k+1):
        for x in range(n):
            if(y==0) : arr[y][x] = x+1 # 0층 초기화
            else : arr[y][x] = apt_Sum(arr[y-1],x+1) # 나머지 층 규칙



T = int(input())

for i in range(T):
    k = int(input())
    n = int(input())
    get_Apt(apartment,k,n)
    print(apartment[k][n-1])



# 달팽이는 올라가고 싶다.
def snail_Problem(a,b,v):
    day = 0  # 걸린 날 출력
    day_Up = 0 # 하루에 올라간 양
    while(True) :
        day_Up+=a # 하룻동안 a만큼 올라간다.
        day+=1 #일단 하루 올라갔으니 하루 증가
        print("%d일차 : %d 올라옴"%(day,day_Up))
    # 정상에 도달한 것이 아니면 잠을 자는데 밤동안 b만큼 떨어진다 ㅠ
        if(day_Up >= v) : return day
        day_Up-=b
        print("미끄러져서 %d 됨" % (day_Up))

def snail(a,b,v):
    if ((v-b) % (a-b))!=0 : return int ((v-b) // (a-b)) + 1
    return int ((v-b) // (a-b))

a,b,v = input().split()
print(snail(int(a),int(b),int(v)))


# print(snail_Problem(int(a),int(b),int(v)))



# 분수찾기
# 아래의 방법은 차례대로 배열을 만드는 프로그램
# n = int(input())
# arr = []
#
# def sol(n,arr) :
#     index = 0
#     level = 1  # 층
#     while (index <= n):
#         for x in range(level):
#             if (level % 2 == 0):  # 짝수
#                 arr.append("{}/{}".format(x+1,level-x))
#                 print("%d/%d"%(x+1,level-x))
#                 # print(x + 1, "%",level - x)
#             else:
#                 arr.append("{}/{}".format(level-x,x+1))
#                 print("%d/%d" % (level - x, x + 1))
#                 # print(level - x, x + 1)
#             index += 1
#             if (index == n): return
#         level += 1
#
# sol(n,arr)
# print(arr[n-1])




def get_Sol(n):
    sum = 1
    level = 1
    while(True):
        if(sum>=n) : break
        level+=1
        sum+=level
    index = sum-n
    # 여기까지 레벨과 인덱스를 구함
    # 이를 기준으로 출력
    if (level % 2 != 0):  # 홀수
        print("%d/%d" % (index + 1, level - index))
    else: #짝수
        print("%d/%d" % (level - index, index + 1))



n = int(input())
get_Sol(n)

print("\n문제 분기선============")
a = input()

# 벌집
def get_Dist(N) :
    if N == 1 : return 1

    sum = 2
    i=1
    while(True):
        sum += 6*i
        if(N<sum) :return i+1
        i+=1

N = int(input())
print(get_Dist(N))


# 손익분기점

def get_BEP(A,B,C) :
    if(C<=B) : return -1 #손익분기 발생하지 않음
    return int (A / (C-B)) + 1

a,b,c = input().split()
print(get_BEP(int(a),int(b),int(c)))




# 단어의 개수
print(len(input().split()))

# 단어 공부

def get_WordMax(arr):
    max_i = 0 # 최댓값의 위치, 첫번째 값이 최댓값이라 가정
    for i in range(len(arr)) :
        if(arr[max_i]< arr[i]) : max_i = i

    max = arr[max_i]
    # max는 최댓값이 된다.
    # 만약 최댓값이 하나라면 최댓값의 위치를 알파벳 대문자로 변환하여 출력
    # 그렇지 않으면 ? 출력
    chk = 0
    for i in range(len(arr)) :
        if(arr[i] == max) : chk += 1 #
        if(chk>1) : return '?' #최댓값이 1개를 넘어가면 뒤 확인할 것도 없이 '?' 출력

    return chr(max_i+65) # A의 아스키 코드는 65다.




alpah_Count = []
for i in range(26) :
    alpah_Count.append(0)

word = input()

for i in range(len(word)) :
    #대소문자 구별하기
    if(ord(word[i]) >= 97 ) : #아스키 코드가 97이상이라면 소문자
        index = ord(word[i])-97 # 정수로 변환후, 해당 인덱스의 알파벳 카운트값 증가
        alpah_Count[index]+=1
    else : # 그렇지 않으면 대문자
        index = ord(word[i])-65 # 정수로 변환후, 해당 인덱스의 알파벳 카운트값 증가
        alpah_Count[index]+=1

print(get_WordMax(alpah_Count))



# 문자열 반복
test_Case = int(input())
for i in range(test_Case):
    n,word = input().split() # 공백을 기준으로 앞에는 숫자, 뒤에는 문자열
    for word_Index in range(len(word)): #단어의 0번째 문자부터 끝까지 반복
        for print_Index in range(int(n)): # 각 단어들을 앞에 입력받은 n만큼 반복해서 출력
            print(word[word_Index],end='')
    print() # 개행


print("\n문제 분기선============")
a = input()



# 알파벳 찾기

def is_In(word,char) : # 단어와, 알파벳을 입력하면 어디에 있는지 찾아주는 함수
    for i in range(len(word)):
        if (word[i] == char) : return i
    return -1

word = input()
for i in range(97,123): # a의 아스키 코드는 97, z는 122
    # a~y까지는 띄어쓰기로 표시
    if(i != 122): print(is_In(word,chr(i)),end=' ')
    # 마지막 z는 띄어쓰기 안하고 개행처리
    else : print(is_In(word, chr(i)))



# 아스키 코드
print(ord(input())) # 아스키 -> 숫자
x = int(input())
print(chr(x)) # 숫자 -> 아스키












# 문자열 숫자의 합

sum = 0 # 합산을 기록할 공간
n = int(input())
x = input()
for i in range(n) :
    sum += int(x[i])
print(sum)


print("\n문제 분기선============")
a = input()


# 한수

def is_AP(arr) : # 등차수열 : Arithmetic Progression
    d = arr[1] - arr[0]
    for i in range(len(arr)-1) :
        if arr[i+1] != arr[i] + d :
            return False # 중간에 등차를 이루지 않음
    return True # 모든 항이 등차를 이룸

def is_Hansu(n) : #한수 체크
    if n<100 : return True
    x = str(n)
    arr = []
    for i in range(len(x)) : # 각 수의 자릿수로 수열을 만든다
        arr.append( int(x[i]) )
    if is_AP(arr) :
        return True # 등차수열을 이루면 한수
    else : return False # 그렇지 않으면 한수아님

han_Count = 0
n = int(input())

for i in range(1,n+1) :
    if is_Hansu(i) : han_Count+=1
print(han_Count)






print("\n문제 분기선============")
a = input()

# 셀프넘버
def is_In(x, arr):  # 배열에 해당 값이 있는지 확인
    for i in arr:
        if (i == x): return True  # 배열안에 있으면 참
    return False  # 없으면 거짓


def d(n):
    result = int(n)
    for i in range(len(n)):
        result += int(n[i])
    return result


arr = []  # 수열을 담을 배열

for i in range(1, 10000):
    arr.append(d(str(i)))  # 수열을 만들어냄
    if (not is_In(i, arr)): print(i)


# 평균은 넘겠지


def get_Avg(arr):  # 평균 구하는 함수
    # 평균이 소수점으로 찍히도록 자동 형변환을 위해 float형으로 적어둠
    sum = 0.0
    for i in range(len(arr)):  # 합계
        sum += int(arr[i])
    avg = sum / len(arr)
    return avg


def chk_Avg(arr):  #
    count = 0  # 평균을 넘은 학생의 수
    avg = get_Avg(arr)
    for i in range(len(arr)):
        if (float(arr[i]) > avg):
            count += 1
    sad_Story = (count / len(arr)) * 100

    return float(sad_Story)


n = int(input())

for i in range(n):
    x = input().split()
    n = int(x[0])  # 학생의 수
    student = []
    for a in range(1, len(x)):
        student.append(int(x[a]))
    print("%0.3f%%" % chk_Avg(student))


# 평균조작

def get_Max(arr):
    max = arr[0]  # 첫번째 값을 최댓값이라 가정
    for i in range(len(arr)):
        if (max <= arr[i]): max = arr[i]

    return max


n = int(input())  # 과목의 갯수
arr = input().split()
sum = 0

for i in range(len(arr)):  # 정수로 변환
    arr[i] = int(arr[i])
    sum += arr[i]

max = get_Max(arr)
avg = float(sum) / n
avg = (avg * 100) / max

print(avg)

# 42로 나누기

result = []  # 비어있는 배열


def is_Exist(x, arr):  # 배열에 해당 값이 있는지 확인

    for i in range(len(arr)):
        if (x == arr[i]): return True  # 중간에 같은 값 발견하면 종료
    return False  # 끝까지 일치하는 값 없으면 존재하지 않음


for i in range(10):
    x = int(input()) % 42
    if (not is_Exist(x, result)): result.append(x)

print(len(result))

# 숫자의 갯수
num_count = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]  # 각 숫자들이 들어있는 갯수


def get_Numcount(arr):
    for i in range(len(arr)):
        for j in range(10):
            if int(arr[i]) == j: num_count[j] += 1


a = int(input())
b = int(input())
c = int(input())
x = str(a * b * c)

get_Numcount(x)

for i in range(10):
    print(num_count[i])

# 최댓값

arr = []
for i in range(9):
    arr.append(int(input()))


def get_MAXnPOS(arr):  # 최댓값과 위치를 구하는 함수
    max = arr[0]
    max_i = 0  # 최댓값의 인덱스 번호
    for i in range(len(arr)):
        if (arr[i] >= max):
            max = arr[i]
            max_i = i
    return max, max_i


a, b = get_MAXnPOS(arr)

print(a)
print(b + 1)


# 최솟값, 최댓값

def get_Min(arr):
    min = arr[0]  # 첫번째 값을 최솟값이라 가정
    for i in range(len(arr)):
        if (min >= arr[i]): min = arr[i]

    return min


def get_Max(arr):
    max = arr[0]  # 첫번째 값을 최댓값이라 가정
    for i in range(len(arr)):
        if (max <= arr[i]): max = arr[i]

    return max


n = int(input())
x = input().split()
arr = []

for i in range(0, n):
    arr.append(int(x[i]))

print(get_Min(arr), get_Max(arr))


# 자릿수 문제
def get_kor_amount_string(num_amount, ndigits_round=0, str_suffix='원'):
    """숫자를 자릿수 한글단위와 함께 리턴한다 """
    assert isinstance(num_amount, int) and isinstance(ndigits_round, int)
    assert num_amount >= 1, '최소 1원 이상 입력되어야 합니다'
    ## 일, 십, 백, 천, 만, 십, 백, 천, 억, ... 단위 리스트를 만든다.
    ## 1~9 숫자
    num_toKor = ['', '일', '이', '삼', '사', '오', '육', '칠', '팔', '구']
    maj_units = ['만 ', '억 ', '조 ', '경 ', '해 ', '자 ', '양 ', '구 ', '간 ', '정 ', '재 ', '극 ']  # 10000 단위
    units = [' ']  # 시작은 일의자리로 공백으로하고 이후 십, 백, 천, 만...
    for mm in maj_units:
        units.extend(['십', '백', '천'])  # 중간 십,백,천 단위
        units.append(mm)

    list_amount = list(str(round(num_amount, ndigits_round)))  # 라운딩한 숫자를 리스트로 바꾼다
    list_amount.reverse()  # 일, 십 순서로 읽기 위해 순서를 뒤집는다

    str_result = ''  # 결과
    num_len_list_amount = len(list_amount)

    for i in range(num_len_list_amount):
        str_num = list_amount[i]
        # 만, 억, 조 단위에 천, 백, 십, 일이 모두 0000 일때는 생략
        if num_len_list_amount >= 9 and i >= 4 and i % 4 == 0 and ''.join(list_amount[i:i + 4]) == '0000':
            continue
        if str_num == '0':  # 0일 때
            if i % 4 == 0:  # 4번째자리일 때(만, 억, 조...)
                str_result = units[i] + str_result  # 단위만 붙인다
        elif str_num == '1':  # 1일 때
            if i % 4 == 0:  # 4번째자리일 때(만, 억, 조...)
                # str_result = units[i] + str_result  # 숫자와 단위를 붙인다
                str_result = num_toKor[int(str_num)] + units[i] + str_result  # 숫자와 단위를 붙인다
            else:  # 나머지자리일 때
                str_result = units[i] + str_result  # 단위만 붙인다
        else:  # 2~9일 때
            str_result = num_toKor[int(str_num)] + units[i] + str_result  # 숫자와 단위를 붙인다
    str_result = str_result.strip()  # 문자열 앞뒤 공백을 제거한다
    if len(str_result) == 0:
        return "일원"
    # if not str_result[0].isnumeric():  # 앞이 숫자가 아닌 문자인 경우
    return str_result + str_suffix  # 접미사를 붙인다


sum = 0

for i in range(56):
    money = int(input())
    result = get_kor_amount_string(money)
    count = 0  # 공백의 갯수
    word_count = 0
    for x in range(len(result)):
        if result[x] == ' ': count += 1

    for x in range(len(result)):
        if result[x] != ' ': word_count += 1

    a = count + 1
    b = word_count
    mul = a * b
    sum += mul

    str_result = str(money) + '\t' + result + '\t' + str(count) + '\t' + str(word_count) + '\t' + str(sum)
    print(str_result)

print(sum)

# 더하기 싸이클

N = input()  # 처음 입력값
result = "100"  # 연산 후 결과값을 담는 부분
# 처음 연산에는 어떤 값이 들어오더라도 싸이클을 돌리기 위해
# 조건에 영향을 미치지 않는 의미없는 값을 입력
# (출력되는 수의 범위가 0~99 이므로 100이라 함)

# 각 자리수들을 기억하기 위한 장치, 반복문 속에서 변화가 생김
# 10 미만의 수라면 앞에 0을 붙여줘서 자릿수를 맞춰준다.
if int(N) < 10:
    op_factor = '0' + N[0]
else:
    op_factor = N[0] + N[1]

count = 0  # 사이클 횟수
while int(N) != int(result):
    count += 1
    # 연산을 위해 각 자릿수 가져오기
    a = int(op_factor[0])
    b = int(op_factor[1])
    if ((a + b) < 10):
        sum = '0' + str(a + b)
    else:
        sum = str(a + b)
    op_factor = str(b) + sum[1]  # 싸이클 연산을 위한 인자
    result = str(b) + sum[1]  # 연산 후 최종 결과값
    print(result)

print("사이클 횟수 : " + str(count))  # 횟수 출력

# A + B 무한반복

run = 1
while (run == 1):
    a, b = input().split()
    a = int(a)
    b = int(b)
    sum = a + b
    if (sum == 0):
        continue
    print(sum)

# 별찍기(중첩 for문 연습)


n = int(input())

for i in range(n):
    for j in range(n - i - 1):  # 공백을 찍는 서브루틴
        print(" ", end='')
    for j in range(i + 1):  # 별을 찍는 서브루틴
        print("*", end='')
    print()

# 구구단

n = int(input())

arr = range(1, 10)
for i in arr:
    print("{0} * {1} = {2}".format(n, i, n * i))
    # print("%d * %d = %d"%(n,i,n*i))

# 1~N까지 합

N = int(input())

Numbers = range(1, N + 1)

sum = 0
for n in Numbers:
    sum += n

print(sum)

# 알람시계
hour, min = input().split()
hour = int(hour)
min = int(min)

time = (hour * 60) + min
time -= 45
if (time < 0): time += (24 * 60)

hour = time // 60
min = time % 60

print(hour, min)

# 윤년
year = int(input())

leap_year = 0
if (year % 4 == 0 and year % 100 != 0) or (year % 400 == 0):
    leap_year = 1

#
# if ( year % 4 == 0 ) :                  #4의 배수?
#     leap_year = 1                       # 윤년이다.
#     if ( year % 100 == 0 ) :            #4의 배수긴 하지만 100의 배수
#         leap_year = 0                   # 그럼 윤년 아님
#
# if( year % 400 == 0 ) :                 #400의 배수는 예외
#     leap_year = 1

print(leap_year)

# 성적처리

score = int(input())

if score >= 90:
    rank = "A"
elif score >= 80:
    rank = "B"
elif score >= 70:
    rank = "C"
elif score >= 60:
    rank = "D"
else:
    rank = "F"

print(rank)

# 백준 세로곱셈 알고리즘

num1 = int(input())
num2 = []
inNum2 = int(input())

while (inNum2 != 0):
    num2.append(inNum2 % 10)  # 끝자리 수 num2 배열에 입력
    inNum2 = inNum2 // 10  # 10으로 나누어서 끝 자리 버림 (몫)

num3 = num1 * num2[0] * 1  # 1의 자리 수의 곱셈
num4 = num1 * num2[1] * 10  # 10의 자리 수의 곱셈
num5 = num1 * num2[2] * 100  # 100의 자리 수의 곱셈
num6 = num3 + num4 + num5  # 각 곱셈들의 합

print(num3)
print(num4 // 10)
print(num5 // 100)
print(num6)
