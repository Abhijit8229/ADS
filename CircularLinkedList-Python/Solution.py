class node:
    def __init__(self,value):
        self.value = value
        self.prev = None
        self.next = None
    
class CircularLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
        self.__size = 0

    def add(self,value):
        new_node = node(value)
        if((self.head  == None) and (self.tail == None)):
            self.head = new_node
            self.tail = new_node

        else:
            temp = self.tail
            temp.next = new_node
            new_node.next = self.head
            new_node.prev = temp
            self.head.prev = new_node
            self.tail = new_node
        self.__size +=1

    def add_first(self,value):
        new_node = node(value)
        if((self.head  == None) and (self.tail == None)):
            self.head = new_node
            self.tail = new_node
        else:
            new_node.next = self.head
            new_node.prev = self.tail
            self.head.prev = new_node
            self.tail.next = new_node
            self.head = new_node
        self.__size+=1
    
    def contains(self,value):
        temp = self.head
        while temp!=self.tail:
            if(temp.value == value):
                return True
            temp = temp.next
        return False
    
    def get_first(self):
        return self.head.value
    
    def get_last(self):
        return self.tail.value
    
    def size(self):
        return self.__size
    
    def remove(self):
        if(self.head  == None and self.tail == None):
            self.head = None
            self.tail = None
            return
        if(self.head == self.tail):
            self.head = None
            self.tail = None
            self.__size -=1
            return
        temp = self.head
        self.tail.next = temp.next
        temp.next.prev  = self.tail
        self.head = temp.next
        self.__size -=1
        return temp.value

    def remove_last(self):
        if(self.head  == None and self.tail == None):
            self.head = None
            self.tail = None
            return
        temp = self.head
        while(temp.next.next != self.head):
            temp = temp.next
        data  = temp.next.value
        
        temp.next = self.head
        self.tail = temp
        self.head  =self.tail
        self.__size -=1
        return data
    
    def clear(self):
        self.head = None
        self.tail = None
        self.__size = 0

    def get(self,index):
        temp = self.head
        count = 0
        while(count != index):
            count +=1
            temp = temp.next
        return temp.value
    
    def is_circular(self):
        temp = self.head
        while temp.next:
            temp = temp.next
            if temp == self.head:
                return True
            
        return False
    
    def __str__(self):
        if self.__size == 0:
            return "CircularLinkedList is empty"
        result = []
        if(self.head == self.tail):
            return f"[{self.head.value }]" 
           
        temp = self.head
        while temp:  
            result.append(f"[{temp.value}]")
            temp = temp.next
            if temp == self.head:  
                break
        return "<->".join(result)