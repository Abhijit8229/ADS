class complexnumber:
    def __init__(self,real,img):
        self.real = real
        self.img = img


class ComplexNumberManager:
    def __init__(self,number:complexnumber):
        self.real =  number.real
        self.img = number.img
        self.console("Initialized: ")
        
    def add(self,real,img):
        self.real += real
        self.img += img
        self.console("After addition: ")

    def sub(self, real, img):
        self.real -= real
        self.img -= img
        self.console("After subtraction: ")

    def conjugate(self):
        self.img = -self.img
        self.console("Conjugate: ")

    def multiply(self, real, img):
        new_real = (self.real * real) - (self.img * img)
        new_img = (self.real * img) + (self.img * real)
        self.real = new_real
        self.img = new_img
        self.console("After multiplication: ")

    def divide(self, real, img):
        denominator = real ** 2 + img ** 2
        if(denominator==0):
            print("Error: Division by zero is not allowed.")
            return
        new_real = ((self.real * real) + (self.img * img)) / denominator
        new_img = ((self.img * real) - (self.real * img)) / denominator
        self.real = new_real
        self.img = new_img
        self.console("After division: ")

    def modulus(self):
        print(f"Modulus: {(self.real ** 2 + self.img ** 2) ** 0.5}")

    def console(self,st):
        if(self.img<0):
            print(f"{st}{self.real} - {-self.img}i")
        else:
            print(f"{st}{self.real} + {self.img}i")

def run():
    holdInput = input().split(" ")
    command = holdInput[0]
    real, img = holdInput[1].split(",")
    number = complexnumber(float(real), float(img))
    obj = ComplexNumberManager(number)
    while True:
        try:
            holdInput = input().split(" ")
            command = holdInput[0]
            real, img = holdInput[1].split(",")
            real, img = float(real), float(img)

            if command == "add":
                obj.add(real, img)
            elif command == "subtract":
                obj.sub(real, img)
            elif command == "conjugate":
                obj.conjugate()
            elif command == "multiply":
                obj.multiply(real, img)
            elif command == "divide":
                obj.divide(real, img)
            elif command == "modulus":
                obj.modulus()
        except Exception as e:
            break 

run()