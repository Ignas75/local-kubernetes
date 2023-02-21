## Can you curl the micro-service from inside the cluster?
Run this command in a terminal: ```kubectl run curl-<YOUR-NAME> --image=radial/busyboxplus:curl -i --tty --rm``` - substitute "<YOUR-NAME>" with your own name, you can even delete this part entirely along with the hyphen but it's good practice for a shared live environment to not run a temporary pod with a name likely to be used by another team member (you'll block the rest from using that name).
This creates a temporary instance of a pod capable of curling inside the cluster (if you want to understand how, then look at ```kubectl run --help``` and the radial/busyboxplus:curl image on docker)

Then, run ```curl hobbies:8080```, then you can play around with the endpoints and see if the values returned match what is specified in the micro-service
Once you are done, you can exit the pod (and simultaneously delete it) by runnning ```exit``` from inside the pod