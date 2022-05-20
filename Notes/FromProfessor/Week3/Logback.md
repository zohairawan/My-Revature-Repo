Logging
==========================

	is the process 

Log4j


Logback
===========================

<!-- SLF4J - API -->
<dependency>
<groupId>org.slf4j</groupId>
<artifactId>slf4j-api</artifactId>
<version>1.7.7</version>
</dependency>

<!-- logback -->
<dependency>
<groupId>ch.qos.logback</groupId>
<artifactId>logback-classic</artifactId>
<version>1.1.2</version>
</dependency>
<dependency>
<groupId>ch.qos.logback</groupId>
<artifactId>logback-core</artifactId>
<version>1.1.2</version>
</dependency>


=============
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Calculator {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Calculator.class);

    public static void main(String[] args) {
        System.out.println("Hello Calculator");
        LOGGER.info("This is an INFO level log message!");
        LOGGER.error("This is an ERROR level log message!");
    }
}


=================
Run it and check

===============
Hello Calculator
[main] INFO Calculator - This is an INFO level log message!
[main] ERROR Calculator - This is an ERROR level log message!

Process finished with exit code 0

=============================

Create logback.xml in src/main/resources

<?xml version="1.0" encoding="UTF-8"?>
<configuration>

    <appender name="Console" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <Pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</Pattern>
        </encoder>
    </appender>

<logger name="com.training.Calculator" level="error"/>

    <root level="INFO">
        <appender-ref ref="Console"/>
    </root>

</configuration>

=================
package com.training;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Calculator {

    private static final Logger log =
            LoggerFactory.getLogger(Calculator.class);

    public static void main(String[] args) {
        System.out.println("Hello Calculator");
        log.trace("hi");
        log.debug("hi");
        log.info("hi");
        log.warn("hi");
        log.error("hi");
        log.debug("RThis is an DEBUG level log message!");
        log.info("RThis is an INFO level log message!");
        log.error("This is an ERROR level log message!");



    }
}


Run it and check only error should come

===============
Hello Calculator
[main] ERROR Calculator - This is an ERROR level log message!

Process finished with exit code 0

=============================
File based logback

<?xml version="1.0" encoding="UTF-8"?>
<configuration>

    <!-- Send debug messages to System.out -->
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <!-- By default, encoders are assigned the type ch.qos.logback.classic.encoder.PatternLayoutEncoder -->
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{5} - %msg%n
            </pattern>
        </encoder>
    </appender>

    <!-- Send debug messages to a file at "c:/jcg.log" -->
    <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>h://ahmed.log</file>
        <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
            <Pattern>%d{yyyy-MM-dd_HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</Pattern>
        </encoder>

        <rollingPolicy class="ch.qos.logback.core.rolling.FixedWindowRollingPolicy">
            <FileNamePattern>h://jcg.%i.log.zip</FileNamePattern>
            <MinIndex>1</MinIndex>
            <MaxIndex>10</MaxIndex>
        </rollingPolicy>

        <triggeringPolicy class="ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy">
            <MaxFileSize>2MB</MaxFileSize>
        </triggeringPolicy>
    </appender>

    <logger name="com.training" level="INFO" additivity="false">
        <appender-ref ref="STDOUT" />
        <appender-ref ref="FILE" />
    </logger>

    <!-- By default, the level of the root level is set to DEBUG -->
    <root level="DEBUG">
        <appender-ref ref="STDOUT" />
    </root>
</configuration>
