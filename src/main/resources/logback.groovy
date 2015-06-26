import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.FixedWindowRollingPolicy
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy

import static ch.qos.logback.classic.Level.ALL
import static ch.qos.logback.classic.Level.ERROR

scan()

appender("CONSOLE", ConsoleAppender) {
    withJansi = true
    encoder(PatternLayoutEncoder) {
        pattern = "%d{dd-MM-yyyy HH:mm:ss} %msg %n"
    }
}

appender("LINKEDIN_SKILL_CRAWLER", RollingFileAppender) {
    file = "linkedin_skill_crawler.log"
    rollingPolicy(FixedWindowRollingPolicy) {
        fileNamePattern = "linkedin_skill_crawler_%i.log"
        minIndex = 1
        maxIndex = 24
    }
    triggeringPolicy(SizeBasedTriggeringPolicy) {
        maxFileSize = "5MB"
    }
    encoder(PatternLayoutEncoder) {
        pattern = "%d{dd-MM-yyyy HH:mm:ss} %msg %n"
    }
}

logger("com.techlooper.crawler.linkedin.LinkedInSkillCrawler", ERROR, ["CONSOLE", "LINKEDIN_SKILL_CRAWLER"], Boolean.FALSE)

root(ERROR, ["CONSOLE", "ROOT", "LINKEDIN_SKILL_CRAWLER"])