#!/bin/bash
PROJECT_ROOT="/home/ubuntu/app/frontend"
APP_LOG="$PROJECT_ROOT/log/application.log"
ERROR_LOG="$PROJECT_ROOT/log/error.log"
DEPLOY_LOG="$PROJECT_ROOT/log/deploy.log"


cd $PROJECT_ROOT

TIME_NOW=$(date +%c)

sudo yarn

echo "$TIME_NOW > START" >> $DEPLOY_LOG
sudo pm2 start dist
echo "$TIME_NOW > END" >> $DEPLOY_LOG


ENC_KEY=${ENC_KEY}

echo "암호화키 >> $ENC_KEY" >> $DEPLOY_LOG

