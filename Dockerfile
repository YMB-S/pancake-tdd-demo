FROM openjdk:21

WORKDIR /app

COPY build/libs/BakedGoodSorterTDD-1.0-SNAPSHOT.jar .

EXPOSE 8080

CMD ["java", "-jar", "BakedGoodSorterTDD-1.0-SNAPSHOT.jar"]