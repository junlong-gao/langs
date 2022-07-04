FROM ubuntu:20.04

RUN apt update && apt install wget unzip -y
RUN mkdir -p /java && cd /java && \
    wget \
       https://download.oracle.com/java/18/latest/jdk-18_linux-aarch64_bin.tar.gz && \
    tar -zxvf jdk-18_linux-aarch64_bin.tar.gz && \
    ln -fs /java/jdk-18.0.1.1 /java-home
# JAVA_HOME will be /java/jdk-18.0.1.1

RUN mkdir -p /gradle && cd /gradle && \
    wget https://services.gradle.org/distributions/gradle-7.4.2-bin.zip && \
    unzip gradle-7.4.2-bin.zip && \
    ln -fs /gradle/gradle-7.4.2 /gradle-install
    