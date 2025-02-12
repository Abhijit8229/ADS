class Person:
    def __init__(self,name,games):
        self.name = name
        self.games = games

    def add_game(self,game):
        if game not in self.games:
            self.games.append(game)
            return
    
    def __eq__(self, value):
        return isinstance(value, Person) and value.name == self.name
        
    def remove_game(self,game:str)->None:
        self.games.remove(game)

    def get_favorite_games(self):
        return self.games
    
    def get_name(self):
        return self.name
    
    def __str__(self):
        return f"Person(name={self.name}, games={self.games})"
    


class SocialNetwork:
    def __init__(self):
        self.person = None
        self.users:list[Person] = []
    
    def add_user(self,person):
        if person in self.users:
            print(f"User with name {person.get_name()} already exists.")
        self.users.append(person)
    def remove_user(self,name):
        for i in self.users:
            if i.get_name() == name:
                self.users.remove(i)
                if self.person == i:
                    self.person = None
                return
        print(f"User with name {name} not found.")

    def get_user(self,name):
        for i in self.users:
            if i.get_name().lower() == name.lower():
                return i
        

    def update_person(self,person):
        if(person in self.users):
            self.person = person
            return
        print(f"User {person.name} is not in the network.")


    def get_users_who_like(self,game):
        users = []
        for i in self.users:
            if game in i.get_favorite_games():
                users.append(i.get_name())
        return users
    
    
    def __str__(self):
        users_str = ", ".join(str(user) for user in self.users)
        return f"SocialNetwork(current person={self.person}, users=[{users_str}])"
