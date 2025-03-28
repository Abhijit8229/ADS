class BinaryHeapPriorityQueue:
    def __init__(self):
        self.l = []
        self.__size = 0
    
    def offer(self,value):
        self.l.append(value)
        self.l.sort()
        self.__size+=1

    def add(self,value):
        self.offer(value)
    
    def size(self):
        return self.__size
    
    def contains(self,element):
        return element in self.l
    
    def peek(self):
        return self.l[0]
    
    def poll(self):
        element  = self.peek()
        self.l.pop(0)
        self.__size-=1
        return element
    
    def remove(self,element):
        if(self.contains(element)):
            self.l.remove(element)
            self.__size-=1
            return True
        return False
    
    def clear(self):
        self.l = []
        self.__size = 0

    def iterator(self):
        
        return self.l
        