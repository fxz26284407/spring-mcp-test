package broit.mcp.client.api.ragflow;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

@Data
public class DocAggs {
    @JSONField(name = "doc_id")
    private String docId;
    private int count;
    @JSONField(name = "doc_name")
    private String docName;
}
