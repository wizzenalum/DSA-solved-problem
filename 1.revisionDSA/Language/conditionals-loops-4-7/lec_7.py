# fibbonacci number
# n = int(input(""))
# a, b = 1,1
# for i in range(n-2):
#     a, b = b, a+b
# print(b)

# all prime numbers
# n = int(input(""))
# for i in range(2,n+1):
#     j = 2
#     prime = True
#     while(j*j<=i):
#         if(i%j==0): prime = False
#         j+=1
#         # print(j,end=" ")
#     if(prime):print(i)


# Sum or Product 
# n = int(input(""))
# c = int(input(""))
# res = -1
# if(c==1):
#     res = 0
#     for i in range(1,n+1):
#         res+=i
# if(c==2):
#     res = 1
#     for i in range(1,n+1):
#         res*=i
# print(res)


# terms of ap
# x = int(input(""))
# num = 0
# k,i = 0,1
# while(k<x):
#     # print("in")
#     num = 3*i+2
#     if(num%4!=0):
#         print(num,end=" ") 
#         k+=1
#     i+=1

# reverse a number
# num = int(input(""))
# revNum = 0
# while(num>0):
#     revNum = num%10+revNum*10
#     num = num//10
# print(revNum)

#binary to decimal
# bin_num = (input(""))
# dec_num = 0
# base = 2
# multiple = 1
# for i in range(len(bin_num)-1,-1,-1):
#     dec_num += int(bin_num[i])*multiple
#     multiple *=base
# print(dec_num)

# decimal to binary
# dec_num = int(input(""))
# bin_num = ""
# while(dec_num!=0):
#     bin_num = bin_num+str((dec_num%2))
#     dec_num //=2
# print(bin_num)

# square root of integral part
# n = int(input(""))
# sqrtn = 1
# if(n <= 0): print(0)
# else:
#     while(sqrtn*sqrtn<=n):
#         sqrtn = sqrtn+1
#     print(sqrtn-1)

# check number sequence
n = int(input(""))
prev = int(input(""))
current = prev
i=1
while(i<n):
    prev = current
    current = int(input(""))
    if(current>=prev): break
    i+=1
if(current>prev):
    i+=1
    while(i<n):
        prev = current
        current = int(input(""))
        if(current<=prev):break
        i+=1
if(i==n):print("true")
else:print("false")
