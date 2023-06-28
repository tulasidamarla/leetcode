def fib(n: int) -> int:
    a = 0
    b = 1
    if n == 0:
        return 0
    for i in range(2, n+1):
        c = a + b
        a = b
        b = c
    return b

def main():
    print('11th number in fibonacci series', str(fib(10)))

main()