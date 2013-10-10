# Name: Brandon Anderson
# Evergreen Login: andbra16
# Computer Science Foundations
# Programming as a Way of Life
# Homework 2

# You may do your work by editing this file, or by typing code at the
# command line and copying it into the appropriate part of this file when
# you are done.  When you are done, running this file should compute and
# print the answers to all the problems.


###
### Problem 1
###

# DO NOT CHANGE THE FOLLOWING LINE
print "Problem 1 solution follows:"

from hw2_test import* #imports variable n from hw2_test

count = 1 
total = 0
while n > 0: # if n is great than 0 it enters  the loop
    total = total + count #adds the previous sum to the running count
    count = count+1 # establishes a running count
    n = n-1 
print total
    
###
### Problem 2
###

# DO NOT CHANGE THE FOLLOWING LINE
print "Problem 2 solution follows:"


for i in range(2, 11): # runs the loop for numbers 1-10
    i = i/1.0 #turns i into type float
    print 1/i

###
### Problem 3
###

# DO NOT CHANGE THE FOLLOWING LINE
print "Problem 3 solution follows:"

n = 10
triangular = 0
for i in range (n+1):
    triangular = triangular+i
print "Triangular number", n, "via loop:", triangular
print "Triangular number", n, "via formula:", n*(n+1)/2

###
### Problem 4
###

# DO NOT CHANGE THE FOLLOWING LINE
print "Problem 4 solution follows:"

n=10
multi=1
for i in range(n):
    multi= multi*(i+1) #makes multi equal the previous multi times the running count
if n == 0: # if the factorial is 0! print multi-1 or else just print multi
    print multi-1
else:
    print multi
    

###
### Problem 5
###

# DO NOT CHANGE THE FOLLOWING LINE
print "Problem 5 solution follows:"

n=10
facto=1
for i in range(n):
    facto=1 #resets facto after it has gone through second for loop
    x= n
    x = n-i #reduces the range of x by 1 each time
    for j in range(x):
         facto= facto*(j+1) #creates the factorial
    print facto

###
### Problem 6
###

# DO NOT CHANGE THE FOLLOWING LINE
print "Problem 6 solution follows:"
facto=1
add=1
for i in range(n):
    add = add+(1/facto) #adds the previous factorial to the new one
    facto=1
    x= n
    x = n-i
    for j in range(x):
         facto= facto*(j+1)/1.0
print add


#for j in range(n):
    #facto= facto*(j+1)/1.0
    #add= add+(1/facto)
#print add
###
### Collaboration
###

# ... List your collaborators and other sources of help here (websites, books, etc.),
# ... as a comment (on a line starting with "#").

###
### Reflection
###

# ... Write how long this assignment took you, including doing all the readings
# ... and tutorials linked to from the homework page. Did the readings, tutorials,
# ... and lecture contain everything you needed to complete this assignment?
