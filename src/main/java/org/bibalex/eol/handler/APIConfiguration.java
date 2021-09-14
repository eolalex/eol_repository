package org.bibalex.eol.handler;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("api")
public class APIConfiguration {
    private int nodesBatchSize;
    private int articlesBatchSize;
    private int mediaBatchSize;

   public int getNodesBatchSize()
   {
       return nodesBatchSize;
   }

   public void setNodesBatchSize(String nodesBatchSize)
   {
       this.nodesBatchSize = Integer.parseInt(nodesBatchSize);
   }

    public int getArticlesBatchSize()
    {
        return articlesBatchSize;
    }

    public void setArticlesBatchSize(String articlesBatchSize)
    {
        this.articlesBatchSize = Integer.parseInt(articlesBatchSize);
    }

    public int getMediaBatchSize() {
        return mediaBatchSize;
    }

    public void setMediaBatchSize(String mediaBatchSize) {
        this.mediaBatchSize = Integer.parseInt(mediaBatchSize);
    }


}
