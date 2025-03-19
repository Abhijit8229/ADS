import abc
from typing import TypeVar, Generic, List, Collection, Optional

T = TypeVar('T')

class ListADT(Generic[T], abc.ABC):
    def __init__(self):
        self.size = 0
        self.data: List[Optional[T]] = []

    @abc.abstractmethod
    def add(self, value: T) -> None:
        pass

    @abc.abstractmethod
    def add_at(self, index: int, value: T) -> None:
        pass

    @abc.abstractmethod
    def add_all_at(self, index: int, collection: Collection[T]) -> None:
        pass

    @abc.abstractmethod
    def add_all(self, collection: Collection[T]) -> None:
        pass

    @abc.abstractmethod
    def contains(self, value: T) -> bool:
        pass

    @abc.abstractmethod
    def get(self, index: int) -> T:
        pass

    @abc.abstractmethod
    def index_of(self, element: T) -> int:
        pass

    @abc.abstractmethod
    def last_index_of(self, element: T) -> int:
        pass

    @abc.abstractmethod
    def ensure_capacity(self, capacity: int) -> None:
        pass

    @abc.abstractmethod
    def is_empty(self) -> bool:
        pass

    @abc.abstractmethod
    def size_(self) -> int:
        pass

    @abc.abstractmethod
    def clear(self) -> None:
        pass

    @abc.abstractmethod
    def remove_at(self, index: int) -> Optional[T]:
        pass

    @abc.abstractmethod
    def remove(self, element: T) -> Optional[T]:
        pass

    @abc.abstractmethod
    def set(self, index: int, element: T) -> T:
        pass

    @abc.abstractmethod
    def trim_to_size(self) -> None:
        pass

    @abc.abstractmethod
    def __str__(self) -> str:
        pass

class ArrayListADT(ListADT[T]):
    def __init__(self):
        super().__init__()

    def __fix_size(self):
        self.data = [i for i in self.data if i is not None]
        self.size = len(self.data)
        return self.data

    def add(self, value) -> None:
        self.data = self.__fix_size()
        self.data.append(value)
        self.size = len(self.data)

    def add_at(self, index, value) -> None:
        self.data = self.__fix_size()
        if index == len(self.data):
            self.data.append(value)
        else:
            self.data.insert(index, value)
        self.size = len(self.data)

    def add_all_at(self, index: int, collection) -> None:
        self.data = self.__fix_size()
        for i in collection:
            self.add_at(index, i)
            index += 1
        self.size = len(self.data)

    def add_all(self, collection: Collection[T]) -> None:
        self.add_all_at(len(self.data), collection)

    def contains(self, value):
        return value in self.data
    
    def get(self, index) :
        return self.data[index]
    
    def index_of(self, element):
        ele = -1
        try:
            for i in range(len(self.data)):
                if self.data[i] == element:
                    ele = i
            return ele
        except ValueError:
            return -1
    
    def last_index_of(self, element):
        try:
            return len(self.data) - 1 - self.data[::-1].index(element)
        except ValueError:
            return -1
    
    def ensure_capacity(self, capacity):
        if capacity > len(self.data):
            self.data.extend([None] * (capacity - len(self.data)))
    
    def is_empty(self) -> bool:
        return len(self.data) == 0
    
    def size_(self) -> int:
        return len(self.data)
    
    def clear(self) -> None:
        self.data = []
        self.size = 0

    def remove_at(self, index):
        if 0 <= index < len(self.data):
            removed_element = self.data[index]
            self.data = self.data[:index] + self.data[index+1:]
            self.size -= 1
            return removed_element
        return None
    
    def remove(self, element: T) -> Optional[T]:
        index = self.index_of(element)
        if index != -1:
            return self.remove_at(index)
        return None
    
    def set(self, index: int, element: T) -> T:
        self.data[index] = element
        return element
    
    def trim_to_size(self) -> None:
        self.data = self.__fix_size()

    def __str__(self) -> str:
        return str(self.data)
    



class Stack:
    def __init__(self):
        self.stack = ArrayListADT()

    def push(self, value):
        self.stack.add(value)
        return value
    def pop(self):
        if self.stack.is_empty():
            raise IndexError("Stack is empty")
        return self.stack.remove_at(self.stack.size_() - 1)
    
    def peek(self):
        if self.stack.is_empty():
            raise IndexError("Stack is empty")
        return self.stack.get(self.stack.size_() - 1)
    
    def empty(self):
        return self.stack.is_empty()
    
    def search(self, value):
        index = self.stack.index_of(value)
        if index != -1:
            return self.stack.size_() - index
        return -1
    
    def __str__(self):
        return str(self.stack)
    def __len__(self):
        return self.stack.size_()
    def __iter__(self):
        for item in self.stack.data:
            yield item
    def __contains__(self, value):
        return self.stack.contains(value)
    def __getitem__(self, index):
        return self.stack.get(index)
    def __setitem__(self, index, value):
        self.stack.set(index, value)
    def __delitem__(self, index):
        self.stack.remove_at(index)
    def __eq__(self, other):
        if isinstance(other, Stack):
            return self.stack.data == other.stack.data
        return False