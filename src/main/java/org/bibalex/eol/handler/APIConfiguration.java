package org.bibalex.eol.handler;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("api")
public class APIConfiguration {
    private int nodesBatchSize;

   public int getNodesBatchSize()
   {
       return nodesBatchSize;
   }

   public void setNodesBatchSize(String nodesBatchSize)
   {
       this.nodesBatchSize = Integer.parseInt(nodesBatchSize);
   }


}
