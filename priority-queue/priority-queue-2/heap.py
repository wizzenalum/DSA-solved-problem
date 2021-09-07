'''
here i will try to put all about heap with applications and all

''' 

def downheapify(heap,root,key):
    ''' 
    heap on which this function perform,
    root node from where i start down heapify,
    key tells about priority of the node.
    '''
    child1 = 2*root+1
    child2 = child1+1
    if child1>=len(heap): return
    elif child2>=len(heap):
        if(key(heap[child1],heap[root])):
            
        


