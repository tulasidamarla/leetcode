from typing import List


def generate(numRows: int) -> List[List[int]]:
    output = []
    prev = []
    for i in range(numRows):
        if i == 0:
            prev = [1]
            output.append(prev)
        else:
            curr = [1]
            j = 1
            # Loop executes only for j value greater than 1
            while j < i:
                curr.append(prev[j - 1] + prev[j])
                j += 1
            curr.append(1)
            output.append(curr)
            prev = curr
    return output


def main():
    result = generate(5)
    for row in result:
        print(row)


main()
