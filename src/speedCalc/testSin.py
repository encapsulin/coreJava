import datetime
import time
import math
import random

def fnCalc():
	time1 = datetime.datetime.now()
	i = 0
	while ( (datetime.datetime.now()) - time1 ).total_seconds() * 1000 < 1000 :
		i+=1
		aRad = math.radians(random.randrange(180))
		aSin = math.sin(aRad)
	print(i)

print(datetime.datetime.now())

for i in range (1,10):
	fnCalc()

print(datetime.datetime.now())
