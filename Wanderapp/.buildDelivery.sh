rm -rf ~/empty/deliver
mkdir ~/empty/deliver/
mvn clean && zip -r wanderapp-maven-project.zip . -x ".*" "*buildDelivery.sh*"
mv wanderapp-maven-project.zip ~/empty/deliver/
mvn clean install 
cp ./Wanderapp-dist/target/README.txt ~/empty/deliver/
cp /home/jmt/Dev/casual/Wanderapp/Wanderapp-dist/target/Wanderapp-ready-dist.zip ~/empty/deliver/
cd ~/empty/deliver/
ls -l
zip -r notification-wanderapp-project-and-dist.zip . -x ".*"
rm wanderapp-maven-project.zip README.txt Wanderapp-ready-dist.zip
ls -l
unzip -d test notification-wanderapp-project-and-dist.zip
cd -
cd ~/empty/deliver/test
unzip Wanderapp-ready-dist.zip
unzip -d project wanderapp-maven-project.zip 
cd -

