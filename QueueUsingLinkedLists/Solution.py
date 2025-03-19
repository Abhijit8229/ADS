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






