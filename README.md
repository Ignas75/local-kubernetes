# local-kubernetes
Practice for setting up and running a local kubernetes cluster involving a micro-service 

# Overall Idea for Micro-Service
I have a bunch of things I like doing so the goal is to create an easily accessible/modifiable list of what I like that is:
music, games, anime, manga, light novels, boardgames, music artists, art (?), mobile games (I am unashamed for liking these... mostly) 

## TO DO: 
- [ ] Create cluster creation/deletion script 
- [ ] Create DB init script 
- [ ] Script for DB in a container in the cluster (with PV?)
- [ ] Script for importing CSVs into DB 
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