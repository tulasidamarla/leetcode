from typing import List


def floodFill(image: List[List[int]], sr: int, sc: int, newColor: int):
    floodFillHelper(image, sr, sc, image[sr][sc], newColor)


def floodFillHelper(image: List[List[int]], i: int, j: int, oldColor: int, newColor: int):
    if i < 0 or j < 0 or i == len(image) or j == len(image[0]) or image[i][j] != oldColor or image[i][j] == newColor:
        return
    image[i][j] = newColor
    floodFillHelper(image, i + 1, j, oldColor, newColor)
    floodFillHelper(image, i - 1, j, oldColor, newColor)
    floodFillHelper(image, i, j + 1, oldColor, newColor)
    floodFillHelper(image, i, j - 1, oldColor, newColor)


def main():
    image = [[1, 1, 1], [1, 1, 0], [1, 0, 1]]
    sr = 1
    sc = 1
    newColor = 2
    print("Given image")
    for row in image:
        print(row)
    print("Selected color", image[sr][sc])
    print("New color", newColor)
    floodFill(image, sr, sc, newColor)
    print("New image")
    for row in image:
        print(row)



main()
