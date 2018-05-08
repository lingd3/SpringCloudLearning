# -*- coding:utf-8 -*-

f = open("a.log", "r")
op = -1
for line in f:
	if line.find("eureka-server") != -1:
		print line
		data = line.split(" ")
		a = float(data[1].strip("%")) / 100
		b = float(data[2].strip("%")) / 100
		if a > 0.01 or b > 0.4:
			op = 0
		elif a < 0.001 and b < 0.2:
			op = 1

print op


f.close()
