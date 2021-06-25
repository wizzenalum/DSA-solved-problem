# for square pattern
# n = int(input(""))
# for i in range(n):
#     for j in range(n):
#         print(n,end=" ")
#     print("")

#for triangular star pattern
# n = int(input(""))
# for i in range(n):
#     for j in range(i+1):
#         print("*",end="")
#     print("")

# for triangle number pattern
# n = int(input(""))
# for i in range(n):
#     for j in range(i+1):
#         print(i+1,end="")
#     print("")

# Code : Reverse Number Pattern 
# n = int(input(""))
# for i in range(n):
#     for j in range(i+1):
#         print(i-j+1,end="")
#     print("")

# Code : Alpha Pattern 
# n = int(input(""))
# for i in range(n):
#     for j in range(i+1):
#         print(chr(ord('A')+i),end="")
#     print("")

# code : character pattern
# n = int(input(""))
# for i in range(n):
#     for j in range(i+1):
#         print(chr(ord('A')+i+j),end="")
#     print("")

# Code : Interesting Alphabets 
n = int(input(""))
for i in range(n):
    for j in range(i+1):
        print(chr(ord('A')+n-i+j-1),end="")
    print("")