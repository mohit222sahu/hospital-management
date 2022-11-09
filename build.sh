#docker_reg=newdevinnoattrepo.azurecr.io
img_name=hospital-management-script
img_version=1.0
img_tag=${img_name}:${img_version}

cp target/hospitalmanagementsystem-0.0.1-SNAPSHOT.jar $img_name/

docker rmi -f $img_tag
docker rmi -f $docker_reg/$img_tag
rm -rf $img_name.tar
tar -czf $img_name.tar $img_name
#docker build  -t $img_tag --no-cache --build-arg APP_NAME=${img_name} .
#docker tag $img_tag $docker_reg/$img_tag

docker build  -t $img_tag --no-cache --build-arg APP_NAME=${img_name} .
docker push $docker_reg/$img_tag
