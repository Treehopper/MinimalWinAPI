#!/bin/bash

#mkdir ~/.bintray/
#FILE=$HOME/.bintray/.credentials
#cat <<EOF >$FILE
#realm = Bintray API Realm
#host = api.bintray.com
#user = $BINTRAY_USER
#password = $BINTRAY_API_KEY
#EOF
#echo $BINTRAY_USER
#echo "Created ~/.bintray/.credentials file: Here it is: "
#ls -la $FILE 

curl -T $TRAVIS_BUILD_DIR/winlogger/target/winlogger*-jar-with-dependencies.jar -u$BINTRAY_USER:$BINTRAY_API_KEY https://api.bintray.com/content/$BINTRAY_USER/generic/winlogger/$TRAVIS_BUILD_NUMBER/
