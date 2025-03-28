from functools import cmp_to_key
class Team:
    def __init__(self,team_name,wins,losses,draws,no_result,points):
        self.name = team_name
        self.points = points
        self.wins = wins
        self.losses = losses
        self.draws  = draws
        self.no_result = no_result
    def __repr__(self):
         return f"{self.name}: Points={self.points}, Wins={self.wins}, Losses={self.losses}, Draws={self.draws}, NoResult={self.no_result}"
    
    @staticmethod
    def customsort(s1, s2):
            if s1.points != s2.points:
                return s2.points - s1.points  
            if s1.wins != s2.wins:
                return s2.wins - s1.wins  
            if s1.losses != s2.losses:
                return s1.losses - s2.losses  
            if s1.draws != s2.draws:
                return s2.draws - s1.draws 
            if s1.no_result != s2.no_result:
                return s1.no_result - s2.no_result  
            return -1 if s1.name < s2.name else (1 if s1.name > s2.name else 0) 
    
class binaryHeap:
    def __init__(self):
        self.l = []
        self.__size = 0

    def add(self, value):
        self.l.append(value)
        self.__size+=1
        self.swim(self.__size-1)

    def swim(self, i):
        while i > 0 :
            parent = (i-1)//2
            if Team.customsort(self.l[i],self.l[parent])<0:
                self.l[i], self.l[parent] = self.l[parent], self.l[i]
                i = parent
            else:
                break

    def poll(self):
        r = self.l[0]
        self.l[0] = self.l[self.__size - 1]
        self.__size -= 1
        self.l.pop()
        self.sink(0)
        return r

    def sink(self, i):
        n = len(self.l)
        largest = i
        left = 2 * i + 1
        right = 2 * i + 2

        if left < n and Team.customsort(self.l[left], self.l[largest]) < 0:
            largest = left
        if right < n and Team.customsort(self.l[right], self.l[largest]) < 0:
            largest = right

        if largest != i:
            self.l[i], self.l[largest] = self.l[largest], self.l[i]
            self.sink(largest)


def main():
    lt = []
    inp = int(input())
    while(True):
        try:
                s = input().split(",")
                t = Team(s[0],int(s[1]),int(s[2]),int(s[3]),int(s[4]),int(s[5]))
                lt.append(t)
        except EOFError:
             break
    pq = binaryHeap()
    for team in lt:
        pq.add(team)
    
    print(f"Top {inp} teams:")
    for i in range(inp):
        print(pq.poll())
        

   
main()