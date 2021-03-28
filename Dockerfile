# Base image to build this image on
FROM payara/micro

# copy war file to $DEPLOY_DIR
# $DEPLOY_DIR is where payara looks for applications
# Default value is /opt/payara/deployments
COPY ./target/DailyNews-1.0.war $DEPLOY_DIR