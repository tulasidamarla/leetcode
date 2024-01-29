def phoneCominations(index, map, digits, path, result):
    if index == len(digits):
        result.append(path)
        return
    chars = map.get(digits[index])
    for j in range(len(chars)):
        path += chars[j]
        phoneCominations(index + 1, map, digits, path, result)
        path = path[:-1]


def main():
    phoneMap = {"2": "abc", "3": "def", "4": "ghi", "5": "jkl", "6": "mno", "7": "pqrs", "8": "tuv", "9": "wxyz"}
    result = []
    phoneCominations(0, phoneMap, "23", "", result)
    print(result)


main()
