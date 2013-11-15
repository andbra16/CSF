n= 6
series= "sum"

#if the string(series) is fibonnaci 
if series == "fibonnaci":
    a=1
    b=0
    
    #calculates fibonnaci to the nth number
    for i in range(n):
        c = a + b
        print c
        a=b
        b=c
        
#if the string(series) is sum
elif series == "sum":
    number=0
    sums=0
    
    #finds the sum of the multiples of 3 to the nth number
    for i in range(n): 
        number= 3*(i+1) #(i+1) because i starts at 0
        sums= number+sums
    print sums
    
#if the string(series) isn't fib or sum 
else:
    print "Invalid string"
        