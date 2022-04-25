n = int(input())
num = n
sum = 0

while True:
    a = num // 10
    b = num % 10
    num = (b * 10) + ((a + b) % 10)

    sum += 1
    if num == n:
        break

print(sum)
