class SelectionSort():
    def __init__(self,lst):
        self.lst = lst

    def selectionsort(self):
        n  = len(self.lst)
        for i in range(n):
            mid = i
            for j in range(i+1,n):
                if(self.lst[mid]>self.lst[j]):
                    mid = j
            print(f"{self.lst}||swap:{i},{mid}||iter:{i}")
            self.lst[mid],self.lst[i] = self.lst[i],self.lst[mid]
    
    def get_sorted_list(self):
        return self.lst




def main():
    lt = []
    while True:
        try:
            inp = input().strip()
            lt.append(inp)
        except:
            break
    lt = SelectionSort(lt)
    lt.selectionsort()
    for i in lt.get_sorted_list():
        print(i)

lt = SelectionSort(['A','B','H','I','J','I','T','B','H','A','R','A','D','W','A','J'])
    
lt.selectionsort()
for i in lt.get_sorted_list():
        print(i)

