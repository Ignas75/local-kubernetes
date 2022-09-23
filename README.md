# local-kubernetes
Practice for setting up and running a local kubernetes cluster involving a micro-service 

# Setup
## Pre-requisites
This project is coded in Windows so that is the first requirement (unless you want to change/fix the code for diff OS)

Need to have Kind, Docker, and Kubectl installed, you can refer to the guides below if you do not:  
Kind/Kubectl: https://kubernetes.io/docs/tasks/tools/  
Docker: https://docs.docker.com/get-docker/  

Need to be able to run shell scripts, one of the options is git bash
https://gitforwindows.org/  

The latest image of postgres from Docker: https://hub.docker.com/_/postgres  
Command to run in the terminal: ```docker pull postgres```

## Starting
The scripts folder contains a setup.sh which you can pass an argument for the name of a cluster you want to create or just run the file 

To run scripts with arguments you need to be in a cli like git bash, powershell, or command prompt

#### Example (with argument)
```./setup.sh my-cluster```  
will create a cluster by the name of my-cluster and store this name in a file later for the sake of clean-up
or just click on the file name in a file explorer GUI
#### Example (with default name)
```./setup.sh```   
this creates a cluster with a default name of "hobbies"  
or just click on the file name in a file explorer GUI
 
## Cleaning
To delete the cluster and the temporarily created files:  
Run the ```./clean.sh script```, this will make use of temporary files created during the setup scripts running (the temporary files will be deleted as part of the script) 

Alternatively, if you deleted the temporary files all that needs to be done is to open the docker GUI/docker commands in a cli to find the docker container created by kind which should have a "-control-plane" suffix and if you used the default name then it should be called "hobbies-control-plane"

# Repo Structure
```/cluster``` contains kubernetes resources that are created in kind clusters  
```/docker``` contains dockerfiles and resources needed for images used by resources in ```/cluster```   
```/scripts``` contains startup and cleanup scripts, temp files used by the cleanup are created and stored here by the startup script 
```/tests``` currently only contains instructions for manual tests (that I don't want to forget)  

# Overall Idea for Micro-Service
I have a bunch of things I like doing so the goal is to create an easily accessible/modifiable list of what I like that is:  
music, games, anime, manga, light novels, boardgames, books, audiobooks, podcasts, art (?), mobile games (I am unashamed for liking mobile games... mostly) 

The database chosen is postgresql, no strong reasons other than it being open-source

## TO DO: 
- [x] Create cluster creation/deletion script 
- [x] Create DB init script (tables and relations)
- [x] Script for Postgres in a container in the cluster 
- [x] Importing CSVs into DB 
- [ ] Micro-service for querying and modifying the DB 
- [ ] Setup the micro-service in a pod (using a script) where it has access to the DB 
- [ ] Add nginx as a front-proxy for the micro-service

# Extensions/Future Projects (aka, feature creep dump):
- endpoint "Random" that recommends anything (or if given a category, from the category)
- front-end app built on top of the micro-service, make it much easier for adding tons of recommendations to throw at friends
- download db script, given that this is a local cluster that is destroyed/created this is one way to persist the data
- setup a way to transfer the local data into a default website template
- visualiser for the data
- setup links to external websites (e.g. here's where you can watch/buy/play x)
- config file for changing defaults, like the default cluster name from "hobbies" to anything else really 
- make it multi-OS compatible (current issue: git-bash file paths interpretation requires different code from Unix based OS in clean.sh)