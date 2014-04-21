rm -rf ~/empty/deliver
mkdir ~/empty/deliver/
mvn clean && zip -r wanderapp-maven-project.zip . -x ".*" "buildDelivery.sh"
mv wanderapp-maven-project.zip ~/empty/deliver/
mvn clean install 
cp ./Wanderapp-dist/src/assembly/doc/README.txt ~/empty/deliver/
cp /home/jmt/Dev/casual/Wanderapp/Wanderapp-dist/target/Wanderapp-dist.zip ~/empty/deliver/
cd ~/empty/deliver/
zip -r notification-wanderapp-project-and-dist.zip . -x ".*"
rm wanderapp-maven-project.zip README.txt Wanderapp-dist.zip
ls
cd -
cd ~/empty/deliver/
unzip -d test notification-wanderapp-project-and-dist.zip
cd -
cd ~/empty/deliver/test
unzip Wanderapp-dist.zip
unzip -d project wanderapp-maven-project.zip 
cd -

