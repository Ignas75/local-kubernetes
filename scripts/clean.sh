# deleting hobbies micro-service snapshot
rm ../docker/micro-service/hobbies-0.0.1-SNAPSHOT.jar

cd temp
# deleting the kind cluster
path_to_dir=$(pwd -W | sed 's/\//\\/g') # converting file path to windows backslashes, because of a git bash glitch with finding files 
path_to_cluster_name="${path_to_dir}\cluster-name"
cluster_name=$(cat ${path_to_cluster_name})
kind delete cluster --name=${cluster_name}

# removing docker images
 docker image rm hobbies/postgres:v1.0
 docker image rm hobbies/micro-service:v1.0

# cleaning the script folder by getting rid of the temp file 
rm ./cluster-name
cd ..
rmdir temp
