dictionary = input().split(" ")
dictionary2 = {}
for elem in dictionary:
    dictionary2[elem] = elem
for word in input().split(" "):
    tempRes = word
    for i in range(len(word)):
        index = word[0:i+1]
        existed = dictionary2.get(index)
        if existed:
            tempRes = existed
            break
    print(tempRes, end=" ")