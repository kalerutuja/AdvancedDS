
file1 = open('myfile.txt', 'r')
Lines = file1.readlines()

count = 0
# Strips the newline character
for line in Lines:
    print("Line{}: {}".format(count, line.strip()))