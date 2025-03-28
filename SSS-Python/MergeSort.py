def merge(a,aur,lo,hi,mid):
    i,j = lo,mid+1
    for k in range(lo,hi+1):
        if(i>mid):
            a[k]  = aur[j]
            j+=1
        elif(j>hi):
            a[k] = aur[i]
            i+=1
        elif(aur[i]<aur[j]):
            a[k] = aur[j]
            j+=1
        else:
            a[k] = aur[i]
            i+=1
def sort(a,lo,hi):
    if(lo>=hi):
        return 
    mid = (lo+hi)//2
    sort(a,lo,mid)
    sort(a,mid+1,hi)
    aur = a[:]
    merge(a,aur,lo,hi,mid)

lt = [8, 5 ,15,3,1,10,20,1]
sort(lt,0,len(lt)-1)
for i in lt:
    print(i)


# def merge(a,aur,lo,hi,mid):
#     i,j = lo,mid+1
#     for k in range(lo,hi+1):
#         if(i>mid):
#             a[k]  = aur[j]
#             j+=1
#         elif(j>hi):
#             a[k] = aur[i]
#             i+=1
#         elif(aur[i]<aur[j]):
#             a[k] = aur[i]
#             i+=1
#         else:
#             a[k] = aur[j]
#             j+=1
# def sort(a,lo,hi):
#     if(lo>=hi):
#         return 
#     mid = (lo+hi)//2
#     sort(a,lo,mid)
#     sort(a,mid+1,hi)
#     aur = a[:]
#     merge(a,aur,lo,hi,mid)

# lt = [8, 5 ,15,3,1,10,20,1]
# sort(lt,0,len(lt)-1)
# for i in lt:
#     print(i)