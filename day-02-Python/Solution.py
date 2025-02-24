class Account:
    def __init__(self,accountNumber,accountHolder,balance):
        self.account_number = accountNumber
        self.account_holder = accountHolder
        self.balance = balance
    
    def deposit(self,amount):
        if(amount>0):
            self.balance+=amount
            return True
        return False
            

    def withdraw(self,amount):
        if(self.balance>amount):
            self.balance-=amount
            return True
        return False

    def getBalance(self):
        return self.balance
    
class SavingsAccount(Account):
    def __init__(self, accountNumber, accountHolder, balance,interst):
        super().__init__(accountNumber, accountHolder, balance)
        self.intrest = interst

    def calculateInterest(self):
        return self.balance*self.intrest
    
class CurrentAccount(Account):
    def __init__(self, accountNumber, accountHolder, balance,overdraft_limit):
        super().__init__(accountNumber, accountHolder, balance)
        self.overdraft_limit = overdraft_limit

    def withdraw(self,amount):
        if(abs(self.balance-amount)<self.overdraft_limit):
            self.balance-=amount
            return True
        return False
      

    
    
