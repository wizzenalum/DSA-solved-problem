MAX_VALUE = 2147483647

def minCostPath(input, mRows, nCols) :
    dp = [[MAX_VALUE]*(nCols+1) for i in range(mRows+1)]
    dp[mRows][nCols] = 0
    for i in range(mRows-1,-1,-1):
        for j in range(nCols-1,-1,-1):
            dp[i][j] = input[i][j]+min(dp[i+1][j],dp[i][j+1],dp[i+1][j+1])
    return dp[0][0]
def lcs(s, t) :
    dp = [[0]*(len(s)+1) for i in range(len(t)+1)]
    for i in range(len(t)-1,-1,-1):
        for j in range(len(s)-1,-1,-1):
            dp[i][j] = max(dp[i+1][j+1] + (1 if t[i]==s[j] else 0),dp[i][j+1],dp[i+1][j])
    return dp[0][0]
def EditDistance(s,t):
    dp = [[0]*(len(s)+1) for i in range(len(t)+1)]
    # at first you missed the terminating condition
    for i in range(len(t)):
        dp[i][len(s)] = len(t)-i
    for i in range(len(s)):
        dp[i][len(t)] = len(s)-i

    dp[len(t)][len(s)] = 0
    ti = 0
    for i in range(len(t)-1,-1,-1):
        sj = 0
        for j in range(len(s)-1,-1,-1):
            if t[ti]==s[sj]: dp[i][j] = dp[i+1][j+1]
            else:
                dp[i][j] = 1 + min(dp[i+1][j+1],dp[i][j+1],dp[i+1][j])
            sj +=1
        ti+=1
    return dp[0][0]

def knapsack1(weights, values, n, maxWeight) :
    # this is wrong way of doing this and i did it this way
    maxValue = [0]
    def help(i,weight,value):
        print(i,weight,value)
        if(weight == maxWeight and maxValue[0]<value): maxValue[0]=value
        if weight>=maxWeight or i==n:return
        help(i+1,weight+weights[i],value+values[i])
        help(i+1,weight,value)
    help(0,0,0)
    return maxValue[0]
def knapsack(weights, values, n, maxWeight) :
    dp = [[0]*(maxWeight+1) for i in range(n+1)]
    for i in range(n-1,-1,-1):
        for j in range(0,maxWeight+1):
            val1 = values[i]+dp[i+1][j-weights[i]] if j-weights[i]>=0 else 0
            val2 = dp[i+1][j]
            dp[i][j] = max(val1,val2)
    return dp[0][maxWeight]
def waysToMakeCoinChange(denominations, numDenominations, value): 
    dp = [[0]*(value+1) for i in range(numDenominations+1)]
    for i in range(numDenominations):
        dp[i][0] = 1
    for i in range(numDenominations-1,-1,-1):
        for j in range(1,value+1):
            # print(i,j,dp)
            val1 = dp[i][j-denominations[i]] if j-denominations[i]>=0 else 0
            val2 = dp[i+1][j]
            dp[i][j] = val1+val2
    return dp[0][value]

def find_squre(arr):
        maximum = 0
        stack = [] 
        for i in range(len(arr)):
            if len(stack)!=0:
                top = stack[len(stack)-1]
                j = i
                while(len(stack)!=0 and arr[top]>arr[i]):
                    temp = min((j-top),arr[top])
                    if(maximum<temp):maximum=temp
                    j = stack.pop()
                    top = stack[len(stack)-1]
            if(len(stack)==0 or arr[stack[len(stack)-1]!=arr[i]]): stack.append(i)
        
            
                


        return maximum

def findMaxSquareWithAllZeros1(mat):
    dp = [[0]*len(mat[0]) for i in range(len(mat))]

    for i in range(len(mat)):
        for j in range(len(mat[0])):
            if(i==0): 
                if(not mat[i][j]): dp[i][j] = 1
            else:
                # print(dp[i-1][j])
                if(not mat[i][j]): dp[i][j] =dp[i-1][j]+1
    print(dp)
    max_square = 0
    for i in range(len(dp)):
        max_in_arr = find_squre(dp[i])
        if(max_square<max_in_arr): max_square = max_in_arr
            # for i in range

def findMaxSquareWithAllZeros(mat):
    if(len(mat)==0 or len(mat[0])==0): return 0
    # dp of maximum square which ends with ith and jth cell
    dp = [[0]*len(mat[0]) for i in range(len(mat))]
    for i in range(len(mat[0])):
        if(mat[0][i] ==0):dp[0][i] = 1
    for i in range(len(mat)):
        if(mat[i][0]==0): dp[i][0] = 1
    # print(dp)
    maximum = 0
    for i in range(len(mat)):
        for j in range(len(mat[0])):
            if(mat[i][j]==1): dp[i][j] = 0
            else:
                dp[i][j] = 1+min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])
            if(maximum<dp[i][j]):maximum = dp[i][j]
    return maximum
def smallestSuperSequence(str1,str2):
    dp = [[0]*(len(str1)+1) for i in range(len(str2)+1)]
    for i in range(len(str1)):
        dp[len(str2)][i] = len(str1)-i
    for i in range(len(str2)):
        dp[i][len(str1)] = len(str2)-i
    for i in range(len(str2)-1,-1,-1):
        for j in  range(len(str1)-1,-1,-1):
            if(str2[i]==str1[j]):    
                dp[i][j] = 1+ min(dp[i+1][j+1],dp[i+1][j],dp[i][j+1])
            else:
                dp[i][j] = 1+ min(dp[i+1][j+1]+1,dp[i+1][j],dp[i][j+1])
    return dp[0][0]
def getMinimumStrength(mat,n,m):
    # here i making dp of the maximum posible power i have to reach the i,j th cell
    dp = [[0]*m for i in range(n)]
    for i in range(1,m):
        dp[0][i] = dp[0][i-1]+mat[0][i]
    for i in range(1,n):
        dp[i][0] = dp[i-1][0]+mat[i][0]
    for i in range(1,n):
        for j in range(1,m):
            dp[i][j] = max(dp[i-1][j],dp[i][j-1]) + mat[i][j]
    min = mat[i][j]
    i,j = 0,0
    while(i<n and j<m):
        

    
    



            

mat = [ [0, 0, 0, 0],
        [0, 0, 0, 0],
        [0, 0, 0, 0],
        [0, 0, 0, 0]]

print(smallestSuperSequence("pqqrpt", "qerepct"))