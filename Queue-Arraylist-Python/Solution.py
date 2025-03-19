class ArrayListADT:
    def __init__(self):
        self.size = 0
        self.data = [None]*self.size

    def __fix_size(self):
        lt = []
        for i in self.data:
            if(i != None):
                lt.append(i)
        self.size = len(lt)
        return lt


    def add(self,value):
        self.data  = self.__fix_size()
        self.data.append(value)
        self.size = len(self.data)

        

    def add_at(self,index,value):
        lt = []
        self.data  = self.__fix_size()
        if(index == len(self.data)):
            self.data.append(value)
            return
        for i in range(len(self.data)):
            if(i==index):
                lt.append(value)
                lt.append(self.data[i])
            else:
                lt.append(self.data[i])
        self.data  = lt
        self.size = len(self.data)
    
    def add_all_at(self,index,collection):
        self.data  = self.__fix_size()
        for i in collection:
            self.add_at(index,i)
            index+=1
        self.size = len(self.data)

    def add_all(self,collection):
        self.add_all_at(len(self.data),collection)

    def contains(self,value):
        return value in self.data
    
    def get(self,index):
        return self.data[index]
    
    def index_of(self,element):
        for i in range(len(self.data)):
            if(self.data[i] == element):
                return i
        return -1
    
    def last_index_of(self,element):
        count = -1
        for i in range(len(self.data)):
            if(self.data[i] == element):
                count=i

        return count
    
    def ensure_capacity(self,capacity):
        olddata= self.data
        self.data = olddata+[None]*capacity
        
    def is_empty(self):
        return len(self.data) == 0
        
    def size_(self):
        return len(self.data)
    
    def clear(self):
        self.data = []
        self.size = 0

        
    def remove_at(self,index):
        for i in range(len(self.data)):
            if i == index:
                val = self.data[i]
                self.data.remove(self.data[index])
                return val
        return -1
    
    def remove(self,element):
        idx = self.index_of(element)
        return self.remove_at(idx)
    
    def set(self,index,element):
        self.data[index] = element
        return element
    
    def trim_to_size(self):
        self.data = self.__fix_size()

    def __str__(self):
        return str(self.data)
class FullQueueException(BaseException):
    pass
class MyQueue:
    def __init__(self,size):
        self.lst = ArrayListADT()
        self.size = size
        self.front = 0
        self.back = 0

    def peek(self):
        if(self.lst.is_empty()):
            return None
        return self.lst.get(self.lst.size_()-1)
    def poll(self):
        if(self.lst.is_empty()):
            return None
        element = self.lst.remove_at(0)
        return element
    
    def element(self):
        if(self.lst.is_empty()):
            raise IndexError("")
        
        return self.lst.get(0)
    
    def add(self,value):
        
        if(self.lst.size_() == self.size): 
            raise FullQueueException()
        self.lst.add(value)
        return True
    def remove(self):
        if(self.size == 0 or self.lst.is_empty()):
            raise IndexError()
        element = self.lst.remove_at(0)
        return element

    def offer(self,value):
        if(self.lst.size_() == self.size): 
            return False
        self.lst.add(value)
        return True
    
    def __str__(self):
        return self.lst.__str__()