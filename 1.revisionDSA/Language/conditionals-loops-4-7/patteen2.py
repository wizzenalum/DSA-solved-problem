# Code : Mirror Image Number Pattern 
# n = int(input(""))
# for i in range(n):
#     k = 1
#     for j in range(n):     
#         if(n-j-1<=i):
#             print(k,end="")
#             k+=1
#         else: print(" ",end="")
#     print()

# Code : Inverted Number Pattern 
# n = int(input(""))
# for i in range(n,0,-1):
#     for j in range(i):     
#         print(i,end="")
#     print() 

# code:star pattern
# n = int(input(""))
# for i in range(n):
#     for j in range(n,2*n+i,1):
#         if(j-2*n+i+1>=0):print("*",end="")
#         else:print(" ",end="")
#     print()

# code:star pattern
# n = int(input(""))
# for i in range(n):
#     k = i+1
#     for j in range(n+i):
#         if(j-n+1+i>=0):
#             print(k,end="")
#             if(j<n-1):k = k+1
#             else: k = k-1
#         else:print(" ",end="")
#     print()

# Code : Diamond of stars 
# n = int(input(""))
# t = 1
# flag = True
# for i in range(n):
#     for j in range(1,(n+1)//2+t,1):
#         if(j>=(n+1)//2-t+1):print("*",end="")
#         else:print(" ",end="")
#     if(t<(n+1)/2 and flag):t = t+1
#     else: 
#         flag = False
#         t = t-1
#     print()

# Half Diamond Pattern
# n = int(input(""))
# print("*")
# t = 1
# flag = True
# for i in range(1,2*n,1):
#     print("*",end="")
#     k = 1
#     flag1 = True
#     for j in range(1,t*2,1):
#         print(k,end="")
#         if(k<t and flag1):k=k+1
#         else:
#             flag1 = False
#             k=k-1
#     print("*")
#     if(t<n and flag):t=t+1
#     else:
#         flag = False
#         t=t-1
# print("*")

# parallelogram pattern
# n = int(input(""))
# for i in range(n):
#     for j in range(n+i):
#         if(j>=i): print("*",end="")
#         else:print(" ",end="")
#     print()

# sum pattern
# n = int(input(""))
# for i in range(n):
#     sum = 0
#     for j in range(1,i+2,1):
#         sum = sum+j
#         print(j,end="")
#         if(j<=i):print("+",end="")
#     print("=",sum,sep="")

# odd square
n = int(input(""))
for i in range(1,2*n,2):
    for j in range(i,2*n+i,2):
        print(j%(2*n),end="")
    print()
