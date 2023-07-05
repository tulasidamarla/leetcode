def square(n: int):
    for i in range(n):
        for j in range(n):
            print("* ", end="")
        print()

def hollowSquare(n: int):
    for i in range(n):
        for j in range(n):
            if i == 0 or j == 0 or i == n - 1 or j == n - 1:
                print(" * ", end="")
            else:
                print("   ", end="")
        print()


def squareArray(n: int):
    for i in range(2 * n - 1):
        for j in range(2 * n - 1):
            top = i
            left = j
            right = (2 * n - 1) - 1 - j
            bottom = (2 * n - 1) - 1 - i
            print(n - min(left, right, top, bottom), end=" ")
        print()


def main():
    print("square array")
    square(5)
    print("Hollow square array")
    hollowSquare(5)
    print("Matrix pattern")
    squareArray(4)


main()
