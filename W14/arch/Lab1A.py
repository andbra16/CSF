number="1111"
answer=0

for i in range(len(number)):
    if number[i]=="1":
        answer= answer + 2**(len(number)-1-i)

if number[0]=="1":
    answer= answer - (2**len(number))

print answer
