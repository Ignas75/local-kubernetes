## Is postgres running
```kubectl get pods```
Should find a pod that is up and running with a "postgres-" prefix

## Can you connect to the postgres pod
using a pod name from the previous step
```kubectl exec -it <insertPodNameHere> -- psql -U postgres```
(in powershell/command prompt, not git-bash)

## Do the tables exist?
While connected (from the previous step) run the following:
```\c hobbies```
to connect to the hobbies database
```\dt``` 
to view the tables  

The result should be a list of tables based on the specification in ```/docker/postgres/init.sql```