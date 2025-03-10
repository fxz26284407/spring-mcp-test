package broit.mcp.server.conf;

import broit.mcp.server.tool.UtilToolBox;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fuxz
 */
@Configuration
public class McpConfig {

    @Bean
    public ToolCallbackProvider companyTools() {
        return MethodToolCallbackProvider.builder().toolObjects(new UtilToolBox()).build();
    }
}
