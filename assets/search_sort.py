from typing import List

def binarySearch(array:List,start:int,end:int,key:int)->int:
    # divide and conquare
    if(start>end):return -1
    mid = (start+end)//2 
    if(array[mid]==key):return mid
    if(key>array[mid]): return binarySearch(array,mid+1,end,key)
    return binarySearch(array,start,mid-1,key)
def selectionSort(array:List):
    #select min and put it in front.
    n = len(array)
    for i in range(n):
        min = i
        for j in range(i+1,n):
            if(array[j]<array[min]): min = j
        swap = array[i]
        array[i] = array[min]
        array[min] = swap
def bubbleSort(array:List,n:int):
    # swap all wrong order pair it will bring biggst at last.
    for j in range(n-1,0,-1):
        for i in range(0,j):
            if(array[i]>array[i+1]):
                swap = array[i]
                array[i] = array[i+1]
                array[i+1] = swap
def insertionSort(array,n):
    # as sort the cards in hand
    for i in range(1,n):
        k = i-1
        j = i
        while(k>=0):
            if(array[k]>array[j]):
                array[k],array[j] = array[j],array[k]
                j=k
            k-=1

def meargeSotedArray(arr1,arr2):
    # mearging two sorted arrays
    arr = [0]*(len(arr2)+len(arr1))
    i, j,k = 0, 0,0
    while(i<len(arr1)and j<len(arr2)):
        if arr1[i]<arr2[j]:
            arr[k] = arr1[i]
            i,k = i+1,k+1
        elif arr1[i]>arr2[j]:
            arr[k] = arr2[j]
            j,k = j+1,k+1
        else:
            arr[k] = arr1[i]
            arr[k+1] = arr2[j]
            i,j,k = i+1,j+1,k+2

    while(i<len(arr1)):
        arr[k] = arr1[i]
        i,k = i+1,k+1
    while(j<len(arr2)):
        arr[k] = arr2[j]
        j,k = j+1,k+1
    return arr




def meargeSort(array):
    # devide conqoure and merging arrays
    if(len(array)<=1):return array
    mid = len(array)//2
    arr1 = meargeSort(array[0:mid])
    arr2 = meargeSort(array[mid:])
    return meargeSotedArray(arr1,arr2)

def quickFix(array,start,end,key):
    print("quick fix",start,end,key)
    if(end<=start): return start
    newArr = [None]*(end-start+1)
    i,j = 0,end-start
    for k in range(0,end-start+1):
        if(array[k]> key):
            newArr[j] = array[k]
            j-=1
        if(array[k]<key):
            newArr[i]=array[k]
            i+=1
    for k in range(0,end-start+1):
        if(newArr[k]==None):
            array[k+start]=key
            if (k-1)<0 or newArr[k-1]!=None : i=k
            if (k+1)>(end-start) or newArr[k+1]!=None :j=k
        else: array[k+start] = newArr[k]
    return i,j


        


    


def quickSort(array,start,end):

    if(end<=start):return
    m1,m2 = quickFix(array,start,end,array[start])
    print(start,end,m1-1)
    quickSort(array,start,m1-1)
    quickSort(array,m2+1,end)



array = [1,4,5,6,2,3,4,5,6,7,7,6,5,4,3]
# print(quickFix(array,0,len(array)-1,1))
print(quickSort(array,0,len(array)-1))
print(array)



        