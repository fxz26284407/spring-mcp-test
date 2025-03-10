package broit.mcp.client.api.ragflow;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author fuxz
 *
 * (1) 高精度模式（如专业领域问答）
 * top_k=5
 * similarity_threshold=0.85
 * vector_similarity_weight=0.9
 * 效果：严格过滤噪声，依赖高质量向量检索。
 * (2) 平衡模式（通用文档生成）
 * top_k=10
 * similarity_threshold=0.75
 * vector_similarity_weight=0.6
 * 效果：平衡语义和关键词，兼顾多样性与准确性。
 * (3) 高召回模式（创意生成/跨领域检索）
 * top_k=15
 * similarity_threshold=0.65
 * vector_similarity_weight=0.8
 */
@Data
public class Param {
    private String question;
    @JsonProperty("dataset_ids")
    private List<String> datasetIds;
    @JsonProperty("page_size")
    private int pageSize = 10;
    @JsonProperty("top_k")
    private int topK = 5;
    @JsonProperty("similarity_threshold")
    private double similarityThreshold = 0.85;
    @JsonProperty("vector_similarity_weight")
    private double vectorSimilarityWeight = 0.9;
    @JsonProperty("rerank_id")
    private String rerankId;
}
