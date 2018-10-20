cd quoteapi;
mvn clean install -DskipTests;
cd ..;

docker-compose down;
docker-compose up;
