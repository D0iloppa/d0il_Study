import sys

def read_input():
    return sys.stdin.read().strip()

def print_result(result):
    if isinstance(result, (list, tuple)):
        print(*result)
    else:
        print(result)
