file = open("marathon.in","r")
checkpoints = int(file.readline())
xCoordinate = []
yCoordinate = []
m,index,totalDist = [0,0,0]
intermediateDist = []

for i in range(0,checkpoints):
    coordinates = file.readline().split()
    xCoordinate.append(int(coordinates[0]))
    yCoordinate.append(int(coordinates[1]))

    if (i != 0): 
        intermediateDist.append(abs(xCoordinate[i-1]-xCoordinate[i]) + abs(yCoordinate[i-1]-yCoordinate[i]))
        totalDist += intermediateDist[i-1]

    if (i > 1):
        # Need to find the net change in distance if the checkpoint before is skipped 
        # Net Distance = IntermediateDist[1-2] + IntermediateDist[2-3] - IntermediateDist[1-3]
        # Want to remove the checkpoint with the largest net distance 

        dist = intermediateDist[i-1] + intermediateDist[i-2] + (abs(xCoordinate[i-2]-xCoordinate[i])+abs(yCoordinate[i-2]-yCoordinate[i]))
        m = max(m,dist)
        if m == dist:
            index = i-1

file.close()

totalDist -= intermediateDist[index] + intermediateDist[index-1]
totalDist += abs(xCoordinate[index-1]-xCoordinate[index+1]) + abs(yCoordinate[index-1]-yCoordinate[index+1])

f = open("marathon.out","w")
f.write(str(totalDist))
f.close()

