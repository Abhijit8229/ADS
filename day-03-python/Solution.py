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
      
class Bank:
    def __init__(self):
        self.accounts:list[Account] = []

    def addAccount(self,account:Account):
        self.accounts.append(account)
    
    def findAccount(self,accountNumber):
        account = next((i for i in self.accounts if i.account_number == accountNumber), None)
        if(account):
            return account
        return None
    def transfer(self,sourceAccountNumber,destinationAccountNumber,amount):
        sourceAccount = self.findAccount(sourceAccountNumber)
        destinationAccount = self.findAccount(destinationAccountNumber)
        if(sourceAccount and destinationAccount):
            if(sourceAccount.withdraw(amount)):
                destinationAccount.deposit(amount)
                return True
        return False
    