#!/bin/bash

# Bash shell to makes a distribution folder and product




# Initial Class files
binaryDir=bin

# Final class files directory
classDir=me

# Name space
namspc=metal

# Plugin file for bukkit
pluginFile=plugin.yml

# Distribution folder
distributionDir=dist

# Final product name
finalJar=Mctoe.jar

# Other files to add to distribution
infoFiles="README.txt commandList.txt License.txt"



# Start code

if [ -d ./dist/ ]; then
	# Clear old product
	rm -r ./dist
fi

# Folder doesn't exist, so make it
mkdir ./dist


# Copy bin data upwards to "me" for jar
cp -R ./$binaryDir/$nmspc ./$nmspc

# Make jar
jarex="jar cf $distributionDir/$finalJar $pluginFile $namspc $infoFiles"
#echo $jarex
$jarex


rm -r ./$namspc

# Open jar for checking
cd $distributionDir
jar xf $finalJar