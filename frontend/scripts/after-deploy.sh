#!/bin/bash
REPOSITORY=/home/ubuntu/app/frontend

cd $REPOSITORY

sudo yarn

sudo pm2 start dist