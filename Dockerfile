FROM openjdk:11
EXPOSE 8080
ADD target/SPECalculator.jar SPECalculator.jar
ENTRYPOINT ["java", "-jar", "/SPECalculator.jar"]
CMD ["3+5*7/3"]
