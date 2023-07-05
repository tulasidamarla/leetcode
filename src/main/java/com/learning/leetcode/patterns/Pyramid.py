def pyramid(n: int):
    for i in range(n):
        for j in range(n - i - 1):
            print(end="   ")
        for j in range(2 * i + 1):
            print(" * ", end="")
        for j in range(n - i - 1):
            print(end="   ")
        print()


def pyramidReverse(n: int):
    for i in range(n):
        for j in range(i):
            print(end="   ")
        for j in range(2 * (n - i) - 1):
            print(" * ", end="")
        for j in range(i):
            print(end="   ")
        print()


def rightPyramid(n: int):
    for i in range(2 * n):
        stars = i
        if i > n:
            stars = 2 * n - i
        for j in range(stars):
            print('*', end="")
        print()


def pyramidSymmetricAlphabets(n: int):
    for i in range(n):
        for j in range(n - i - 1):
            print(end="   ")
        ch = ord('A')
        for j in range(2 * i + 1):
            print(" " + chr(ch) + " ", end="")
            if j < i + 1:
                ch += 1
            else:
                ch -= 1
        for j in range(n - i - 1):
            print(end="   ")
        print()


def pyramidDiamondStar(n: int):
    for i in range(int(n / 2)):
        for j in range(int(n / 2) - i):
            print("*", end="")
        for j in range(2 * i):
            print(" ", end="")
        for j in range(int(n / 2) - i):
            print("*", end="")
        print()
    for i in range(int(n / 2)):
        for j in range(i + 1):
            print("*", end="")
        for j in range(n - 2 - 2 * i):
            print(" ", end="")
        for j in range(i + 1):
            print("*", end="")
        print()


def symmetricPyramidStar(n: int):
    spaces = 2 * n - 2
    for i in range(2 * n - 1):
        stars = i + 1
        if i >= n:
            stars = 2 * n - i - 1
        for j in range(stars):
            print(" * ", end="")
        # Spaces
        for j in range(spaces):
            print("   ", end="")
        for j in range(stars):
            print(" * ", end="")
        if i < n - 1:
            spaces -= 2
        else:
            spaces += 2
        print()


def main():
    print("Pyramid star pattern")
    pyramid(5)
    print("Pyramid reverse star pattern")
    pyramidReverse(5)
    print("Pyramid Right star pattern")
    rightPyramid(5)
    print("Pyramid Symmetric alphabets pattern")
    pyramidSymmetricAlphabets(5)
    print("Pyramid Diamond star pattern")
    pyramidDiamondStar(10)
    print("Symmetric pyramid star pattern")
    symmetricPyramidStar(5);


main()
