def hasBalancedParentheses(s):
    stack  = []
    for i in s:
        if(i == "("):
            stack.append("(")
        elif(i == ')'):
            if stack:
                stack.pop()
            else:
                return False
    
    return len(stack) == 0

print( hasBalancedParentheses((input())))

