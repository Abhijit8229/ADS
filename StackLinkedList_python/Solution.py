class node:
    def __init__(self,data):
        self.data = data
        self.next = None

class Deque:
    def __init__(self):
        self.head = None
        self.tail = None
        self.__size = 0
    def add_first(self,item):
        new_node = node(item)
        if(self.head == None):
            self.head = new_node
            self.tail = new_node
        else:
            new_node.next = self.head
            self.head = new_node
        self.__size+=1
    def size(self):
        return self.__size

    def is_Empty(self):
        return self.__size == 0
    
    def add_last(self,item):
        new_node = node(item)
        if(self.head == None):
            self.head = new_node
            self.tail = new_node
        else:
            self.tail.next = new_node
            self.tail = new_node
        self.__size+=1

    def remove_first(self):

        if(self.head == None and self.tail == None):
            return  "Deque is empty"

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

    def find(self,value):
        temp = self.head
        count = 1
        while(temp):
            if(temp.data == value):
                return count
            count+=1
            temp = temp.next
        return -1

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
        self.stack = Deque()

    def peek(self):
        if(self.stack.tail == None):
            raise IndexError
        return self.stack.head.data

    def empty(self):
        return self.stack.is_Empty()

    def pop(self):
        if(self.stack.tail == None and self.stack.head == None):
            raise IndexError
        return self.stack.remove_first()

    def push(self,value):
        self.stack.add_first(value)
        return value

    def search(self,value):
        return self.stack.find(value)


