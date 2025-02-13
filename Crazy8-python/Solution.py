# Card Class
class Card:
    def __init__(self,suit,rank):
        self.suit = suit
        self.rank = rank
    


    def matches(self,other):
        return other.suit == self.suit or other.rank == self.rank
    
    def __eq__(self, value):
        return (isinstance(value,Card) and ((value.rank == self.rank) and value.suit == self.suit))
        
    def __str__(self):
        return f"{self.rank} of {self.suit}"

# Deck Class (without using random.shuffle)
class Deck:
    def __init__(self):
        self.cards:list[Card]=[]
        suits = ["Hearts","Diamonds","Clubs","Spades"]
        ranks = ["2","3","4","5","6","7","8","9","10","J","Q","K","A"]
        for i in range(len(suits)):
            for j in range(len(ranks)):
                self.cards.append(Card(suits[i],ranks[j]))
           
            
        
        self.manual_shuffle()


    def manual_shuffle(self):
        shuffled = []
        while len(self.cards) > 0:
            mid = len(self.cards) // 2  
            shuffled.append(self.cards.pop(mid))  
        self.cards = shuffled
    
    def draw_card(self):
        return self.cards.pop(0)
    
    def is_empty(self):
        return len(self.cards) == 0
    




class Hand:
    def __init__(self):
        self.cards = []
    
    def add_card(self,Card:Card):
        self.cards.append(Card)

    def remove_card(self,card:Card):
        if(card in self.cards):
            self.cards.remove(card)
            return True
        return False
    
    def play_card(self,card:Card):
        for i in self.cards:
            if(i.matches(card)):
                    self.cards.remove(i)
                    return i
        return None

    def hasCards(self):
        return len(self.cards) > 0
    
    def __str__(self):
        return ', '.join(str(card) for card in self.cards)

# Player Class
class Player:
    def __init__(self,playerName):
        self.name = playerName
        self.isHuman = False
        self.hand = Hand()

    def draw_card(self,deck:Deck):
        self.hand.add_card(deck.draw_card())
    
    def play_turn(self,topCard:Card,deck:Deck):
        
        card = self.hand.play_card(topCard)
        if card:
            return card
        else:
            return None
    def has_won(self):
        return len(self.hand.cards) == 0
    
    def __str__(self):
        return f"{self.name}: {self.hand}"

# Game Class
class Game:
    def __init__(self,numplayers):
        self.numPlayers = numplayers
        self.players = []
        self.currentPlayer = 0
        self.deck:Deck = Deck()
        self.topCard = self.deck.draw_card()
    
    
    def start_game(self):
        player_1 = Player("Player 1")
        player_1.isHuman = True
        player_2 = Player("Player 2")
        for i in range(6,11):
            player_1.draw_card((self.deck))
        for j in range(0,5):
            player_2.draw_card((self.deck))
        player_2.isHuman = False
        self.players.append(player_1)
        self.players.append(player_2)
        
        
    def play_game(self):
        self.start_game()   
        print()
        while True:
            currentPlayer = self.players[self.currentPlayer]
            
            play = currentPlayer.play_turn(self.topCard,self.deck)
            if play:
                print(f"{currentPlayer.name}'s Turn. Top Card: {self.topCard}")
                print(f"{currentPlayer.name} played: {play}")
                self.topCard = play
                if currentPlayer.has_won():
                    print()
                    print(f"{currentPlayer.name} wins the game!")
                    break
            else:
                print(f"{currentPlayer.name}'s Turn. Top Card: {self.topCard}")
                currentPlayer.draw_card(self.deck)
                print(f"{currentPlayer.name} had to draw a card.")
            self.currentPlayer = (self.currentPlayer + 1) % 2
            print()

            
        
        

