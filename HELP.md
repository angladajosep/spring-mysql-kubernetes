# Getting Started

url 
https://www.adictosaltrabajo.com/2019/01/03/desplegar-una-aplicacion-web-con-minikube/

kubectl create -f catalogocursos-mysql-pv.yaml
kubectl create -f catalogocursos-mysql-svc.yaml
kubectl create -f catalogocursos-mysql-deployment.yaml


kubectl create -f redis-master-svc.yaml
kubectl create -f redis-master-deployment.yaml


### COMANDS ###

kubectl get pods 
minikube service catalogocursos-mysql-service --url


1
	
n 

### URL ###
http://192.168.99.100:31810/test-sample/api/test
