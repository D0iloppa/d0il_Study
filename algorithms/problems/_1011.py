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


def sumOfArithmetic(n):
    return ( n * ( n + 1 ) ) / 2


def solution():
    """
    예시:
    input:  0 1 2 2 2 7
    output: 1 0 0 0 0 1
    """
    # TODO: 여기에 문제별 로직 작성


    t = int(input())

    for i in range(t):
        x, y = map(int, input().split())
        distance = ( y - x ) - 2
        min_val = distance

        for k in range(2, distance):
            opp = distance // k
            tmp = sumOfArithmetic(opp)

            if -1 <= (distance - tmp) <= 1:
                if(tmp <= min_val):
                    min_val = tmp




    return [min_val + 2]

@measure_time
def solve():
    result = solution()
    print_result(result)

if __name__ == "__main__":
    solve()
