package broit.mcp.client.conf;

import broit.mcp.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fuxz
 */
@Configuration
public class AIConfig {

    @Bean
    ChatClient chatClient(ChatClient.Builder builder, ChatMemory chatMemory) {
        return builder.defaultSystem("""
                        1. As a data analyst for a company, you need to understand the company's business and be able to provide data support based on the company's business needs
                        2. When you need to query data, try to use the tools provided to you. If the tools do not meet your needs, you can inquire about the data source
                        3. If the source of the data is unclear, you can inquire about the source of the data
                        4. If there is no callable tool, respond directly to the user's information without answering any questions, and ask the user what help they need
                        """)
                .defaultAdvisors(new SimpleLoggerAdvisor())
                .build();
    }


    @Bean
    ChatMemory chatMemory() {
        return new InMemoryChatMemory();
    }
}
