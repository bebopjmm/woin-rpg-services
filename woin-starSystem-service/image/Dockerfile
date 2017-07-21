FROM java:openjdk-8

COPY opt /opt
COPY etc /etc

# The service needs 8080 available to world outside this container
EXPOSE 8080

ENTRYPOINT /opt/woin-StarSystemService/bin/run.sh