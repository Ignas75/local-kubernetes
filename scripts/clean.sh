cd temp

# deleting the kind cluster
cluster_name={echo ./cluster-name}
echo "${cluster_name}"
kind delete cluster ${cluster_name}

# cleaning temp file 
rm ./cluster-name

cd ..
rmdir temp
