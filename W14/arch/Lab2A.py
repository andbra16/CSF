def jvm(expr):
    operands= "+-*/"
    stack=[]
    theList=expr.split()
    for t in theList:
        if t in operands:
            num2= stack.pop()
            num1= stack.pop()
            if t== "+":
               answer= num1+num2
               stack.append(answer)
            elif t=="-":
                answer= num1-num2
                stack.append(answer)
            elif t=="*":
                answer= num1*num2
                stack.append(answer)
            else:
                answer= num1/num2
                stack.append(answer)
        elif t.isdigit():
            stack.append(int(t))
    return stack
    
expr1 = '5 3 +'
expr2 = '5 3 - 6 +'
print(jvm(expr1))
print(jvm(expr2))
