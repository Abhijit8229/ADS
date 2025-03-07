class node:
    def __init__(self, data):
        self.value = data
        self.prev = None
        self.next = None

class DoublyCircularLL:
    def __init__(self):
        self.head = None
        self.tail = None
        self.__size = 0

    def add(self,value):
        new_node = node(value)
        if((self.head  == None) and (self.tail == None)):
            self.head = new_node
            self.tail = new_node
            new_node.next = self.head
            new_node.prev = self.tail
        else:
            temp = self.tail
            temp.next = new_node
            new_node.next = self.head
            self.head.prev = new_node
            self.tail = new_node
        self.__size +=1

    def add_first(self,value):
        new_node = node(value)
        if((self.head  == None) and (self.tail == None)):
            self.head = new_node
            self.tail = new_node
            new_node.next = self.head
            new_node.prev = self.tail
        else:
            new_node.next = self.head
            self.head.prev = self.tail
            self.head = new_node
            self.tail.next = new_node
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
    

    def remove_from(self,value):
        if(self.head  == None and self.tail == None):
            return
        if(self.head == self.tail):
            self.head = None
            self.tail = None
            self.__size -=1
            return
        temp = self.head
        tp = None
        while temp.next != self.head:
            if(temp.next.value == value):
                tp = temp.next
                break
            temp = temp.next

        if tp is None and self.head.value == value:
            tp = self.head
        if tp is None:  
            return None
        
        if tp == self.head: 
            self.head = tp.next
        if tp == self.tail:
            self.tail = temp
        temp.next = tp.next
        tp.next.prev = temp
        self.__size -=1
        return tp.value
        
    def __str__(self):
        if(self.__size == 0):
            return "CircularLinkedList is empty"
        result = []
        temp = self.head
        while True:
            if(temp is not None):
                result.append(f"[{temp.value}]")
                temp = temp.next
                if temp == self.head: 
                    break
            else:
                break
        return "<->".join(result)

class Josephus:
    def josephusDCLL(self, size, rotation):
        game = DoublyCircularLL()
        for i in range(1,size+1):
            game.add(i)
        temp = game.head
        
        while game.size() > 1:
            for _ in range(rotation - 1):  
                temp = temp.next
           
            val = game.remove_from(temp.value)
            temp = temp.next
        return game.get_first()
