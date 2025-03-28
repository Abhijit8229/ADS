import sys
import io
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8')

class Term:
    def __init__(self, query, weight):
        self.query = query
        self.weight = weight

    def __repr__(self):
        return f"{self.weight}	{self.query}"

    
    def __lt__(self, other):
        return self.query < other.query
    
    @staticmethod
    def by_reverse_weight_order(term):
        return -term.weight


class BinarySearchDeluxe:
    @staticmethod
    def first_index_of(terms, prefix):
        
        low, high = 0, len(terms) - 1
        first_index = -1
        while low <= high:
            mid = (low + high) // 2
            if terms[mid].query.startswith(prefix):
                first_index = mid
                high = mid - 1
            elif terms[mid].query < prefix:
                low = mid + 1
            else:
                high = mid - 1
        return first_index

    @staticmethod
    def last_index_of(terms, prefix):
        low, high = 0, len(terms) - 1
        last_index = -1
        while low <= high:
            mid = (low + high) // 2
            if terms[mid].query.startswith(prefix):
                last_index = mid
                low = mid + 1 
            elif terms[mid].query < prefix:
                low = mid + 1
            else:
                high = mid - 1
        return last_index


class Autocomplete:
    def __init__(self, terms):
        self.terms = sorted(terms)  

    def all_matches(self, prefix):
        
        first = BinarySearchDeluxe.first_index_of(self.terms, prefix)
        last = BinarySearchDeluxe.last_index_of(self.terms, prefix)

        if first == -1 or last == -1:  
            return []

       
        matching_terms = self.terms[first:last+1]
        return sorted(matching_terms, key=Term.by_reverse_weight_order)

    def number_of_matches(self, prefix):
        first = BinarySearchDeluxe.first_index_of(self.terms, prefix)
        last = BinarySearchDeluxe.last_index_of(self.terms, prefix)
        if first == -1 or last == -1:
            return 0
        return last - first + 1

def read_file(filename):
    with open(filename, 'r', encoding='utf-8') as file:
        n = int(file.readline().strip()) 
        terms = []
        for _ in range(n):
            line = file.readline().strip().split('\t')
            weight = int(line[0])
            query = line[1]
            terms.append(Term(query, weight))
        return terms
def main():
    filename = input().strip()
    terms = read_file(filename)
    k = int(input().strip())
    autocomplete = Autocomplete(terms)

    while True:
        try:
            prefix = input().strip()
            results = autocomplete.all_matches(prefix)
            print(f"{autocomplete.number_of_matches(prefix)} matches")
            for i in range(min(k, len(results))):
                print(results[i])
        except EOFError:
            break


main()