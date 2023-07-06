from typing import List


def containerWithMaxWater(heights: List[int]) -> int:
    left_index = 0
    right_index = len(heights) - 1
    maxArea = 0
    while left_index < right_index:
        left_height = heights[left_index]
        right_height = heights[right_index]
        min_height = min(left_height, right_height)
        curr_area = (right_index - left_index) * min_height
        maxArea = max(curr_area, maxArea)
        if left_height < right_height:
            left_index += 1
        else:
            right_index -= 1
    return maxArea


def main():
    heights = [1, 8, 6, 2, 5, 4, 8, 3, 7]
    print("Given heights : ", heights)
    print("Max area is : ", str(containerWithMaxWater(heights)))
    heights = [1, 1]
    print("Given heights : ", heights)
    print("Max area is : ", str(containerWithMaxWater(heights)))


main()
