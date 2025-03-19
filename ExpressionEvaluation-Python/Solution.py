def stackcal(exp:str):
    exp = exp.split()
    stack = []
    ans = 0
    op = {"+","-","*","/"}
    for i in exp:
        if(i.isdigit()):
            stack.append(float(i))
        elif(i in op):
            stack.append(i)
        elif i == ")":
            operand2 = stack.pop()
            operator = stack.pop()
            operand1 = stack.pop()
            if operator == "+":
                stack.append(operand1 + operand2)
            elif operator == "-":
                stack.append(operand1 - operand2)
            elif operator == "*":
                stack.append(operand1 * operand2)
            elif operator == "/":
                stack.append(operand1 / operand2)
            

                
               
    # ans = stack.pop()   
    print(stack.pop())
                    
    

stackcal(input())