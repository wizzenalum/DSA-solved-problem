# decision making statements
"""if(True): print("if")
elif(True):print("elif")
else:print("else")"""

# while statements
"""i = 3
while(i<9):
    i+=1
    if(i==6):continue
    if(i==9):break
    print(i)
else: print("else")"""

# for loop 
"""for i in range(3,10,1):
    i+=1
    if(i==6):continue
    if(i==9):break
    print(i)
else: print("else")"""

from typing import Iterable

# when the sequence is being modified by the loop: use copy of the sequence
a = list(range(1,11))
for i in a:
    print(i)
    if(i>0):
        a.remove(i)

while input(""): # this will stop at only enter
    pass
