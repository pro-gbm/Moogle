#!/bin/bash
PROJECT_ROOT="/home/ubuntu/app/frontend/build"
APP_LOG="/home/ubuntu/app/frontend/log/application_front.log"
ERROR_LOG="/home/ubuntu/app/log/error_front.log"
DEPLOY_LOG="/home/ubuntu/app/log/deploy_front.log"
#test


cd $PROJECT_ROOT

TIME_NOW=$(date +%c)

sudo yarn

echo "$TIME_NOW > START" >> $DEPLOY_LOG
sudo pm2 start dist
echo "$TIME_NOW > END" >> $DEPLOY_LOG



