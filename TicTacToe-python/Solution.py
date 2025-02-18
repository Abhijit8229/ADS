class Board:
    def __init__(self, size):
        self.size = size
        self.grid = [[' ' for _ in range(size)] for _ in range(size)]

    def is_valid_move(self, row, col):
        return 0 <= row < self.size and 0 <= col < self.size and self.grid[row][col] == ' '

    def place_move(self, row, col, symbol):
        if self.is_valid_move(row, col):
            self.grid[row][col] = symbol
            return True
        return False

    def check_win(self, symbol):
        # Check rows and columns
        for i in range(self.size):
            if all(self.grid[i][j] == symbol for j in range(self.size)):
                return True
            if all(self.grid[j][i] == symbol for j in range(self.size)):
                return True
        
        # Check main diagonal
        if all(self.grid[i][i] == symbol for i in range(self.size)):
            return True
        
        # Check anti-diagonal
        if all(self.grid[i][self.size - i - 1] == symbol for i in range(self.size)):
            return True
        
        return False

    def check_draw(self):
        return all(self.grid[i][j] != ' ' for i in range(self.size) for j in range(self.size)) and not (self.check_win('X') or self.check_win('O'))

class Player:
    pass
class Game:
    pass