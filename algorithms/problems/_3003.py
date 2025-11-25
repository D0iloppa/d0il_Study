from utils.io_helper import print_result
from utils.timer import measure_time

def solution():
    pieces = [1, 1, 2, 2, 2, 8]
    have = list(map(int, input().split()))
    return [p - h for p, h in zip(pieces, have)]

@measure_time
def solve():
    result = solution()
    print_result(result)

if __name__ == "__main__":
    solve()
