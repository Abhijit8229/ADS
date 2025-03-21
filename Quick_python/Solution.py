def partition(lt, lo, hi):
    pivot = lt[lo]
    i = lo + 1
    j = hi
    while True:
        while i <= j and lt[i] <= pivot:
            i += 1
        while i <= j and lt[j] >= pivot:
            j -= 1
        if i <= j:
            lt[i], lt[j] = lt[j], lt[i]
        else:
            break
    lt[lo], lt[j] = lt[j], lt[lo]
    return j

def quickSort(lt, lo, hi):
    if lo >= hi:
        return
    j = partition(lt, lo, hi)
    quickSort(lt, lo, j - 1)
    quickSort(lt, j + 1, hi)



lt = []
try:
    while(True):
        inp = input()
        lt.extend(inp.split())
except EOFError:
    quickSort(lt, 0, len(lt) - 1)
    for i in lt:
        print(i)
