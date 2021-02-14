package org.bibalex.eol.repositories;

import com.mongodb.BasicDBObject;
import org.bibalex.eol.collections.Node;
import org.bibalex.eol.collections.Vernacular;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.util.CloseableIterator;

import java.util.ArrayList;
import java.util.List;

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

        AggregationOptions cursor = newAggregationOptions().cursor(new org.bson.Document()).build();
        CloseableIterator<String> iterator = mongoTemplate.aggregateStream(agg.withOptions(cursor),String.class);
        List<String> result = toList(iterator);
        iterator.close();
        return (result != null && result.size() > 0)? result.get(0) : "";
    }

    private static <T> List<T> toList(CloseableIterator<? extends T> results) {
        List<T> result = new ArrayList<T>();
        while (results.hasNext()) {
            result.add(results.next());
        }
        return result;
    }
}
