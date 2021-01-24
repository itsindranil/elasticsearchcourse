package com.neel.elasticsearchcourse;


import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class init_rest_client_1 {
    static Logger logger = LoggerFactory.getLogger(init_rest_client_1.class);

    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")
                )
        );

        GetRequest getRequest = new GetRequest("shakespeare","34229");

        GetResponse response = client.get(getRequest, RequestOptions.DEFAULT);
        logger.info(String.valueOf(response));

        client.close();
    }
}
