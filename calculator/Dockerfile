#Docker file para construir la imagen calculator

FROM openjdk

ENV SERVER_PORT=7593

COPY build/libs/calculator-*.jar /app/calculator.jar

EXPOSE $SERVER_PORT

CMD ["java", "-jar", "/app/calculator.jar"]