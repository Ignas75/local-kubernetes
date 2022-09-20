cd temp

# deleting the kind cluster
cluster_name={echo ./cluster-name}
kind delete cluster --name=${cluster_name}

# cleaning temp file 
rm ./cluster-name

cd ..
rmdir temp
