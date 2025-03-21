def Insertionsort(arr):
    n =  len(arr)
    it = 0
    for i in range(n):
        for j in range(i,0,-1):
            if(arr[j]>arr[j-1]):
                break
            it+=1
            print(f"{arr}||{arr[j-1]}||{arr[j]}||{it}")
            arr[j-1],arr[j] = arr[j],arr[j-1]
    return arr
def main():
    lt = []
    try:
        while True:
            inp = input().strip()
            lt.append(inp)
    except:
        lt = Insertionsort(lt)
        for i in lt:
            print(i)


# main()

s = "sadhvik"
lt = Insertionsort(list(s))


