def nearest(arr, left, right, target):
    mid = (left + right) // 2
    if left == right:
        diff1, diff2, diff3 = abs(arr[mid]-target), abs(arr[mid-1]-target), abs(arr[mid+1]-target)
        diff = min(diff1, diff2, diff3)
        if diff == diff1:
            return arr[mid]
        elif diff == diff2:
            return arr[mid-1]
        else:
            return arr[mid+1]

    if arr[mid] < target:
        return nearest(arr, mid + 1, right, target)
    else:
        return nearest(arr, left, mid - 1, target)


def main():
    prices = [21, 33, 47, 53, 77, 89, 91]
    target = 48
    closest = nearest(prices, 0, len(prices) - 1, target)
    print("Closest to target " + str(target) + " is " + str(closest))

main()
