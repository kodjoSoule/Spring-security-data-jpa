# Utiliser une image Alpine pour réduire la taille de l'image finale
FROM adoptopenjdk/openjdk11:x86_64-ubuntu-jdk-11.0.3_7

# Métadonnées de l'image
MAINTAINER Name "souleymanekodjo@gmail.com"
# Répertoire de travail
WORKDIR /app

# Copier le jar dans le conteneur
COPY build/libs/Spring-security-auth-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port
EXPOSE 8080

# Commande d'entrée
ENTRYPOINT ["java", "-jar", "app.jar"]
