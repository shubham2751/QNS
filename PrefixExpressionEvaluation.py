# Prefix Expression Evaluation

def ans(s):
    
    l = []
    
    for i in range(len(s)-1, -1, -1): # Right to Left
        
        if s[i] >= '0' and s[i] <= '9':
            l.append(int(s[i]))
        
        else:
            
            op1 = l.pop()
            op2 = l.pop()
            
            oper = s[i]
            
            l.append(operator(op1, op2, oper))
            
    return l[0]

def operator(op1, op2, s):
    
    d = { '+' : lambda op1, op2 : op1 + op2,
           '-' : lambda op1, op2 : op1 - op2,
           '*' : lambda op1, op2 : op1 * op2,
           '//' : lambda op1, op2 : op1 // op2
        }
        
    # print(d.get(s)(op1, op2) , "lam")
    return d.get(s)(op1, op2)

s = "-+7*45+20"

print(ans(s))
