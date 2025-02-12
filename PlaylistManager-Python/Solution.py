class Song:
    def __init__(self,title:str,artist:str,album:str,genre:str,duration:int):
        self.title:str = title
        self.artist = artist
        self.album = album
        self.genre = genre
        self.duration = duration

    def display_details(self):
        return f"Title: {self.title}, Artist: {self.artist}, Album: {self.album}, Genre: {self.genre}, Duration:{self.duration}s"
    
    
class Playlist:
    def __init__(self,name:str):
        self.name = name
        self.songs:list[Song] = []

    def add_song(self,song:Song):
        self.songs.append(song)
    
    def remove_song(self,identifier:str):
        for i in self.songs:
            if((identifier == i.title )or (identifier == i.album ) or (identifier == i.artist ) or (identifier == i.genre ) ):
                self.songs.remove(i)
                return True
        return False
    

    def get_songs(self):
        return self.songs
    


    def filter_songs(self, criteria:str, value:str):
        lt = []
        if(criteria == "artist"):
            for i in self.songs:
                if(i.artist == value):
                    lt.append(i)
            return lt
        if(criteria == "title"):
            for i in self.songs:
                if(i.title == value):
                    lt.append(i)
            return lt
        if(criteria == "album"):
            for i in self.songs:
                if(i.album == value):
                    lt.append(i)
            return lt
        
        if(criteria == "genre"):
            for i in self.songs:
                if(i.genre == value):
                    lt.append(i)
            return lt
        

    def search_songs(self,keyword:str):
        lt = []
        for i in self.songs:
            if((keyword.lower() == i.title.lower() )or(keyword.lower() == i.album.lower() )or(keyword.lower() == i.artist.lower() )or(keyword.lower() == i.genre.lower() )):
                # print(i.title)
                lt.append(i)
        return lt
    

class PlaylistManager:
    def __init__(self):
        self.playlists:list[Playlist]= []

    def create_playlist(self,name:str):
        self.playlists.append(Playlist(name))
    

    def delete_playlist(self,name):
        for i in self.playlists:
            if i.name == name:
                self.playlists.remove(i)
                return True
        return False
    

    def get_playlist(self,name):
        for i in self.playlists:
            if(i.name == name):
                return i
        return None
    
    def list_playlists(self):
        return self.playlists
    

    def cross_playlist_search(self, keyword:str):
        lt = []
        for i in self.playlists:
            songs = i.search_songs(keyword)
            lt.extend(songs)
        return lt
    
