# functions
def love(parameter,fucking = "good",brain = "storming",*arg,**karg):
    print(parameter,fucking,brain,arg,karg)
    print(type(arg),type(karg))

love("par","great","hmmm",2,3,4,5,key="keywo",kyy="kayiku")

def fact(n):
    if(n<=1): return 1
    return n*fact(n-1)
def ncr(n,r):
    return fact(n)/(fact(n-r)*fact(r))
print(ncr(5,2))
print(ncr(5,5))
# default return type is None
print(love("par","great","hmmm",2,3,4,5,key="keywo",kyy="kayiku"))

def even(n,i):
    if(i>n): return
    print(i)
    even(n,i+2)

even(15,0)

def fib(n):
    if(n>0):
        a= 1
        b= 1
        
