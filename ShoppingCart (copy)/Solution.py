class Item:
    def __init__(self,name,price,quantity):
        self.name = name
        self.price = price
        self.quantity = quantity

    def __eq__(self, other):
        if isinstance(other, Item):
            return self.name == other.name
        return False
    

    def __str__(self):
        return f"{self.name} - ${self.price:.2f} * {self.quantity} = ${(self.price * self.quantity):.2f}"

class Cart:
    def __init__(self,items):
       
        self.items = items

    
    def addItem(self,item):
        if(item not in self.items):
            self.items.append(item)
            print(f"Item added to cart: {item.name}")
            return
        temp = self.items.index(item)
        temp_item = self.items[temp]
        temp_item.quantity += item.quantity
        print(f"Quantity updated for item: {temp_item.name}")
        return
    
    def RemoveItem(self, name) :
        item = [item for item in self.items if item.name == name]
        if(len(item) == 0):
            print(f"Item not found in the cart: {name}")
            return 
        self.items.remove(item[0])
        print(f"Item removed from cart: {name}")

    def __str__(self):
        if(len(self.items) == 0):
            return "Cart is empty."
        print("Items in Cart:")
        for i in self.items:
            print(i)
        return f"Total Amount: ${self.CalculateTotalAmount():.2f}"
        
    def CalculateTotalAmount(self):
        totalAmount = 0
        for i in self.items:
            totalAmount+=i.price*i.quantity
        return totalAmount

    def ApplyDiscount(self):
        total = self.CalculateTotalAmount()
        print(f"Total after 10% discount: ${total - (total*(10/100)):.2f}")




        
   
def run():
    item = []
    obj = Cart(item)
    while True:
        try:
            holdInput = input().split(" ")
            if(holdInput[0] == 'Add'):
                name = holdInput[2].strip(",")
                price = float(holdInput[3].strip(","))
                quantity = int(holdInput[4])
                item = Item(name,price,quantity)
                obj.addItem(item)
            elif(holdInput[0] == 'DisplayCart'):
                print(obj)
            elif(holdInput[0] == 'Remove'):
                name = holdInput[2].strip(",")
                obj.RemoveItem(name)
            elif(holdInput[0] == 'ApplyDiscount'):
                obj.ApplyDiscount()

        except EOFError:          
            break     
run()

    