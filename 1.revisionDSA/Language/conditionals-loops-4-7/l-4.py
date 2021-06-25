
# find character case.
chr = input("")
if(96<ord(chr)<123): print("0") # character case is small
elif(64<ord(chr)<91): print("1")  # character case is capital
else: print("-1") # input is not cahracter


# farhnehite to celcious
a,b,c = int(input("")),int(input("")),int(input(""))
while(a<=b):

    print(a," ",int(5*(a-32)/9))
    a +=c;