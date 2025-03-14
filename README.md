# This is just a project for doing springAI MCP testing

## Build
```bash
cd spring-mcp-test
git checkout EmptyToolName
mvn clean package
java -jar mcp-server/target/mcp-server.jar
java -jar mcp-client/target/mcp-client.jar
```
## Test
```bash
curl http://localhost:8080/ai/mcp?message=Get%sCurrent%sDate
```