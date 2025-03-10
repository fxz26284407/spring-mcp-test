package broit.mcp.client.api;

import broit.mcp.client.api.ragflow.Param;
import broit.mcp.client.api.ragflow.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;

public interface RagFlowApi {
    @PostExchange("/api/v1/retrieval")
    ResponseEntity<Response> retrieval(@RequestBody Param body);
}
