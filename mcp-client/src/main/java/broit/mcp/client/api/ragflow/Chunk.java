package broit.mcp.client.api.ragflow;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

@Data
public class Chunk {

    private String content;
    @JSONField(name = "content_ltks")
    private String contentLtks;
    @JSONField(name = "dataset_id")
    private String datasetId;
    @JSONField(name = "document_id")
    private String documentId;
    @JSONField(name = "document_keyword")
    private String documentKeyword;
    private String highlight;
    private double similarity;
    @JSONField(name = "term_similarity")
    private double termSimilarity;
    @JSONField(name = "vector_similarity")
    private double vectorSimilarity;
}
