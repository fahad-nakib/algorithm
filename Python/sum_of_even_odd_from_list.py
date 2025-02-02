list = [2,2,1,9,0,2,1,4,9,5,4,3,6,8,6]
evenSum = 0
oddSum = 0
for item in list :
    if(item % 2 == 0):
        evenSum += item
    else :
        oddSum += item
print(list)
print("Even Sum : ", evenSum)
print("Odd Sum : ", oddSum)
