import re
class MyString:
    def __init__(self,str=""):
        if(str == ""):
            self.str = ""
        elif(isinstance(str,list)):
            self.str = "".join(str)
        elif(isinstance(str,MyString)):
            self.str =  str
    

    def char_at(self,index):
        return self.str[index]
    
    def substring(self,begin,end = None):
        if(end is None):
            return self.str[begin:]
        return self.str[begin:end]
    
    def compare_to(self,other:'MyString'):
        if(self.str == other.str):
            return 0
        if(self.length() == other.length()):
            for i in range(self.length()):
                if(ord(self.str[i])<ord(other.str[i])):
                    return 1
                return -1
        if(self.length()<other.length()):
            return 1
        return -1

    def compare_to_ignore_case(self,other:'MyString'):
        str1 = self.to_lower_case()
     
        str2 = other.to_lower_case()
        return str1.compare_to(str2)
    
    def equals_ignore_case(self,other:'MyString'):
        str1 = self.to_lower_case()
    
        str2 = other.to_lower_case()
    
        return str1.str == str2.str
    
    def concat(self,other:'MyString'):
        str = self.str + other.str
        return MyString(list(str))
    
    def replace(self,old,new):
        res = []
        for i in range(self.length()):
            if(self.str[i] == old):
                res  +=  new
            else:
                res+= self.str[i] 
        return MyString(res)

    def replace_seq(self,old_seq:'MyString',new_seq:'MyString'):
        c = self.to_char_array().copy()
        for i in range (len(c)):
          if (c[i:i+len (old_seq.to_char_array())] == old_seq.to_char_array()):
            c = c[:1] + new_seq.to_char_array() + c[i + len(old_seq.to_char_array()):]
            return MyString (c)
        return MyString (c)

    def replace_all (self, old_seq, new_seq):
        s = str(MyString (self.to_char_array()))
        m = re.split(old_seq, s)
        return MyString(m)
    
    def replace_first(self, old_seq, new_seq):
        s = str(MyString (self.to_char_array()))
        f = re.findall (old_seq, s)[0]
        return self.replace(f,"")

    def to_char_array(self):
        res = []
        for i in self.str:
            res+=i
        return res
    
    def contains(self,str1:'MyString'):
        return str1.str in self.str
    
    from typing import Union

    def index_of(self, ch):
        return self.index_of_from(ch,0)
        
    def index_of_from(self,ch,index):
        if(isinstance(ch,str)):
          
            for i in range(index,self.length()):
                
                if(self.str[i] == ch):
                    return i
                
            return -1
        if(isinstance(ch,MyString)):
            leng = index+ch.length()
            for i in range(index,self.length()):
                if(self.str[i:leng] == ch.str):
                    return i
                leng=leng+1
            
            return -1

    def last_index_of(self,ch):
        return self.last_index_of_from(ch,self.length()-1)
    
    def last_index_of_from(self, ch, index):
        if isinstance(ch, str):
            for i in range(index, -1, -1):
                if self.str[i] == ch:
                    return i
            return -1
        if isinstance(ch, MyString):
            leng = index + 1
            for i in range(index, -1, -1):
                
                if self.str[i:leng] == ch.str:
                    return i
                leng -= 1
            return -1

    def trim(self):
        start = 0
        end = 0
        for i in range(self.length()):
            if(self.str[i]!=" "):
                start = i
                break
        for i in range(self.length()-1,-1,-1):
            if(self.str[i]!=" "):
                end = i
                break
        
        return MyString(list(self.str[start:end+1]))
    

    def starts_with(self,ch):
        return self.starts_with_from(ch,0)
        return True

    def starts_with_from(self,ch,index):
        pre = self.str[index:index+ch.length()]
        return pre == ch.str
# TODO://implement split properly
    def split(self,delimiter):
        
            res = []
            for i in self.str:
                if(i!=delimiter.str):
                    res+=i
            
            return res
    def split_limit(self,delimiter,index):
        res = []
        init_index = 0
        delimit_index = 0
        dc = 1
        for i in range(index,self.length()):
            if(dc==index):
                break
            if(self.str[i]==delimiter.str):
                delimit_index = i
                dc+=1
            if(self.str[init_index:delimit_index]!=""):
                res.append(self.str[init_index:delimit_index])
            init_index = delimit_index+1
        res.append(self.str[delimit_index+1:self.length()])


       
        return res
    
       
    def is_empty(self):
        return self.length() == 0

    def to_lower_case(self)->'MyString':
        str1 = []
        for i in range(self.length()):
            if(ord(self.str[i])>=65 and ord(self.str[i])<=90):
                str1 += chr(ord(self.str[i])+32)
            else:
                str1+=self.str[i]
        
        return MyString(str1)
    def to_upper_case(self):
        str1 = []
        for i in range(self.length()):
            if(ord(self.str[i])>=97 and ord(self.str[i])<=122):
                str1 += chr(ord(self.str[i])-32)
            else:
                str1+=self.str[i]
        
        return MyString(str1)

    def length(self):
        return len(self.str)
    def __str__(self):
        return f"{self.str}"