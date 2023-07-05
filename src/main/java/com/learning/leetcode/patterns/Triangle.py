def triangleStars(n: int):
    for i in range(n):
        for j in range(i + 1):
            print("*", end=" ")
        print()


def triangleStarsReverse(n: int):
    for i in range(n):
        for j in range(n - i):
            print("*", end=" ")
        print()


def triangleNumbers(n: int):
    for i in range(n):
        for j in range(i + 1):
            print(str(j + 1), end=" ")
        print()


def triangleNumbers2(n: int):
    for i in range(n):
        for j in range(i + 1):
            print(str(i + 1), end=" ")
        print()


def triangleNumbers3(n: int):
    for i in range(n):
        start = 1 if i % 2 == 0 else 0
        for j in range(i + 1):
            print(str(start), end=" ")
            start = 1 - start
        print()


def triangleNumbers4(n: int):
    for i in range(n):
        for j in range(i + 1):
            print(str(j + 1), end=" ")
        for j in range(2 * (n - i - 1)):
            print(" ", end=" ")
        for j in range(i, -1, -1):
            print(str(j + 1), end=" ")
        print()


def triangleNumbersReverse(n: int):
    for i in range(n):
        for j in range(n - i):
            print(str(j + 1), end=" ")
        print()


def triangleNumbersIncrement(n: int):
    count = 1
    for i in range(n):
        for j in range(i + 1):
            print(str(count), end=" ")
            count += 1
        print()


def triangleCharacters(n: int):
    for i in range(n):
        for j in range(ord('A'), ord('A') + i + 1, 1):
            print(chr(j), end=" ")
        print()


def triangleCharacters2(n: int):
    for i in range(n):
        ch = ord('A') + i
        for j in range(i+1):
            print(chr(ch), end=" ")
        print()


def triangleAlphabetsReverse(n: int):
    for i in range(n):
        for j in range(ord('A'), ord('A') + n - i, 1):
            print(chr(j), end=" ")
        print()


def triangleAlphabetsReverse2(n: int):
    for i in range(n):
        start = ord('E') - i
        end = ord('E') + 1
        for j in range(start, end):
            print(chr(j), end=" ")
        print()


def main():
    print("Triangle star pattern")
    triangleStars(5)
    print("Triangle star reverse pattern")
    triangleStarsReverse(5)
    print("Triangle number pattern")
    triangleNumbers(5)
    print("Triangle same number row pattern")
    triangleNumbers2(5)
    print("Triangle alternate number pattern")
    triangleNumbers3(5)
    print("Symmetric triangle number pattern")
    triangleNumbers4(5)
    print("Triangle number reverse pattern")
    triangleNumbersReverse(5)
    print("Triangle number increment pattern")
    triangleNumbersIncrement(5)
    print("Triangle characters pattern")
    triangleCharacters(5)
    print("Triangle characters pattern 2")
    triangleCharacters2(5)
    print("Triangle alphabets reverse pattern")
    triangleAlphabetsReverse(5)
    print("Triangle alphabets reverse pattern 2")
    triangleAlphabetsReverse2(5)


main()
