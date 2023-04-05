#!/usr/bin/env bash
#test

PROJECT_ROOT="/home/ubuntu/app/backend"
JAR_FILE="$PROJECT_ROOT/spring-webapp.jar"

APP_LOG="/home/ubuntu/app/log/application_backend.log"
ERROR_LOG="/home/ubuntu/app/log/error_backend.log"
DEPLOY_LOG="/home/ubuntu/app/log/deploy_backend.log"

TIME_NOW=$(date +%c)
ENC_KEY=${ENC_KEY}

# build 파일 복사
echo "$TIME_NOW > $JAR_FILE 파일 복사" >> $DEPLOY_LOG
cp $PROJECT_ROOT/build/libs/*.jar $JAR_FILE

# jar 파일 실행
echo "$TIME_NOW > $JAR_FILE 파일 실행" >> $DEPLOY_LOG
nohup java -Djasypt.encryptor.password=$ENC_KEY -jar $JAR_FILE > $APP_LOG 2> $ERROR_LOG &

CURRENT_PID=$(pgrep -f $JAR_FILE)
echo "$TIME_NOW > 실행된 프로세스 아이디 $CURRENT_PID 입니다." >> $DEPLOY_LOG