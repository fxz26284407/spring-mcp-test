package broit.mcp.server.tool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.context.i18n.LocaleContextHolder;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;

/**
 * @author fuxz
 */
@Slf4j
public class UtilToolBox {

    @Tool(description = "Get the current date. for example: yyyy-MM-dd")
    String getCurrentDate() {
        log.info("getCurrentDate: {}, ", LocalDateTime.now().toLocalDate().toString());
        return LocalDateTime.now().toLocalDate().toString();
    }

    @Tool(description = "According to the date query for what day of the week is it")
    String getDayOfWeek(@ToolParam(description="format: yyyy-MM-dd") String date) {
        LocalDate localDate = LocalDate.parse(date);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        String dayOfWeekName = dayOfWeek.getDisplayName(TextStyle.FULL, LocaleContextHolder.getLocale());
        log.info("getDayOfWeek: {}, ", dayOfWeekName);
        return dayOfWeekName;
    }
}
