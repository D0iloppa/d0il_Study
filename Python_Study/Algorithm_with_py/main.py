# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.








# 헬로우 월드
stuff = ["Hello, World!", "My name is Doil", "bbomi" , 920201]
for i in stuff :
    print(i)





#백준 1000
A,B = input().split()
A = int(A)
B = int(B)
# 첫째 줄에 A+B, 둘째 줄에 A-B, 셋째 줄에 A*B, 넷째 줄에 A/B, 다섯째 줄에 A%B를 출력한다.
print(A + B)
print(A - B)
print(A * B)
print(A / B)
print(A % B)

# (A+B)%C는 ((A%C) + (B%C))%C 와 같을까?
# (A×B)%C는 ((A%C) × (B%C))%C 와 같을까?
# 세 수 A, B, C가 주어졌을 때, 위의 네 가지 값을 구하는 프로그램을 작성하시오.
# 입력
# 첫째 줄에 A, B, C가 순서대로 주어진다. (2 ≤ A, B, C ≤ 10000)
# 출력
# 첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.


A,B,C = input().split()
A = int(A)
B = int(B)
C = int(C)

print( (A+B)%C )
print( ((A%C) + (B%C))%C )
print( (A*B)%C )
print( ((A%C) * (B%C))%C )

