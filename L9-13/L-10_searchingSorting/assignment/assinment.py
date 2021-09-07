def pushZerosAtEnd(arr, n) :
    i = -1
    for k in range(len(arr)):
        if(i==-1 and arr[k]==0):i=k
        if(arr[k]!=0 and i!=-1):
            arr[k],arr[i] = arr[i],arr[k]
            i+=1
def rotate(arr, n, d):
    # reverse arr from start to end
    def reverse(arr,start,end):
        
