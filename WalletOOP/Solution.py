class Transaction:
    def __init__(self,type,amount,fee):
        self.type = type
        self.amount = amount
        self.fee = fee

    def __str__(self):
        return f"{self.type} {self.amount:.1f} (Fee: {self.fee:.1f})"


class Wallet:
    
   
    def __init__(self,withdrawalLimit:float,withdrawalFeePercentage:float)->None:
        self.withdrawalLimit = withdrawalLimit
        self.withdrawalFeePercentage = withdrawalFeePercentage
        print(f"Wallet initialized with withdrawalLimit: {withdrawalLimit:.1f}, withdrawalFeePercentage: {withdrawalFeePercentage:.1f}%")
        self.transactions = []
        self.balance = 0.0
        


    def  deposit(self,amount:float)->bool:
        if(amount<=0):
            print(f"Deposit of {amount:.1f} failed. Balance remains: {self.balance:.1f}")
            return False
        self.transactions.append(Transaction("DEPOSIT",amount,0.0)) 
        self.balance+=amount
        print(f"Deposit of {amount:.1f} successful. Current balance: {self.balance:.1f}")
        return True
    

    def withdraw(self,amount: float) -> bool:
        if(amount>self.balance or amount<=0 or amount>self.withdrawalLimit) :
            print(f"Withdrawal of {amount:.1f} failed. Balance remains: {self.balance:.1f}")
            return False
        
        withdrawalfee = amount*(self.withdrawalFeePercentage/100)
        self.transactions.append(Transaction("WITHDRAW",amount,withdrawalfee)) 
        self.balance-=(amount+withdrawalfee)
        print(f"Withdrawal of {amount:.1f} successful with a fee of {withdrawalfee:.1f}. Current balance: {self.balance:.1f}")
        return True
    

    def getBalance(self) -> float:
        print(f"Current Balance: {self.balance:.1f}")
        return self.balance
    

    def getTransactions(self):
        print("Transaction History:")
        for i in range(0,len(self.transactions)):
            print(f"{i+1}. {self.transactions[i]}")
        return self.transactions
    
        
    
    
def run():
    holdInput = input().split(" ")
    obj = Wallet(float(holdInput[0]),float(holdInput[1]))
    while True:
        try:
            hldInput = input().split(" ")
            if(hldInput[0] == "deposit"):
                obj.deposit(float(hldInput[1]))
            elif(hldInput[0] == "withdraw"):
                obj.withdraw(float(hldInput[1]))
            elif(hldInput[0] == "getBalance"):
               obj.getBalance()
            elif(hldInput[0] == "getTransactions"):
                obj.getTransactions()
            

        except EOFError:
            break

    
   

    

run()
