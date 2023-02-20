# getting kind cluster name from arguments
if [ $? == 1 ]
then 
    cluster_name=$1
else 
    cluster_name="hobbies"
fi

# creating the kind cluster
kind create cluster --name=${cluster_name}

# building and loading the docker image for postgres into kind cluster 
docker build ../docker/postgres/ -t hobbies/postgres:v1.0
kind load docker-image hobbies/postgres:v1.0 --name=hobbies

# creating the postgres resources
kubectl apply -f ../cluster/database/

# storing the kind cluster name in a file for use in deletion
mkdir temp
cd temp 
echo ${cluster_name} > cluster-name
cd .. 

# dockerizing the micro-service
cd ../micro-service/hobbies
mvn package
cp ./target/hobbies-0.0.1-SNAPSHOT.jar ../../docker/micro-service
cd ../../docker/micro-service 
docker build -t hobbies/micro-service:v1.0 .