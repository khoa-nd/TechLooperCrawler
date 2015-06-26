import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.FixedWindowRollingPolicy
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy

import static ch.qos.logback.classic.Level.ERROR
import static ch.qos.logback.classic.Level.INFO

scan()

appender("STDOUT", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%d{dd-MM-yyyy HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"
    }
}

appender("LINKEDIN_SKILL_CRAWLER_INFO", RollingFileAppender) {
    file = "linkedin_skill_crawler_info.log"
    rollingPolicy(FixedWindowRollingPolicy) {
        fileNamePattern = "linkedin_skill_crawler_info_%i.log"
        minIndex = 1
        maxIndex = 24
    }
    triggeringPolicy(SizeBasedTriggeringPolicy) {
        maxFileSize = "5MB"
    }
    encoder(PatternLayoutEncoder) {
        pattern = "%d{dd-MM-yyyy HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"
    }
}

logger("com.techlooper.crawler", INFO, ["LINKEDIN_SKILL_CRAWLER_INFO"], Boolean.FALSE)

root(DEBUG, ["STDOUT"])
