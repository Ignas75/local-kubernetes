# getting kind cluster name from arguments
if [ $? == 1 ]
then 
    cluster_name=$1
else 
    cluster_name="hobbies"
fi

# creating the kind cluster
kind create cluster --name=${cluster_name}

# creating the postgres resources
kubectl apply -f ./cluster/database/

# storing the kind cluster name in a file for use in deletion
mkdir temp
cd temp 
echo ${cluster_name} > cluster-name
