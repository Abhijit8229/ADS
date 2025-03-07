# Solution.py

class NegativeAmountException(Exception):
    
    pass


class InsufficientFundsException(Exception):
   
    pass


class BankAccount:
    def __init__(self, initial_balance=0):
        if initial_balance < 0:
            raise NegativeAmountException("Initial balance cannot be negative.")
        self.balance = initial_balance

    def deposit(self, amount):
        if amount < 0:
            raise NegativeAmountException("Deposit amount cannot be negative.")
        self.balance += amount

    def withdraw(self, amount):
        if amount < 0:
            raise NegativeAmountException("Withdrawal amount cannot be negative.")
        if amount > self.balance:
            raise InsufficientFundsException("Insufficient funds for withdrawal.")
        self.balance -= amount

    def get_balance(self):
        return self.balance
