package broit.mcp.client.api.ragflow;

import lombok.Data;

@Data
public class Response {
    public final static int SUCCESS = 0;
    private int code;
    private ChunkData data;
    private String message;
}
