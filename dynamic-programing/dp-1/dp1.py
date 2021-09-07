# ehre i solving the problems just by dp method.


def nth_fib_num(n):
    if(n<1): return 0
    if(n<3): return 1
    a,b = 1,1
    for i in range(n-2):
        a,b = b,a+b
    return b

def staircase(n):
    if(n<=0):return 0
    if(n<3): return n
    if(n==3): return 4
    a,b,c = 1,2,4
    for i in range(n-3):
        a,b,c = b,c,a+b+c
    return c
def countMinStepsToOne(n) :
    if(n<=0): return ""
    dp = [0]*(n+1) if n>3 else[0]*4
    dp[0] = n+1
    dp[1] = 0
    dp[2] = 1
    dp[3] = 1
    if(n<4):return dp[n]
    for i in range(4,n+1):
        temp = dp[i-1]
        if(not bool(i&1)): temp = min(temp,dp[i//2])
        if i%3==0: temp = min(temp,dp[i//3])
        dp[i] = temp+1
    return dp[n]
def minimumNumberOfSquare(n):
    store = [0]*(n+1)
    store[0] = float('inf')
    for i in range(1,n+1):
        j = 1
        temp = n # n can work like infinite because ans cant be more thant that
        while(j*j<i):
            temp = min(temp,store[i-j*j])
            j+=1
        if(j*j==i): temp = 1
        else:temp+=1
        store[i] = temp
        # print(store)
    return store[n]


## assignments 
# solution is correct but memory issue due to long solution with time complexity of O(N)
def byteLandianGoldExchange(n):
    dp = [0]*(n+1)
    for i in range(1,n+1):
        # print(dp)
        dp[i] = max(i,dp[i//2]+dp[i//3]+dp[i//4])
    return dp[n]
# lets use memoization instead ******* this is example for using memoization *** even we can do it by itteration but that too tedious
def byteLandianGoldExchangeMemo(n):
    dp = {}
    def exchange(n):
        if n<=0: return n
        if n in dp: return dp[n]
        dp[n] = max(n,exchange(n//2)+exchange(n//3)+exchange(n//4))
        return dp[n]
    return exchange(n)
# not getting how to solve so move with memoization
def LootHouseByThievs(houses,n):
    dp = [[None]*(n+1),[None]*(n+1)]
    dp[0][n],dp[1][n] = [0,False],[0,False]
    for i in range(n-1,-1,-1):
        # print(i,dp)
        # // here i assumed that previously loot has occured means filling dp[1]
        sum1 = dp[0][i+1]
        result = [sum1[0],False]
        dp[1][i] = result
        # here i assumed that previously loot not ocurred means i am filling dp[0]
        sum2 = dp[1][i+1]
        if sum1[0]<(sum2[0]+houses[i]) and (not sum2[1]) : result = [sum2[0]+houses[i],True]
        dp[0][i] = result
    return dp[0][0][0]
def FindWinnerWhoLast(n,x,y):
    beerus = [True]*(n+1)
    whis = [True]*(n+1)
    beerus[0] = False
    whis[0] = False
    for i in range(1,n+1):
        # calculating for whis
        temp1 = False if i-x<0 else beerus[i-x]
        temp2 = False if i-y<0 else beerus[i-y]
        whis[i] = True if False in [beerus[i-1],temp1,temp2] else False
        # calculating for beerus
        temp1 = False if i-x<0 else whis[i-x]
        temp2 = False if i-y<0 else whis[i-y]
        beerus[i] = True if False in [whis[i-1],temp1,temp2] else False
    if beerus[n]:
        return "Beerus"
    else:
        return "Whis"







    






# print(countMinStepsToOne(30))
# print(minimumNumberOfSquare(12))
# print(byteLandianGoldExchangeMemo(12))
# print(LootHouseByThievs([10, 2, 30, 20, 3, 50] ,6))
FindWinnerWhoLast(4,2,3)
