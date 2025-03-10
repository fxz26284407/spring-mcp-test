package broit.mcp.client.api.ragflow;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.util.List;

@Data
public class ChunkData {
    private List<Chunk> chunks;
    @JSONField(name = "doc_aggs")
    private List<DocAggs> docAggs;
    private int total;
}
