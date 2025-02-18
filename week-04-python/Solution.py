class LuckyBingoBoard:
    def __init__(self,size,board):
        self.size = size
        self.board = board
        self.marks = [[False for i in range(size)] for _ in range(size)]
    
    def mark_number(self,num):
        for i in range(len(self.board)):
            for j in range(len(self.board)):
                if(self.board[i][j] == num):
                    self.marks[i][j] = True
                    self.board[i][j] = -1
                    return
    
    def is_row_complete(self,row):
        for i in range(len(self.board[row])):
            if(self.board[row][i] != -1):
                return False
        return True
    
    def is_column_complete(self,col):
        for i in range(len(self.board[col])):
            if(self.board[i][col] != -1):
                return False
        return True

    def is_main_diagonal_complete(self):
        for i in range(len(self.board)):
            if(self.board[i][i]!= -1):
                return False
        return True
    
    def is_anti_diagonal_complete(self):
        for i in range(len(self.board)):
            if(self.board[i][len(self.board)-i-1]!=-1):
                return False
        return True
    
    def is_cross_complete(self):
        size = int((len(self.board))/2)
        flag = True
        for i in range(len(self.board)):
            if(self.board[i][size]!=-1 ):
                flag = False
        for j in range(len(self.board)):
            if(self.board[size][i]!=-1):
                flag = False
        return flag


    def check_win(self):
        for i in range(len(self.board)):
            if(self.is_row_complete(i)):
                return True
            if(self.is_column_complete(i)):
                
                return True
        if( self.is_main_diagonal_complete()):
            
            return True
        if(self.is_anti_diagonal_complete()):
            
            return True

        return False



    def print_board(self):
        print("Board State:")
        for i in range(self.size):
            print(" ".join("X" if self.marks[i][j] else str(self.board[i][j]) for j in range(self.size)))


class Player:
    def __init__(self,name,board):
        self.name  = name
        self.board:LuckyBingoBoard = board

    def mark_number(self,number):
        self.board.mark_number(number)

    def has_won(self):
        return self.board.check_win()
    

    def display_board(self):
        print(f"{self.name}'s Board:")
        self.board.print_board()


class LuckyBingoGame:
    def __init__(self,players,predefined_numbers):
        self.players:list[Player] = players
        self.predefined_numbers= predefined_numbers
        self.current_index = 0
        self.current_number = 0
        self.predefined_size = len(predefined_numbers)
        self.players_size = len(players)

    def play(self):
        while(True):
                currentPlayer = self.players[self.current_index]
                print(f"{currentPlayer.name} calls number: {self.predefined_numbers[self.current_number]}")
                
                current_number = self.predefined_numbers[self.current_number]
                for i in self.players:
                    i.mark_number(current_number)

                for player in self.players:
                    player.display_board()
                
                if(currentPlayer.has_won() ):
                    print(f"{currentPlayer.name} Wins!")
                    break
                
                self.current_index = (self.current_index+1)%self.players_size
                self.current_number+=1
            
            

                    


