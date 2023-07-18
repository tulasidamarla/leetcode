from typing import List


def plusOne(digits: List[int]) -> List[int]:
    for i in range(-1, -len(digits) - 1, -1):
        if digits[i] < 9:
            digits[i] += 1
            return digits
        digits[i] = 0
    digits = [0] * (len(digits) + 1)
    digits[0] = 1
    return digits


def main():
    digits = [9, 8, 7, 6, 5, 9]
    print('Given -> %20s' % digits)
    print('Plus one  -> %16s' % plusOne(digits))
    digits = [9]
    print('Given -> %20s' % digits)
    print('Plus one  -> %16s' % plusOne(digits))
    digits = [9, 9]
    print('Given -> %20s' % digits)
    print('Plus one  -> %16s' % plusOne(digits))


main()
