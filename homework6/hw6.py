# Name: Brandon Anderson
# Evergreen Login: andbra16
# Computer Science Foundations
# Programming as a Way of Life
# Homework 6

# You may do your work by editing this file, or by typing code at the
# command line and copying it into the appropriate part of this file when
# you are done.  When you are done, running this file should compute and
# print the answers to all the problems.


###
### Problem 3
###

# DO NOT CHANGE THE FOLLOWING LINE
print "Problem 3 solution follows:"

a=2
b=3
#assert a==b

# the assert statement makes a boolean statement:
# if your assertion is true, the program runs.
# if your assertion is false, the program gets an
# assertion error.

###
### Problem 4
###

# DO NOT CHANGE THE FOLLOWING LINE
print "Problem 4 solution follows:"

def add(x, y):
    numbSum= x+y
    return numbSum

total= add(a,b)
print total

# You can identify a function if you see a variable
# that has arguments that need to be passed to it
# (anything with a name and parenthesis that take arguments)
# For example: a(x, y), sum(a, b, c, d) would be functions


###
### Problem 5
###

# DO NOT CHANGE THE FOLLOWING LINE
print "Problem 5 solution follows:"

v={"a": a, "b": b}

assert v=={"a":2, "b":3}


###
### Problem 6
###

# DO NOT CHANGE THE FOLLOWING LINE
print "Problem 6 solution follows:"

v2={}
v2["a"]=a
v2["b"]=b

assert v==v2

# this method allows you to add new keys/values to the existing dictionary
# without having to type out the whole dictionary again with the new key
# For example: v={"a": a, "b": b} if i want to add c, I could just do
# v["c"]= 4 instead of typing out the whole dictionary of
# v={"a": a, "b": b, "c": 4} 

###
### Problem 7
###

# DO NOT CHANGE THE FOLLOWING LINE
print "Problem 7 solution follows:"

for keys in v:
    print keys
    print v[keys]
    
# k is all the keys in the dictionary and dictionary["k"] is all the
# values for the keys in the dictionary.

###
### Collaboration
###

# ... Andrew Loewen (loeand16)
# ... 