class BinarySearchST:
    def __init__(self):
        self.keys = []
        self.values = []

    def isEmpty(self):
        return len(self.keys) == 0

    def size(self):
        return len(self.keys)

    def put(self, key, value):
        index = self.rank(key)
        if index < len(self.keys) and self.keys[index] == key:
            self.values[index] = value  # Update existing key
        else:
            self.keys.insert(index, key)
            self.values.insert(index, value)

    def get(self, key):
        if self.isEmpty():
            return None
        index = self.rank(key)
        if index < len(self.keys) and self.keys[index] == key:
            return self.values[index]
        return None

    def contains(self, key):
        return self.get(key) is not None

    def delete(self, key):
        index = self.rank(key)
        if index < len(self.keys) and self.keys[index] == key:
            self.keys.pop(index)
            self.values.pop(index)

    def min(self):
        if self.isEmpty():
            return None
        return self.keys[0]

    def max(self):
        if self.isEmpty():
            return None
        return self.keys[-1]

    def floor(self, key):
        index = self.rank(key)
        if index < len(self.keys) and self.keys[index] == key:
            return self.keys[index]
        if index == 0:
            return None
        return self.keys[index - 1]

    def ceiling(self, key):
        index = self.rank(key)
        if index < len(self.keys):
            return self.keys[index]
        return None

    def rank(self, key):
        lo, hi = 0, len(self.keys) - 1
        while lo <= hi:
            mid = (lo + hi) // 2
            if self.keys[mid] < key:
                lo = mid + 1
            elif self.keys[mid] > key:
                hi = mid - 1
            else:
                return mid
        return lo

    def select(self, rank):
        if rank < 0 or rank >= len(self.keys):
            return None
        return self.keys[rank]

    def deleteMin(self):
        if not self.isEmpty():
            self.keys.pop(0)
            self.values.pop(0)

    def deleteMax(self):
        if not self.isEmpty():
            self.keys.pop(-1)
            self.values.pop(-1)

    def size_range(self, lo, hi):
        if self.isEmpty():
            return 0
        start = self.rank(lo)
        end = self.rank(hi)
        if end < len(self.keys) and self.keys[end] == hi:
            end += 1
        return end - start

    def keys_all(self):
        return self.keys[:]

    def keys_range(self, lo, hi):
        if self.isEmpty():
            return []
        start = self.rank(lo)
        end = self.rank(hi)
        if end < len(self.keys) and self.keys[end] == hi:
            end += 1
        return self.keys[start:end]