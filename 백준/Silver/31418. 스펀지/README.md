# [Silver IV] 스펀지 - 31418 

[문제 링크](https://www.acmicpc.net/problem/31418) 

### 성능 요약

메모리: 214852 KB, 시간: 556 ms

### 분류

조합론, 수학

### 제출 일자

2024년 10월 20일 11:36:48

### 문제 설명

<p>가로 $W$칸 세로 $H$칸의 격자 모양 스펀지가 있다. 이 스펀지는 $1 \times 1$ 크기의 칸들로 나누어져 있으며 곳곳에 구멍이 뚫려 있어 바이러스가 이동할 수 있는 특이한 성질이 있다.</p>

<p>바이러스는 $1$초마다 스펀지 바깥으로 벗어나지 않는 선에서 자신이 위치한 칸의 상하좌우 및 대각선 $8$칸으로 이동하거나, 자신이 위치한 칸에 가만히 있을 수 있다. 한 칸에 바이러스는 여러 마리 존재할 수 있으며, 모양이 다르기 때문에 구분이 가능하다.</p>

<p style="text-align: center;"><img alt="" height="399" src="https://u.acmicpc.net/d70df67b-8e96-448a-a9ea-2cf4be9e193b/62wPX6.png" width="550"></p>

<p><strong>raa</strong>는 바이러스들을 관찰하다 $T$초 후 가능한 서로 다른 바이러스 분포의 수가 궁금해졌다. 두 바이러스 분포의 어떤 바이러스의 위치가 다를 경우 두 분포는 다르다. <strong>raa</strong>를 도와 그 수를 구하자.</p>

### 입력 

 <p>첫 번째 줄에 스펀지의 가로 길이 $W$와 세로 길이 $H$, 바이러스의 수 $K$, <strong>raa</strong>가 바이러스를 관찰할 시간 $T$가 공백으로 구분되어 주어진다. $(1 \leq W, H, K \leq 10^6;$ $0 \leq T \leq 10^6)$</p>

<p>이어서 $K$줄에 걸쳐 각 바이러스의 현재 위치가 주어진다. 그중 $(i+1)$번째 줄에는 $i$번째 바이러스의 위치를 나타내는 두 정수 $x_{i}, y_{i}$가 공백으로 구분되어 주어진다. 이는 $i$번째 바이러스가 현재 스펀지의 맨 왼쪽 위 칸부터 가로로 $x_{i}$번째, 세로로 $y_{i}$번째 칸에 있음을 의미한다. $(1\leq x_{i} \leq W;$ $1\leq y_{i} \leq H)$</p>

<p>입력으로 주어지는 수는 모두 정수이다.</p>

### 출력 

 <p>$T$초 후 가능한 서로 다른 바이러스 분포의 수를 구하여라. 수가 매우 커질 수 있으므로 $998 \, 244 \, 353$로 나눈 나머지를 출력한다.</p>

