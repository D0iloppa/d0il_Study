from utils.io_helper import print_result
from utils.timer import measure_time


"""
📘 Algorithm Template
사용법:
1. 문제별 알고리즘 로직은 `solution()` 함수에 작성

2️. 반환값이 있으면 print(*solution())으로 결과를 출력
   print(*solution())

3. 답 제출시
----------------------------
def solution():
    ~~~~
print(*solution())
----------------------------
형태로 제출
"""


# 3개의 조합 추출
def getCombs(n, m, cards):

    result = [];


    max = 0
    # 시작점
    i1 = 0
    
    for i1 in range(0, n-2):
        i2 = i1 + 1
        for i2 in range(i1 +1, n-1):
            i3 = i2 + 1
            for i3 in range(i2 + 1, n):
                sum = cards[i1] + cards[i2] + cards[i3];
                if(sum > m) : continue;
                if(sum >= max) : max = sum;


    return max;

def solution():
    n, m = map(int, input().split())
    cards = list(map(int, input().split()))
    

    max_sum = getCombs(n, m, cards)
    
    return [max_sum]

@measure_time
def solve():
    result = solution()
    print_result(result)

if __name__ == "__main__":
    solve()
