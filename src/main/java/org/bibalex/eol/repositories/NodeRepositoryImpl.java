package org.bibalex.eol.repositories;

import com.mongodb.BasicDBObject;
import org.bibalex.eol.collections.Node;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregationOptions;

public class NodeRepositoryImpl implements NodeRepositoryCustom{

    private final MongoTemplate mongoTemplate;

    public NodeRepositoryImpl(MongoTemplate mongoTemplate)
    {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public String countVernaculars()
    {

        UnwindOperation unwind = Aggregation.unwind("vernaculars");
        CountOperation count = Aggregation.count().as("total");
        TypedAggregation agg = newAggregation(Node.class, unwind,count);
        AggregationOptions cursor = newAggregationOptions().cursor(new BasicDBObject()).build();
        AggregationResults  r = mongoTemplate.aggregate(agg.withOptions(cursor),Node.class);
        BasicDBObject s =  BasicDBObject.parse(r.getRawResults().get("cursor").toString());
        String result =  s.get("firstBatch").toString();
        return result;
    }
}
