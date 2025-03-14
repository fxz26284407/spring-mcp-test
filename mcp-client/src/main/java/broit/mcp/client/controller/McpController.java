package broit.mcp.client.controller;

import io.modelcontextprotocol.client.McpAsyncClient;
import io.modelcontextprotocol.client.McpSyncClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.mcp.McpToolUtils;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * @author fuxz
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class McpController {
    private final ChatClient chatClient;
    private final List<McpSyncClient> mcpSyncClients;
    private final List<McpAsyncClient> mcpAsyncClients;

    @GetMapping("/ai/mcp")
    public Flux<String> flux(@RequestParam(value = "message", defaultValue = "list for files") String message) {
//        List<ToolCallback> toolCallbackProvider = McpToolUtils.getToolCallbacksFromSyncClients(mcpSyncClients);
        List<ToolCallback> toolCallbackProvider = McpToolUtils.getToolCallbacksFromAsyncClients(mcpAsyncClients);
        return chatClient.prompt().user(message)
                .tools(toolCallbackProvider)
                .stream().content();
    }

    @GetMapping("/ai/mcp2")
    public String normal(@RequestParam(value = "message", defaultValue = "list for files") String message) {
        List<ToolCallback> toolCallbackProvider = McpToolUtils.getToolCallbacksFromAsyncClients(mcpAsyncClients);
        return chatClient.prompt().user(message)
                .tools(toolCallbackProvider)
                .call().content();
    }

}
