a, b = map(int, input().split())
c = int(input())
d = a + ((b + c) // 60)

if d >= 24:
    print(d - 24, (b + c) - 60 * ((b + c) // 60))
else:
    print(d, (b + c) - 60 * ((b + c) // 60))
