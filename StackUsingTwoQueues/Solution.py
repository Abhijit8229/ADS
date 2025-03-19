class node:
    def __init__(self,data):
        self.data = data
        self.next = None
class FullQueueException(BaseException):
    def __init__(self, *args):
        super().__init__(*args)

class MyQueue:
    def __init__(self,capacity):
        self.head = None
        self.tail = None
        self.__size = 0
        self.capacity = capacity
    def add_first(self,item):
        new_node = node(item)
        if(self.head == None):
            self.head = new_node
            self.tail = new_node
        else:
            new_node.next = self.head
            self.head = new_node
        self.__size+=1

    def peek(self):
        if(self.__size == 0):
            return None
        return self.head.data
    def size(self):
        return self.__size

    def is_Empty(self):
        if(self.__size == 0):
            return "true"
        return "false"
    
    def add(self,item):
        if(self.__size == self.capacity):
            raise FullQueueException("")
        new_node = node(item)
        if(self.head == None):
            self.head = new_node
            self.tail = new_node
        else:
            self.tail.next = new_node
            self.tail = new_node
        self.__size+=1
        return True

    def offer(self,item):
        if(self.__size == self.capacity):
            return False
        new_node = node(item)
        if(self.head == None):
            self.head = new_node
            self.tail = new_node
        else:
            self.tail.next = new_node
            self.tail = new_node
        self.__size+=1
        return True


    def poll(self):
        if(self.head == None and self.tail == None):
            return  None

        value = self.head.data
        if(self.__size == 1):
            self.head = None
            self.tail = None
            self.__size-=1
            return value
        
        temp = self.head
        self.head = temp.next
        self.__size -= 1
        return value
    def element(self):
        if(self.__size == 0):
            raise IndexError("")
        return self.head.data
    def remove(self):

        if(self.head == None and self.tail == None):
            raise IndexError("")

        value = self.head.data
        if(self.__size == 1):
            self.head = None
            self.tail = None
            self.__size-=1
            return value
        
        temp = self.head
        self.head = temp.next
        self.__size -= 1
        return value

    def remove_last(self):
        if(self.head == None and self.tail == None):
            return "Deque is empty"

        if(self.__size == 1):
            value = self.head.data
            self.head = None
            self.tail = None
            self.__size-=1
            return value
        temp = self.head
        while temp.next.next!=None:
            temp = temp.next
        value = temp.next.data
        self.tail = temp
        temp.next = None
        self.__size-=1
        return value

    def __str__(self):
        st = ""
        temp = self.head
        if(self.__size == 0):
            return "Deque is empty"
        while temp.next!=None:
            st+=f"{temp.data}, "
            temp = temp.next
        return st+f"{temp.data}"






class Stack:
    def __init__(self):
        self.queue1 = MyQueue(10)
        self.queue2 = MyQueue(10)
        
    def empty(self):
        return self.queue1.is_Empty() == "true" and self.queue2.is_Empty() == "true"
    
    def push(self, item):
        if self.queue1.is_Empty() == "true":
            self.queue1.add(item)
        else:
            while self.queue1.size() > 0:
                self.queue2.add(self.queue1.poll())
            self.queue1.add(item)
            while self.queue2.size() > 0:
                self.queue1.add(self.queue2.poll())
        return self.peek()
    def pop(self):
        if self.queue1.is_Empty() == "true":
            raise IndexError("")
        return self.queue1.poll()
    
    def peek(self):
        if self.queue1.is_Empty() == "true":
            raise IndexError("")
        return self.queue1.peek()
    
    def search(self, item):
        if self.queue1.is_Empty() == "true":
            return -1
        temp = self.queue1.head
        index = 1
        while temp != None:
            if temp.data == item:
                return index
            temp = temp.next
            index += 1
        return -1
    
    def __str__(self):
        return str(self.queue1)
    def __len__(self):
        return self.queue1.size()
    
    