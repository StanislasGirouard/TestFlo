FROM ubuntu:latest
LABEL authors="stagiaire"

# install les dependances
RUN apt-get update
RUN apt-get install -y openjdk-21-jdk-headless

#crée un dossier /opt/app
RUN mkdir /opt/app
#copie le fichier vers /opt/app/myapp.jar
COPY target/SpringFilRouge-0.0.1-SNAPSHOT.jar /opt/app/myapp.jar
#signale à docker quel est le dossier de travail
WORKDIR /opt/app
#demarre l'appli
ENTRYPOINT ["java", "-jar", "myapp.jar"]