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
    




def customsort(s1: Team, s2: Team):
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


                 
def main():
    
    lt = []
    while(True):
        try:
                s = input().split(",")
                t = Team(s[0],int(s[1]),int(s[2]),int(s[3]),int(s[4]),int(s[5]))
                lt.append(t)

        except EOFError:
             break
    lt.sort(key=cmp_to_key(customsort))
    print("Sorted Leaderboard:")
    s = "\n".join(str(team) for team in lt)
    print(s)

main()