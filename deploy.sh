./mvnw package -Dmaven.test.skip
docker rm -rf backend
docker build . -t backend
docker compose up
