#!/bin/sh 

docker stats --no-stream  --format "{{.Container}} {{.CPUPerc}} {{.MemPerc}} {{.Name}}" > a.log
python a.py