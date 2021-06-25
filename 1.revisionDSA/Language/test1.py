# number is palindrom or not
# num = int(input(""))
# orNum = num
# plNum = 0
# while(num>0):
#     plNum = num%10+plNum*10
#     num = num//10
# if(orNum == plNum): print("true")
# else: print("false")

# check ap or not
# n = int(input(""))
# apSeries = input("").strip().split()
# ap = True
# for i in range(n-2):
#     # print(apSeries)
#     if(int(apSeries[i+1])-int(apSeries[i])!=int(apSeries[i+2])-int(apSeries[i+1])):
#         ap = False
#         break
# if(ap):print("true")
# else: print("false")

# star pattern
n = int(input(""))
for i in range(1,n+1,1):
    for j in range(n,0,-1):
        if(i==j): print("*",end="")
        else: print(j,end="")
    print()