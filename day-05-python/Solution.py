class Account:
    def __init__(self,accountNumber,accountHolder:'Person',balance):
        self.accountNumber = accountNumber
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

class Person:
    def __init__(self,personId,personName):
        self.person_id = personId
        self.person_name = personName
        self.accounts:list[Account] = []

    def addAccount(self,account:Account):
        self.accounts.append(account)

    def getAccounts(self):
        return self.accounts
    
class SavingsAccount(Account):
    def __init__(self, accountNumber, accountHolder:Person, balance,interst):
        super().__init__(accountNumber, accountHolder, balance)
        self.intrest = interst
        

    def calculateInterest(self):
        return self.balance*self.intrest
    
class CurrentAccount(Account):
    def __init__(self, accountNumber, accountHolder:Person, balance,overdraft_limit):
        super().__init__(accountNumber, accountHolder, balance)
        self.overdraft_limit = overdraft_limit

    def withdraw(self,amount):
        if(abs(self.balance-amount)<self.overdraft_limit):
            self.balance-=amount
            return True
        return False
class LoanAccount(Account):
    def __init__(self, accountNumber, accountHolder:Person, balance,interest):
        super().__init__(accountNumber, accountHolder, balance)
        self.interest = interest

    def repay(self,amount):
        if(amount>0):
            self.balance-=amount
            return True
        return False

    def calculateInterest(self):
        return self.balance*self.interest
    
    def getOutstandingLoan(self):
        return self.balance
      
class Bank:
    def __init__(self):
        self.accounts:list[Account] = []

    def addAccount(self,account:Account):
        self.accounts.append(account)
    
    def findAccount(self,accountNumber):
        account = next((i for i in self.accounts if i.accountNumber == accountNumber), None)
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
    


class Transaction:
    def __init__(self,transactionId,accountNumber,transactionType,amount,transactionDate):
        self.transaction_id = transactionId
        self.account_number = accountNumber
        self.transaction_type = transactionType
        self.amount = amount
        self.transaction_date = transactionDate
    
    def __str__(self):
        return f"Transaction ID: {self.transaction_id}, Account Number: {self.account_number}, Transaction Type: {self.transaction_type}, Amount: {self.amount}, Date: {self.transaction_date}"